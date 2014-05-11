package part4;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class Mynotepad extends JFrame implements ActionListener {
	String savetext="";
	TextArea textArea;
	JMenuBar mainmenu;
	JMenu file,edit,help;
	JMenuItem fileopen,filesave,fileexit,editcope,editpast,editcut,helpabote;


	public Mynotepad(){
		super("My Notepad");
		this.setBounds(400, 100, 600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container pa= this.getContentPane();;
		pa.setLayout(new BorderLayout());

		textArea = new TextArea("", 0,0, TextArea.SCROLLBARS_VERTICAL_ONLY);
		mainmenu=new JMenuBar();



		fileopen=new JMenuItem("open",new ImageIcon("C:/Daniel/μιξεγιν/Workplace/yearB_semesterA_matala3/folder_open.png"));
		filesave=new JMenuItem("save",new ImageIcon("C:/Daniel/μιξεγιν/Workplace/yearB_semesterA_matala3/file_save.png"));
		fileexit=new JMenuItem("exit",new ImageIcon("C:/Daniel/μιξεγιν/Workplace/yearB_semesterA_matala3/exit.png"));
		editcope=new JMenuItem("cope",new ImageIcon("C:/Daniel/μιξεγιν/Workplace/yearB_semesterA_matala3/copy.png"));
		editpast=new JMenuItem("paste",new ImageIcon("C:/Daniel/μιξεγιν/Workplace/yearB_semesterA_matala3/paste.png"));
		editcut=new JMenuItem("cut",new ImageIcon("C:/Daniel/μιξεγιν/Workplace/yearB_semesterA_matala3/cut.png"));
		helpabote=new JMenuItem("about",new ImageIcon("C:/Daniel/μιξεγιν/Workplace/yearB_semesterA_matala3/help_doc.png"));
		file=new JMenu("File");
		edit=new JMenu("Edit");
		help=new JMenu("Help");

		mainmenu.setBounds(1, 1, 300, 300);

		fileopen.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		filesave.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		fileexit.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		editcope.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		editpast.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		editcut.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_X, ActionEvent.CTRL_MASK));

		fileopen.addActionListener(this);
		filesave.addActionListener(this);
		fileexit.addActionListener(this);
		editcope.addActionListener(this);
		editpast.addActionListener(this);
		editcut.addActionListener(this);
		helpabote.addActionListener(this);

		file.add(fileopen);
		file.add(filesave);
		file.add(fileexit);
		edit.add(editcope);
		edit.add(editpast);
		edit.add(editcut);
		help.add(helpabote);

		mainmenu.add(file);
		mainmenu.add(edit);
		mainmenu.add(help);

		this.setJMenuBar(mainmenu);
		pa.add(textArea);


	}
	public static void main(String[] args){
		Mynotepad a=new Mynotepad();
		a.setVisible(true);
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==fileopen){
			JFileChooser open = new JFileChooser();
			int option = open.showOpenDialog(this);
			if (option == JFileChooser.APPROVE_OPTION) {
				String newtext =readFile(open.getSelectedFile().getPath());
				textArea.setText(newtext);
			}
		}
		if(e.getSource()==filesave){
			JFileChooser save = new JFileChooser();
			int option = save.showSaveDialog(this);
			if (option == JFileChooser.APPROVE_OPTION) {
				writeFile(save.getSelectedFile().getPath(),this.textArea.getText());
				
			}
		}
		if(e.getSource()==fileexit){
			exit ex=new exit();
			ex.setVisible(true);
		}
		if(e.getSource()==editcope){
			savetext=this.textArea.getText();
		}
		if(e.getSource()==editpast){
			textArea.setText(this.textArea.getText()+savetext);
		}
		if(e.getSource()==editcut){
			savetext=this.textArea.getText();
			textArea.setText("");
		}
		if(e.getSource()==helpabote){
			help h=new help();
			h.setVisible(true);
		}
	}
	private class help extends JFrame implements ActionListener{
		JButton done;
		public help(){
			super("My Notepad");
			this.setBounds(600, 300, 100, 100);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 done=new JButton("OK");
			 JLabel helptext=new JLabel("My Notepad version 1.0.0");
			 Container pa= this.getContentPane();
			 pa.setPreferredSize(new Dimension(250, 500));
			 pa.setLayout(new FlowLayout());
			done.addActionListener(help.this);
			 pa.add(helptext);
			 pa.add(done);
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==done){
				help.this.setVisible(false);
			}
		}
	}
	private class exit extends JFrame implements ActionListener{
		JButton yes,no;
		public exit(){
			super("exiting");
			this.setBounds(600, 300, 100, 100);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 yes=new JButton("yes");
			 no=new JButton("no");
			 JLabel exittext=new JLabel("do you wont to save?");
			 Container pa= this.getContentPane();
			 pa.setPreferredSize(new Dimension(250, 500));
			 pa.setLayout(new FlowLayout());
			yes.addActionListener(exit.this);
			no.addActionListener(exit.this);
			 pa.add(exittext);
			 pa.add(no);
			 pa.add(yes);
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==yes){
				filesave.doClick();
				Mynotepad.this.setVisible(false);
				exit.this.setVisible(false);
			}
			if(e.getSource()==no){
				Mynotepad.this.setVisible(false);
				exit.this.setVisible(false);
			}
		}
	}
	public static void writeFile(String fileName,String text){
		//		try write to the file
		try { 
			FileWriter fw = new FileWriter(fileName);  
			PrintWriter outs = new PrintWriter(fw);
			outs.println(text);
			outs.close(); 
			fw.close();
		}
		catch(IOException ex) {  
			System.out.print("Error writing file\n" + ex);
		}		
	}	
	
	public static String readFile (String fileName){
		String back="";
		try { 
			FileReader fr = new FileReader(fileName); 
			BufferedReader br = new BufferedReader(fr);
			String str;
			str = br.readLine();
			back=str+'\n';
			for(int i=1; str!=null; i=i+1) {
				str = br.readLine();
				if (str != null){
					back=back+str+'\n';
				}
			}
			br.close();     
			fr.close();     
		}
		catch(IOException ex) {  
			System.out.print("Error reading file\n" + ex);
			System.exit(2);
		}
		return back;
	}
}

