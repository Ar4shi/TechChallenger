package basic.juc.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {

    private final ConcurrentHashMap<String, Integer> visitCountMap;

    public ConcurrentHashMapExample() {
        this.visitCountMap = new ConcurrentHashMap<>();
    }

    // 用户访问时调用的方法
    public void userVisited(String userId) {
        visitCountMap.compute(userId, (key, value) -> value == null ? 1 : value + 1);
    }

    // 获取用户的访问次数
    public int getVisitCount(String userId) {
        return visitCountMap.getOrDefault(userId, 0);
    }

}
