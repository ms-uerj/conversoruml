import java.io.*;  
  
import javax.xml.transform.Templates;  
import javax.xml.transform.Transformer;  
import javax.xml.transform.TransformerFactory;  
import javax.xml.transform.dom.DOMSource;  
import javax.xml.transform.stream.StreamResult;  
import javax.xml.transform.stream.StreamSource;  
  
import org.jdom.Document;  
import org.jdom.Element;  
import org.jdom.output.DOMOutputter;


public class XslParser {
	/** 
	    * Quando o arquivo � transformado de apenas texto para um Template 
	    * � armazenado neste espa�o 
	    */  
	   private Templates xslCompiled;  
	  
	   /** 
	    * Construtor que cria o Template a partir do arquivo. 
	    * Este arquivo � passado como: 
	    * caminho/arquivo.xsl 
	    */  
	   public XslParser(String xslLocation) throws Exception {  
	      TransformerFactory factory = TransformerFactory.newInstance();  
	      xslCompiled = factory.newTemplates(new StreamSource(new File(xslLocation)));  
	   }  
	  
	   /** 
	    * Faz a transforma��o de um Document para saida direta no Output 
	    */  
	   public void parserFile(Document doc, PrintStream out) throws Exception {  
	      process(doc, new PrintWriter(out));  
	   }  
	  
	   /** 
	    * Executa a tranforma��o do XML  
	    * e retorna o HTML processado a partir do XSL. 
	    */  
	   private String basicProcess(Document root) throws Exception {  
	      StringWriter result = new StringWriter();  
	      process(root, new PrintWriter(result));  
	      return result.toString().trim();  
	   }  
	  
	   /** 
	    * Este m�todo � o respons�vel por criar uma instancia de tranforma��o  
	    * do XSL e processar com o XML 
	    */  
	   private void process(Document root, Writer saida) throws Exception {  
	      Transformer transformer = xslCompiled.newTransformer();  
	      transformer.transform(new DOMSource(new DOMOutputter().output(root)),new StreamResult(saida));  
	   }  
}
