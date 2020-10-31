public class Array4 {
    /*
     * 二维数组的使用：
     * 	规定：二维数组分为外层数组的元素，内层数组的元素
     * 		int[][] arr = new int[2][2];
     * 		外层元素：arr[0],arr[1]等
     * 		内层元素：arr[0][0],arr[1][2]等
     *
     * 数组元素的默认初始化值
     *   针对于初始化方式一：比如：int[][] arr = new int[4][3];
     *      外层元素的初始化值为：地址值
     *      内层元素的初始化值为：与一维数组初始化情况相同
     *
     *   针对于初始化方式二：比如：int[][] arr = new int[4][];
     *   	外层元素的初始化值为：null
     *      内层元素的初始化值为：不能调用，否则报错。
     *
     */
    public static void main(String[] args) {
        int[][] a1 = new int[2][2];
        System.out.println(a1[0]); // [I@1b6d3586  <- 地址值
        System.out.println(a1[0][0]); // 0

        String[][] a2 = new String[2][2];
        System.out.println(a2[0]); // [Ljava.lang.String;@4554617c  <- 地址值
        System.out.println(a2[0][0]); // null <- 空值

        int[][] a3 = new int[2][];
        System.out.println(a3[1]); // null
        System.out.println(a3[1][0]); // NullPointerException <- 报错
    }
}
