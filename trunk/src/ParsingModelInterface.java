
public interface ParsingModelInterface {
	
	/* Estes m�todos permitem que a visualiza��o e o controlador 
	 * recebam informa��es sobre o estado e tornem-se observadores */
	
	void registerObserver(ParsingObserver o);
	void removeObserver(ParsingObserver o);
}
