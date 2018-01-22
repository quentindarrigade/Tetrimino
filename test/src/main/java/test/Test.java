package test;


import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;

import model.ModelTetrimino;

public class Test {

	public static void main(String[] args) {
		
		//AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);		
	/*	ModelTetrimino p1 = new ModelTetrimino();
		p1.setTetrimino00("1,0,1/1,1,1");
		System.out.println(p1.getTetrimino00());*/
		String str = "1,0,1/1,1,1/";
		String reponse="";
		String [] t1= str.split("/");
        int hauteur = t1.length;
        int largeur = t1[0].split(",").length;
        String [][] l2= new String [hauteur] [largeur];
        for (int i=0; i<hauteur;i++) {
            String [] t = t1[i].split(",");
            for (int j=0; j<largeur;j++) {
                l2[i][j] = t[j];
            }
        }
       // String [][] l3= new String [largeur] [hauteur];
        for (int i=0;i< largeur;i++) {
            for (int j =0;j<hauteur;j++) {
                reponse= reponse + l2[hauteur-j-1][i]+",";
            }
            reponse+="/";
        }
        
//        for(int i =0;i<largeur;i++) {
//        	for (int j=0;j<hauteur;j++) {
//        		reponse=reponse + l3[i][j]+ ",";
//        	}
//        	reponse+="/";
//        }
        
        System.out.println(reponse);
		}
		
		
		
		
		
		
		
		
		
		
		/*
		String s1 =  "1,0,1/1,1,1";
		System.out.println(s1);
		//String[][] s2= s1.split("/");
		//System.out.println(s2);
		
		int tab[][]={{1,0,1},{1,1,1}},  i=0 , j=0 ;
		 System.out.print(tab[0][0]);
		while (i < 2)
		{
		  j = 0;
		  while(j < 5)
		  {
		    System.out.print(tab[i][j]);
		    j++;
		  }
		  System.out.println("");
		  i++;
		};
		//System.out.println(tab[1][]);
		
		for (int[] k : tab)
		{
		    System.out.println(k);
		}
		
		while (i < 2)
		{
		  j = 0;
		  while(j < 5)
		  {
		    System.out.print(tab[i][j]);
		    j++;
		  }
		  System.out.println("");
		  i++;
		}
		
		//int s3= s2.length;
		//System.out.println(s3+" s3");
		
		for (String i : s2)
		{
		    System.out.println(i);
		}
		
		System.out.println(s2.length);
		//System.out.println(s3.length);
		
	
		String[] a = s1.split("/");
        boolean[][] b = new boolean[a.length][a[0].length()];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                b[i][j] = (a[i].charAt(j) == 'x');
            }
        }
        System.out.println(b);*/
    }

	
		
		
		
			
	
	
//	public static String listerPiece(ApplicationContext myContext) {
//		String result = "";
//		for (ModelTetrimino mt1 : myContext.getBean(DaoTetrimino.class).getAllPiece()) {
//			result+=mt1.toString() + "\n";
//		}
//		
//		return result;
//	}


