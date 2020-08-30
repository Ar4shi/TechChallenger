package com.leetcode.Solution01_100.solution01_10;

import java.util.Stack;

/**
 * 整数反转
 *
 * @author jianghan
 * @date 2019-06-19 20:29
 */
public class Reverse_07 {

    public int reverse(int x) {
        long result = 0;//用长整型来接收数据
        Stack<Integer> stack = new Stack<>();//数字容器
        long times = 1;//倍率
        int size = 0;//stack的容量
        if(x==0) return 0;
        while (x!=0){
            int num = x%10;//获取每个位置上的数字
            stack.push(num);
            x = x/10;//为了遍历其他数位上的数字
        }
        size = stack.size();
        for(int i =0;i<size;i++){
            result+=stack.pop()*times;
            times*=10;
        }
        if(result<Integer.MIN_VALUE) return 0;
        if(result>Integer.MAX_VALUE) return 0;
        return (int) result;
    }

}
