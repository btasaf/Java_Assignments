package part2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;

public class calculator {
	fraction[] frarry;
	int size;
	private final int newsize =10;
	public calculator(){
		size=0;
		frarry=new fraction[newsize];
	}
	private String[] filetofra(String filename){
		String[] back = null;
		try { 
			FileReader fr1 = new FileReader(filename); 
			BufferedReader br1 = new BufferedReader(fr1);
			LineNumberReader ln=new LineNumberReader(br1);
			ln.skip(Long.MAX_VALUE);
			back=new String[ln.getLineNumber()+1];
			fr1.close();
			br1.close();
			ln.close();
			FileReader fr = new FileReader(filename); 
			BufferedReader br = new BufferedReader(fr);
			
			String str = br.readLine();
			for(int i=0; str!=null; i++) {
					back[i]=str;
					str = br.readLine();
				
			}
			br.close();     
			fr.close();     
		}
		catch(IOException ex) {  
			System.out.print("Error reading file\n" + ex);
			System.exit(2);//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		}
		return back;
	}
	
	public void calcfraction(String filename){
		String[] filefra=filetofra(filename);
		
		for(String i: filefra){
			if(frarry.length==size)resize();
			try{
				fraction temp=operation(i);
				frarry[size++]=temp;
			}
			catch(Exception e){
				System.out.println(e);
			}
		}

	}
	public void readfraction(String filename){
		String[] filefra=filetofra(filename);
		for(String i: filefra){
			if(frarry.length==size)resize();
			try{
				fraction temp=new fraction(i);
				frarry[size++]=temp;
			}
			catch(Exception e){
				System.out.println(e);
			}
		}

	}
	public fraction operation(String line)throws fractionException{
		String[] frarr;
		fraction a ,b;
		if(line.contains("+")){
			frarr=line.split("\\+");
			a=new fraction(frarr[0].substring(0, frarr[0].length()-1));
			b=new fraction(frarr[1].substring(1, frarr[1].length()));
			a.plus(b);
			return a;
		}
		else if(line.contains("-")){
			frarr=line.split("-");
			a=new fraction(frarr[0].substring(0, frarr[0].length()-1));
			b=new fraction(frarr[1].substring(1, frarr[1].length()));
			a.minus(b);
			return a;
		}
		else if(line.contains(":")){
			frarr=line.split(":");
			a=new fraction(frarr[0].substring(0, frarr[0].length()-1));
			b=new fraction(frarr[1].substring(1, frarr[1].length()));
			a.div(b);
			return a;
		}
		else if(line.contains("*")){
			frarr=line.split("\\*");
			a=new fraction(frarr[0].substring(0, frarr[0].length()-1));
			b=new fraction(frarr[1].substring(1, frarr[1].length()));
			a.mul(b);
			return a;
		}
		else{
			throw new fractionException("the line is Illegal");
		}


	}
	public void writeFraction(String filename){
		try { 

			FileWriter fw = new FileWriter(filename);  
			PrintWriter outs = new PrintWriter(fw);
			for(int i=0;i<size;i++){
				outs.println(frarry[i].ToString());
			}
			outs.close(); 
			fw.close();
		}
		catch(IOException ex) {  
			System.out.print("Error writing file\n" + ex);
		}	
	}
	private void resize() {
		fraction[] temp=new fraction[frarry.length+newsize];
		int index=0;
		for(fraction i:frarry){
			temp[index++]=i;
		}
		frarry=temp;
	}

	public static void main(String[] args) {
		calculator cal=new calculator();
		cal.calcfraction("C:\\fractions");
		cal.readfraction("C:\\MyFile.txt");
		
		cal.writeFraction("C:\\MyFileAns.txt");
	}
}
