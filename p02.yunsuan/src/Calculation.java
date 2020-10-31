public class Calculation {
    public static void main(String[] args) {
        // 除法
        int n1 = 12;
        int n2 = 5;
        int r1 = n1 / n2; // 2

        float r2 = n1 / n2; // 2.0  先算出结果为2，再将2赋值给r2
        double r3 = n1 / n2; // 同上

        double r4 = n1 / n2 + 0.0; // 2.0
        double r5 = n1 / (n2 + 0.0); // 2.4
        double r6 = (double) (n1 / n2); // 2.0
        double r7 = (double) n1 / n2; // 2.4

        // 取模 %
        // 结果的符号与被模数的符号想用
        int n3 = -12;
        int n4 = 5;
        System.out.println(n3 % n4); // -2

        int n5 = 12;
        int n6 = -5;
        System.out.println(n5 % n6); // 2

        // 前++  先自增1，后运算
        // 后++  先运算，后自增1
        int a1 = 10;
        int a2 = ++a1;
        System.out.println("a1=" + a1 + " a2=" + a2); // a1=11 a2=11

        int a3 = 10;
        int a4 = a3++;
        System.out.println("a3=" + a3 + " a4=" + a4); // a3=11 a4=10

        // 前--  先自减1，后运算
        // 后--  先运算，后自减1
        short s1 = 10;
        short s2 = --s1;
        System.out.println("s1=" + s1 + " s2=" + s2); // s1=9 s2=9

        short s3 = 10;
        short s4 = s3--;
        System.out.println("s3=" + s3 + " s4=" + s4); // s3=9 s4=10

        // 逻辑运算符
        boolean b1 = true;
        b1 = false;
        int num1 = 10;
        if (b1 & (num1++ > 0)) {
            System.out.println("true");
        } else {
            System.out.println("false"); // false
        }
        System.out.println("num1 = " + num1); // num1 = 11

        boolean b2 = true;
        b2 = false;
        int num2 = 10;
        if (b2 && (num2++ > 0)) {
            System.out.println("true");
        } else {
            System.out.println("false"); // false
        }
        System.out.println("num2 = " + num2); // num2 = 10


        boolean b3 = false;
        b3 = true;
        int num3 = 10;
        if (b3 | (num3++ > 0)) {
            System.out.println("true"); // true
        } else {
            System.out.println("false");
        }
        System.out.println("num3 = " + num3); // num3 = 11

        boolean b4 = false;
        b4 = true;
        int num4 = 10;
        if (b4 || (num4++ > 0)) {
            System.out.println("true"); // true
        } else {
            System.out.println("false");
        }
        System.out.println("num4 = " + num4); // num4 = 10


        //  三元运算符
        int m = 12;
        int n = 5;
        int k = 4;

        int max = (m < n) ? m : (n > k) ? n : k;
        System.out.println(max); // 5
    }
}
