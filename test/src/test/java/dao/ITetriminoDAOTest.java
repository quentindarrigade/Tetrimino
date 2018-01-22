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
import model.ModelTetrimino;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
@Transactional
@Rollback(true)
public class ITetriminoDAOTest {
	

	@Autowired(required=false)//permet aux tests de s'ex�cuter m�me si pas de bean pr�sent
	private ITetriminoDAO itd;
	@Autowired(required=false)//permet aux tests de s'ex�cuter m�me si pas de bean pr�sent
	private IAdminDAO iad;
	
	@BeforeClass
	public static void initialisation() {
		System.out.println("D�marrage du jeu de test....");
	}

	@Test
	public void testBeanIAdminDAO() {
		assertNotNull(itd);
	}
	
	
	
@Test
	public void testAjouterTetrimino() {
		ModelTetrimino a = new ModelTetrimino();
		a.setCouleur("Rouge comme les communistes");
		a.setNom("Lenine");
		String tetri="1,1,1/1,0,1";
		a.setTetrimino00(tetri);
		a.setTetrimino90(tetri);
		a.setTetrimino180(tetri);
		a.setTetrimino270(tetri);
		assertNotNull(iad);
		a.setAdmin(iad.findById(1).get());
		
		itd.save(a);
		assertEquals("Lenine",itd.findById(2).get().getNom());
	}

	@Test
	public void testFindCoup() {
		assertEquals(2,itd.findById(1).get().getCoups().get(0).getId());
	}
	
	
	@Test
	public void testFindTetrimino() {
		assertNotNull( itd.findById(1).get());
	}
	

	@Test
	public void testSupprimerTetrimino() {
		try {
			itd.deleteById(1);
			assertFalse(itd.findById(1).isPresent());
			}
			catch (Exception e){
				fail();
			}
	}
	
	@Test
	public void modifierTetrimino() {
		Optional<ModelTetrimino> myOptionalTetrimino = itd.findById(1);
		ModelTetrimino myTetrimino;
		myTetrimino=myOptionalTetrimino.get();
		assertNotNull(myTetrimino);
		assertNotEquals("Coty",myTetrimino.getNom());
		
		myTetrimino.setNom("Coty");
		itd.save(myTetrimino);
		
		assertEquals("Coty", itd.findById(1).get().getNom());
	}
	

}
