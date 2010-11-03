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
	
	public void umlToXmi(File file, File directory){
		model.umlToXmi(file, directory);
	}
	
	public void xmiToUml(File file, File directory){
		Boolean t = model.xmiToUml(file, directory);
		view.updateParsing(t);
	}
}
