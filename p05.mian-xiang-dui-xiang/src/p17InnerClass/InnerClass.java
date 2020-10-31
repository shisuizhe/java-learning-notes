package p17InnerClass;

/*
 * 类的内部成员之五：内部类
 * 1.Java中允许将一个类A声明在一个类B中，则类A就是内部类，类B称为外部类
 *
 * 2.内部类的分类：成员内部类（静态、非静态） vs 局部内部类(方法内、代码块内、构造器内)
 *
 * 3.成员内部类：
 * 		一方面，作为外部类的成员：
 * 			> 调用外部类的结构
 * 			> 可以被static修饰
 * 			> 可以被4种不同的权限修饰
 *
 * 		另一方面，作为一个类：
 * 			> 类内可以定义属性、方法、构造器等
 * 			> 可以被final修饰，表示此类不能被继承。言外之意，不使用final，就可以被继承
 * 			> 可以被abstract修饰
 *
 * 4.关注如下的3个问题
 *   4.1 如何实例化成员内部类的对象
 *   4.2 如何在成员内部类中区分调用外部类的结构
 *   4.3 开发中局部内部类的使用  见《InnerClassTest1.java》
 *
 */
public class InnerClass {
    public static void main(String[] args) {
        // 创建Dog实例(静态的成员内部类):
        Animal.Dog dog = new Animal.Dog();
        dog.show();

        // 创建Bird实例(非静态的成员内部类):
		// Animal.Bird bird = new Animal.Bird(); // 错误的
        Animal p = new Animal();
        Animal.Bird bird = p.new Bird("鹦鹉");
        bird.sing();

        System.out.println();

        bird.display("黄鹂");

    }
}

class Animal {
    String name = "不知名动物";
    int age;

    public void eat() {
        System.out.println("动物：吃饭");
    }

    // 静态成员内部类
    static class Dog {
        String name = "旺财";

        public void show() {
            System.out.println(this.name + "在看门");
			// eat(); // 错误
        }
    }

    // 非静态成员内部类
    class Bird {
        String name = "杜鹃";

        public Bird(String name) {
            this.name = name;
        }

        public void sing() {
            System.out.println("我是一只小小鸟");
            Animal.this.eat();  // 调用 外部 类中的非静态方法
            this.eat();         // 调用 自己 类中的非静态方法
            eat();              // 同上
            System.out.println(age);
        }

        public void eat() {
            System.out.println("Bird: eat");
        }

        public void display(String name) {
            System.out.println(name);               // 方法的形参
            System.out.println(this.name);          // 内部类的属性
            System.out.println(Animal.this.name);   // 外部类的属性
        }
    }

    // ------------------------------------------------------------------

    public void method() {
        // 局部内部类
        class AA {
        }
    }

    {
        // 局部内部类
        class BB {
        }
    }

    public Animal() {
        // 局部内部类
        class CC {
        }
    }
}