package p07JiCheng.permission1;

public class P1Test {
    public static void main(String[] args) {
        P1 p = new P1();

        p.Default = 1;
        p.Protected = 2;
        p.Public = 3;

        p.methodDefault();
        p.methodProtected();
        p.methodPublic();

        // 同一个包中的其他类，不可以调用 P1 类中私有的属性、方法
        // p.Private = 4;
        // p.methodPrivate();
    }
}
