package sentenceGenerator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author <your name goes here>
 */
public class ListOfDefinitionsTest {

    /**
     * Test method for {@link sentenceGenerator.ListOfDefinitions#toString()}.
     */
    @Test
    public final void testToString() {
    	SingleDefinition def1 = new SingleDefinition();
    	def1.add("hits");
    	SingleDefinition def2 = new SingleDefinition();
    	def2.add("sees");
    	
    	ListOfDefinitions defList = new ListOfDefinitions();
    	defList.add(def1);
    	defList.add(def2);
    	
    	assertTrue("hits | sees".equals(defList.toString()));
    	
    	ListOfDefinitions defList2 = new ListOfDefinitions();
    	
    	assertTrue("".equals(defList2.toString()));
    	
    	SingleDefinition def3 = new SingleDefinition();
    	def3.add("plays tuba");
    	
    	ListOfDefinitions defList3 = new ListOfDefinitions();
    	defList3.add(def1);
    	defList3.add(def2);
    	defList3.add(def3);
    	
    	assertTrue("hits | sees | plays tuba".equals(defList3.toString()));
    }
}
