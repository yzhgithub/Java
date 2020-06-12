package com.yzh.lambda;

import com.yzh.utils.JsonUtil;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaDemo {

    public static void main(String[] args)
    {
        LambdaDemo lambdaDemo=new LambdaDemo();
        lambdaDemo.Test();
    }

    public void Test()
    {
        List<User> userList = buildUserList();
        groupBySingleField(userList);
        //groupByMultiField(userList);
        //filter(userList);
        //sum(userList);
        //max(userList);
        //min(userList);
        //maxValueObject(userList);
        //minValueObject(userList);
        //sortBySingleField(userList);
        //sortByMultiField(userList);
        //distinctByBaseType();
        //distinctByAttribute(userList);
        //buildNewListByField(userList);
        //batchSetListFieldValue(userList);
        //diffEntityListCopy(userList);
    }


    // region Private Methods

    private List<User> buildUserList() {
        List<User> userList = new ArrayList<>();

        User user1 = new User();
        user1.setName("Name1");
        user1.setSex("M");
        user1.setAge(20);
        user1.setNumber(new BigDecimal(5));
        userList.add(user1);

        User user2 = new User();
        user2.setName("Name2");
        user2.setSex("F");
        user2.setAge(18);
        user2.setNumber(new BigDecimal(2));
        userList.add(user2);

        User user3 = new User();
        user3.setName("Name3");
        user3.setSex("F");
        user3.setAge(18);
        user3.setNumber(new BigDecimal(4));
        userList.add(user3);

        User user4 = new User();
        user4.setName("Name4");
        user4.setSex("M");
        user4.setAge(21);
        user4.setNumber(new BigDecimal(1));
        userList.add(user4);

        User user5 = new User();
        user5.setName("Name5");
        user5.setSex("M");
        user5.setAge(21);
        user5.setNumber(new BigDecimal(3));
        userList.add(user5);

        return userList;
    }

    /**
     * groupingBy（单字段分组)
     */
    private void groupBySingleField(List<User> userList) {
        Map<String, List<User>> groupBySex = userList.stream().collect(Collectors.groupingBy(User::getSex));
        for (Map.Entry<String, List<User>> entryUser : groupBySex.entrySet()) {
            String key = entryUser.getKey();
            List<User> entryUserList = entryUser.getValue();
            System.out.println("key:" + key + ",value:" + JsonUtil.objectToJson(entryUserList));
        }
    }

    /**
     * groupingBy（多字段分组)
     */
    private void groupByMultiField(List<User> userList) {
        Function<User, List<Object>> compositeKey = p -> Arrays.<Object>asList(p.getSex(), p.getAge());
        Map<Object, List<User>> map = userList.stream().collect(Collectors.groupingBy(compositeKey, Collectors.toList()));
        for (Map.Entry<Object, List<User>> entryUser : map.entrySet()) {
            List<Object> key = (List<Object>) entryUser.getKey();
            List<User> entryUserList = entryUser.getValue();
            String sex = (String) key.get(0);
            int age = (int) key.get(1);
            System.out.println("key.sex:" + sex + ",key.age:" + age + ",value:" + JsonUtil.objectToJson(entryUserList));
        }
    }

    /**
     * 过滤
     */
    private void filter(List<User> userList) {
        List<User> fUserList = userList.stream().filter(p -> p.getSex().equals("F")).collect(Collectors.toList());
        for (User user : fUserList) {
            System.out.println(JsonUtil.objectToJson(user));
        }
    }

    /**
     * 求和(分基本类型和大数据类型)
     * 基本类型：先mapToInt，然后调用sum方法
     * 大数类型：先map，然后使用reduce调用BigDecimal::add方法
     */
    private void sum(List<User> userList) {
        int totalAge = userList.stream().mapToInt(User::getAge).sum();
        BigDecimal totalNumber = userList.stream().map(User::getNumber).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("BaseType.TotalAge:" + totalAge + ",BigDecimalType.TotalNumber:" + totalNumber);
    }

    /**
     * 最大值
     */
    private void max(List<User> userList) {
        int maxAge = userList.stream().map(User::getAge).max(Integer::compareTo).get();
        System.out.println("max age:" + maxAge);
    }

    /**
     * 最小值
     */
    private void min(List<User> userList) {
        int minAge = userList.stream().map(User::getAge).min(Integer::compareTo).get();
        System.out.println("min age:" + minAge);
    }

    /**
     * 最大值对象
     */
    private void maxValueObject(List<User> userList) {
        Comparator<User> comparator = Comparator.comparing(User::getAge);
        User maxAgeUser = userList.stream().max(comparator).get();
        System.out.println("max age user:" + JsonUtil.objectToJson(maxAgeUser));
    }

    /**
     * 最小值对象
     */
    private void minValueObject(List<User> userList) {
        Comparator<User> comparator = Comparator.comparing(User::getAge);
        User minAgeUser = userList.stream().min(comparator).get();
        System.out.println("min age user:" + JsonUtil.objectToJson(minAgeUser));
    }

    /**
     * 排序（单字段）
     */
    private void sortBySingleField(List<User> userList) {
        userList.sort(Comparator.comparing(User::getAge));
        System.out.println("single field sort result:" + JsonUtil.objectToJson(userList));
    }

    /**
     * 排序（多字段）
     */
    private void sortByMultiField(List<User> userList) {
        userList.sort(Comparator.comparing(User::getAge).thenComparing(User::getNumber));
        System.out.println("multi field sort result:" + JsonUtil.objectToJson(userList));
    }

    /**
     * 去重（基本类型）
     */
    private void distinctByBaseType() {
        List<String> idList = new ArrayList<>();
        idList.add("1");
        idList.add("1");
        idList.add("2");
        List<String> distinctIdList = idList.stream().distinct().collect(Collectors.toList());
        System.out.println(String.join(",", distinctIdList));
    }

    /**
     * 去重（针对属性）
     */
    private void distinctByAttribute(List<User> userList) {
        List<User> distinctUserList = userList.stream().filter(distinctByKey(p -> p.getAge())).collect(Collectors.toList());
        System.out.println(JsonUtil.objectToJson(distinctUserList));
    }

    /**
     * 自定义distinctByKey
     */
    private static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    /**
     * 获取List某个字段组装成新的List
     */
    private void buildNewListByField(List<User> userList) {
        List<String> userSexList = userList.stream().map(p -> p.getSex()).collect(Collectors.toList());
        List<String> userSexDistinctList = userSexList.stream().distinct().collect(Collectors.toList());
        System.out.println(JsonUtil.objectToJson(userSexList));
        System.out.println(JsonUtil.objectToJson(userSexDistinctList));
    }

    /**
     * 批量设置List中某字段为同一值
     */
    private void batchSetListFieldValue(List<User> userList) {
        userList.stream().forEach(p -> p.setNumber(new BigDecimal(3)));
        System.out.println(JsonUtil.objectToJson(userList));
    }

    /**
     * 不同实体List的拷贝
     */
    private void diffEntityListCopy(List<User> userList) {
        List<Person> personList = userList.stream().map(a ->
        {
            Person person = new Person();
            person.setName(a.getName());
            person.setSex(a.getSex());
            person.setAge(a.getAge());
            return person;
        }).collect(Collectors.toList());
        System.out.println(JsonUtil.objectToJson(personList));
    }

    // endregion
}
