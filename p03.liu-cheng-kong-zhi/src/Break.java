public class Break {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                break;
            }
            System.out.println(i);
        }
        System.out.println("----------------------------------");
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                continue;
            }
            System.out.println(i);
        }
        // 以下同上
        System.out.println("----------------------------------");
        Label:for (int i = 0; i < 5; i++) {
            if (i == 3) {
                break Label;
            }
            System.out.println(i);
        }
        System.out.println("----------------------------------");
        Label:for (int i = 0; i < 5; i++) {
            if (i == 3) {
                continue Label;
            }
            System.out.println(i);
        }
    }
}
