package p08DuoTai;

public class DuoTaiExample {

    public static void main(String[] args) {
        DuoTaiExample e = new DuoTaiExample();
        e.func(new Dog());
        /*
         * 狗吃骨头
         * 汪！汪！汪！
         */
        e.func(new Cat());
        /*
         * 猫吃鱼
         * 喵！喵！喵！
         */
    }

    public void func(Animal animal) {
        animal.eat();
        animal.shout();
    }
}

class Animal {
    public void eat() {
        System.out.println("动物：进食");
    }

    public void shout() {
        System.out.println("动物：叫");
    }
}

class Dog extends Animal {
    public void eat() {
        System.out.println("狗吃骨头");
    }

    public void shout() {
        System.out.println("汪！汪！汪！");
    }
}

class Cat extends Animal {
    public void eat() {
        System.out.println("猫吃鱼");
    }

    public void shout() {
        System.out.println("喵！喵！喵！");
    }
}