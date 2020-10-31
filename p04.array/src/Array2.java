public class Array2 {
    /*
    数组元素的默认初始化值:
        数组元素是整型：0
        数组元素是浮点型：0.0
        数组元素是char型：0或'\u0000'，而非'0'
        数组元素是boolean型：false
        数组元素是引用数据类型：null
    */
    public static void main(String[] args) {
        int[] a1 = new int[2];
        for (int i = 0; i < a1.length; i++) {
            System.out.println(a1[i]);
        }
        System.out.println("-----------------");

        float[] a2 = new float[2];
        for (int i = 0; i <a2.length ; i++) {
            System.out.println(a2[i]);
        }
        System.out.println("-----------------");

        double[] a3 = new double[2];
        for (int i = 0; i <a3.length ; i++) {
            System.out.println(a3[i]);
        }
        System.out.println("-----------------");

        char[] a4 = new char[2];
        for (int i = 0; i < a4.length; i++) {
            System.out.println(a4[i]);
        }
        System.out.println("-----------------");

        boolean[] a5 = new boolean[2];
        for (int i = 0; i < a5.length; i++) {
            System.out.println(a5[i]);
        }
        System.out.println("-----------------");

        String[] a6 = new String[2];
        for (int i = 0; i < a6.length; i++) {
            System.out.println(a6[i]); // null
        }
    }
}
