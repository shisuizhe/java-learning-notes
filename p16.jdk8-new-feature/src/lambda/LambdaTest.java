package lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/*
 * Lambda表达式的使用举例
 */

public class LambdaTest {
    @Test
    public void testa() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };
        r1.run();

        System.out.println("***********************");

        Runnable r2 = () -> System.out.println("我爱北京故宫");
        r2.run();
    }


    @Test
    public void testb() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare1 = com1.compare(12, 21);
        System.out.println(compare1);


        // Lambda表达式的写法
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);
        int compare2 = com2.compare(32, 21);
        System.out.println(compare2);


        // 方法引用
        Comparator<Integer> com3 = Integer::compare;
        int compare3 = com3.compare(32, 21);
        System.out.println(compare3);
    }

    // *************************  Lambda 表达式：语法  *************************
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("lambda");
            }
        };
        r1.run();

        // 语法格式一：无参，无返回值
        Runnable r2 = () -> {System.out.println("lambda");};
        r2.run();
    }

    @Test
    public void test2() {
        Consumer<String> c1 = new Consumer<String>() {
            @Override
            public void accept(String str) {
                System.out.println(str);
            }
        };
        c1.accept("lambda");

        // 语法格式二：Lambda需要一个参数，但是没有返回值。
        Consumer<String> c2 = (String str) -> {System.out.println(str);};
        c2.accept("lambda");

        // 语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
        Consumer<String> c3 = (str) -> {System.out.println(str);};
        c3.accept("lambda");

        // 语法格式四：Lambda若只需要一个参数时，参数的小括号可以省略
        Consumer<String> c4 = str -> {System.out.println(str);};
        c4.accept("lambda");
    }

    @Test
    public void test3() {
        Comparator<Integer> c1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                System.out.println("lambad");
                return 0;
            }
        };
        int res1 = c1.compare(1, 2);
        System.out.println(res1);

        // 语法格式五：Lambda具有两个或以上的参数，多条执行语句，并且可以有返回值
        Comparator<Integer> c2 = (x, y) -> {
            System.out.println("lambad");
            return 0;
        };
        int res2 = c2.compare(1, 2);
        System.out.println(res2);
    }

    @Test
    public void test4() {
        Comparator<Integer> c1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return Integer.compare(x, y);
            }
        };
        int res1 = c1.compare(1, 2);
        System.out.println(res1);

        // 语法格式六：当Lambda体只有一条语句时，return与大括号若有，都可以省略
        Comparator<Integer> c2 = (x, y) -> Integer.compare(x, y);
        int res2 = c2.compare(1, 2);
        System.out.println(res2);
    }
}
