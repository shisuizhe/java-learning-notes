public class While {
    public static void main(String[] args) {
        int i = 0;
        while(i < 10) {
            System.out.println(i);
            i++;
        }

        int n = 0;
        String s = "abcdefg";
        while(n < 10) {
            for (int j = 0; j < s.length(); j++) {
                if (j ==n) {
                    System.out.println(s.charAt(j));
                }
            }
            n++;
        }
    }
}
