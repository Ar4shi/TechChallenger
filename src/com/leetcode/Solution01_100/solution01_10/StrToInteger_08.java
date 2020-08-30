package com.leetcode.Solution01_100.solution01_10;

/**
 * 字符串转换整数
 *
 * @author jianghan
 * @date 2019-06-20 16:04
 */
public class StrToInteger_08 {
    public int myAtoi(String str) {
        String string = handleSpacce(str);
        return handleValue(string);
    }

    /**
     * 处理空格(最前面的空格去掉,中间的空格合并成为一个)
     */
    private String handleSpacce(String str){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0;i<str.length();i++){
            if((int) str.charAt(i)==32){//空格的ASCII码为32
                if(i==0){
                    continue;
                }else{
                    if((int) str.charAt(i-1)==32){//判断空格前面有没有空格，如果有直接跳过，无论空格在最前面还是在字符串中间都没有影响
                        continue;
                    }else {
                        stringBuffer.append(str.charAt(i));
                    }
                }
            }else{
                stringBuffer.append(str.charAt(i));
            }
        }
        return stringBuffer.toString();
    }

    /*
    * 处理数字
    * */
    private int handleValue(String string){
        StringBuffer stringBuffer = new StringBuffer();
        int flag = 1;//正负号
        if(string.length()==0) return 0;
        if( !((int)string.charAt(0)==45 || (int)string.charAt(0)==43 || ((int)string.charAt(0)>=48&&(int)string.charAt(0)<=57 ))){ return 0;}//首字母必须以"-"、"+"和数字为开头
        if((int)string.charAt(0)==45||(int)string.charAt(0)==43){//如果以正负号打头则后续为数字
            if(string.length()==1){
                return 0;
            }else{
                if((int)string.charAt(1)<48||(int)string.charAt(1)>57){return 0;}
            }
        }
        for(int i =0;i<string.length();i++){
            if((int)string.charAt(i)>=48&&(int)string.charAt(i)<=57){// 0的ASCII码为45 9的ASCII码为57
                if(i>0&&(int)string.charAt(i-1)==45){
                    flag = -1;
                }
                while(i<string.length()&&(int)string.charAt(i)>=48&&(int)string.charAt(i)<=57){
                    stringBuffer.append(string.charAt(i));
                    i++;
                }
                break;//直接结束循环
            }
        }
        if(stringBuffer.length()==0){
            return 0;
        }else{
            return handleOverflow(stringBuffer.toString(),flag);
        }
    }

    /**
     * 溢出处理
     */
    private int handleOverflow(String str,int flag){
        int result = 0;
        if(flag>0){
            for(int i = 0;i<str.length();i++){
                int value = str.charAt(i)-'0';
                if(result>Integer.MAX_VALUE/10||result==Integer.MAX_VALUE/10&&value>7){
                    return Integer.MAX_VALUE;
                }else{
                    result = result*10+value;
                }
            }
        }else{
            for(int i = 0;i<str.length();i++){
                int value = (int) str.charAt(i)-'0';
                if(result<Integer.MIN_VALUE/10||result==Integer.MIN_VALUE/10&&value>8){
                    return Integer.MIN_VALUE;
                }else{
                    result = result*10-value;
                }
            }
        }
        return result;
    }
}
