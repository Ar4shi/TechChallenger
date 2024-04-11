package com.interview.medium;

import org.junit.Test;

public class GroupAnagramsTest {

    @Test
    public void test() {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams.groupAnagrams(strs));
    }
}
