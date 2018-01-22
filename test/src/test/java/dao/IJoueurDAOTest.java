package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.AppConfig;
import model.ModelAdmin;
import model.ModelJoueur;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
@Transactional
@Rollback(false)

public class IJoueurDAOTest {

	@Autowired(required=false)//permet aux tests de s'exécuter même si pas de bean présent
	private IJoueurDAO ijd;
	
	@BeforeClass
	public static void initialisation() {
		System.out.println("Démarrage du jeu de test....");
	}

	@Test
	public void testBeanIJoueurDAO() {
		assertNotNull(ijd);
		
	}
	
	@Test
	public void testAjouterJoueur() {
		ModelJoueur a = new ModelJoueur();
		a.setLogin("Tota");
		a.setPassword("1234");
		ijd.save(a);
		assertEquals("Tota",ijd.findById(6).get().getLogin());
		assertEquals("1234",ijd.findById(6).get().getPassword());
	}
	
	//@Test
	public void testFindJoueur() {
		assertNotNull( ijd.findById(2).get());
	}
	
	//@Test
	public void testSupprimerJoueur() {
		try {
			ijd.deleteById(2);
			assertFalse(ijd.findById(2).isPresent());
			}
			catch (Exception e){
				fail();
			}
	}
	
	//@Test
	public void modifierJoueur() {
		Optional<ModelJoueur> myOptionalJoueur = ijd.findById(2);
		ModelJoueur myJoueur;
		myJoueur=myOptionalJoueur.get();
		assertNotNull(myJoueur);
		assertNotEquals("ABCD",myJoueur.getLogin());
		
		myJoueur.setLogin("ABCD");
		ijd.save(myJoueur);
		
		assertEquals("ABCD", ijd.findById(2).get().getLogin());

}
}
