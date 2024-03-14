package com.leetcode.Solution301_400.Solution331_340;

import java.util.*;

/**
 * 重新安排行程
 *
 * @author jianghan
 * @date 2020-08-27 00:44
 */
public class ReconstructLtinerary_332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> resultList = new ArrayList<>();
        resultList.add("JFK");
        while (tickets.size()>0){
            Map<Integer,String> map = new HashMap<>();
            String currentPlace = resultList.get(resultList.size()-1);
            for(int i = 0 ;i< tickets.size();i++){
                if(tickets.get(i).get(0).equals(currentPlace)){
                    map.put(i,tickets.get(i).get(1));
                }
            }
            if(map.size()<=1){
                Set<Integer> integers = map.keySet();
                integers.forEach(index->{
                    resultList.add(map.get(index));
                    tickets.remove(index.intValue());
                });
            }else {
                Set<Integer> integers = map.keySet();
                List<String> a = new ArrayList<>();
                integers.forEach(index->a.add(map.get(index)));
                String minString = compareOrder(a);
                resultList.add(minString);
                map.forEach((k,v)->{
                    if(v.equals(minString)){
                        tickets.remove(k.intValue());
                    }
                });
            }
        }
        return resultList;
    }

    /**
     * 比较机场的顺位关系,返回最优先顺位
     */
    private String compareOrder(List<String> list) {
        String minString = list.get(0);
        for(int i = 1 ;i<list.size();i++){
            for(int j = 0 ;j<3;j++){
                if(minString.charAt(j)!=list.get(i).charAt(j)){
                    minString = minString.charAt(j)<list.get(i).charAt(j)?minString:list.get(i);
                    break;
                }
            }
        }
        return minString;
    }

    public static void main(String[] args) {
        ReconstructLtinerary_332 a = new ReconstructLtinerary_332();
        List<String> list1 = new ArrayList<>();
        list1.add("JFK");
        list1.add("ATL");
        List<String> list2 = new ArrayList<>();
        list2.add("ORD");
        list2.add("PHL");
        List<String> list3 = new ArrayList<>();
        list3.add("JFK");
        list3.add("ORD");
        List<String> list4 = new ArrayList<>();
        list4.add("PHX");
        list4.add("LAX");
        List<String> list5 = new ArrayList<>();
        list5.add("LAX");
        list5.add("JFK");
        List<String> list6 = new ArrayList<>();
        list6.add("PHL");
        list6.add("ATL");
        List<String> list7 = new ArrayList<>();
        list7.add("ATL");
        list7.add("PHX");
        List<List<String>> k = new ArrayList<>();
        k.add(list1);k.add(list2);k.add(list3);k.add(list4);k.add(list5);k.add(list6);k.add(list7);
        List<String> result = a.findItinerary(k);
        System.out.println(a.compareOrder(result));
    }
}
