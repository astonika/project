package com.company.project.redission;


import org.redisson.Redisson;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;

/**
 * https://zhuanlan.zhihu.com/p/86609750
 */
public class ListExamples {
    public static void main(String[] args) {
        // 默认连接上 127.0.0.1:6379
        RedissonClient client = Redisson.create();
        // RList 继承了 java.util.List 接口
        RList<String> nameList = client.getList("nameList");
        nameList.clear();
        nameList.add("bingo");
        nameList.add("yanglbme");
        nameList.add("yanglbme - Overview");
        nameList.remove(-1);

        boolean contains = nameList.contains("yanglbme");
        System.out.println("List size: " + nameList.size());
        System.out.println("Is list contains name 'yanglbme': " + contains);
        nameList.forEach(System.out::println);
        client.shutdown();
    }
}
