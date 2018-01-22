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
import model.ModelCoup;
import model.ModelFAQ;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
@Transactional
@Rollback(true)
public class ICoupDAOTest {
	
	@Autowired(required=false)//permet aux tests de s'exécuter même si pas de bean présent
	private ICoupDAO icd;
	
	@BeforeClass
	public static void initialisation() {
		System.out.println("Démarrage du jeu de test....");
	}

	@Test
	public void testBeanICoupDAO() {
		assertNotNull(icd);
		
	}
	
	@Test
	public void testAjouterCoup() {
		ModelCoup a = new ModelCoup();
		a.setJoueur();
		icd.save(a);
		assertEquals("Toto",icd.findById(1).get().getLogin());
		assertEquals("1234",icd.findById(2).get().getPassword());
	}
	
	@Test
	public void testFindCoup() {
		assertNotNull( icd.findById(1).get());
	}
	
	@Test
	public void testSupprimerCoup() {
		try {
			icd.deleteById(1);
			assertFalse(icd.findById(1).isPresent());
			}
			catch (Exception e){
				fail();
			}
	}
	
	@Test
	public void modifierCoup() {
		Optional<ModelCoup> myOptionalCoup = icd.findById(1);
		ModelCoup myCoup;
		myCoup=myOptionalCoup.get();
		assertNotNull(myCoup);
		assertNotEquals("ABCD",myCoup.getLogin());
		
		myCoup.setLogin("ABCD");
		icd.save(myCoup);
		
		assertEquals("ABCD", icd.findById(1).get().getLogin());
	}
	
	

}
