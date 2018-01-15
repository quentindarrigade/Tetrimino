package test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.DaoTetrimino;
import model.ModelTetrimino;

public class Test {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext myContext = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		ModelTetrimino test = myContext.getBean(DaoTetrimino.class).getPieceById(1);
		System.out.println(test);
		
//		ModelTetrimino mt = new ModelTetrimino();
//		mt.setCouleur("vert");
//		mt.setNom("Non");
//		
//		myContext.getBean(DaoTetrimino.class).ajouterPiece(mt);
//		
		System.out.println( listerPiece(myContext));
			
	}
	
	public static String listerPiece(ApplicationContext myContext) {
		String result = "";
		for (ModelTetrimino mt1 : myContext.getBean(DaoTetrimino.class).getAllPiece()) {
			result+=mt1.toString() + "\n";
		}
		
		return result;
	}

}
