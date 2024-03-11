package LCS;

import java.util.Arrays;

public class LCS { // Longest Common Subsequence (strings)



    public int findLCSDynamic(String text1, String text2) { // O( len(text1) * len(text2) )
        int[][] grid = new int[text1.length() + 1][];

        for (int i = 0; i < grid.length; i++) {
            grid[i] = new int[text2.length() + 1];
            Arrays.fill(grid[i], 0);
        }

        for (int i = text1.length()-1; i > -1; i--) {
            for (int j = text2.length()-1; j > -1; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    grid[i][j] = 1 + grid[i + 1][j + 1];
                } else {
                    grid[i][j] = Math.max(grid[i][j+1], grid[i+1][j]);
                }
            }
        }

        return grid[0][0];
    }


    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        LCS lcs = new LCS();

        System.out.println(lcs.findLCSDynamic(text1, text2));
    }
}
