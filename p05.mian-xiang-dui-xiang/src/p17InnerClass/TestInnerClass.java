package p17InnerClass;

// 局部内部类和局部变量地位类似，不能使用public,protected,缺省,private

import org.junit.Test;

class Human { // 外部类
    private static String name = "Human";
    private int age = 10;

    public Human() {  // 局部内部类（在构造器内）
        class A {

        }
    }

    public void method() { // 局部内部类（在方法体内）
        class B {

        }
    }

    static { // 局部内部类（在代码块内）
        class C {

        }
    }

    // 外部类的静态方法
    public static void eat() {
        String name = "人类"; // 局部变量
        System.out.println(name + "吃饭");
    }

    // 静态成员成员内部类
    protected static class Man {
        private String name = "男人"; // 内部类的成员变量

        void eat() {
            System.out.println(name + "吃饭");
        }

        void testEat() {
            eat();        // 男人吃饭
            this.eat();   // 男人吃饭
            Human.eat();  // 人类吃饭
        }
    }

    // 静态成员内部类
    class Woman {
        private int age = 100;

        public void getAge() {
            System.out.println(age);            // 100   内部类的属性
            System.out.println(this.age);       // 100   内部类的属性
            System.out.println(Human.this.age); // 10    外部类的属性
        }
    }
}

interface MyInterface {
    void hello();
}

public class TestInnerClass {
    public static void main(String[] args) {
        // 创建Man实例(静态的成员内部类)
        Human.Man man = new Human.Man();
        man.testEat();

        // 创建Woman实例(非静态的成员内部类)
        Human human = new Human();
        Human.Woman woman = human.new Woman();
        woman.getAge();
    }

    //***************************************************************************

    // 匿名内部类，因为没有类名，所以声明的同时必须创建对象
    // 格式：
    // new 父类构造器(实参列表) | 实现接口名() {
    //     匿名内部类的类体：类体就是后面的类或接口的子类
    // }
    @Test
    public void test1() {
        Object obj = new Object() {
            @Override
            public String toString() {
                return "匿名内部类";
            }
        };
        System.out.println(obj); // 匿名内部类
    }

    @Test
    public void test2() {
        // new MyInterface(); // 接口不能new对象，但是如果在后面加上花括号，他就是匿名内部类了

        MyInterface i = new MyInterface() {
            // 类体：相当于接口的实现子类
            @Override
            public void hello() {
                System.out.println("hello");
            }
        };
        i.hello();
    }

    @Test
    public void test3() {
        new MyInterface() {
            @Override
            public void hello() {
                System.out.println("hello");
            }
        }.hello(); // 匿名类 + 匿名对象
    }
}
