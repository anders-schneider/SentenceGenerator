package sentenceGenerator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFileChooser;

/**
 * @author Anders Schneider
 * 
 * This is my version of a CIT594 assignment to read in a BNF grammar
 * and produce sentences from that grammar.
 */
public class SentenceGenerator {
    private Grammar grammar;
    private Random random = new Random();

    /**
     * Prompts the user for a file containing a BNF grammar, then
     * generates several sentences from that grammar.
     * 
     * @param args Unused.
     */
    public static void main(String[] args) {
        try {
            new SentenceGenerator().run();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Does the work of this class.
     * 
     * @throws IOException If an input exception occurs.
     */
    private void run() throws IOException {
        BufferedReader reader = getFileReader();
        grammar = new Grammar(reader);
        
        for (int i = 0; i < 20; i++) {
        	List<String> sentenceList = generate("<sentence>");
        	printAsSentence(sentenceList);
        }
        reader.close();
    }
    
    /**
     * Expands the given term into a list of terminals. If the given
     * term is already a terminal, a list containing this single term
     * is returned.
     * 
     * @param term A terminal or nonterminal to expand into a list.
     * @return A list of terminals.
     */
    List<String> generate(String term) {
        List<String> result = new ArrayList<String>();

        if (term.startsWith("<")) {
        	// Choose a definition of the non-terminal at random
        	ListOfDefinitions defList = grammar.getDefinitions(term);
        	SingleDefinition def = (SingleDefinition) chooseRandomElement(defList);
        	for (int i = 0; i < def.size(); i++) {
        		// Add the parts of the decomposed definition to result, recursively
        		// calling generate to break down further non-terminals
        		result.addAll(generate(def.get(i)));
        	}
        } else {
        	result.add(term);
        }

        return result;
    }

    /**
     * Randomly choose and return one element from a list.
     * 
     * @param list The list from which the selection is to be made.
     * @return The randomly selected element.
     */
    public Object chooseRandomElement(List list) {
        return (list.get(random.nextInt(list.size())));
    }

    /**
     * Prints the given list of words as a sentence. The first word is
     * capitalized, and a period is printed at the end.
     * 
     * @param list The words to be printed.
     */
    void printAsSentence(List<String> list) {
    	String strToPrint = "";
    	
    	if (list.isEmpty()) {
    		System.out.println(strToPrint);
    		return;
    	}
    	
    	strToPrint += list.get(0);
    	
    	// Select and capitalize the first character
    	char firstChar = strToPrint.charAt(0);
    	strToPrint = strToPrint.substring(1, strToPrint.length());
    	strToPrint = Character.toUpperCase(firstChar) + strToPrint;
    	
    	// Concatenate each successive term
    	for (int i = 1; i < list.size(); i++) {
    		strToPrint += " " + list.get(i);
    	}
    	
    	strToPrint += ".";
    	
    	System.out.println(strToPrint);
    }
    
    /**
     * Prompts the user to choose a file, which should contain a BNF grammar.
     * 
     * @return The chosen file, or <code>null</code> if none is chosen.
     * @throws IOException 
     */
    private BufferedReader getFileReader() throws IOException {
        BufferedReader reader = null;
        String fileName;
        
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Load which file?");
        int result = chooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            if (file != null) {
                fileName = file.getCanonicalPath();
                reader = new BufferedReader(new FileReader(fileName));
            }
        }
        return reader;
    }
}
