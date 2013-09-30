package uk.ac.ed.inf.pepa.eclipse.ui.wizards.metaHeuristicCapacityPlanning.metaHeuristicEngine.candidates;

import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;

import uk.ac.ed.inf.pepa.eclipse.ui.wizards.metaHeuristicCapacityPlanning.metaHeuristicEngine.searchEngines.*;
import uk.ac.ed.inf.pepa.eclipse.ui.wizards.metaHeuristicCapacityPlanning.model.ExperimentConfiguration;



public class Experiment extends Candidate{
	
	private IProgressMonitor monitor;
	private int totalWork;
	private int processors;
	private int experiments;
	private boolean candidate;

	public Experiment(IProgressMonitor monitor, int totalWork, int processors, boolean candidate) {
		this.monitor = monitor;
		this.totalWork = totalWork;
		this.candidate = candidate;
		this.processors = processors;
	}
	
	public IStatus startExperiments(){
		
		try {
			this.monitor.beginTask("Experiment started", this.totalWork);
			
			int experiments = ExperimentConfiguration.metaHeuristic.getAttributeMap().get(ExperimentConfiguration.EXPERIMENTS_S).intValue();
			
			for(int i = 0; i < experiments; i++){
				
				if(monitor.isCanceled())
					return Status.CANCEL_STATUS;
				
				((Metaheuristic) this.getNewMetaheuristic(this.monitor)).search(this.totalWork/experiments, experiments);
				
			}
			
		} finally {
			this.monitor.done();
		}
		
		return Status.OK_STATUS;
	}

	@Override
	public Map<String, Double> getFitness() {
		return null;
	}
	
	public Metaheuristic getNewMetaheuristic(IProgressMonitor monitor){
		if(ExperimentConfiguration.metaHeuristic.getValue().equals(ExperimentConfiguration.HILLCLIMBING_S)){
			return new HillClimbing(monitor);
		} else if (ExperimentConfiguration.metaHeuristic.getValue().equals(ExperimentConfiguration.GENETICALGORITHM_S)){
			return new GeneticAlgorithm(monitor);
		} else {
			return new ParticleSwarmOptimisation(monitor);
		}
	}
	
}