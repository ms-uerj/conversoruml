import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

public class ParsingView implements ActionListener,  ParsingObserver{

	ParsingModelInterface model;
	ControllerInterface controller;
	JFrame viewFrame;
	JPanel viewPanel;
	JLabel parsingInstructionLabel;
	JTextField pathTextField;
	JButton fileChooserButton;
	JButton fileConverterButton;
	JFileChooser parsingFileChooser;
	File file;
	
	public ParsingView(ControllerInterface controller, ParsingModelInterface model){
		this.controller = controller;
		this.model = model;
		model.registerObserver((ParsingObserver)this);
	}
	
	public void createView(){
		//Criar todos os componentes aqui
		viewPanel = new JPanel(new FlowLayout());
		
		viewFrame = new JFrame("Parsing");
		viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewFrame.setResizable(false);
		//viewFrame.pack();
		viewFrame.setSize(new Dimension(500, 100));
		
		parsingInstructionLabel = new JLabel("Arquivo de entrada:", SwingConstants.CENTER);
		parsingFileChooser = new JFileChooser();
		pathTextField = new JTextField("",25);
		fileChooserButton = new JButton("Abrir");
		fileChooserButton.addActionListener(this);
		fileConverterButton = new JButton("Converter");
		fileConverterButton.addActionListener(this);
		fileConverterButton.setEnabled(false);
		
		//Adicionando os componentes no painel		
		viewPanel.add(parsingInstructionLabel);
		viewPanel.add(pathTextField);
		viewPanel.add(fileChooserButton);
		viewPanel.add(fileConverterButton);
		
		viewFrame.add(viewPanel);
		viewFrame.getContentPane().add(viewPanel);
		viewFrame.setVisible(true);
	}
		
	public void actionPerformed(ActionEvent event){
		/* Identificar as ações do usuário (Quais botões clicou) e executar as 
		 * respectivas funções no controller
		 */
		if(event.getSource() == fileChooserButton){
			fileConverterButton.setEnabled(true);
			int returnVal = parsingFileChooser.showOpenDialog(viewFrame);
			
			if(returnVal == JFileChooser.APPROVE_OPTION){
				file = parsingFileChooser.getSelectedFile();
				pathTextField.setText(file.getAbsolutePath().toString());
			}
		}
	}
	
	public void updateParsing(){
		/* Fazer algo */
	}
}
