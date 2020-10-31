package p07JiCheng.SuperOverride;
/*
 * 方法的重写 Override
 *
 * 1.重写：子类继承父类以后，可以对父类中同名同参数的方法，进行覆盖操作
 *
 * 2.应用：重写以后，当创建子类对象以后，通过子类对象调用子父类中的同名同参数的方法时，实际执行的是子类重写父类的方法。
 *
 * 3.重写的规定：
 * 			方法的声明： 权限修饰符 返回值类型 方法名(形参列表) throws 异常的类型 {
 * 						    方法体
 * 					    }
 * 			约定俗称：子类中的叫 重写的方法，父类中的叫 被重写的方法
 * 		① 子类重写的方法的方法名和形参列表与父类被重写的方法的 方法名 和 形参列表 相同
 *      ② 子类 重写的方法的 权限修饰符 大于或等于 父类 被重写的方法的 权限修饰符
 *      	>特殊情况：子类不能重写父类中声明为private权限的方法
 *      ③ 返回值类型：
 *      	>父类被重写的方法的返回值类型是void，则子类重写的方法的返回值类型只能是void
 *      	>父类被重写的方法的返回值类型是A类型，则子类重写的方法的返回值类型可以是A类或A类的子类
 *      	>父类被重写的方法的返回值类型是基本数据类型(比如：double)，则子类重写的方法的返回值类型必须是相同的基本数据类型(必须也是double)
 *		④ 子类重写的方法抛出的异常类型 小于或等于 父类被重写的方法抛出的异常类型（具体放到异常处理时候讲）
 *
 *		⑤ 子类和父类中的同名同参数的方法要么都声明为非static的（是重写），要么都声明为static的（非重写）。
 *
 * 面试题：区分方法的重载与重写
 */
public class Cylinder extends Circle {
    private double length; // 圆柱的长度

    public Cylinder(){
        length = 1.0;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    // 返回圆柱的体积
    public double getVolume(){
		// return Math.PI * getRadius() * getRadius() * getLength();
        return super.getArea() * length;
    }

    // 返回圆柱的表面积
    @Override
    public double getArea() {
        System.out.println("Override");
        return Math.PI * getRadius() * getRadius() * 2 + 2 * Math.PI * getRadius() * getLength();
    }
}
