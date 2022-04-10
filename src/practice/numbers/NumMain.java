package practice.numbers;

public class NumMain {
  static int max;
  public static void main(String[] args) {
    max = 129814999;
    findMaxNumWithSwaps("129814999".toCharArray(), 4);
	//findMaximumNum("129814999".toCharArray(), 4);
	System.out.println(max);
  }

  private static void findMaxNumWithSwaps(char[] inputNum, int numSwapsAllowed) {
    if(numSwapsAllowed==0)
      return;
    max = Integer.valueOf(String.valueOf(inputNum));
    for(int i=0; i<inputNum.length-1; i++) {
      for(int j=i+1; j<inputNum.length; j++) {
        if(inputNum[j]>inputNum[i]) {
		  swap(inputNum, i, j);
		  if (new String(inputNum).compareTo(String.valueOf(max)) > 0) {
			max = Integer.valueOf(new String(inputNum));
		  }
		  findMaxNumWithSwaps(inputNum, numSwapsAllowed - 1);
		  swap(inputNum, i, j);
		}
	  }
	}
  }

  static void findMaximumNum(char[] str,
	  int k)
  {
	// Return if no swaps left
	if (k == 0)
	  return;

	int n = str.length;

	// Consider every digit
	for (int i = 0; i < n - 1; i++)
	{
	  // Compare it with all digits
	  // after it
	  for (int j = i + 1; j < n; j++)
	  {
		// if digit at position i
		// is less than digit
		// at position j, swap it
		// and check for maximum
		// number so far and recurse
		// for remaining swaps
		if (str[i] < str[j])
		{
		  // swap str[i] with
		  // str[j]
		  char t = str[i];
		  str[i] = str[j];
		  str[j] = t;

		  // If current num is more
		  // than maximum so far
		  if (String.valueOf(str).compareTo(String.valueOf(max)) > 0)
			max = Integer.valueOf(String.valueOf(str));

		  // recurse of the other
		  // k - 1 swaps
		  findMaximumNum(str, k - 1);

		  // Backtrack
		  char c = str[i];
		  str[i] = str[j];
		  str[j] = c;
		}
	  }
	}
  }

  private static void swap(char[] charArr, int i, int j) {
    char temp = charArr[i];
    charArr[i] = charArr[j];
    charArr[j] = temp;
  }
}
