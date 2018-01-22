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
import model.ModelFAQ;
import model.ModelPartie;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
@Transactional
@Rollback(true)
public class IPartieDAOTest {

	@Autowired(required=false)//permet aux tests de s'exécuter même si pas de bean présent
	private IPartieDAO ipd;
	@Autowired(required=false)
	private IJoueurDAO ijd;
	
	@BeforeClass
	public static void initialisation() {
		System.out.println("Démarrage du jeu de test....");
	}

	@Test
	public void testBeanIPartieDAO() {
		assertNotNull(ipd);
		
	}
	
	@Test
	public void testAjouterPartie() {
		ModelPartie a = new ModelPartie();
		assertNotNull(ijd);
		a.setJoueur(ijd.findById(2).get());
		ipd.save(a);
		
		assertEquals(ijd.findById(2).get(),ipd.findById(1).get().getJoueur());
	}
	
	@Test
	public void testFindPartie() {
		assertNotNull( ipd.findById(1).get());
	}
	
    @Test
	public void testSupprimerPartie() {
		try {
			ipd.deleteById(1);
			assertFalse(ipd.findById(1).isPresent());
			}
			catch (Exception e){
				fail();
			}
	}
	
	@Test
	public void modifierProduit() {
		Optional<ModelPartie> myOptionalPartie =  ipd.findById(1);
		ModelPartie myPartie;
		myPartie=myOptionalPartie.get();
		assertNotNull(myPartie);
		assertNotEquals(ijd.findById(6).get(),myPartie.getJoueur());
		
		myPartie.setJoueur(ijd.findById(6).get());
		ipd.save(myPartie);
		
		assertEquals(ijd.findById(6).get(), ipd.findById(1).get().getJoueur());
	}

}
