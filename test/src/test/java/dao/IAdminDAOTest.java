package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

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
import model.ModelTetrimino;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
@Transactional
@Rollback(true)

public class IAdminDAOTest {
	

	@Autowired(required=false)//permet aux tests de s'exécuter même si pas de bean présent
	private IAdminDAO iad;
	
	@BeforeClass
	public static void initialisation() {
		System.out.println("Démarrage du jeu de test....");
	}

	@Test
	public void testBeanIAdminDAO() {
		assertNotNull(iad);
		
	}
	
	@Test
	public void testAjouterAdmin() {
		ModelAdmin a = new ModelAdmin();
		a.setLogin("Toto");
		a.setPassword("1234");
		iad.save(a);
		assertEquals("Toto",iad.findById(1).get().getLogin());
		assertEquals("1234",iad.findById(1).get().getPassword());
	}
	
	@Test
	public void testFindPiece()  {
		List<ModelTetrimino> l= iad.findById(1).get().getTetrimino();
		assertEquals("Lenine",l.get(0).getNom());
	}
	
	@Test
	public void testFindFAQ() {
		assertEquals("Où se trouve l'oiseau?",iad.findById(1).get().getFaq().get(0).getQuestions());
	}
	
	@Test
	public void testFindAdmin() {
		assertNotNull( iad.findById(1).get());
	}
	
	@Test
	public void testSupprimerAdmin() {
		try {
			iad.deleteById(1);
			assertFalse(iad.findById(1).isPresent());
			}
			catch (Exception e){
				fail();
			}
	}
	
	@Test
	public void modifierProduit() {
		Optional<ModelAdmin> myOptionalAdmin = iad.findById(1);
		ModelAdmin myAdmin;
		myAdmin=myOptionalAdmin.get();
		assertNotNull(myAdmin);
		assertNotEquals("ABCD",myAdmin.getLogin());
		
		myAdmin.setLogin("ABCD");
		iad.save(myAdmin);
		
		assertEquals("ABCD", iad.findById(1).get().getLogin());
	}
	

}
