public class Array6 {
    /*
    * 实现array2对array1数组的复制
    * */
    public static void main(String[] args) {
        int[] array1, array2;

        array1 = new int[]{2, 3, 5};

        //显示array1的内容
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + "\t"); // 2	3	5
        }
        System.out.println();

        //数组的复制:
        array2 = new int[array1.length];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = array1[i];
        }

        //修改array2
        array2[0] = 100;

        //打印出array1
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + "\t"); // 2	3	5
        }
    }
}
