import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ParsingView implements ActionListener,  ParsingObserver{

	ParsingModelInterface model;
	ControllerInterface controller;
	JFrame viewFrame;
	JPanel viewPanel;
	JLabel parsingInstructionLabel;
	JButton fileChooserButton;
	JFileChooser parsingFileChooser;
	
	public ParsingView(ControllerInterface controller, ParsingModelInterface model){
		this.controller = controller;
		this.model = model;
		model.registerObserver((ParsingObserver)this);
	}
	
	public void createView(){
		//Criar todos os componentes aqui
		viewPanel = new JPanel(new GridLayout(1,2));
		
		viewFrame = new JFrame("Parsing");
		viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewFrame.setResizable(false);
		viewFrame.setSize(new Dimension(400, 100));
		
		parsingInstructionLabel = new JLabel("Arquivo de entrada:", SwingConstants.CENTER);
		parsingFileChooser = new JFileChooser();
		fileChooserButton = new JButton("Abrir");
		fileChooserButton.setSize(new Dimension(30,15));
		
		//Adicionando os componentes no painel
		viewPanel.add(parsingInstructionLabel);
		viewPanel.add(fileChooserButton);
		
		viewFrame.add(viewPanel);
		viewFrame.getContentPane().add(viewPanel, BorderLayout.CENTER);
		viewFrame.setVisible(true);
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
