import java.io.*;
import java.util.*;
import org.jdom.*;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
 

public class ParsingModel implements ParsingModelInterface {
	ArrayList parsingObservers = new ArrayList();
	Document doc = new Document();
	
	
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
	
	public boolean umlToXmi(File file, File directory)throws Exception{
		// Cria a instancia da Classe para mostrar o arquivo.  
	    XslParser xslParser = new XslParser("C://umlToxmi.xsl");
	    
	    SAXBuilder sb = new SAXBuilder();  
	    
	    //Este documento agora possui toda a estrutura do arquivo.  
	    Document doc = sb.build(file);
	   
	    // Chamada da função que criar a transformacao de XML para HTML.  
	    xslParser.parserFile(doc, new PrintStream(directory.getAbsolutePath().concat("/diagrama.xmi")));
	    return true;
	}
	
	public boolean xmiToUml(File file, File directory) throws Exception{
		// Cria a instancia da Classe para mostrar o arquivo.  
	    XslParser xslParser = new XslParser("C://xmiTouml.xsl");
	    
	    SAXBuilder sb = new SAXBuilder();  
	    
	    //Este documento agora possui toda a estrutura do arquivo.  
	    Document doc = sb.build(file);
	   
	    // Chamada da função que criar a transformacao de XML para HTML.  
	    xslParser.parserFile(doc, new PrintStream(directory.getAbsolutePath().concat("/diagrama.uml")));
	    return true;
	}
	
	
}
