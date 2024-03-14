package com.leetcode.Solution301_400.Solution381_390;

import java.util.*;

/**
 * O(1) 时间插入、删除和获取随机元素 - 允许重复
 *
 * @author jianghan
 * @date 2020-10-31 23:23
 */
public class RandomizedCollection_381 {

    //key: val , value : val的索引集合
    Map<Integer, Set<Integer>> indexMap;
    //容器
    List<Integer> list;
    Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection_381() {
        indexMap = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean result = true;
        if (indexMap.containsKey(val)) {
            indexMap.get(val).add(list.size());
            result = false;
        } else {
            indexMap.put(val, new HashSet<Integer>() {{
                this.add(list.size());
            }});
        }
        list.add(val);
        return result;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false;
        } else {
            //取出需要remove值的第一个索引,并删除
            Set<Integer> indexSet = indexMap.get(val);
            Integer index = indexSet.iterator().next();
            //取出list中最后一个值的索引,并修改为上面的索引
            Set<Integer> lastIndexSet = indexMap.get(list.get(list.size() - 1));
            Iterator<Integer> iterator = lastIndexSet.iterator();
            Integer lastIndex = 0;
            while (iterator.hasNext()){
                lastIndex = iterator.next();
            }
            //交换位置并执行索引的删除和修改操作
            swap(list, index, lastIndex);
            indexSet.remove(index);
            if(indexSet.size()==0){
                indexMap.remove(val);
            }
            lastIndexSet.remove(lastIndex);
            lastIndexSet.add(index);
            //移除容器队尾元素
            list.remove(list.size() - 1);
            return true;
        }
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    private void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void main(String[] args) {
        RandomizedCollection_381 randomizedCollection_381 = new RandomizedCollection_381();
        randomizedCollection_381.insert(1);
        randomizedCollection_381.insert(1);
        randomizedCollection_381.insert(2);
        randomizedCollection_381.insert(2);
        randomizedCollection_381.insert(2);
        randomizedCollection_381.remove(1);
        randomizedCollection_381.remove(1);
        randomizedCollection_381.remove(2);
        randomizedCollection_381.insert(1);
        randomizedCollection_381.remove(2);
    }
}
