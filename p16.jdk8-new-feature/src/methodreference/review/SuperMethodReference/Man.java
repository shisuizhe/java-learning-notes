package methodreference.review.SuperMethodReference;

/*
    定义子类
 */
public class Man extends Human {
    // 子类重写父类sayHello的方法
    @Override
    public void sayHello() {
        System.out.println("Hello 我是Man!");
    }

    // 定义一个方法参数传递Greetable接口
    public void method(Greetable g) {
        g.greet();
    }

    public void show() {
        // 调用method方法，方法的参数Greetable是一个函数式接口，所以可以传递Lambda
        method(() -> super.sayHello()); // Hello 我是Human!

        /*
           使用super引用类的成员方法
           super是已经存在的
           父类的成员方法sayHello也是已经存在的
           所以我们可以直接使用super引用父类的成员方法
       */
        method(super::sayHello); // Hello 我是Human!
    }

    public static void main(String[] args) {
        new Man().show();
    }
}
