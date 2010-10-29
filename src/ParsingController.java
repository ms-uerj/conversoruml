
public class ParsingController implements ControllerInterface {
	ParsingModelInterface model;
	ParsingView view;
	
	public ParsingController(ParsingModelInterface model){
		this.model = model;
		view = new ParsingView(this, model);
		view.createView();
		model.initialize();
		
	}
}
