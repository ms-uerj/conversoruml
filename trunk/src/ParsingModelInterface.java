import java.io.File;


public interface ParsingModelInterface {
	
	/* Estes métodos permitem que a visualização e o controlador 
	 * recebam informações sobre o estado e tornem-se observadores */
	void initialize();
	void registerObserver(ParsingObserver o);
	void removeObserver(ParsingObserver o);
	
	/* Estes métodos são responsáveis pela conversão */
	void umlToXmi(File file, File directory);
	boolean xmiToUml(File file, File directory)throws Exception;
}
