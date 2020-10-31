package p14Final;

/*
 * 关键字final表示“最终的”:
 *
 * 1. final 可以用来修饰的结构：类、方法、变量
 *
 * 2. final 修饰一个类: 此类不能被其他类所继承。
 *          比如：String类、System类、StringBuffer类
 *
 * 3. final 修饰方法：表明此方法不可以被重写
 * 			比如：Object类中getClass();
 *
 * 4. final 修饰变量：此时的"变量"就称为是一个常量
 * 	        4.1 final 修饰属性：
 *                  可以考虑赋值的位置有：显式初始化、代码块中初始化、构造器中初始化
 * 		    4.2 final 修饰局部变量：
 *                  ① 修饰局部变量时，此变量就变成了常量。
 *                  ② 修饰形参时，表明此形参是一个常量。当调用此方法时，给常量形参赋一个实参，一旦赋值以后，就只能在方法体内使用此形参，但不能进行重新赋值。
 *
 *  static final 用来修饰属性时，表示：全局常量
 *  static final 用来修饰方法时：可以 类.方法 直接调用，而且此方法不可被重写（Override）
 *
 */
public class FinalTest {
    final int WIDTH = 0;
    final int LEFT;
    final int RIGHT;
	// final int DOWN;
    static final String COUNTRY = "CN";

    {
        LEFT = 1;
    }

    public FinalTest() {
        RIGHT = 2;
    }

    public void doWidth() {
        // WIDTH = 20;
    }

    public void setDown(int down){
        // DOWN = down;     // 无法通过方法给 final 成员属性赋值
	}

    public void show() {
        final int NUM = 10; // 常量
		// NUM += 20;       // 编译不通过，无法修改
    }

    public void show(final int num) {
        // num = 20;        // 编译不通过，无法修改
        System.out.println(num);
    }
}

// -----------------------------------------------------

final class FinalA {
}

// 无法继承一个被 final 修饰的类
// class B extends FinalA {
//
// }

// class C extends String {
//
// }

// -----------------------------------------------------

class AA {
    public final void show() {
    }
}

class BB extends AA {
    // 子类无法重写父类中被 final 修修饰的方法
	// public void show(){
    //
	// }
}
