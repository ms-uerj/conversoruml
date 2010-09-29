import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ParsingView implements ActionListener,  ParsingObserver{

	ParsingModelInterface model;
	ControllerInterface controller;
	
	public ParsingView(ControllerInterface controller, ParsingModelInterface model){
		this.controller = controller;
		this.model = model;
		model.registerObserver((ParsingObserver)this);
	}
	
	public void actionPerformed(ActionEvent event){
		/* Identificar as ações do usuário (Quais botões clicou) e executar as 
		 * respectivas funções no controller
		 */
	}
	
	public void updateParsing(){
		/* Fazer algo */
	}
}
