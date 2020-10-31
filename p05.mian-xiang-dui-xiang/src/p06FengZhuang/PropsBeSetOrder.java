package p06FengZhuang;
/*
 * 总结：属性赋值的先后顺序
 *
 *
 * ① 默认初始化
 * ② 显式初始化
 * ③ 构造器中初始化
 * ④ 通过"对象.方法" 或 "对象.属性"的方式，赋值
 *
 * 以上操作的先后顺序：① - ② - ③ - ④
 *
 */
public class PropsBeSetOrder {
    public static void main(String[] args) {
        User u = new User();
        System.out.println(u.a);

        User u1 = new User(2); // 3.构造器中初始化
        System.out.println(u1.age);
        u1.setAge(3); // 4.赋值
        System.out.println(u1.age);
    }
}

class User {
    int a;       // 1.默认初始化
    int age = 1; // 2.显式初始化

    public User() {

    }

    public User(int a) {
        age = a;
    }

    public void setAge(int a) {
        age = a;
    }
}
