package practice.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CheckParenthesis {
  	private static final Map<Character, Character> OPENING_CLOSING_BRACKET_MAP = new HashMap() {{put('{','}'); put('(',')'); put('[',']'); }};

	public static void main(String[] args) {
	  String s="{}{(})";
	  System.out.println(isParenthesisNestingCorrect(s.toCharArray()));
	}

	private static boolean isParenthesisNestingCorrect(char[] charArray) {
	  Stack<Character> characterStack = new Stack<>();
	  for(char ch: charArray) {
	    if(!characterStack.empty() && OPENING_CLOSING_BRACKET_MAP.containsKey(characterStack.peek()) && ch==OPENING_CLOSING_BRACKET_MAP.get(characterStack.peek())) {
	      characterStack.pop();
		} else {
	      characterStack.push(ch);
		}
	  }
	  return characterStack.empty();
	}
}
