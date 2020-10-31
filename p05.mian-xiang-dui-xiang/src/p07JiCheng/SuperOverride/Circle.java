package p07JiCheng.SuperOverride;

public class Circle {
    private double radius; // 半径

    public Circle() {
        radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // 返回圆的面积
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
