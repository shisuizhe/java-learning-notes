package p16Interface;

/*
 * JDK8：除了定义全局常量和抽象方法之外，还可以定义静态方法、默认方法
 *
 */
public class InterfaceImprove {
    public static void main(String[] args) {
        subClass s = new subClass();

        // 知识点1：接口中定义的静态方法，只能通过接口来调用。
        CompareA.method1(); // CompareA: 北京

        // 知识点2：通过实现类的对象，可以调用接口中的默认方法。
        // 如果实现类重写了接口中的默认方法，调用时，仍然调用的是重写以后的方法
        s.method2(); // SubClass：上海

        // 知识点3：如果子类(或实现类)继承的父类和实现的接口中声明了同名同参数的默认方法，
        // 那么子类在没有重写此方法的情况下，默认调用的是父类中的同名同参数的方法。--> 类优先原则
        // 知识点4：如果实现类实现了多个接口，而这多个接口中定义了同名同参数的默认方法，
        // 那么在实现类没有重写此方法的情况下，报错。--> 接口冲突。
        // 这就需要我们必须在实现类中重写此方法
        s.method3(); // SubClass：深圳

    }
}

interface CompareA {
    // 静态方法
    public static void method1() {
        System.out.println("CompareA: 北京");
    }

    // 默认方法
    public default void method2() {
        System.out.println("CompareA：上海2");
    }

    // 默认方法
    default void method3() {
        System.out.println("CompareA：上海3");
    }
}

interface CompareB {
    default void method3() {
        System.out.println("CompareB：上海");
    }
}

class SuperClass {
    public void method3() {
        System.out.println("SuperClass: 北京");
    }
}

class subClass extends SuperClass implements CompareA, CompareB {
    public void method2() {
        System.out.println("SubClass：上海");
    }

    public void method3() {
        System.out.println("SubClass：深圳");
    }

    // 知识点5：如何在子类(或实现类)的方法中调用父类、接口中被重写的方法
    public void myMethod() {
        // 调用自己定义的重写的方法
        method3();
        // 调用的是父类中声明的
        // super.method3();
        // 调用接口中的默认方法
        CompareA.super.method2();
        CompareB.super.method3();
    }
}
