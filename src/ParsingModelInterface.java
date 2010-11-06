import java.io.File;


public interface ParsingModelInterface {
	
	/* Estes m�todos permitem que a visualiza��o e o controlador 
	 * recebam informa��es sobre o estado e tornem-se observadores */
	void initialize();
	void registerObserver(ParsingObserver o);
	void removeObserver(ParsingObserver o);
	
	/* Estes m�todos s�o respons�veis pela convers�o */
	void umlToXmi(File file, File directory);
	boolean xmiToUml(File file, File directory)throws Exception;
}
