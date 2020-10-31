public class Variable {
    public static void main(String[] args) {
        //  整数类型：byte(1B)、short(2B)、int(4B)、long(8B)
        byte b = 127;
        short s = 32767;
        int i = 2147483647;
        long l = 9223372036854775807L;

        // 浮点类型：float(4B)、double(8B)
        float f = 10.0F;
        double d = 20.0;

        // 字符类型：char
        char c1 = 'a';
        char c2 = '是';
        char c3 = '\n';
        char c4 = '2';
        char c5 = '\u0043'; // C

        // 布尔类型：boolean
        boolean b1 = true;
        boolean b2 = false;

        // 自动类型转换
        byte b3 = 2;
        int i1 = 129;
        int i22 = b3 + i1;
        long l1 = b3 + i1;
        float f1 = b3 + i1;
        double f2 = b3 + i1;

        // byte、short、char 之间不会相互转换，他们三者在计算时首先转换为 int 类型
        char c6 = 'A'; // 65
        int i2 = 35;
        int i3 = c6 + i2; // 100

        short s1= 35;
        // char c7 = c6 + s1; // 出错
        // short s2 = c6 + s1; // 出错

        String str = "str";
        String ret = str + s1;

        // 强制类型转换
        double d1 = 12.9;
        int i4 = (int)d1; // 12 损失精度

        long l3 = 100;
        short s3 = (short)l3; // 100 没有损失精度

        // 通常，字符串不能直接转换为基本类型，但通过基本类型对应的包装类则可以实现把字符串转换成基本类型
        String a = "11";
        int i5 = Integer.parseInt(a); // 11

        // 编码情况1
        long l2 = 123213; // 这里也可以不加L

        // long l3 = 9223372036854775807; // 编译失败
        long l4 = 9223372036854775807L;

        // float f3 = 10.0; // 编译失败，必须加F

        // 编码情况2
        // 整数常量，默认类型为int
        // 浮点数常量，默认类型为double

        byte b5 = 12;
        // byte b6 = b5 + 1; // 编译失败
        int i7 = 12;
        int i8 = b5 + 1;

        float f3 = 10.0F;
        // float f4 = b3 + 10.0; // 编译失败
        double f5 = b3 + 10.0;

        /*
        * 对于整数，有四种表示方式：
        *   二进制（binary）：0~1，以0b或0B开头表示
        *   十进制（decimal）：0~9
        *   八进制（octal）：0~7，以数字0开头表示
        *   十六进制（hex）：0~9 A~F，以0x或0X开头表示，A~F不区分大小写
        * */
        int num1 = 0b10; // 2
        int num2 = 110;
        // int num3 = 0778; // 八进制，没有数字8
        int num4 = 0777; // 511
        int num5 = 0x110A; // 4362
    }
}
