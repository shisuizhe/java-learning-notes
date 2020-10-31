public class Array1 {
    public static void main(String[] args) {
        // 1.声明
        int[] ids;
        // 2.静态初始化:数组的初始化和数组元素的赋值操作同时进行
        ids = new int[]{1, 2, 3};

        // 动态初始化:数组的初始化和数组元素的赋值操作分开进行
        String[] names = new String[2];

        //错误的写法：
		/*
		int[] arr1 = new int[];
		int[5] arr2 = new int[5];
		int[] arr3 = new int[3]{1,2,3};
		*/

        //也是正确的写法：
        int[] arr4 = {1, 2, 3}; // 类型推断

        /*---------- 总结：数组一旦初始化完成，其长度就确定了 ----------*/

        names[0] = "a";
        names[1] = "b";
        // names[2] = "c"; // ArrayIndexOutOfBoundsException


    }
}
