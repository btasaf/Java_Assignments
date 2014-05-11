 package part3;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class numgame extends JFrame implements ActionListener {
	int pl1,pl2,p,c,indexleft,indexright,turn;
	int[] arr,startarr;
	JButton cpleft,cpright,ppleft,ppright,pVSp,cVSp;
	JTextField panel,sump1,sump2,str;
	boolean even=true;


	public numgame(){
		super("what type of game?");
		this.setBounds(300, 300, 250, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container pa= this.getContentPane();;
		pa.setPreferredSize(new Dimension(250, 60));
		pa.setLayout(new FlowLayout());

		startarr=randArray(6);
		System.out.println(tostring(startarr,0,startarr.length-1));
		str= new JTextField(13);
		str.setFont(new Font("ARIAL",Font.BOLD,20));
		str.setText(tostring(startarr,0,startarr.length-1));

		pVSp=new JButton("player VS player");
		cVSp=new JButton("computer VS player");
		cVSp.addActionListener(this);
		pVSp.addActionListener(this);
		pVSp.setSize(160, 60);
		cVSp.setSize(160, 60);
		pa.add(pVSp);
		pa.add(cVSp);
		pa.add(str);


	}
	public numgame(int[] a){
		super("player VS player");
		this.setBounds(300, 300, 700, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container _window = this.getContentPane();
		_window.setLayout(new FlowLayout());
		JPanel Pup=new JPanel();
		JPanel Pmid=new JPanel();
		JPanel Pdown=new JPanel();
		JPanel Pupup=new JPanel();
		Pupup.setPreferredSize(new Dimension(500, 60));
		Pup.setPreferredSize(new Dimension(500, 120));
		Pmid.setPreferredSize(new Dimension(500, 100));
		Pdown.setPreferredSize(new Dimension(500, 200));

		JLabel forpanel=new JLabel("the numbers");
		JLabel forchoose=new JLabel("choose left or right:");
		JLabel forp1=new JLabel("player 1 sum");
		JLabel forp2=new JLabel("player 2 sum");
		forp1.setFont(new Font("ARIAL",Font.BOLD,30));
		forp2.setFont(new Font("ARIAL",Font.BOLD,30));
		forchoose.setFont(new Font("ARIAL",Font.BOLD,30));
		forpanel.setFont(new Font("ARIAL",Font.BOLD,30));

		arr=a;
		indexleft=0;
		indexright=arr.length-1;


		turn=1;
		pl1=pl2=0;
		ppleft=new JButton("left");
		ppleft.setSize(160, 60);
		ppright=new JButton("right");
		ppright.setSize(160, 60);
		ppleft.addActionListener(this);
		ppright.addActionListener(this);

		sump1=new JTextField(6);
		sump1.setFont(new Font("ARIAL",Font.BOLD,44));
		sump2=new JTextField(6);
		sump2.setFont(new Font("ARIAL",Font.BOLD,44));
		panel = new JTextField(10);
		panel.setFont(new Font("ARIAL",Font.BOLD,44));
		panel.setText(tostring(arr,indexleft,indexright));


		Pup.add(forpanel);
		Pup.add(panel);

		Pmid.add(forchoose);
		Pmid.add(ppleft);
		Pmid.add(ppright);

		Pdown.add(forp1);
		Pdown.add(forp2);
		Pdown.add(sump1);
		Pdown.add(sump2);

		_window.add(Pupup);
		_window.add(Pup);
		_window.add(Pmid);
		_window.add(Pdown);


	}
	public numgame(int[] a,char v){

		super("computer VS player");
		this.setBounds(300, 300, 700, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container _window = this.getContentPane();
		_window.setLayout(new FlowLayout());
		JPanel Pup=new JPanel();
		JPanel Pmid=new JPanel();
		JPanel Pdown=new JPanel();
		JPanel Pupup=new JPanel();
		Pupup.setPreferredSize(new Dimension(500, 60));
		Pup.setPreferredSize(new Dimension(500, 120));
		Pmid.setPreferredSize(new Dimension(500, 100));
		Pdown.setPreferredSize(new Dimension(500, 200));

		JLabel forpanel=new JLabel("the numbers");
		JLabel forchoose=new JLabel("choose left or right:");
		JLabel forp1=new JLabel("computer  sum");
		JLabel forp2=new JLabel("player  sum");
		forp1.setFont(new Font("ARIAL",Font.BOLD,30));
		forp2.setFont(new Font("ARIAL",Font.BOLD,30));
		forchoose.setFont(new Font("ARIAL",Font.BOLD,30));
		forpanel.setFont(new Font("ARIAL",Font.BOLD,30));

		arr=a;
		indexleft=0;
		indexright=arr.length-1;
		int sumEven=0,sumOdd=0;
		for(int k=0; k<arr.length; k=k+2){
			sumEven = sumEven + arr[k];
			sumOdd = sumOdd + arr[k+1];
		}
		if (sumEven<sumOdd) even = false;

		p=c=0;
		cpleft=new JButton("left");
		cpleft.setSize(160, 60);
		cpright=new JButton("right");
		cpright.setSize(160, 60);
		cpleft.addActionListener(this);
		cpright.addActionListener(this);

		sump1=new JTextField(6);
		sump1.setFont(new Font("ARIAL",Font.BOLD,44));
		sump1.setText(""+c);
		sump2=new JTextField(6);
		sump2.setFont(new Font("ARIAL",Font.BOLD,44));
		sump2.setText(""+p);
		panel = new JTextField(12);
		panel.setFont(new Font("ARIAL",Font.BOLD,44));
		panel.setText(tostring(arr,0,arr.length-1));


		Pup.add(forpanel);
		Pup.add(panel);

		Pmid.add(forchoose);
		Pmid.add(cpleft);
		Pmid.add(cpright);

		//Pdown.setLayout(new GridLayout());
		Pdown.add(forp1);
		Pdown.add(forp2);
		Pdown.add(sump1);
		Pdown.add(sump2);

		_window.add(Pupup);
		_window.add(Pup);
		_window.add(Pmid);
		_window.add(Pdown);

		arr=a;
		if(even){
			c=c+arr[indexleft++];
			panel.setText(tostring(arr,indexleft,indexright));	
			sump1.setText(""+c);
		}
		else{
			c=c+arr[indexright--];
			panel.setText(tostring(arr,indexleft,indexright));
			sump1.setText(""+c);
		}

	}




	public static int[] randArray(int size){
		int [] arr = new int[size];
		for(int i=0; i<arr.length; i++){
			arr[i] = (int)(Math.random()*arr.length*10);
		}
		return arr;
	}
	public static String tostring(int [] arr, int i, int j){
		String back="";
		for(int t=i; t<=j; t++){
			back =back+ arr[t]+", ";
		}
		return back;
	}



	public static void main(String[] argq){

		numgame game= new numgame();
		game.setVisible(true); 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==pVSp){
			this.setVisible(false);
			numgame a= new numgame(startarr);
			a.setVisible(true); 
		}
		if(e.getSource()==cVSp){
			this.setVisible(false);
			numgame a= new numgame(startarr,'a');
			a.setVisible(true); 
		}
		if(e.getSource()==cpleft){
			p=p+arr[indexleft++];
			panel.setText(tostring(arr,indexleft,indexright));
			sump2.setText(""+p);
			if(indexleft<indexright){
				c=c+arr[indexleft++];
				panel.setText(tostring(arr,indexleft,indexright));
				sump1.setText(""+c);
			}
		}
		if(e.getSource()==cpright){
			p=p+arr[indexright--];
			panel.setText(tostring(arr,indexleft,indexright));
			sump2.setText(""+p);
			if(indexleft<indexright){
				c=c+arr[indexright--];
				panel.setText(tostring(arr,indexleft,indexright));
				sump1.setText(""+c);
			}
		}
		if(e.getSource()==ppleft){
			if(turn==1){
				turn++;
				pl1=pl1+arr[indexleft++];
				panel.setText(tostring(arr,indexleft,indexright));
				sump1.setText(""+pl1);
			}
			else{
				turn--;
				pl2=pl2+arr[indexleft++];
				panel.setText(tostring(arr,indexleft,indexright));
				sump2.setText(""+pl2);
			}
		}
		if(e.getSource()==ppright){
			if(turn==1){
				turn++;
				pl1=pl1+arr[indexright--];
				panel.setText(tostring(arr,indexleft,indexright));
				sump1.setText(""+pl1);
			}
			else{
				turn--;
				pl2=pl2+arr[indexright--];
				panel.setText(tostring(arr,indexleft,indexright));
				sump2.setText(""+pl2);
			}
		}


	}
}
