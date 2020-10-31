package p07JiCheng.permission2;

import p07JiCheng.permission1.P1;

public class P2Test {
    public static void main(String[] args) {
        P1 p = new P1();

        p.Public = 3;
        p.methodPublic();

        // 不同包下的普通类（非子类）要使用 P1 类，不可以调用声明为private、缺省、protected权限的属性、方法
        // p.Private = 4;
        // p.Default = 1;
        // p.Protected = 2;
        //
        // p.methodPrivate();
        // p.methodDefault();
        // p.methodProtected();
    }
}
