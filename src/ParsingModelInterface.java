
public interface ParsingModelInterface {
	
	/* Estes métodos permitem que a visualização e o controlador 
	 * recebam informações sobre o estado e tornem-se observadores */
	
	void registerObserver(ParsingObserver o);
	void removeObserver(ParsingObserver o);
}
