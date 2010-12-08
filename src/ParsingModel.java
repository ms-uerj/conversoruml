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
	   
	    xslParser.parserFile(doc, new PrintStream(directory.getAbsolutePath().concat("/diagrama.xmi")));
	    return true;
	}
	
	public boolean xmiToUml(File file, File directory) throws Exception{
		// Cria a instancia da Classe para mostrar o arquivo.  
	    XslParser xslParser = new XslParser("C://xmiTouml.xsl");
	    
	    SAXBuilder sb = new SAXBuilder();  
	    
	    //Este documento agora possui toda a estrutura do arquivo.  
	    Document doc = sb.build(file);
	    
	    xslParser.parserFile(doc, new PrintStream(directory.getAbsolutePath().concat("/diagrama.uml")));
	    
	    //Substituir o namespace 
	    File f = new File(directory.getAbsolutePath().concat("/diagrama.uml"));
 	    BufferedReader reader = new BufferedReader(new FileReader(f));
 	    String line = "", oldtext = "";
 	    while((line = reader.readLine()) != null){
 		   oldtext += line + "\r\n";
 	    }
 	    reader.close();
 	    String newtext = oldtext.replaceAll("http://schema.omg.org/spec/UML/2.1", "http://www.eclipse.org/uml2/3.0.0/UML");
 	    FileWriter writer = new FileWriter(directory.getAbsolutePath().concat("/diagrama.uml"));
 	    writer.write(newtext);writer.close();
	    return true;
	}
	
	
}
