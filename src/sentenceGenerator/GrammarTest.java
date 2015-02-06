package sentenceGenerator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Anders Schneider
 */
public class GrammarTest {

    /**
     * Test method for {@link sentenceGenerator.Grammar#Grammar()}.
     */
    @Test
    public final void testGrammar() {
    	Grammar grammar = new Grammar();
    	
    	grammar.addRule("<this> ::= <that> | <other thing>");
    	grammar.addRule("<this> ::= <something else>");
    	grammar.addRule("<this> ::= boy");
    	
    	SingleDefinition def1 = new SingleDefinition();
    	def1.add("<that>");
    	SingleDefinition def2 = new SingleDefinition();
    	def2.add("<other thing>");
    	SingleDefinition def3 = new SingleDefinition();
    	def3.add("<something else>");
    	SingleDefinition def4 = new SingleDefinition();
    	def4.add("boy");
    	
    	ListOfDefinitions defList = new ListOfDefinitions();
    	defList.add(def1);
    	defList.add(def2);
    	defList.add(def3);
    	defList.add(def4);
    	
    	assertEquals("<that> | <other thing> | <something else> | boy", grammar.getDefinitions("<this>").toString());
    }

    /**
     * Test method for {@link sentenceGenerator.Grammar#addRule(java.lang.String)}.
     */
    @Test
    public final void testAddRule() {
    	Grammar grammar = new Grammar();
    	
    	ListOfDefinitions defList1 = new ListOfDefinitions();
    	SingleDefinition def1 = new SingleDefinition();
    	def1.add("<noun phrase>");
    	def1.add("<verb phrase>");
    	defList1.add(def1);
    	
    	grammar.addRule("<sentence> ::= <noun phrase> <verb phrase>");
    	assertTrue(grammar.getDefinitions("<sentence>").toString().equals(defList1.toString()));
    	
    	SingleDefinition def2 = new SingleDefinition();
    	def2.add("<something else>");
    	defList1.add(def2);
    	
    	grammar.addRule("<sentence> ::= <something else>");
    	assertTrue(grammar.getDefinitions("<sentence>").toString().equals(defList1.toString()));
    	
    	ListOfDefinitions defList2 = new ListOfDefinitions();
    	SingleDefinition def3 = new SingleDefinition();
    	def3.add("and");
    	SingleDefinition def4 = new SingleDefinition();
    	def4.add("but");
    	defList2.add(def3);
    	defList2.add(def4);
    	
    	grammar.addRule("<conjunction> ::= and | but");
    	assertTrue(grammar.getDefinitions("<conjunction>").toString().equals(defList2.toString()));
    
    	try {
    		grammar.addRule("conjunction ::= and | but");
    		fail("Should have thrown exception");
    	} catch (IllegalArgumentException e) {
    		assertEquals(e.getMessage(), "Syntax error in rule: conjunction ::= and | but");
    	}
    	
    	try {
    		grammar.addRule("<this> <that> ::= wrong");
    		fail("Should have thrown exception");
    	} catch (IllegalArgumentException e) {
    		assertEquals(e.getMessage(), "Syntax error in rule: <this> <that> ::= wrong");
    	}
    }

    /**
     * Test method for {@link sentenceGenerator.Grammar#getDefinitions(java.lang.String)}.
     */
    @Test
    public final void testGetDefinitions() {
    	Grammar grammar = new Grammar();
    	
    	ListOfDefinitions defList1 = new ListOfDefinitions();
    	SingleDefinition def1 = new SingleDefinition();
    	def1.add("<noun phrase>");
    	def1.add("<verb phrase>");
    	defList1.add(def1);
    	
    	grammar.addRule("<sentence> ::= <noun phrase> <verb phrase>");
    	assertTrue(grammar.getDefinitions("<sentence>").toString().equals(defList1.toString()));
    	
    	SingleDefinition def2 = new SingleDefinition();
    	def2.add("<something else>");
    	defList1.add(def2);
    	
    	grammar.addRule("<sentence> ::= <something else>");
    	assertTrue(grammar.getDefinitions("<sentence>").toString().equals(defList1.toString()));
    	
    	ListOfDefinitions defList2 = new ListOfDefinitions();
    	SingleDefinition def3 = new SingleDefinition();
    	def3.add("and");
    	SingleDefinition def4 = new SingleDefinition();
    	def4.add("but");
    	defList2.add(def3);
    	defList2.add(def4);
    	
    	grammar.addRule("<conjunction> ::= and | but");
    	assertTrue(grammar.getDefinitions("<conjunction>").toString().equals(defList2.toString()));
    }

}
