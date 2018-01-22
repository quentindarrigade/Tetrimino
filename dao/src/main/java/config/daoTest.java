package config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.IAdminDAO;
import dao.IJoueurDAO;
import dao.ITetriminoDAO;
import model.*;

public class daoTest {

	public static void main(String[] args) {
		//testJoueur();
		testAdmin();

	}

	static void test1() {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		ITetriminoDAO daoTetrimino = myContext.getBean(ITetriminoDAO.class);
		ModelTetrimino a = new ModelTetrimino();
		a.setCouleur("Rouge comme les communistes");
		a.setNom("Lenine");

		daoTetrimino.save(a);

		System.out.println("ok");
	}

	static void testJoueur() {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
		IJoueurDAO daoJoueur = myContext.getBean(IJoueurDAO.class);
		ModelJoueur a = new ModelJoueur();
		a.setLogin("Larmina");
		a.setPassword("1234");
		daoJoueur.save(a);
		System.out.println("ok");
	}
	
	static void testAdmin() {
		AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext(AppConfig.class);
	IAdminDAO daoAdmin = myContext.getBean(IAdminDAO.class);
		ModelAdmin a = new ModelAdmin();
		a.setLogin("Karadoc");
		a.setPassword("1234");
		daoAdmin.save(a);
		System.out.println("ok");
	}
}
