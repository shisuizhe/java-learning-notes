package p09ObjectClass;

public class Finalize {
    public static void main(String[] args) {
        Person p = new Person("Pd", 12);
        System.out.println(p); // Person [name=Pd, age=12]
        p = null;    // 此时对象实体就是垃圾对象，等待被回收。但时间不确定。
        System.gc(); // 强制性释放空间

        // 垃圾回收之前输出：对象被释放--->Person [name=Pd, age=12]
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 子类重写此方法，作用：在对象被回收之前，执行某些操作
    // 垃圾回收机制回收任何对象之前，总会先调用它的 finalize 方法（如果覆盖此方法，
    // 让一个新的引用变量重新引用该对象，则会重新激活对象）
    @Override
    protected void finalize() throws Throwable {
        System.out.println("对象被释放--->" + this);
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}
