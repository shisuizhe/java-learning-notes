package p05TransferType;

public class ArrayTest {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        System.out.println(arr); // 地址值
        // 调的是 println(Object x)

        char[] arr1 = new char[]{'a', 'b', 'c'};
        System.out.println(arr1); // abc
        // 调的是 println(char x[])
    }
}
