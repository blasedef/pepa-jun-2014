package uk.ac.ed.inf.pepa.eclipse.ui.wizards.capacityplanning.pages;

import java.util.ArrayList;

import org.eclipse.draw2d.GridData;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import uk.ac.ed.inf.pepa.eclipse.ui.dialogs.IValidationCallback;
import uk.ac.ed.inf.pepa.eclipse.ui.wizards.capacityplanning.controllers.CapacityPlanningWidget;
import uk.ac.ed.inf.pepa.eclipse.ui.wizards.capacityplanning.models.ConfigurationModel;

public abstract class CapacityPlanningWizardPage extends WizardPage {
	
	protected Composite container;
	protected ConfigurationModel configurationModel;
	protected ArrayList<CapacityPlanningWidget> widgets; 
	
	protected final IValidationCallback parentCallBack = new IValidationCallback() {

		public void validate() {
			completePage();
		}
	};

	public CapacityPlanningWizardPage(String s, String title, String description) {
		
		//copy title upwards
		super(s);
		
		//set page title
	    setTitle(title);
	    
	    //set description underneath
	    setDescription(description);
	    
	    this.widgets = new ArrayList<CapacityPlanningWidget>();
	    
	}

	@Override
	public void createControl(Composite parent) {
		//minimum required for a wizard page 1/2
		ScrolledComposite sc = new ScrolledComposite(parent, SWT.H_SCROLL | SWT.V_SCROLL);
		sc.setSize(sc.computeSize(SWT.DEFAULT,SWT.DEFAULT));
		this.container = new Composite(sc, SWT.NONE);
		sc.setContent(container);
		//this.container = new Composite(parent, SWT.NONE);
		this.container.setLayoutData(new GridData(GridData.FILL_BOTH));
		GridLayout layout = new GridLayout();
		layout.marginWidth = 10;
		layout.numColumns = 2;
		container.setLayout(layout);
		constructPage(this.parentCallBack);

		sc.setExpandHorizontal(true);
		
				setControl(sc);
		this.container.setSize(this.container.computeSize(SWT.DEFAULT,SWT.DEFAULT));
		
	}
	
	protected abstract void constructPage(IValidationCallback cb);
	
	public abstract void completePage();
	
}