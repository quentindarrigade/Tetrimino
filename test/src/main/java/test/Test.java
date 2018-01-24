package test;


import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;

import model.ModelTetrimino;

public class Test {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
	}
}
	

	
		
		
		
			
	
	
//	public static String listerPiece(ApplicationContext myContext) {
//		String result = "";
//		for (ModelTetrimino mt1 : myContext.getBean(DaoTetrimino.class).getAllPiece()) {
//			result+=mt1.toString() + "\n";
//		}
//		
//		return result;
//	}


