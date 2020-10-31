import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        System.out.print("请输入季节：");
        Scanner scanner = new Scanner(System.in);
        String season = scanner.next();

        switch (season) {
            case "春天":
                System.out.println("spring");
                break;
            case "夏天":
                System.out.println("summer");
                break;
            case "秋天":
                System.out.println("autumn");
                break;
            case "冬天":
                System.out.println("winter");
                break;
            default:
                System.out.println("输入错误");
                break;
        }

        System.out.println("-----------------------------------");

        int a = 10;
        int b = 20;
        switch (a + b) {
            case 30:
                System.out.println(30);
                break;
            default:
                System.out.println(-1);
        }
    }
}

