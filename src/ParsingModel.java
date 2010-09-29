import java.util.*;

public class ParsingModel implements ParsingModelInterface {
	ArrayList parsingObservers = new ArrayList();
	
	public void registerObserver(ParsingObserver o){
		parsingObservers.add(o);
	}
	
	public void removeObserver(ParsingObserver o){
		int i = parsingObservers.indexOf(o);
		if(i >= 0 ){
			parsingObservers.remove(i);
		}
	}
	
	
}
