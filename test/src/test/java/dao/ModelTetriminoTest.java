package dao;

import static org.junit.Assert.*;



import org.junit.Test;





import model.ModelTetrimino;




public class ModelTetriminoTest {

	
	private ModelTetrimino mt = new ModelTetrimino();
	
	@Test
	public void testRotation() {
		String str = "1,1,1/1,0,1";
		assertEquals("1,1,/0,1,/1,1,/",mt.rotation(str));
	}


}
