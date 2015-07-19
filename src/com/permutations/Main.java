package com.permutations;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // http://www.regentsprep.org/regents/math/algebra/apr2/LpermRep.htm
        System.out.println(getDiffWords("apple"));
    }

    private static int getDiffWords(String input) {
        char[] inputArr = input.toCharArray();
        HashMap<Character, Integer> types = new HashMap<Character, Integer>();
        for (char c : inputArr) {
            Integer num = types.get(c);
            if (num == null) {
                types.put(c, 1);
            } else {
                types.put(c, ++num);
            }
        }
        int res = getFactorial(input.length());
        for (Map.Entry<Character, Integer> entry : types.entrySet()) {
            res /= entry.getValue();
        }
        return res;
    }

    private static int getFactorial(int n) {
        int res = 1;
        while (n >= 1) {
            res *= n;
            n--;
        }
        return res;
    }
}
