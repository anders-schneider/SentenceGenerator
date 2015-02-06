package sentenceGenerator;
import java.util.ArrayList;

/**
 * A <code>ListOfDefinitions</code> object consists of a list of alternatives
 * (each of which is a list of terminals and/or nonterminals), but
 * does not include the thing being defined.
 * 
 * @author Anders Schneider
 */
public class ListOfDefinitions extends ArrayList<SingleDefinition> {
    
    /**
     * Constructs an empty list of definitions.
     */
    ListOfDefinitions() {}
    
    /**
     * Returns a string containing the contents of this <code>ArrayList</code>,
     * separated by <code>" | "</code> symbols.
     * 
     * @see java.util.AbstractCollection#toString()
     */
    @Override
    public String toString() {
    	String result = "";
    	
    	if (this.isEmpty()) {return result;}
    	
    	result += this.get(0).toString();
    	
    	// Successively concatenate definitions, separated by " | "
    	for (int i = 1; i < this.size(); i++) {
    		result += " | " + this.get(i);
    	}
    	
    	return result;
    }
}
