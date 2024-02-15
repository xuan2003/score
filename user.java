package hw1;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class user {
	static Frame frm=new Frame("作業1");
	static Label number =new Label("number");static TextField txf1= new TextField(20);
	static Label score1=new Label("score1");static TextField txf2= new TextField(20);
	static Label score2=new Label("score2");static TextField txf3= new TextField(20);
	static Label score3=new Label("score3");static TextField txf4= new TextField(20);
	static TextArea txtarea1= new TextArea("",10,20);
	static Button btnclose=new Button("close");
	static Button btnadd=new Button(" add ");
	static Button btndelete=new Button("delete");
	static Button btnall=new Button("all_data");
	static Button btnsort=new Button("sort_data");
	static Button btncreate=new Button("create");
	static ActionLis act=new ActionLis();

	public static void main(String[] args) {
		FlowLayout flow=new FlowLayout(FlowLayout.CENTER,5,10);
		frm.setLayout(flow);
		frm.setSize(250,450);
		frm.add(number);frm.add(txf1);
		frm.add(score1);frm.add(txf2);
		frm.add(score2);frm.add(txf3);
		frm.add(score3);frm.add(txf4);

		frm.add(btncreate);
		frm.add(btnadd);
		frm.add(btndelete);
		frm.add(btnall);
		frm.add(btnsort);
		
		frm.add(txtarea1);
		frm.add(btnclose);
		 
		frm.setVisible(true);
		
		btnclose.addActionListener(act); 
		btnadd.addActionListener(act); 
		btnall.addActionListener(act);
		btnsort.addActionListener(act);
		btndelete.addActionListener(act);
		btncreate.addActionListener(act);
	}
	static class ActionLis implements ActionListener { 
		public void actionPerformed(ActionEvent e) {
			Button btn=(Button) e.getSource();
			if (btn==btncreate) {
				create_data();
			}
 			if (btn==btnadd) {
 				add_data();
  		}
 			if (btn==btndelete) {
 				delete_data();
 			}
 			if (btn==btnall) {
 				print_data();
 			}
 			if (btn==btnsort) {
 				sort_data();
 			}
 			if (btn==btnclose)System.exit(0); 
 			txf1.setText("");
 			txf2.setText("");
 			txf3.setText("");
 			txf4.setText("");
		}
  }
	static void create_data() {
		class Student {
            String studentname;
            int score1;
            int score2;
            int score3;
            int average;
        }

        Student student[] = new Student[100];
        int no = 0;

        try {
            PrintWriter out_file = new PrintWriter(new File("C:\\軟體設計與開發\\out.txt"));
            student[no]=new Student();
            student[no].studentname=txf1.getText(); 
            student[no].score1 = Integer.parseInt(txf2.getText());
            student[no].score2 = Integer.parseInt(txf3.getText());
            student[no].score3 = Integer.parseInt(txf4.getText());
    	    student[no].average = (student[no].score1 + student[no].score2 + student[no].score3) / 3;
    	    no++;

    	    for (int i = 0; i < no; i++) {
                System.out.print(student[i].studentname + "\t");
                System.out.print(student[i].score1 + "\t");
                System.out.print(student[i].score2 + "\t");
                System.out.print(student[i].score3 + "\t");
                System.out.println(student[i].average + "\t");
            }
    	  
    	    PrintWriter file_out = new PrintWriter(new File("C:\\軟體設計與開發\\out.txt"));
    			/*寫入檔案*/
    	     for (int i=0;i<no;i++){
    	     	file_out.print(student[i].studentname+"\t");
    	     	file_out.print(student[i].score1+"\t");
    	     	file_out.print(student[i].score2+"\t");
    	     	file_out.print(student[i].score3+"\t");
    	     	file_out.println(student[i].average);
    	     }
    	     
    	     file_out.close();
    	     
    	     for (int i=0;i<no;i++){
    	    	 	txtarea1.append("學號:"+student[i].studentname+"\n");
    				txtarea1.append("成績1:"+student[i].score1+"\n");
    				txtarea1.append("成績2:"+student[i].score2+"\n");
    				txtarea1.append("成績3:"+student[i].score3+"\n");
    				txtarea1.append("平均:"+student[i].average+"\n\n");
    		     }
    	   }
    		catch (IOException ioe){
    			System.out.println("file not found");
    		}
        }
	static void add_data() {
		class Student{
	       	String studentname;
	       	int score1;
	       	int score2;
	       	int score3;
	       	int average;;
	}
	Student student[]=new Student[100];/*參考8-4*/
	  try {
		  
	   	int no=0;
	    Scanner file_in=new Scanner(new File("C:\\軟體設計與開發\\out.txt"));
	    Scanner sc = new Scanner(System.in);
	    /*或從console 輸入input file name*/
//	    PrintWriter file_out = new PrintWriter(new File("C:\\軟體設計與開發\\out.txt"));
//	    PrintWriter file_out = new PrintWriter(new FileWriter(new File("C:\\軟體設計與開發\\out.txt"), true));
	    /*或從console 輸入output file name*/
		
	        /* 逐筆讀入資料到array */
	    no=0;
	    while (file_in.hasNext()) {
	    	student[no]=new Student();
	        student[no].studentname=file_in.next();
		    student[no].score1=file_in.nextInt();
		    student[no].score2=file_in.nextInt();
		    student[no].score3=file_in.nextInt();
		    student[no].average=file_in.nextInt();
	        no++;
	    }
	    file_in.close();
	    student[no]=new Student();
        student[no].studentname=txf1.getText(); 
        student[no].score1 = Integer.parseInt(txf2.getText());
        student[no].score2 = Integer.parseInt(txf3.getText());
        student[no].score3 = Integer.parseInt(txf4.getText());
	    student[no].average = (student[no].score1 + student[no].score2 + student[no].score3) / 3;
	    no++;

	    for (int i = 0; i < no; i++) {
            System.out.print(student[i].studentname + "\t");
            System.out.print(student[i].score1 + "\t");
            System.out.print(student[i].score2 + "\t");
            System.out.print(student[i].score3 + "\t");
            System.out.println(student[i].average + "\t");
        }
	  
	    PrintWriter file_out = new PrintWriter(new File("C:\\軟體設計與開發\\out.txt"));
			/*寫入檔案*/
	     for (int i=0;i<no;i++){
	     	file_out.print(student[i].studentname+"\t");
	     	file_out.print(student[i].score1+"\t");
	     	file_out.print(student[i].score2+"\t");
	     	file_out.print(student[i].score3+"\t");
	     	file_out.println(student[i].average);
	     }
	     
	     file_out.close();
	     txtarea1.setText("");
	     for (int i=0;i<no;i++){
	    	 txtarea1.append("學號:"+student[i].studentname+"\n");
				txtarea1.append("成績1:"+student[i].score1+"\n");
				txtarea1.append("成績2:"+student[i].score2+"\n");
				txtarea1.append("成績3:"+student[i].score3+"\n");
				txtarea1.append("平均:"+student[i].average+"\n\n");
		     }
	   }
		catch (IOException ioe){
			System.out.println("file not found");
		}
    }
	static void delete_data() {
		class Student{
	       	String studentname;
	       	int score1;
	       	int score2;
	       	int score3;
	       	int average;
	}
	Student student[]=new Student[100];/*參考8-4*/
	  try {
	   	int no=0;
	    Scanner file_in=new Scanner(new File("C:\\軟體設計與開發\\out.txt"));
	    Scanner sc = new Scanner(System.in);
	    /*或從console 輸入input file name*/
//	    PrintWriter file_out = new PrintWriter(new File("C:\\軟體設計與開發\\out.txt"));
//	    PrintWriter file_out = new PrintWriter(new FileWriter(new File("C:\\軟體設計與開發\\out.txt"), true));
	    /*或從console 輸入output file name*/
		
	        /* 逐筆讀入資料到array */
	    no=0;
	    while (file_in.hasNext()) {
	    	student[no]=new Student();
	        student[no].studentname=file_in.next();
		    student[no].score1=file_in.nextInt();
		    student[no].score2=file_in.nextInt();
		    student[no].score3=file_in.nextInt();
		    student[no].average=file_in.nextInt();
	        no++;
	    }
	    file_in.close();
	    String name = txf1.getText();
        int name_i = -1;
        for (int i = 0; i < no; i++) {
            if (student[i].studentname.equals(name)) {
                name_i = i;
                break;
            }
        }

        if (name_i != -1) {
            for (int i = name_i; i < no - 1; i++) {
                student[i] = student[i + 1];
            }
            no--;
        }

        for (int i = 0; i < no; i++) {
            System.out.print(student[i].studentname + "\t");
            System.out.print(student[i].score1 + "\t");
            System.out.print(student[i].score2 + "\t");
            System.out.print(student[i].score3 + "\t");
            System.out.println(student[i].average + "\t");
        }
	  
	    PrintWriter file_out = new PrintWriter(new File("C:\\軟體設計與開發\\out.txt"));
			/*寫入檔案*/
	     for (int i=0;i<no;i++){
	     	file_out.print(student[i].studentname+"\t");
	     	file_out.print(student[i].score1+"\t");
	     	file_out.print(student[i].score2+"\t");
	     	file_out.print(student[i].score3+"\t");
	     	file_out.println(student[i].average);
	     }
	     
	     file_out.close();
	     txtarea1.setText("");
	     for (int i=0;i<no;i++){
	    	 txtarea1.append("學號:"+student[i].studentname+"\n");
				txtarea1.append("成績1:"+student[i].score1+"\n");
				txtarea1.append("成績2:"+student[i].score2+"\n");
				txtarea1.append("成績3:"+student[i].score3+"\n");
				txtarea1.append("平均:"+student[i].average+"\n\n");
		     }
	   }
		catch (IOException ioe){
			System.out.println("file not found");
		}
	}
	static void print_data() {
		class Student{
    	   	String studentname;
    	   	int score1;
    	   	int score2;
    	   	int score3;
    	   	int average;;
    	}
    Student student[]=new Student[100];/*參考8-4*/
      try {
       	int no=0;
        Scanner file_in=new Scanner(new File("C:\\軟體設計與開發\\out.txt"));
        /*或從console 輸入input file name*/

    	
            /* 逐筆讀入資料到array */
        no=0;
        while (file_in.hasNext()) {
        	student[no]=new Student();
            student[no].studentname=file_in.next();
    	    student[no].score1=file_in.nextInt();
    	    student[no].score2=file_in.nextInt();
    	    student[no].score3=file_in.nextInt();
    	    student[no].average=file_in.nextInt();
            no++;
        }
        for (int i = 0; i < no; i++) {
            System.out.print(student[i].studentname + "\t");
            System.out.print(student[i].score1 + "\t");
            System.out.print(student[i].score2 + "\t");
            System.out.print(student[i].score3 + "\t");
            System.out.println(student[i].average + "\t");
        }
         file_in.close();
         txtarea1.setText("");
         for (int i=0;i<no;i++){
	    	 txtarea1.append("學號:"+student[i].studentname+"\n");
				txtarea1.append("成績1:"+student[i].score1+"\n");
				txtarea1.append("成績2:"+student[i].score2+"\n");
				txtarea1.append("成績3:"+student[i].score3+"\n");
				txtarea1.append("平均:"+student[i].average+"\n\n");
		     }
       }
    	catch (IOException ioe){
    		System.out.println("file not found");
    	}
	}
	static void sort_data() {
		class Student{
	       	String studentname;
	       	int score1;
	       	int score2;
	       	int score3;
	       	int average;;
	}
	Student student[]=new Student[100];/*參考8-4*/
	  try {
	   	int no=0;
	    Scanner file_in=new Scanner(new File("C:\\軟體設計與開發\\out.txt"));
	    /*或從console 輸入input file name*/
//	    PrintWriter file_out = new PrintWriter(new File("C:\\軟體設計與開發\\out.txt"));
//	    PrintWriter file_out = new PrintWriter(new FileWriter(new File("C:\\軟體設計與開發\\out.txt"), true));
	    /*或從console 輸入output file name*/
		
	        /* 逐筆讀入資料到array */
	    no=0;
	    while (file_in.hasNext()) {
	    	student[no]=new Student();
	        student[no].studentname=file_in.next();
		    student[no].score1=file_in.nextInt();
		    student[no].score2=file_in.nextInt();
		    student[no].score3=file_in.nextInt();
		    student[no].average=file_in.nextInt();
	        no++;
	    }
	    file_in.close();
	  /*依照平均分數排序*/     
	    for(int i=0;i<no;i++){
	      	for(int j=i+1;j<no;j++)
	       	  if(student[j].average<student[i].average) {      		
	    		Student tmp=new Student();
	    		tmp=student[j];
	    		student[j]=student[i];
	    		student[i]=tmp;
	       	}
	     }    
	    PrintWriter file_out = new PrintWriter(new File("C:\\軟體設計與開發\\out.txt"));
			/*寫入檔案*/
	     for (int i=0;i<no;i++){
	     	file_out.print(student[i].studentname+"\t");
	     	file_out.print(student[i].score1+"\t");
	     	file_out.print(student[i].score2+"\t");
	     	file_out.print(student[i].score3+"\t");
	     	file_out.println(student[i].average);
	     }
	     for (int i = 0; i < no; i++) {
	            System.out.print(student[i].studentname + "\t");
	            System.out.print(student[i].score1 + "\t");
	            System.out.print(student[i].score2 + "\t");
	            System.out.print(student[i].score3 + "\t");
	            System.out.println(student[i].average + "\t");
	        }
	     
	     file_out.close();
	     txtarea1.setText("");
	     for (int i=0;i<no;i++){
	    	 txtarea1.append("學號:"+student[i].studentname+"\n");
				txtarea1.append("成績1:"+student[i].score1+"\n");
				txtarea1.append("成績2:"+student[i].score2+"\n");
				txtarea1.append("成績3:"+student[i].score3+"\n");
				txtarea1.append("平均:"+student[i].average+"\n\n");
		     }
	   }
		catch (IOException ioe){
			System.out.println("file not found");
		}
	}
}

