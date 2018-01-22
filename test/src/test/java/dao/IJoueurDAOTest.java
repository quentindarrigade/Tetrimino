package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;
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
import model.ModelCoup;
import model.ModelJoueur;
import model.ModelTetrimino;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
@Transactional
@Rollback(true)

public class IJoueurDAOTest {

	@Autowired(required=false)//permet aux tests de s'ex�cuter m�me si pas de bean pr�sent
	private IJoueurDAO ijd;
	
	
	@BeforeClass
	public static void initialisation() {
		System.out.println("D�marrage du jeu de test....");
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
		assertEquals("Larmina",ijd.findById(1).get().getLogin());
		assertNotEquals("1234",ijd.findById(1).get().getPassword());
	}
	
	@Test
	public void testFindPartie() {
		assertEquals(1,ijd.findById(1).get().getParties().get(0).getId());
	}
	
	@Test
	public void testFindJoueur() {
		assertNotNull( ijd.findById(2).get());
	}
	
	@Test
	public void testQuery() {
		assertEquals( "Larmina", ijd.authJoueur("Larmina", "1234").getLogin());
	/*	try {
		ijd.authJoueur("Larmina", "1234");
		}
		catch (Exception e) {
			fail();
			System.out.println("ERROR");
		}*/
		
		
		//assertEquals( "Larmina", ijd.authJoueur("Larmina", "1234").getLogin());
	}
	
	@Test
	public void testFindCoup() {
		List<ModelCoup> l= ijd.findById(1).get().getCoup();
		assertEquals(1,l.get(0).getId());
	}
	
	
	
	
	
	@Test
	public void testSupprimerJoueur() {
		try {
			ijd.deleteById(2);
			assertFalse(ijd.findById(2).isPresent());
			}
			catch (Exception e){
				fail();
			}
	}
	
	@Test
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
