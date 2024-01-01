package com.Interview;

public class IsUniqueLCCI_001 {

    public boolean isUnique(String astr) {
        int flag = 0;
        for (int i = 0; i < astr.length(); i++) {
            int offset = astr.charAt(i) - 'a';
            int currentFlag = 1 << offset;
            if ((flag & currentFlag) != 0) {
                return false;
            }
            flag |= currentFlag;
        }
        return true;
    }
}
