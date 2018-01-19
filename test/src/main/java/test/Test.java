package test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;
import dao.DaoTetrimino;
import model.ModelTetrimino;

public class Test {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);		ModelTetrimino test = myContext.getBean(DaoTetrimino.class).getPieceById(1);
		
			
	}
	
	public static String listerPiece(ApplicationContext myContext) {
		String result = "";
		for (ModelTetrimino mt1 : myContext.getBean(DaoTetrimino.class).getAllPiece()) {
			result+=mt1.toString() + "\n";
		}
		
		return result;
	}

}
