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
import model.ModelFAQ;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
@Transactional
@Rollback(true)
public class IFAQDAOTest {
	
	@Autowired(required=false)//permet aux tests de s'exécuter même si pas de bean présent
	private IFAQDAO ifd;
	
	@BeforeClass
	public static void initialisation() {
		System.out.println("Démarrage du jeu de test....");
	}

	@Test
	public void testBeanIFAQDAO() {
		assertNotNull(ifd);
		
	}
	
	@Test
	public void testAjouterFAQ() {
		ModelFAQ a = new ModelFAQ();
		a.setQuestions("Où se trouve l'oiseau?");
		a.setPassword("1234");
		ifd.save(a);
		assertEquals("Toto",ifd.findById(1).get().getLogin());
		assertEquals("1234",ifd.findById(2).get().getPassword());
	}
	
	@Test
	public void testFindAdmin() {
		assertNotNull( ifd.findById(1).get());
	}
	
	@Test
	public void testSupprimerAdmin() {
		try {
			ifd.deleteById(1);
			assertFalse(ifd.findById(1).isPresent());
			}
			catch (Exception e){
				fail();
			}
	}
	
	@Test
	public void modifierProduit() {
		Optional<ModelAdmin> myOptionalAdmin = ifd.findById(1);
		ModelAdmin myAdmin;
		myAdmin=myOptionalAdmin.get();
		assertNotNull(myAdmin);
		assertNotEquals("ABCD",myAdmin.getLogin());
		
		myAdmin.setLogin("ABCD");
		ifd.save(myAdmin);
		
		assertEquals("ABCD", ifd.findById(1).get().getLogin());
	}
	
	

}
