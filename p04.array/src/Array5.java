public class Array5 {
    public static void main(String[] args) {
        int[] array1, array2;

        array1 = new int[]{2, 3, 5};

        //显示array1的内容
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + "\t"); // 2	3	5
        }
        System.out.println();

        //赋值array2变量等于array1
        //不能称作数组的复制。
        array2 = array1;

        //修改array2
        array2[0] = 100;

        //打印出array1
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + "\t"); // 100	3	5
        }
    }
}
