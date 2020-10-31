import java.util.Arrays;

public class Array8 {
    /*
     * java.util.Arrays:操作数组的工具类，里面定义了很多操作数组的方法
     *
     */
    public static void main(String[] args) {
        // 判断相等
        int[] arr1 = new int[]{1, 2, 3, 4};
        int[] arr2 = new int[]{1, 3, 2, 4};
        boolean isEquals = Arrays.equals(arr1, arr2);
        System.out.println(isEquals); // false

        // 输出数组信息
        System.out.println(Arrays.toString(arr1)); // [1, 2, 3, 4]

        // 将指定值填充到数组之中
        Arrays.fill(arr1, 5);
        System.out.println(Arrays.toString(arr1)); // [5, 5, 5, 5]

        // 对数组进行排序
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2)); // [1, 2, 3, 4]

        // 二分查找
        int[] arr3 = new int[]{-98, -34, 2, 34, 54, 66, 79, 105, 210, 333};
        int index = Arrays.binarySearch(arr3, 66);
        if (index >= 0) {
            System.out.println(index); // 5
        } else {
            System.out.println("未找到");
        }
    }
}
