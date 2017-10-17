package tk.zhangh.leetcode.medium;

/**
 * Created by ZhangHao on 2017/5/19.
 */
public class SuperUglyNumber {
    public static void main(String[] args) {
        System.out.println(new SuperUglyNumber().nthSuperUglyNumber(2, new int[]{2, 3, 5}));
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] uglies = new int[n];
        int[] count = new int[primes.length];
        uglies[0] = 1;
        for (int i = 1; i < n; i++) {
            uglies[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++)
                uglies[i] = Math.min(uglies[i], primes[j] * uglies[count[j]]);
            for (int j = 0; j < primes.length; j++) {
                while (primes[j] * uglies[count[j]] == uglies[i]) count[j]++;
            }
        }
        return uglies[n - 1];
    }
}
