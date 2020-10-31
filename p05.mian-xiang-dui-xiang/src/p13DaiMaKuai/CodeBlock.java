package p13DaiMaKuai;

/*
 * 类的成员之四：代码块（或初始化块）
 *
 * 1. 代码块的作用：用来初始化类、对象
 * 2. 代码块如果有修饰的话，只能使用static.
 * 3. 分类：静态代码块  vs 非静态代码块
 *
 * 4. 静态代码块
 * 	    >内部可以有输出语句
 * 	    >随着 类的加载 而执行, 而且只执行一次
 * 	    >作用：初始化类的信息
 * 	    >如果一个类中定义了多个静态代码块，则按照声明的先后顺序执行
 * 	    >静态代码块的执行要优先于非静态代码块的执行
 * 	    >静态代码块内只能调用静态的属性/方法，不能调用非静态的属性/方法
 *
 * 5. 非静态代码块
 * 		>内部可以有输出语句
 * 		>随着 对象的创建 而执行
 * 		>每创建一个对象，就执行一次非静态代码块
 * 		>作用：可以在创建对象时，对对象的属性等进行初始化
 * 		>如果一个类中定义了多个非静态代码块，则按照声明的先后顺序执行
 * 		>非静态代码块内可以调用静态属性/方法，或非静态的属性/方法
 *
 *
 * 总结：程序中成员变量赋值的执行顺序:
 *    声明成员变量的默认初始化 ---> 显式初始化、多个初始化块依次被执行（同级别下按先后顺序执行）--->
 *    构造器再对成员进行初始化操作 ---> 通过”对象.属性”或”对象.方法”的方式，可多次给属性赋值
 *
 */
public class CodeBlock {
    public static void main(String[] args) {

        String desc = Person.desc;
        System.out.println(desc);

        System.out.println();

        Person p1 = new Person();

        System.out.println();

        Person p2 = new Person();

        System.out.println();

        System.out.println(p1.age);
        Person.info();
        /*
         * static block-1
         * static block-2
         * static info
         * static block: desc
         *
         * block-1
         * block-2
         * eat
         * static info
         *
         * block-1
         * block-2
         * eat
         * static info
         *
         * 1
         * static info
         *
         */
    }
}

class Person {
    String name;
    int age;
    static String desc = "我是一个人";

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 非static的代码块
    {
        System.out.println("block-1");
    }

    {
        System.out.println("block-2");
        // 调用非静态结构
        age = 1;
        eat();

        // 调用静态结构
        desc = "non-static block: desc";
        info();
    }

    // static的代码块
    static {
        System.out.println("static block-1");
    }

    static {
        System.out.println("static block-2");
        // 不可以调用非静态结构
        // age = 1;
        // eat();

        // 调用静态结构
        desc = "static block: desc";
        info();
    }

    // 方法
    public void eat() {
        System.out.println("eat");
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    public static void info() {
        System.out.println("static info");
    }
}
