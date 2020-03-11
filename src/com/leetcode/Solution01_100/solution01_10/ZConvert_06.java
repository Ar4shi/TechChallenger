package com.leetcode.Solution01_100.solution01_10;

import java.util.ArrayList;
import java.util.List;

/**
 * 字形变换
 *
 * @author jianghanh
 * @date 2019-06-22 11:18
 */
public class ZConvert_06 {
    public String convert(String s, int numRows) {
        String result = "";
        boolean down = true;//初始方向为向下
        int contentNo = 0;//初始容器编号为0
        if (s.length()==0) return result;//边界单独判断
        if(numRows == 1 ) return s;
        List<StringBuffer> stringBuffers = new ArrayList<>();//按行存储字符串的容器
        for(int i = 0;i<numRows;i++){
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffers.add(stringBuffer);
        }
        for(int i =0;i<s.length();i++){
            if(contentNo == 0) down = true;//根据容器编号的大小改变Z的方向
            if(contentNo == numRows - 1) down = false;
            stringBuffers.get(contentNo).append(s.charAt(i));
            if(down) contentNo++;
            else contentNo--;
        }
        for(StringBuffer sb : stringBuffers){
            result+=sb.toString();
        }
        return result;
    }
}
