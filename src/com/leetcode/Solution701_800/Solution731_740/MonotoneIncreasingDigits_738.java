package com.leetcode.Solution701_800.Solution731_740;

/**
 * 单调递增的数字
 *
 * @author jianghan
 * @date 2020-12-15 23:46
 */
public class MonotoneIncreasingDigits_738 {

    public int monotoneIncreasingDigits(int N) {
        char[] charArray = String.valueOf(N).toCharArray();
        for (int i = charArray.length - 1; i > 0; i--) {
            if (charArray[i] < charArray[i - 1]) {
                charArray[i - 1]--;
                for (int j = i; j < charArray.length; j++) {
                    charArray[j] = '9';
                }
            }
        }
        return Integer.parseInt(String.valueOf(charArray));
    }

    /**
     * 超时
     */
    public int monotoneIncreasingDigits1(int N) {
        if (N < 10) {
            return N;
        }
        while (N >= 10) {
            if (isRaise(N)) {
                return N;
            }
            N -= 1;
        }
        return 9;
    }

    private boolean isRaise(int i) {
        while (i >= 10) {
            int currentNum = i % 10;
            int preNum = i / 10 % 10;
            if (currentNum < preNum) {
                return false;
            }
            i = i / 10;
        }
        return true;
    }

    public static void main(String[] args) {
        MonotoneIncreasingDigits_738 monotoneIncreasingDigits_738 = new MonotoneIncreasingDigits_738();
        System.out.println(monotoneIncreasingDigits_738.monotoneIncreasingDigits(332));
    }
}
