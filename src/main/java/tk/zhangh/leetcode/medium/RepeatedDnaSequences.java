package tk.zhangh.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * Created by ZhangHao on 2017/5/2.
 */
public class RepeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 10; i <= s.length(); i++) {
            String substr = s.substring(i - 10, i);
            if (map.containsKey(substr)) {
                if (map.get(substr) == 1) {
                    result.add(substr);
                }
                map.put(substr, 2);
            } else {
                map.put(substr, 1);
            }
        }
        return result;
    }
}
