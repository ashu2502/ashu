package practice.interview;

import java.util.HashMap;
import java.util.Map;

public class Operative {
  // 9,8,2,4,10,6,5,10
  public static void main(String[] args) {
    String s = "ABC";
	//System.out.println(findSecondMaxNumber(new int[]{9,8,2,4,10,6,5,10}));
	reverseString("sun@rise");
  }

  private static int findSecondMaxNumber(int[] arr) {
    int max = -1;
    int secondMax = -1;
    for(int i:arr) {
      if(i>max) {
        secondMax = max;
        max = i;
	  } else if(i>secondMax && i<max) {
        secondMax = i;
	  }
	}
    return secondMax;
  }

  // sun@rise -> esi@rnus
  private static void reverseString(String str) {
    char[] charArr = str.toCharArray();
    int arrLen = charArr.length;
    char temp;
    int lastIndexPtr = arrLen-1;
    for(int i=0;i<=arrLen/2;i++) {
      if(charArr[i]!='@') {
		temp = charArr[i];
		charArr[i] = charArr[lastIndexPtr];
		charArr[lastIndexPtr] = temp;
		lastIndexPtr--;
	  }
	}
    System.out.print(String.valueOf(charArr));
  }

  private static final Map<Character,
		Integer> roman = new HashMap<Character,
			  Integer>()
  {{
	put('I', 1);
	put('V', 5);
	put('X', 10);
	put('L', 50);
	put('C', 100);
	put('D', 500);
	put('M', 1000);
  }};

  // This function returns value
  // of practice.a Roman symbol
  private static int romanToInt(String s)
  {
	int sum = 0;
	int n = s.length();

	for(int i = 0; i < n; i++)
	{

	  // If present value is less than next value,
	  // subtract present from next value and add the
	  // resultant to the sum variable.
	  if (i != n - 1 && roman.get(s.charAt(i)) <
		  roman.get(s.charAt(i + 1)))
	  {
		sum += roman.get(s.charAt(i + 1)) -
			roman.get(s.charAt(i));
		i++;
	  }
	  else
	  {
		sum += roman.get(s.charAt(i));
	  }
	}
	return sum;
  }

}
