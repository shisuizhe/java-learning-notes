package p06FengZhuang;

/**
 * this关键字的使用：
 * 1.this可以用来修饰、调用：属性、方法、构造器
 *
 * 2.this修饰属性和方法：
 *   this理解为：当前对象 或 当前正在创建的对象
 *
 *  2.1 在类的方法中，我们可以使用"this.属性"或"this.方法"的方式，调用当前对象属性或方法。但是，
 *   通常情况下，我们都选择省略"this."。特殊情况下，如果方法的形参和类的属性同名时，我们必须显式
 *   的使用"this.变量"的方式，表明此变量是属性，而非形参。
 *
 *  2.2 在类的构造器中，我们可以使用"this.属性"或"this.方法"的方式，调用当前正在创建的对象属性或方法。
 *  但是，通常情况下，我们都选择省略"this."。特殊情况下，如果构造器的形参和类的属性同名时，我们必须显式
 *   的使用"this.变量"的方式，表明此变量是属性，而非形参。
 *
 * 3. this调用构造器
 * 	  ① 我们在类的构造器中，可以显式的使用"this(形参列表)"方式，调用本类中指定的其他构造器
 *    ② 构造器中不能通过"this(形参列表)"方式调用自己
 *    ③ 如果一个类中有n个构造器，则最多有 n - 1构造器中使用了"this(形参列表)"
 *    ④ 规定："this(形参列表)"必须声明在当前构造器的首行
 *    ⑤ 构造器内部，最多只能声明一个"this(形参列表)"，用来调用其他的构造器
 *
 */
public class This {
    public static void main(String[] args) {
        Person1 p1 = new Person1();
        p1.setAge(1);
        System.out.println(p1.getAge());
        p1.eat();
        /*
         * 代码
         * 1
         * 人吃饭
         * 人学习
         */

        System.out.println();

        Person1 p2 = new Person1("pd", 18);
        System.out.println(p2.getAge());
        /*
         * 代码
         * 18
         */
    }
}

class Person1 {
    private String name;
    private int age;

    public Person1() {
        // Person初始化时，可能每个构造器都有相同的代码，此时在另一个构造器使用this即可调用另个一个构造器
        String info = "代码";
        System.out.println(info);
    }

    public Person1(String name) {
        // 不同写重复代码了，使用this即可！！
        // String info = "代码";
        // System.out.println(info);

        // this() 调用 Person1() 构造器
        this();
        this.name = name;
    }

    public Person1(int age) {
        this();
        this.age = age;

    }

    public Person1(String name, int age) {
        this(age); // 调用 Person1(int age) 构造器
        this.name = name;
    }

    // 形参没有体现 见名知意 所以可以将 n 改为 name，但此形参name与属性name同名了，所以加个this就可以区分了
    // public void setName(String n) {
    //     name = n;
    // }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void eat() {
        System.out.println("人吃饭");
        this.study();
    }

    public void study() {
        System.out.println("人学习");
    }
}
