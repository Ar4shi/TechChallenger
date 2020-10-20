package com.leetcode.Solution901_1000.Solution921_930;

/**
 * 长按键入
 *
 * @author jianghan
 * @date 2020-10-21 02:16
 */
public class LongPressedName_925 {
    public boolean isLongPressedName(String name, String typed) {
        if (typed.length() < name.length()) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else {
                if (i == 0) {
                    return false;
                } else {
                    if (name.charAt(i - 1) == typed.charAt(j)) {
                        j++;
                    } else {
                        return false;
                    }
                }
            }
        }
        if (i < name.length()) {
            return false;
        } else {
            if (j == typed.length()) {
                return true;
            } else {
                char lastChar = name.charAt(i - 1);
                for (int k = j - 1; k < typed.length(); k++) {
                    if (typed.charAt(k) != lastChar) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LongPressedName_925 longPressedName_925 = new LongPressedName_925();
        System.out.println(longPressedName_925.isLongPressedName("alex", "alexxr"));
    }
}
