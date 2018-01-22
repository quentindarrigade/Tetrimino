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
	@Autowired(required=false)
	private IAdminDAO iad;
	
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
		a.setReponses("Oui");
		assertNotNull(iad);
		a.setAdmin(iad.findById(1).get());
		ifd.save(a);
		assertEquals("Où se trouve l'oiseau?",ifd.findById(1).get().getQuestions());
		assertEquals("Oui",ifd.findById(1).get().getReponses());
		assertEquals(iad.findById(1).get(),ifd.findById(1).get().getAdmin());
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
		Optional<ModelFAQ> myOptionalFAQ =  ifd.findById(1);
		ModelFAQ myFAQ;
		myFAQ=myOptionalFAQ.get();
		assertNotNull(myFAQ);
		assertNotEquals("ABCD",myFAQ.getReponses());
		
		myFAQ.setReponses("ABCD");
		ifd.save(myFAQ);
		
		assertEquals("ABCD", ifd.findById(1).get().getReponses());
	}
	
	

}
