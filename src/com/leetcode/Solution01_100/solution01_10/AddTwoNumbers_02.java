package com.leetcode.Solution01_100.solution01_10;

/**
 * 两数相加
 *
 * @author jianghanh
 * @date 2019-06-14 21:14
 */
public class AddTwoNumbers_02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String value1= "";String value2 = "";int carry = 0;//进位数
        ListNode head = null;
        ListNode current = null;
        int temp1;int temp2;
        do {
            value1 += l1.val;
            l1 = l1.next;
        }while(l1!=null);
        do {
            value2 += l2.val;
            l2 = l2.next;
        }while(l2!=null);
        int lenth = value1.length()<value2.length()?value2.length():value1.length();//取较长的字符串遍历
        for(int i=0;i<lenth;i++){
            if(i<value1.length()){
                temp1 = Integer.parseInt(String.valueOf(value1.charAt(i)));
            }else{
                temp1 = 0;
            }
            if(i<value2.length()){
                temp2 = Integer.parseInt(String.valueOf(value2.charAt(i)));
            }else{
                temp2 = 0;
            }
            int figure =(temp1+temp2+carry)%10 ;//当前位置数字
            if((temp1+temp2+carry)/10<1){
                carry = 0;
            }else {
                carry=1;
            }
            if(head==null){
                head = new ListNode(figure);
                current = head;
            }else {
                current.next = new ListNode(figure);
                current = current.next;
            }
        }
        if(carry==1){
            current.next = new ListNode(1);
        }
        return head;
    }
}

/**
 * 此方法由于 int 和 long 长度有限 无法涵盖所有情况，故舍弃
 */
class OneSolution{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long value1 = 0;long value2 = 0;int flag = 1;
        ListNode head = null;
        ListNode current = null;
        do {
            value1 += l1.val * flag;
            flag *= 10 ;
            l1 = l1.next;
        }while(l1!=null);
        flag = 1;
        do {
            value2 += l2.val * flag;
            flag *= 10 ;
            l2 = l2.next;
        }while(l2!=null);
        String result = String.valueOf(value1+ value2);
        for(int i = 0;i<result.length();i++){
            int element = Integer.parseInt(String.valueOf(result.charAt(result.length()-i-1)));
            if(head == null){
                head = new ListNode(element);
                current = head;
            }else{
                current.next = new ListNode(element);
                current = current.next;
            }
        }
        return head;
    }
}


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

