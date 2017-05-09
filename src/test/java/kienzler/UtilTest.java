package kienzler;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilTest {

	@Test
	public void testIstErstesHalbjahr() {
		boolean test = Util.istErstesHalbjahr(8);
		
		if(test){
			fail("Falsches halbjahr");
		}
		
	}
	
	@Test
	public void testIstErstesHalbjahrFalse() {
		boolean test = Util.istErstesHalbjahr(2);
		
		if(!test){
			fail("Falsches halbjahr");
		}
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public final void testIstErstesHalbjahrUngueltigeeingabe(){
		Util.istErstesHalbjahr(13);
		fail("Exception not throw");
	}
}

