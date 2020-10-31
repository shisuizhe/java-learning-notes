package streamapi;

import methodreference.Employee;
import methodreference.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/*
 * 测试Stream的中间操作
 *
 */

public class StreamApiTest1 {
    // 筛选与切片
    @Test
    public void test1() {
        List<Employee> list = EmployeeData.getEmployees();

        // filter(Predicate p) —— 接收 Lambda ， 从流中排除某些元素。
        Stream<Employee> stream = list.stream();
        // 练习：查询员工表中薪资大于7000的姓氏为马的员工信息。
        stream.filter(new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() > 7000;
            }
        }).filter(e -> e.getName().startsWith("马")).forEach(e -> System.out.println(e));
        list.stream().filter(e -> e.getSalary() > 7000).filter(e -> e.getName().startsWith("马")).forEach(System.out::println);

        System.out.println();

        // limit(n) —— 截断流，使其元素不超过给定数量。
        list.stream().limit(3).forEach(System.out::println);

        System.out.println();

        // skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补。
        list.stream().skip(6).forEach(System.out::println);

        System.out.println();

        // distinct() —— 筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素。
        list.add(new Employee(1010, "刘强东", 40, 8000));
        list.add(new Employee(1010, "刘强东", 40, 8000));
        list.add(new Employee(1010, "刘强东", 41, 8000));
        // System.out.println(list);
        list.stream().distinct().forEach(System.out::println);
    }


    // 映射
    @Test
    public void test2() {
        // map(Function f) —— 接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        List<String> list = Arrays.asList("abc", "def", "ghi", "jkl");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

        // 练习1：获取员工姓名长度大于3的员工的姓名。
        List<Employee> employees = EmployeeData.getEmployees();
        // 使用函数式接口
        Stream<String> namesStream1 = employees.stream().map(new Function<Employee, String>() {
            @Override
            public String apply(Employee e) {
                return e.getName();
            }
        });
        // 使用Lambda
        Stream<String> namesStream2 = employees.stream().map(e -> e.getName());
        // 使用方法引用
        Stream<String> namesStream3 = employees.stream().map(Employee::getName);
        namesStream3.filter(name -> name.length() > 3).forEach(System.out::println);

        System.out.println();

        // 练习2
        Stream<Stream<Character>> streamStream = list.stream().map(StreamApiTest1::fromStringToStream);
        streamStream.forEach(s -> s.forEach(System.out::println));
        System.out.println();
        // flatMap(Function f) —— 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
        Stream<Character> characterStream = list.stream().flatMap(StreamApiTest1::fromStringToStream);
        characterStream.forEach(System.out::println);
    }


    // 将字符串中的多个字符构成的集合转换为对应的Stream的实例
    public static Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }


    @Test
    public void test3() {
        ArrayList list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList list2 = new ArrayList();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        // list1.add(list2);
        list1.addAll(list2);
        System.out.println(list1);
    }


    // 排序
    @Test
    public void test4() {
        // sorted() —— 自然排序
        List<Integer> list = Arrays.asList(12, 43, 65, 34, 87, 0, -98, 7);
        list.stream().sorted().forEach(System.out::println);
        // 抛异常，原因:Employee没有实现Comparable接口
        // List<Employee> employees = EmployeeData.getEmployees();
        // employees.stream().sorted().forEach(System.out::println);

        // sorted(Comparator com) —— 定制排序
        List<Employee> employees = EmployeeData.getEmployees();
        // employees.stream().sorted(new Comparator<Employee>() {
        //     @Override
        //     public int compare(Employee e1, Employee e2) {
        //         int ageValue = Integer.compare(e1.getAge(), e2.getAge());
        //         if (ageValue != 0) {
        //             return ageValue;
        //         } else {
        //             return -Double.compare(e1.getSalary(), e2.getSalary());
        //         }
        //     }
        // }).forEach(System.out::println);
        employees.stream().sorted((e1, e2) -> {
            int ageValue = Integer.compare(e1.getAge(), e2.getAge());
            if (ageValue != 0) {
                return ageValue;
            } else {
                return -Double.compare(e1.getSalary(), e2.getSalary());
            }
        }).forEach(System.out::println);
    }
}
