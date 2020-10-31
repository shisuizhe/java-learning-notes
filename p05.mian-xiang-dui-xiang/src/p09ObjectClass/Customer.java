package p09ObjectClass;

public class Customer {

    String name;
    int age;

    public Customer(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }


    // 重写的原则：比较两个对象的实体内容(即：name和age)是否相同
    // 手动实现equals()的重写
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Customer) {
            Customer cust = (Customer) obj;
            // 比较两个对象的每个属性是否都相同
            return this.name.equals(cust.name) &&  this.age == cust.age;
        } else {
            return false;
        }
    }

    // 手动实现
    @Override
    public String toString() {
        return "Customer [name = " + name + ",age = " + age + "]";
    }
}

class Student {
    String name;
    int age;

    public Student(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
}
