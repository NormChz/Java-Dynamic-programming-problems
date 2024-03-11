package Fibonacci;

import java.util.HashMap;

public class FibBottomUp { // using memoization

    public int fibSum(int target) {
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
        FibBottomUp fib = new FibBottomUp();
        System.out.println(fib.fibSum(6));
    }
}
