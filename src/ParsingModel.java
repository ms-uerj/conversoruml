import java.io.File;
import java.util.*;

public class ParsingModel implements ParsingModelInterface {
	ArrayList parsingObservers = new ArrayList();
	
	
	public void initialize(){
		/*inicialização do model*/
	}
	public void registerObserver(ParsingObserver o){
		parsingObservers.add(o);
	}
	
	public void removeObserver(ParsingObserver o){
		int i = parsingObservers.indexOf(o);
		if(i >= 0 ){
			parsingObservers.remove(i);
		}
	}
	
	public void umlToXmi(File file){

	}
	
	public void xmiToUml(File file){

	}
	
	
}
