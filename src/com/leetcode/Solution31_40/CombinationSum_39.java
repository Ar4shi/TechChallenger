package com.leetcode.Solution31_40;

import com.sun.org.apache.bcel.internal.generic.RET;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和
 *
 * @author jianghanh
 * @date 2020-02-05 14:52
 */
public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> result = iterationMethod(candidates,target,0,list);
        return result;
    }

    /**
     * 迭代方法
     */
    private List<List<Integer>> iterationMethod(int[] candidates,int newTarget,int index,List<Integer> list){
        List<List<Integer>> results = new ArrayList<>();
        //迭代器出口1
        if(index>=candidates.length){

        }else{
            if(candidates[index]<newTarget){
                list.add(candidates[index]);
                iterationMethod(candidates,newTarget-candidates[index],0,list);//由于可以重复,从0下标开始重读
            }else if(candidates[index]==newTarget){//迭代器出口2
                list.add(candidates[index]);
                results.add(list);
            }else{
                iterationMethod(candidates,newTarget,index+1,list);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        CombinationSum_39 combinationSum_39 = new CombinationSum_39();
        combinationSum_39.combinationSum(new int[]{2,3,6,7},7);
    }
}
