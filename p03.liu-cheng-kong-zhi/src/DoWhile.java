public class DoWhile {
    public static void main(String[] args) {
        // do-while循环至少会执行一次循环体

//        int num = 1;
//        do {
//            if (num % 2 == 0) {
//                System.out.println(num);
//            }
//            num++;
//        }while (num < 10);

        int number1 = 10;
        while(number1 > 10){
            System.out.println("while");
            number1--;
        }

        int number2 = 10;
        do{
            System.out.println("do-while"); // do-while
            number2--;
        }while(number2 > 10);
    }
}
