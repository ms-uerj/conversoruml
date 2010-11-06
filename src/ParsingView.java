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
	JLabel directoryInstructionLabel;
	JTextField pathTextField;
	JTextField directoryTextField;
	JButton fileChooserButton;
	JButton directoryChooserButton;
	JButton fileConverterButton;
	JFileChooser parsingFileChooser;
	JFileChooser parsingDirectoryChooser;
	JOptionPane dialog;
	File file;
	File directory;
	String extension;
	
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
		viewFrame.setSize(new Dimension(500, 130));
		
		parsingInstructionLabel = new JLabel("Arquivo de entrada:", SwingConstants.CENTER);
		directoryInstructionLabel = new JLabel("Diretório de saída:", SwingConstants.CENTER);
		parsingFileChooser = new JFileChooser();
		parsingDirectoryChooser = new JFileChooser();
		parsingDirectoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		pathTextField = new JTextField("",25);
		directoryTextField = new JTextField("",25);
		fileChooserButton = new JButton("Abrir");
		fileChooserButton.addActionListener(this);
		directoryChooserButton = new JButton("Abrir");
		directoryChooserButton.addActionListener(this);
		fileConverterButton = new JButton("Converter");
		fileConverterButton.addActionListener(this);
		fileConverterButton.setEnabled(false);
		
		//Adicionando os componentes no painel		
		viewPanel.add(parsingInstructionLabel);
		viewPanel.add(pathTextField);
		viewPanel.add(fileChooserButton);
		viewPanel.add(directoryInstructionLabel);
		viewPanel.add(directoryTextField);
		viewPanel.add(directoryChooserButton);
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
			int returnVal = parsingFileChooser.showOpenDialog(viewFrame);
			
			if(returnVal == JFileChooser.APPROVE_OPTION){
				file = parsingFileChooser.getSelectedFile();
				extension = Utils.getExtension(file);
				if(extension.equals("uml") || extension.equals("xmi")){
					pathTextField.setText(file.getAbsolutePath().toString());
					fileConverterButton.setEnabled(true);
				}else{
					pathTextField.setText("Tipo de arquivo não suportado");
					fileConverterButton.setEnabled(false);
				}
			}
		}
		if(event.getSource() == fileConverterButton){
			if(extension.equals("uml")){
				controller.umlToXmi(file,directory);
			}else
			if(extension.equals("xmi")){
				try {
					controller.xmiToUml(file,directory);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if(event.getSource() == directoryChooserButton){
			int returnVal = parsingDirectoryChooser.showOpenDialog(viewFrame);
			
			if(returnVal == JFileChooser.APPROVE_OPTION){
				directory = parsingDirectoryChooser.getSelectedFile();
				directoryTextField.setText(directory.getAbsolutePath().toString());
			}
		}
	}
	
	public void updateParsing(boolean t){
		if(t == true){
			JOptionPane.showMessageDialog(null, "Convertido com sucesso","Alert",JOptionPane.INFORMATION_MESSAGE);
			pathTextField.setText("");
			directoryTextField.setText("");
		}else{
			JOptionPane.showMessageDialog(null, "Erro ao converter","Alert",JOptionPane.ERROR_MESSAGE);
			pathTextField.setText("");
			directoryTextField.setText("");
		}
	}
}
