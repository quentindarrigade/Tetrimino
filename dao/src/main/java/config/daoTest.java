package config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.IJoueurDAO;
import model.*;

public class daoTest {

	public static void main(String[] args) {
		test1();

	}

	static void test1() {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		IJoueurDAO daoJoueur = myContext.getBean(IJoueurDAO.class);
		ModelJoueur myJoueur = new ModelJoueur();
		myJoueur.setLogin("Jean-Marie");
		myJoueur.setPassword("1234");
		daoJoueur.save(myJoueur);
		
		System.out.println("ok");
	}
}
