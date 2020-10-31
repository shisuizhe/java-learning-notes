package Collection;

import org.junit.Test;

import java.util.*;

/*
 * 一、集合框架的概述
 *
 * 1.集合、数组都是对多个数据进行存储操作的结构，简称Java容器。
 * 说明：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储（.txt,.jpg,.avi，数据库中）
 *
 * 2.1 数组在存储多个数据方面的特点：
 *      > 一旦初始化以后，其长度就确定了。
 *      > 数组一旦定义好，其元素的类型也就确定了。我们也就只能操作指定类型的数据了。
 *        比如：String[] arr;int[] arr1;Object[] arr2;
 * 2.2 数组在存储多个数据方面的缺点：
 *      > 一旦初始化以后，其长度就不可修改。
 *      > 数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便，同时效率不高。
 *      > 获取数组中实际元素的个数的需求，数组没有现成的属性或方法可用
 *      > 数组存储数据的特点：有序、可重复。对于无序、不可重复的需求，不能满足。
 *
 * 二、集合框架
 * |----Collection接口：单列集合，用来存储一个一个的对象
 *      |----List接口：存储有序的、可重复的数据。  -->“动态”数组
 *          |----ArrayList、LinkedList、Vector
 *
 *      |----Set接口：存储无序的、不可重复的数据   -->高中讲的“集合”
 *          |----HashSet、LinkedHashSet、TreeSet
 *
 * |----Map接口：双列集合，用来存储一对(key - value)一对的数据   -->高中函数：y = f(x)
 *      |----HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 *
 *
 * 三、Collection接口中的方法的使用
 *
 */
public class CollectionTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();

        // add(Object e):将元素e添加到集合coll中
        coll.add("AA");
        coll.add("BB");
        coll.add(123); // 自动装箱
        coll.add(new Date());

        // size(): 获取添加的元素的个数
        System.out.println(coll.size()); // 4

        // addAll(Collection coll1): 将coll1集合中的元素添加到当前的集合中
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add("CC");
        coll.addAll(coll1);

        System.out.println(coll.size()); // 6
        System.out.println(coll); // [AA, BB, 123, Sun Oct 25 14:31:03 CST 2020, 456, CC]

        // clear(): 清空集合元素
        coll.clear();

        // isEmpty(): 判断当前集合是否为空
        System.out.println(coll.isEmpty()); // true
    }

    @Test
    public void test5() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        // 1.contains(Object obj): 判断当前集合中是否包含obj
        // 我们在判断时会调用obj对象所在类的equals()。
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        System.out.println(coll.contains(new Person("Jerry", 20))); // true
        System.out.println(coll.contains(new String("Tom"))); // true

        // 2.containsAll(Collection coll1):判断形参coll1中的所有元素是否都存在于当前集合中。
        Collection coll1 = Arrays.asList(123, 4567);
        System.out.println(coll.containsAll(coll1)); // false
    }



    @Test
    public void test2() {
        // 3.remove(Object obj): 从当前集合中移除obj元素。
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        coll.remove(123);
        System.out.println(coll); // [456, Person{name='Jerry', age=20}, Tom, false]

        coll.remove(new Person("Jerry", 20));
        System.out.println(coll); // [456, Tom, false]

        //4. removeAll(Collection coll1): 差集：从当前集合中移除coll1中所有的元素。
        Collection coll1 = Arrays.asList(123, 456);
        coll.removeAll(coll1);
        System.out.println(coll); // [Tom, false]
    }



    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        // 5.retainAll(Collection coll1):交集：获取当前集合和coll1集合的交集，并返回给当前集合
        // Collection coll1 = Arrays.asList(123,456,789);
        // coll.retainAll(coll1);
        // System.out.println(coll); // [123, 456]

        // 6.equals(Object obj):要想返回true，需要当前集合和形参集合的元素都相同。
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add(123);
        coll1.add(new Person("Jerry", 20));
        coll1.add(new String("Tom"));
        coll1.add(false);

        System.out.println(coll.equals(coll1)); // false
    }



    @Test
    public void test4() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        // 7.hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());

        // 8.集合 --> 数组：toArray()
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        // 拓展：数组 --> 集合:调用Arrays类的静态方法asList()
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        List arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1.size()); // 1

        List arr2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr2.size()); // 2

        // 9.iterator(): 返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest.java中测试
    }
}
