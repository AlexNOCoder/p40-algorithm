package test_alex.pagelimit;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableList;
import test_alex.Person;
import java.util.List;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 测试MemoryPageHelper
 * @date 2021-12-28 12:33:08
 */
public class TestMemoryTest {
    static  List<Person> persons = ImmutableList.of(
            new Person(1,"Tom",17,"男"),
            new Person(2,"Alex",18,"男"),
            new Person(3,"Liz",19,"女"),
            new Person(4,"rola",22,"女"),
            new Person(5,"rola1",22,"女"),
            new Person(6,"rola1",22,"女")
    );

    public static void main(String[] args) {
        testMemoryTest();
    }

    public static void testMemoryTest(){
        MemoryPageInfo pageInfo = new MemoryPageInfo(3,2);
        MemoryPageHelper pageHelper = new MemoryPageHelper(persons,pageInfo);
        MemoryPage memoryPage = pageHelper.fetchData();
        System.out.println(JSON.toJSONString(memoryPage,true));
    }

}



