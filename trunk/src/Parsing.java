
public class Parsing {
	public static void main (String[] args){
		ParsingModelInterface model = new ParsingModel();
		ControllerInterface controller = new ParsingController(model);
	}

}
