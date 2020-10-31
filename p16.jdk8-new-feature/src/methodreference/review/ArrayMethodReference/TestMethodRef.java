package methodreference.review.ArrayMethodReference;

import java.util.Arrays;

/*
    数组的构造器引用
 */
public class TestMethodRef {
    /*
        定义一个方法
        方法的参数传递创建数组的长度和ArrayBuilder接口
        方法内部根据传递的长度使用ArrayBuilder中的方法创建数组并返回
     */
    public static int[] createArray(int length, ArrayBuilder ab) {
        return ab.builderArray(length);
    }

    public static void main(String[] args) {
        // 调用createArray方法，传递数组的长度和Lambda表达式
        int[] arr1 = createArray(10, length -> new int[length]);
        System.out.println(Arrays.toString(arr1)); // [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

        /*
            使用方法引用优化Lambda表达式
            已知创建的就是int[]数组
            数组的长度也是已知的
            就可以使用方法引用
            int[]引用new，根据参数传递的长度来创建数组
         */
        int[] arr2 = createArray(10, int[]::new);
        System.out.println(Arrays.toString(arr2)); // [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    }
}
