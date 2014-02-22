package uk.ac.ed.inf.pepa.eclipse.ui.wizards.capacityplanning.job.labs;


import org.eclipse.core.runtime.IProgressMonitor;
//import org.eclipse.core.runtime.IStatus;
//import org.eclipse.core.runtime.Status;

import uk.ac.ed.inf.pepa.eclipse.ui.wizards.capacityplanning.job.candidates.*;
import uk.ac.ed.inf.pepa.eclipse.ui.wizards.capacityplanning.job.labs.Parameters.CandidateParameters;
import uk.ac.ed.inf.pepa.eclipse.ui.wizards.capacityplanning.job.labs.Parameters.FitnessFunctionParameters;
import uk.ac.ed.inf.pepa.eclipse.ui.wizards.capacityplanning.job.labs.Parameters.LabParameters;
import uk.ac.ed.inf.pepa.eclipse.ui.wizards.capacityplanning.job.labs.Parameters.MetaHeuristicParameters;
import uk.ac.ed.inf.pepa.eclipse.ui.wizards.capacityplanning.job.labs.Parameters.RecordParameters;
import uk.ac.ed.inf.pepa.eclipse.ui.wizards.capacityplanning.job.metaheurstics.HillClimbing;
import uk.ac.ed.inf.pepa.eclipse.ui.wizards.capacityplanning.job.metaheurstics.Metaheuristic;
import uk.ac.ed.inf.pepa.eclipse.ui.wizards.capacityplanning.job.recorders.Recorder;
import uk.ac.ed.inf.pepa.eclipse.ui.wizards.capacityplanning.job.recorders.SystemEquationRecorder;

public class SingleNetworkHillClimbingLab extends SingleNetworkLab {

	public SingleNetworkHillClimbingLab(LabParameters labParameters,
			RecordParameters recordParameters,
			MetaHeuristicParameters metaheuristicParameters,
			FitnessFunctionParameters fitnessFunctionParameters,
			CandidateParameters candidateParameters) {
		super(labParameters,
				recordParameters,
				metaheuristicParameters,
				fitnessFunctionParameters,
				candidateParameters);
	}
	
	@Override
	public Metaheuristic setupLab(IProgressMonitor monitor){
		
		Recorder temp = new SystemEquationRecorder(recordParameters);
		
		return ((Metaheuristic) new HillClimbing(metaheuristicParameters, 
				getSystemEquationCandidate(temp), 
				monitor,
				temp));
		
	}
	
	public Candidate getSystemEquationCandidate(Recorder recorder){
		return (Candidate) new HillClimbingSystemEquationCandidate(0, 
				getSystemEquationFitnessFunction(recorder),
				candidateParameters);
	}

}