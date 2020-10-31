package p06FengZhuang;

/*
* 同一个包的不同类：无法访问另一个类的私有属性/方法
* */
public class PermissionTest {
    public static void main(String[] args) {
        Permission P = new Permission();
        // p.Private = 1; // 无法访问
        P.Default = 2;
        P.Public = 3;

    }
}
