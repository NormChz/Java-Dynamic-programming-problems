package LIS;

import java.util.ArrayList;
import java.util.Arrays;

public class LIS {

    public ArrayList<Integer> findLIS(int[] numbers) {

        int[] count = new int[numbers.length];
        int[] position = new int[numbers.length];
        Arrays.fill(count,1);
        Arrays.fill(position,-1);

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j] && count[i] < count[j] + 1) {
                    count[i] = count[j]+1;
                    position[i] = j;
                }
            }
        }
        int maxCount = 0;
        int maxIDX = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                maxIDX = i;
            }
        }

        ArrayList<Integer> lst = new ArrayList<>();
        lst.add(0,numbers[maxIDX]);
        while (position[maxIDX] != -1) {
            maxIDX = position[maxIDX];
            lst.add(0,numbers[maxIDX]);
        }

        return lst;
    }


    public static void main(String[] args) {
        int[] numbers = {5,3,4,8,7,10};
        LIS lis = new LIS();
        System.out.println(lis.findLIS(numbers));
    }
}
