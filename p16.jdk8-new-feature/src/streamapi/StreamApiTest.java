package streamapi;

import methodreference.Employee;
import methodreference.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/*
 * 1.Stream关注的是对数据的运算，与CPU打交道。
 *   集合关注的是数据的存储，与内存打交道。
 *
 * 2.
 *   Stream 自己不会存储元素。
 *   Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。
 *   Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行。
 *
 * 3.Stream 执行流程:
 *    3.1 Stream的实例化
 *    3.2 一系列的中间操作（过滤、映射、...)
 *    3.3 终止操作
 *
 * 4.说明：
 *    4.1 一个中间操作链，对数据源的数据进行处理
 *    4.2 一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用
 */


public class StreamApiTest {
    // 创建Stream方式一：通过集合
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();

        // default Stream<E> stream() : 返回一个顺序流
        Stream<Employee> stream = employees.stream();

        // default Stream<E> parallelStream() : 返回一个并行流
        Stream<Employee> parallelStream = employees.parallelStream();
    }


    // 创建Stream方式二：通过数组
    // 调用Arrays类的static <T> Stream<T> stream(T[] array): 返回一个流
    @Test
    public void test2() {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6};
        Stream<Integer> stream = Arrays.stream(arr);

        Employee e1 = new Employee(1001, "Tom");
        Employee e2 = new Employee(1002, "Jerry");
        Employee[] arr1 = new Employee[]{e1, e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);
    }


    // 创建Stream方式三：通过Stream的of()
    @Test
    public void test3() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
    }


    // 创建Stream方式四：创建无限流（了解即可）
    @Test
    public void test4() {
        // 迭代
        // public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        // 遍历前5个偶数
        Stream.iterate(0, new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer i) {
                return i + 2;
            }
        }).limit(5).forEach(c -> System.out.println(c));

        Stream.iterate(0, i -> i + 2).limit(5).forEach(System.out::println);


        // 生成
        // public static<T> Stream<T> generate(Supplier<T> s)
        // 输出5个随机数
        Stream.generate(new Supplier<Double>() {
            @Override
            public Double get() {
                return Math.random();
            };
        }).limit(5).sorted().forEach(c -> System.out.println(c));

        Stream.generate(() -> Math.random()).limit(5).sorted().forEach(c -> System.out.println(c));

        Stream.generate(Math::random).limit(5).sorted().forEach(System.out::println);
    }
}
