package practice.strings;

public class PrintAllCombinations {

  public static void main(String[] args) {
	permuteString("heap", 0, 3);
  }

  private static void permuteString(String str, int left, int right) {
	if (left == right) {
	  System.out.println(str);
	} else {
	  for(int i=left; i<=right; i++) {
		str = swap(str, left, i);
		permuteString(str, left+1, right);
		str = swap(str, i, left);
	  }
	}
  }

  private static String swap(String str, int left, int right) {
    char[] charArr = str.toCharArray();
    char buffer;
    buffer = charArr[left];
    charArr[left] = charArr[right];
    charArr[right] = buffer;
    return String.valueOf(charArr);
  }

}
