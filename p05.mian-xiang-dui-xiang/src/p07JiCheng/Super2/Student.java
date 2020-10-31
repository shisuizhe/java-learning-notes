package p07JiCheng.Super2;

public class Student extends Person {
    String major;
    int id = 1; // 学号

    public Student() {
        // super(); // 调用父类构造器（无参）
        // 若子类构造器的首行，没有显式调用 this() 或 super()，则默认调用的是父类中空参的构造器
    }

    public Student(String major) {
        super(); // 必须声明在首行
        this.major = major;
    }

    public Student(String name,  String major) {
        // 在构造器中，this() 或 super() 只能二选一，不能同时出现
        super(name);
        // this(major);
        this.major = major;
    }

    public Student(String name, int age, String major) {
        super(name, age); // 调用父类构造器（有参）
        this.major = major;
    }

    @Override
    public void eat() {
        System.out.println("学生：多吃有营养的食物");
    }

    public void study() {
        System.out.println("学生：学习知识");
        this.eat();
        super.eat();
        walk(); // 调用父类方法（省略了super）
    }

    public void show() {
        System.out.println("name = " + name + ", age = " + age);
        System.out.println("id(学号) = " + this.id);
        System.out.println("id(身份证) = " + super.id);
    }
}
