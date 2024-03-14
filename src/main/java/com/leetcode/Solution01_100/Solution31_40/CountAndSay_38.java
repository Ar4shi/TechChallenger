package com.leetcode.Solution01_100.Solution31_40;

import java.util.ArrayList;
import java.util.List;

/**
 * 外观数列
 *
 * @author jianghan
 * @date 2020-02-04 23:10
 */
public class CountAndSay_38 {
    public String countAndSay(int n) {
        String result = "";
        List<String> oldStr = new ArrayList<>();
        List<String> newStr = new ArrayList<>();
        for(int i = 1 ; i<=n;i++){
            if(i == 1) {
                oldStr.add("1");
                newStr.add("1");
            }else{
                newStr.clear();
                int count = 1;
                for(int j = 0;j<oldStr.size();j++){
                    if(j+1<oldStr.size()){
                        if(oldStr.get(j).equals(oldStr.get(j+1))){
                            count++;
                        }else{
                            newStr.add(String.valueOf(count));
                            newStr.add(oldStr.get(j));
                            count = 1;
                        }
                    }else{
                        newStr.add(String.valueOf(count));
                        newStr.add(oldStr.get(j));
                        oldStr.clear();
                        oldStr.addAll(newStr);
                        break;
                    }
                }
            }
        }
        for(String str : newStr) result += str;
        return result;
    }

    public static void main(String[] args) {
        CountAndSay_38 countAndSay_38 = new CountAndSay_38();
        String sss = countAndSay_38.countAndSay(6);
        System.out.println(sss);
    }
}
