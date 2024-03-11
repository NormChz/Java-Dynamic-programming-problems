package LCS;

public class LCSRecursive {

    public int findLCSRecursive(String t1, String t2) { // O(2^n) -> checks all possible combinations

        if (t1.length() == 0 || t2.length() == 0)
            return 0;

        String subT1 = t1.substring(0, t1.length()-1);
        String subT2 = t2.substring(0, t2.length()-1);

        if (t1.charAt(t1.length()-1) == t2.charAt(t2.length()-1)) {
            return 1 + findLCSRecursive(subT1, subT2);
        } else {
            return Math.max(findLCSRecursive(subT1, t2), findLCSRecursive(t1, subT2));

        }
    }


    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        LCSRecursive lcs = new LCSRecursive();

        System.out.println(lcs.findLCSRecursive(text1, text2));
    }
}
