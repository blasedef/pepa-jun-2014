package uk.ac.ed.inf.pepa.cpt.searchEngine.metaheuristics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import uk.ac.ed.inf.pepa.cpt.CPTAPI;
import uk.ac.ed.inf.pepa.cpt.Utils;
import uk.ac.ed.inf.pepa.cpt.config.Config;
//import uk.ac.ed.inf.pepa.cpt.ode.Dummy;
import uk.ac.ed.inf.pepa.cpt.ode.FluidSteadyState;
import uk.ac.ed.inf.pepa.cpt.searchEngine.candidates.ModelConfiguration;
import uk.ac.ed.inf.pepa.cpt.searchEngine.tree.PSONode;
import uk.ac.ed.inf.pepa.cpt.searchEngine.tree.ParticleSwarmOptimisationLabCandidateNode;

public class BruteForce implements MetaHeuristics {
	
	public class SynchronizedCounter implements CounterCallBack {
	    
		private int c = 0;
		
		public SynchronizedCounter(){
		}

	    public synchronized void increment() {
	        c++;
	    }

	    public synchronized int value() {
	        return c;
	    }
	}
	
	public class Counter {
		
		private Double min, max, pointer;
		private boolean hasChild;
		private Counter child;
		private String name;
		
		public Counter(HashMap<String,Double> maxs, HashMap<String,Double> mins){
			
			String[] keys = maxs.keySet().toArray(new String[maxs.keySet().size()]);
			if(keys.length > 0)
				this.name = keys[0];
			
			this.min = mins.get(this.name);
			this.max = maxs.get(this.name);
			this.pointer = min;
			
			HashMap<String,Double> newMins, newMaxs;
			
			newMins = new HashMap<String, Double>();
			newMaxs = new HashMap<String, Double>();
			
			for(String s : maxs.keySet()){
				if(!s.equals(keys[0])){
					newMins.put(s,mins.get(s));
					newMaxs.put(s,maxs.get(s));
				}
			}
			
			if(newMaxs.size() > 0){
				this.child = new Counter(newMaxs, newMins);
				this.hasChild = true;
			} else {
				this.hasChild = false;
			}
			
		}
		
		public boolean hasMaxed(){
			return (this.pointer == this.max);
		}
		
		
		public HashMap<String,Double> getPopulations(HashMap<String,Double> output){
			
			if(!hasChild){
				output.put(this.name, pointer);
				pointer++;
				if(pointer > max)
					pointer = min;
			} else {
				this.child.getPopulations(output);
				output.put(this.name, pointer);
				if(this.child.hasMaxed()){
					pointer++;
					if(pointer > max)
						pointer = min;
				}
			}
			return output;
			
		}

	}
	
	private PSONode myNode;
	private IProgressMonitor myMonitor;
	private ArrayList<ModelConfiguration> population;
	private int threads;
	private ExecutorService executor;
	private SynchronizedCounter counter;
	private Counter populationCounter;

	public BruteForce(HashMap<String, Double> parameters,
			ParticleSwarmOptimisationLabCandidateNode particleSwarmOptimisationLabCandidateNode, 
			IProgressMonitor monitor) {
		
		this.myNode = new PSONode("ParticleSwarmOptimisation", 
				parameters, 
				particleSwarmOptimisationLabCandidateNode);
		
		particleSwarmOptimisationLabCandidateNode.registerChild(this.myNode);
		
		this.myMonitor = monitor;
		
		this.population = new ArrayList<ModelConfiguration>();
		
		this.threads = this.myNode.getMyMap().get(Config.LABPOP).intValue();
	
		this.executor = Executors.newFixedThreadPool(threads);
		
		startAlgorithm();

		this.executor.shutdown();
		
		this.myNode.updateFinishTime();
		
		
	}
	
	public void startAlgorithm(){
		
		try{
			
			this.myMonitor.beginTask("Searching" + this.myNode.getName(), CPTAPI.totalPSOWork());
			this.myMonitor.subTask("PSO " + this.myNode.getName() + " starting...");
			
			Double count = 1.0;
			String[] keys = CPTAPI.getPopulationControls().getKeys();
			
			HashMap<String,Double> mins, maxs;
			
			mins = new HashMap<String, Double>();
			maxs = new HashMap<String, Double>();
			
			for(String s : keys){
				mins.put(s,Double.parseDouble(CPTAPI.getPopulationControls().getValue(s, Config.LABMIN)));
				maxs.put(s,Double.parseDouble(CPTAPI.getPopulationControls().getValue(s, Config.LABMAX)));
			}
			
			this.populationCounter = new Counter(mins,maxs);
			
			for(int i = 0; i < keys.length; i++){
				count = count * Double.parseDouble(CPTAPI.getPopulationControls().getValue(keys[i], Config.LABRAN));
			}
			
			
			for(int i = 0; i < this.myNode.getMyMap().get(Config.LABPOP);i++){
				this.population.add(new ModelConfiguration(Utils.copyHashMap(Utils.copyHashMap(this.populationCounter.getPopulations(new HashMap<String,Double>()))), 
						null,
						null, 
						myNode));
				count--;
			}
			
			
			int i = 1;
			while(count > 0){
				
				this.myMonitor.subTask("Working... please wait: " + this.myNode.getName() + " " + count + " left." );
				
				
				for(int j = 0; j < this.myNode.getMyMap().get(Config.LABPOP); j++){
					population.get(j).setParameters(this.populationCounter.getPopulations(new HashMap<String, Double>()), 
							null, 
							myNode);
					count--;
				}
				
				
				evaluateAll();
				
				i++;
				
				if(this.myMonitor.isCanceled()){
					throw new OperationCanceledException();
				}
			}
			
			this.myMonitor.subTask("Finished Brute force. " + this.myNode.getName());
			
		
		}
		finally {
			this.myNode.updateFinishTime();
			this.myMonitor.done();
		}
	
	}
	
	
	/**
	 * Cycle through all particles doing an ODE evaluation
	 */
	public void evaluateAll(){
		
		this.counter = new SynchronizedCounter();
		
		for (int i = 0; i < this.population.size(); i++) {
			
			Runnable worker = new FluidSteadyState(CPTAPI.getLabels(), 
				population.get(i).getGraph(), 
				CPTAPI.getEstimators(), 
				CPTAPI.getCollectors(), 
				CPTAPI.getOptionMap(),
				null,
				population.get(i).getNode(),
				this.counter);
			
//			Runnable worker = new Dummy(CPTAPI.getLabels(), 
//			population.get(i).getNode(),
//			this.counter);
			
			this.executor.execute(worker);
		}
		
		
		//barrier 
		while(this.counter.value() < population.size());
		
		for (int i = 0; i < this.population.size(); i++) {
			
			population.get(i).getNode().updateFitness();
			if(this.myNode.getFittestNode().getMyMap().size() == 0){
				this.myNode.setFittestNode(population.get(i).getNode());
			} else if (population.get(i).getNode().getFitness() < this.myNode.getFittestNode().getFitness()){
				this.myNode.setFittestNode(population.get(i).getNode());
			}
			
			this.myMonitor.worked(1);
		}
		
		
	}	

}
