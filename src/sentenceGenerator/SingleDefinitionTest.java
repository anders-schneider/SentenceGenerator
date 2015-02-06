package sentenceGenerator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Anders Schneider
 */
public class SingleDefinitionTest {

    /**
     * Test method for {@link sentenceGenerator.SingleDefinition#toString()}.
     */
    @Test
    public final void testToString() {
    	SingleDefinition definition = new SingleDefinition();
    	definition.add("<transitive verb>");
    	definition.add("<noun>");
    	assertTrue("<transitive verb> <noun>".equals(definition.toString()));
    	
    	SingleDefinition empty = new SingleDefinition();
    	assertTrue("".equals(empty.toString()));
    	
    	SingleDefinition longer = new SingleDefinition();
    	longer.add("<determiner>");
    	longer.add("<adjectives>");
    	longer.add("<noun>");
    	assertTrue("<determiner> <adjectives> <noun>".equals(longer.toString()));
    	
    	SingleDefinition oneWord = new SingleDefinition();
    	oneWord.add("<noun>");
    	assertTrue("<noun>".equals(oneWord.toString()));
    }
}
