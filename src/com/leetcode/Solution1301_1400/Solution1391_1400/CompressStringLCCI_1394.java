package com.leetcode.Solution1301_1400.Solution1391_1400;

/**
 * 字符串压缩
 *
 * @author jianghanh
 * @date 2020-03-16 00:14
 */
public class CompressStringLCCI_1394 {
    public String compressString(String S) {
        String res = "";
        int i = 0;
        int count = 1;
        while(i<S.length()){
            if(i+1<S.length()){
                if(S.charAt(i)==S.charAt(i+1)){
                    count++;
                }else {
                    res+=S.charAt(i)+String.valueOf(count);
                    count = 1;
                }
            }else {
                res+=S.charAt(i)+String.valueOf(count);
            }
            i++;
        }
        return res.length()<S.length()?res:S;
    }
}
