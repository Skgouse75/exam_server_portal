import java.io.BufferedReader;
import java.io.FileReader;

public class Hmwithname {
	String getmwname(String filename) {
		String name="";
		 int hm=0;

		try {
		 FileReader fr=new FileReader(filename);
		 BufferedReader br=new BufferedReader(fr);
		 String line;
		 while((line=br.readLine())!=null) {
			 line=line.trim();
			 	 if(line.length()>0) {
				 String[] arr=line.split(",");
				 int marks=Integer.parseInt(arr[4]);
				 if(marks>hm) {
					 hm=marks;
					 name=arr[1];
				 }
		      } 
		    }
		 System.out.println(hm);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return name;
	}
public static void main(String[] args) {
	Hmwithname n=new Hmwithname();
	String str=n.getmwname("C:\\Users\\Dell\\Desktop\\slokam files\\19022021\\student.txt");
	System.out.println(str);
	}
	
}

