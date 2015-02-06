package sentenceGenerator;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Anders Schneider
 */
public class SentenceGeneratorTest {

    /**
     * Test method for {@link sentenceGenerator.SentenceGenerator#readGrammar()}.
     */
    @Test
    public final void testChooseRandomElement() {
    	SentenceGenerator sg = new SentenceGenerator();
    	
    	ArrayList<Integer> arrList = new ArrayList<Integer>();
    	arrList.add(1);
    	arrList.add(2);
    	arrList.add(3);
    	arrList.add(4);
    	arrList.add(5);
    	
    	assertTrue(arrList.contains(sg.chooseRandomElement(arrList)));
    }

}
