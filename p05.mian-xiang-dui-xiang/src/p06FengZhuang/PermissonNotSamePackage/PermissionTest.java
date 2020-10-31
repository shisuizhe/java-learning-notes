package p06FengZhuang.PermissonNotSamePackage;

import p06FengZhuang.Permission;

/*
 * 不同包：无法访问另一个类的 私有/缺省 的 属性/方法
 * */
public class PermissionTest {
    public static void main(String[] args) {
        // 如何Permission类不是 public，那么不同包下，就无法实例化这个类了
        Permission P = new Permission();
        // p.Private = 1; // 无法访问
        // P.Default = 2; // 无法访问
        P.Public = 3;
    }
}
