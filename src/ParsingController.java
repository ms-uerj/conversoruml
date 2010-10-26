import java.io.File;

public class ParsingController implements ControllerInterface {
	ParsingModelInterface model;
	ParsingView view;
	
	public ParsingController(ParsingModelInterface model){
		this.model = model;
		view = new ParsingView(this, model);
		view.createView();
		model.initialize();
	}
	
	public void umlToXmi(File file){
		model.umlToXmi(file);
	}
	
	public void xmiToUml(File file){
		model.xmiToUml(file);
	}
}
