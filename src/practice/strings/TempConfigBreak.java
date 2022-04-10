package practice.strings;

import java.util.StringTokenizer;

public class TempConfigBreak {

  public static void main(String[] args) {
	String s = "";
	int i=1;
	for(String subs : s.split("\n", 1080)) {
	  System.out.println("config"+i+" := config"+i+" || '"+subs+"';");
	  i++;
	}
  }

  private String addLinebreaks(String input, int maxLineLength) {
	StringTokenizer tok = new StringTokenizer(input, " ");
	StringBuilder output = new StringBuilder(input.length());
	int lineLen = 0;
	int i = 0;
	while (tok.hasMoreTokens()) {
	  String word = tok.nextToken();
	  if (lineLen + word.length() > maxLineLength) {
		System.out.println("config"+i+" := config"+i+" || '"+"';");
		i++;
		lineLen = 0;
	  }
	  output.append(word);
	  lineLen += word.length();
	}
	return output.toString();
  }

}
