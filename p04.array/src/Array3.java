public class Array3 {
    public static void main(String[] args) {
        // 静态初始化
        int[] a1 = new int[]{1, 2, 3}; // 一维数组
        int[][] a2 = new int[][]{{1, 2, 3}, {4, 5, 6}}; // 二维数组

        // 动态初始化
        int[][] a3 = new int[3][3];
        int[][] a4 = new int[3][];

        // 错误的示例
        // int[][] a5 = new int[][3];
        // int[3][3] a6 = new int[][];
        // int[][] a7 = new int[3][3]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        // 也是正确的写法
        int[] a8[] = new int[][]{{1, 2, 3}, {4, 5, 6}};
        int[] a9[] = {{1, 2, 3}, {4, 5, 6}}; // 类型推断

        // 如何调用数组的指定位置的元素
        System.out.println(a2[0][1]); // 2

        a4[1] = new int[3];
        System.out.println(a4[1][0]); // 0

        // 如何遍历二维数组
        for (int i = 0; i < a3.length; i++) {
            for (int j = 0; j < a3[i].length; j++) {
                System.out.print(a3[i][j] + " "); // 0 0 0 0 0 0 0 0 0
            }
        }
    }
}
