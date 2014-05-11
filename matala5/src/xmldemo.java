import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;



public class xmldemo extends JFrame implements ActionListener {
	String savetext="";
	JPanel panel,paneltext;
	JTextField tf;
	JMenuBar mainmenu;
	JMenu file,edit,help;
	JMenuItem fileopen,filesave,fileexit,editclear,helpabote;
	int x,y;
	pointsContainer pc;

	public xmldemo(){
		super("xml demo");
		this.setBounds(400, 100, 600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		tf=new JTextField(8);
		tf.setFont(new Font("ARIAL",Font.BOLD,20));

		pc=new pointsContainer();

		Container pa= this.getContentPane();;
		pa.setLayout(new BorderLayout());

		panel = new JPanel();
		panel.setBounds(100, 60, 400,400);
		panel.setBackground(Color.WHITE);
		this.panel.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent me) {
				drawall();
			}

			@Override
			public void mouseDragged(MouseEvent me) {

			}
		});
		this.panel.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent me) {

			}

			@Override
			public void mousePressed(MouseEvent me) {

			}

			@Override
			public void mouseExited(MouseEvent me) {

			}

			@Override
			public void mouseEntered(MouseEvent me) {


			}

			@Override
			public void mouseClicked(MouseEvent me) {
				x=me.getX();
				y=me.getY();
				draw();
				point temp=new point(x,y);
				pc.add(temp);
				tf.setText(temp.toString());
			}
		});
		mainmenu=new JMenuBar();



		fileopen=new JMenuItem("open",new ImageIcon("C:/Daniel/לימודים/Workplace/yearB_semesterA_matala3/folder_open.png"));
		filesave=new JMenuItem("save",new ImageIcon("C:/Daniel/לימודים/Workplace/yearB_semesterA_matala3/file_save.png"));
		fileexit=new JMenuItem("exit",new ImageIcon("C:/Daniel/לימודים/Workplace/yearB_semesterA_matala3/exit.png"));
		editclear=new JMenuItem("clear",new ImageIcon("C:/Daniel/לימודים/Workplace/yearB_semesterA_matala3/cut.png"));
		helpabote=new JMenuItem("about",new ImageIcon("C:/Daniel/לימודים/Workplace/yearB_semesterA_matala3/help_doc.png"));
		file=new JMenu("File");
		edit=new JMenu("Edit");
		help=new JMenu("Help");

		mainmenu.setBounds(1, 1, 300, 300);

		fileopen.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		filesave.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		fileexit.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		editclear.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_X, ActionEvent.CTRL_MASK));

		fileopen.addActionListener(this);
		filesave.addActionListener(this);
		fileexit.addActionListener(this);
		editclear.addActionListener(this);
		helpabote.addActionListener(this);

		file.add(fileopen);
		file.add(filesave);
		file.add(fileexit);
		edit.add(editclear);
		help.add(helpabote);

		mainmenu.add(file);
		mainmenu.add(edit);
		mainmenu.add(help);
		panel.add(tf);
		this.setJMenuBar(mainmenu);
		pa.add(panel);


	}
	
	public static void main(String[] args){
		xmldemo a=new xmldemo();
		a.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==fileopen){
			JFileChooser open = new JFileChooser();
			int option = open.showOpenDialog(this);
			if (option == JFileChooser.APPROVE_OPTION) {
				readxml(open.getSelectedFile().getPath());
			}
			drawall();
		}
		if(e.getSource()==filesave){
			JFileChooser save = new JFileChooser();
			int option = save.showSaveDialog(this);
			if (option == JFileChooser.APPROVE_OPTION) {
				writeToXml(save.getSelectedFile().getPath());
			}
			drawall();
		}
		if(e.getSource()==fileexit){
			exit ex=new exit();
			ex.setVisible(true);
		}
		if(e.getSource()==editclear){
			clear();
		}
		if(e.getSource()==helpabote){
			help h=new help();
			h.setVisible(true);
		}
	}

	/**
	 * קלאס נפרד שנועד לפתוח למשתמש את חלון המידע
	 */
	private class help extends JFrame implements ActionListener{
		JButton done;
		public help(){
			super("matala xml");
			this.setBounds(600, 300, 100, 100);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			done=new JButton("OK");
			JLabel helptext=new JLabel("matala 5 xml read write demo");
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
	/**
	 * קלאס נפרד שנועד לפתוח למשתמש את חלון תפריט היציאה
	 */	
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
				xmldemo.this.setVisible(false);
				exit.this.setVisible(false);
			}
			if(e.getSource()==no){
				xmldemo.this.setVisible(false);
				exit.this.setVisible(false);
			}
		}
	}
	
	/**
	 * פונקציה שמציירת נקודה שהקורדינטטות שלה הם האיקס והווי 
	 */
	public void draw(){
		Graphics g=this.panel.getGraphics();
		g.setColor(Color.BLACK);
		g.drawOval(x, y, 3, 3);
		g.fillOval(x, y, 3, 3);

	}
	/**
	 * פונקציה שמציירת את כל הנקודות שנמצאות במערך הנקודות
	 */
	public void drawall(){
		for (int i = 0; i < pc.size(); i++) {
			point temp=pc.points.elementAt(i);
			x=temp.x;
			y=temp.y;
			draw();
		}
	}
	/**
	 * פונקציה שמוחקת את כל הנקודות מהמערך של הנקודות ומנקה את הפאנל
	 */
	public void clear(){
		panel.removeAll();
		panel.updateUI();
		panel.add(tf);
		pc.points.clear();
		
		

	}
	/**
	 *  קלאס פרטי של נקודות
	 */
	private class point{
		int x,y;
		public point(int a,int b){
			x=a;
			y=b;
		}
		public String toString(){
			return "x= "+x+",y= "+y;
		}
		public String xtostring(){
			return ""+x;
		}
		public String ytostring(){
			return ""+y;
		}
	}
	/**
	 * קלאס פרטי של מערך נקודות
	 */
	private class pointsContainer {
		public Vector<point> points;

		public pointsContainer() {
			points = new Vector<point>();
		}
		public pointsContainer(pointsContainer sc) {
			points = new Vector<point>(sc.points);
		}

		public int size() {
			return points.size();
		}

		public void add(point s) {
			points.add(s);
		}
		public void remove(point s) {
			points.removeElement(s);
		}
	}
	/**
	 * הפונקציה מקבלת את נתיב הקובץ הרצוי וקוראת ממנו
	 */
	public void readxml(String path){
		
		try {

			File fXmlFile = new File(path);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("point");
			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);


				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					x=Integer.parseInt(eElement.getElementsByTagName("x").item(0).getTextContent());
					y=Integer.parseInt(eElement.getElementsByTagName("y").item(0).getTextContent());
					pc.add(new point(x,y));
					draw();
				}
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 *  הפונקציה מקבלת את נתיב  הרצוי ויוצרת את הקובץ החדש בנתיב הרצוי
	 */
	public void writeToXml(String path) {
		Document doc = null;
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			//get an instance of builder
			DocumentBuilder db = dbf.newDocumentBuilder();
			//create an instance of DOM
			doc = db.newDocument();
		}catch(ParserConfigurationException pce) {}

		Element root_ele = doc.createElement("points");
		doc.appendChild(root_ele);

		for (int i=0; i< pc.size(); i++) {

			Element student_ele = doc.createElement("point");
			root_ele.appendChild(student_ele);

			Element name_ele = doc.createElement("x");
			Text name_txt = doc.createTextNode(pc.points.elementAt(i).xtostring());
			name_ele.appendChild(name_txt);
			student_ele.appendChild(name_ele);

			Element name_ele1 = doc.createElement("y");
			Text name_txt1 = doc.createTextNode(pc.points.elementAt(i).ytostring());
			name_ele1.appendChild(name_txt1);
			student_ele.appendChild(name_ele1);

		}

		OutputFormat format = new OutputFormat(doc);
		format.setIndenting(true);
		String f_location = path+".xml";
		try {

			XMLSerializer serializer = new XMLSerializer(new FileOutputStream(new File(f_location)), format);
			serializer.serialize(doc);
		} 

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		catch (IOException e) {
			e.printStackTrace();
		}
	}



}
