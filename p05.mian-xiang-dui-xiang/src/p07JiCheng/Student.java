package p07JiCheng;

// Student 继承自 Person
public class Student extends Person {
    // Persion已经有name 和 age 了，所以不需要再声明
    // String name;
    // int age;

    String major;

    public Student() {

    }

    public Student(String name, int age, String major) {
        this.name = name;
        // this.age = age;  // 因为 Person 中 age 是私有的，所以不能直接访问
        setAge(age);        // 直接调用 Person（父类）中的公共方法
        this.major = major;
    }

    // public void eat() {
    //     System.out.println("吃饭");
    // }
    //
    // public void sleep() {
    //     System.out.println("睡觉");
    // }

    public void study() {
        System.out.println("学习");
    }

    public void show() {
        System.out.println("name:" + name + ",age:" + getAge());
    }
}
