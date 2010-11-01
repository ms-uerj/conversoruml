import java.io.*;
import java.util.*;
import org.jdom.*;
import org.jdom.output.XMLOutputter;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.xpath.*;

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
		Element umlModel = new Element("Model","uml","http://www.eclipse.org/uml2/3.0.0/UML");
		Element packagedElement = new Element("packagedElement");
		Element packagedElement2 = new Element("packagedElement");
		Element ownedAttribute = new Element("ownedAttribute");
		Element lowerValue = new Element("lowerValue");
		
		Namespace namespace = Namespace.getNamespace("xmi", "http://schema.omg.org/spec/XMI/2.1");
		
		umlModel.setAttribute("version","2.1", namespace);
		umlModel.setAttribute("id","_zv37QN7mEd-oHKAY1dg54A", namespace);
		
		packagedElement.setAttribute("type","uml:PrimitiveType", namespace);
		packagedElement.setAttribute("id","_6uH_cd7pEd-9r-9AFaL-Dg", namespace);
		packagedElement.setAttribute("name","int");
		
		packagedElement2.setAttribute("type","uml:Class", namespace);
		packagedElement2.setAttribute("id","_FpEKYN7nEd-oHKAY1dg54A", namespace);
		packagedElement2.setAttribute("name","Classe1");
		
		ownedAttribute.setAttribute("id","_jt4B0N7nEd-oHKAY1dg54A", namespace);
		ownedAttribute.setAttribute("name","atrib1");
		ownedAttribute.setAttribute("type","_6uH_cd7pEd-9r-9AFaL-Dg");
		
		lowerValue.setAttribute("type","uml:LiteralInteger",namespace);
		lowerValue.setAttribute("id","_AXOV8N7qEd-9r-9AFaL-Dg", namespace);
		
		ownedAttribute.addContent(lowerValue);
		packagedElement2.addContent(ownedAttribute);
		umlModel.addContent(packagedElement);
		umlModel.addContent(packagedElement2);
		
		Document doc = new Document();
		doc.setRootElement(umlModel);
		
		XMLOutputter xout = new XMLOutputter();
		try{
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("diagrama.uml"), "UTF8")); 
			xout.output(doc, out);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	
}
