package textgen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * An implementation of the MTG interface that uses a list of lists.
 * @author UC San Diego Intermediate Programming MOOC team 
 */
public class MarkovTextGeneratorLoL implements MarkovTextGenerator {

	// The list of words with their next words
	private List<ListNode> wordList; 
	
	// The starting "word"
	private String starter;
	
	// The random number generator
	private Random rnGenerator;
	
	public MarkovTextGeneratorLoL(Random generator)
	{
		wordList = new LinkedList<ListNode>();
		starter = "";
		rnGenerator = generator;
	}
	
	
	/** Train the generator by adding the sourceText */
	@Override
	public void train(String sourceText)
	{	
		String prevWord;
		// TODO: Implement this method
		List<String> tokens = getTokens("[a-zA-Z.,]+", sourceText);
		
		if(tokens.size()==0)
			return;
		//System.out.println(tokens);
//		for (int i = 0; i < tokens.size(); i++) {
//			System.out.println(tokens.get(i));
//		}
//		set "starter" to be the first word in the text  
		starter = tokens.get(0);
//		set "prevWord" to be starter
		prevWord = new String(starter);
	    
//		for each word "w" in the source text starting at the second word
//		   check to see if "prevWord" is already a node in the list
//		      if "prevWord" is a node in the list
//		         add "w" as a nextWord to the "prevWord" node
//		      else
//		         add a node to the list with "prevWord" as the node's word
//		         add "w" as a nextWord to the "prevWord" node
//		    set "prevWord" = "w"
//
//		add starter to be a next word for the last word in the source text.
		for (int i = 1; i < tokens.size(); i++) {	
			ListNode ln = findWords(wordList, prevWord);
		    if(ln!= null) 
		    	ln.addNextWord(tokens.get(i));
			else {
				ListNode listNode = new ListNode(prevWord);
				listNode.addNextWord(tokens.get(i));
				wordList.add(listNode);					
			}
			prevWord = tokens.get(i);	
		}
		ListNode listNode1 = new ListNode(prevWord);
		listNode1.addNextWord(starter);
		wordList.add(listNode1);					
		
	}
	
	/** 
	 * Generate the number of words requested.
	 */
	@Override
	public String generateText(int numWords) {
	    // TODO: Implement this method
		
//		set "currWord" to be the starter word
		String currWord = new String(starter);
//		set "output" to be ""
		String output = "";
//		add "currWord" to output
		output += currWord;
		
		if (wordList.isEmpty() || numWords == 0)
			return "";
		
		int counter = 1;
//		while you need more words
		while(counter < numWords) {
//		   find the "node" corresponding to "currWord" in the list
			ListNode node = findWords(wordList, currWord);
//		   select a random word "w" from the "wordList" for "node"
			String word = new String (node.getRandomNextWord(rnGenerator));
//		   add "w" to the "output"
			output += " " + word;			   		   
//		   set "currWord" to be "w" 
		   currWord = word;
//		   increment number of words added to the list
			counter++;
		}
		return output;
	}
	
	
	// Can be helpful for debugging
	@Override
	public String toString()
	{
		String toReturn = "";
		for (ListNode n : wordList)
		{
			toReturn += n.toString();
		}
		return toReturn;
	}
	
	/** Retrain the generator from scratch on the source text */
	@Override
	public void retrain(String sourceText)
	{
		// TODO: Implement this method.
		starter = "";
		wordList.clear();
		train(sourceText);
	}
	
	// TODO: Add any private helper methods you need here.
	private List<String> getTokens(String pattern, String sourceText)
	{
		ArrayList<String> tokens = new ArrayList<String>();
		Pattern tokSplitter = Pattern.compile(pattern);
		Matcher m = tokSplitter.matcher(sourceText);

		while (m.find()) {
			tokens.add(m.group());
		}

		return tokens;
	}
	
	private ListNode findWords (List<ListNode> wordList, String prevWord) {
		for (ListNode currNode : wordList) {
			if(currNode.getWord().contentEquals(prevWord))
				return currNode;								
		}
		return null;
	}
	
	
	/**
	 * This is a minimal set of tests.  Note that it can be difficult
	 * to test methods/classes with randomized behavior.   
	 * @param args
	 */
	public static void main(String[] args)
	{
		// feed the generator a fixed random value for repeatable behavior
		MarkovTextGeneratorLoL gen = new MarkovTextGeneratorLoL(new Random(41));
		String textString = "Hello.  Hello there.  This is a test.  Hello there.  Hello Bob.  Test again.";
		System.out.println(textString);
		gen.train(textString);
		System.out.println(gen);
		System.out.println(gen.generateText(11));
		String textString2 = "You say yes, I say no, "+
				"You say stop, and I say go, go, go, "+
				"Oh no. You say goodbye and I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"I say high, you say low, "+
				"You say why, and I say I don't know. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"Why, why, why, why, why, why, "+
				"Do you say goodbye. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"You say yes, I say no, "+
				"You say stop and I say go, go, go. "+
				"Oh, oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello,";
		System.out.println(textString2);
		gen.retrain(textString2);
		System.out.println(gen);
		System.out.println(gen.generateText(20));
	}

}

/** Links a word to the next words in the list 
 * You should use this class in your implementation. */
class ListNode
{
    // The word that is linking to the next words
	private String word;
	
	// The next words that could follow it
	private List<String> nextWords;
	
	ListNode(String word)
	{
		this.word = word;
		nextWords = new LinkedList<String>();
	}
	
	public String getWord()
	{
		return word;
	}

	public void addNextWord(String nextWord)
	{
		nextWords.add(nextWord);
	}
	
	public String getRandomNextWord(Random generator)
	{
		// TODO: Implement this method
	    // The random number generator should be passed from 
	    // the MarkovTextGeneratorLoL class
		return nextWords.get(generator.nextInt(nextWords.size()));
	}

	public String toString()
	{
		String toReturn = word + ": ";
		for (String s : nextWords) {
			toReturn += s + "->";
		}
		toReturn += "\n";
		return toReturn;
	}	
}


