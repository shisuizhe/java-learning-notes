package p08DuoTai;

import p02Obj.Obj;

import java.util.Date;

/*
 * 面向对象特征之三：多态性
 *
 * 1.理解多态性：可以理解为一个事物的多种形态。
 * 2.何为多态性：
 *   对象的多态性：父类的引用指向子类的对象（或子类的对象赋给父类的引用）
 *
 * 3.多态的使用：虚拟方法调用
 *   有了对象的多态性以后，我们在编译期，只能调用父类中声明的方法，但在运行期，我们实际执行的是子类重写父类的方法。
 *   总结：编译，看左边；运行，看右边。
 *
 * 4.多态性的使用前提：  ① 类的继承关系  ② 方法的重写
 *
 * 5.对象的多态性，只适用于方法，不适用于属性（编译和运行都看左边）
 */
public class DuoTaiTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.eat(); // 人：吃饭

        Man m = new Man();
        m.eat(); // 男人多吃肉，长肌肉
        m.earnMoney(); // 男人负责挣钱养家

        // 上面不是多态
        System.out.println("----------------------------------");

        // 对象的多态性：父类的引用指向子类的对象。
        // 我们要一个 Person 对象，但却 new 一个 Man，或 new 一个 Woman，等等。。。
        // 由此知道，等号右边是真实的对象，有多种形态
        Person p2 = new Man();
        Person p3 = new Woman();

        // 多态的使用：当调用子父类同名同参数的方法时，实际执行的是子类重写父类的方法 --- 虚拟方法调用
        p2.eat();  // 男人多吃肉，长肌肉
        p2.walk(); // 男人霸气的走路
        p3.eat();  // 女人少吃，为了减肥
        p3.walk(); // 女人窈窕的走路

        // 不可调用，因为父类不存在此方法
        // p2.earnMoney(); // 非法,编译时错误

        // 父类向下转型为子类 -> 使用强制类型转换实现
        if (p2 instanceof Man) {
            Man m1 = (Man) p2;
            m1.earnMoney(); // 男人负责挣钱养家
        }

        // 对象的多态性，只适用于方法，不适用于属性
        System.out.println(p2.desc); // 我是Person


        // 注意：编译时通过，运行时不通过
        // Person p4 = new Woman();
        // Man m2 = (Man) p4;
        //
        // Person p5 = new Person();
        // Man m3 = (Man) p5;

        // 注意：编译时通过，运行时也通过
        // Object obj = new Woman();
        // Person p6 = (Person) obj;
        // System.out.println(p6); // p08DuoTai.Woman@1b6d3586

        // 注意：编译时通过，运行不通过（示例其实属于编译时不通过，只不过先转换成Object，欺骗了编译器）
        // Object obj1 = new Date();
        // String s = (String) obj1;
    }
}
