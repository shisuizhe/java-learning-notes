package p07JiCheng.SuperOverride;

public class Test {
    public static void main(String[] args) {
        Cylinder c = new Cylinder();
        c.getArea(); // Override
        System.out.println(c.getVolume()); // 3.141592653589793
    }
}
