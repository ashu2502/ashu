package practice.strings;

import java.util.Arrays;
import java.util.List;

public class StringClass {
    public static void main(String[] args) {
        String s = "operatingSystem.name:`Windows` and tags.name:[`tag1`,`tag2`] and tags.name:\"tag3\"";

        //s = s.replaceAll("[[(tags.name:\\[)]+[A-Za-z0-9\"` ,$&+,:;=?@#|'<>.\\-^*()%!]*]", "<REDACTED>");
        s = s.replaceAll("[(tags\\.name( )*:( )*\\[)][A-Za-z0-9\"` ,$&+,:;=?@#|'<>.\\-^*()%!]*\\]","<REDACTED>");
        System.out.println(s);
    }

    private static List<Integer> getMatchNonMatchCount(String a, String b) {
        int matchCount = 0;
        int nonMatchCount = 0;
        for(char c : a.toCharArray()) {
            if(b.indexOf(c)>-1) matchCount++;
            else nonMatchCount++;
        }
        nonMatchCount += Math.abs(b.length()-a.length());
        return Arrays.asList(matchCount, nonMatchCount);
    }


}
