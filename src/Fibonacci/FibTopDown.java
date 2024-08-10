package Fibonacci;

import java.util.HashMap;

public class FibTopDown { // using memoization

    public int calcFib(int target) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return _fibSum(target, memo);
    }

    private int _fibSum(int target, HashMap<Integer, Integer> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        if (target == 1 || target == 0) {
            return target;
        }
        int result = _fibSum(target - 1, memo) + _fibSum(target - 2, memo);
        memo.put(target, result);
        return result;
    }

    public static void main(String[] args) {
        FibTopDown fib = new FibTopDown();
        System.out.println(fib.calcFib(6));
    }
}
