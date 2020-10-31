package p16Interface;

import java.util.Random;

interface SaveMother {
    default void help() {
        System.out.println("儿子：老妈，我来救你了");
    }
}

interface SaveWife {
    default void help() {
        System.out.println("儿子：媳妇，别怕，我来了");
    }
}

class Father {
    public void help() {
        System.out.println("老爸：儿子，救我媳妇！");
    }
}

public class Man extends Father implements SaveMother, SaveWife {
    @Override
    public void help() {
        System.out.println("儿子：我该救谁呢？");
        super.help();
        Random random = new Random();
        int num = random.nextInt(3);
        switch (num) {
            case 0:
                SaveMother.super.help();
                break;
            case 1:
                SaveWife.super.help();
                break;
            default:
                System.out.println("儿子：咕噜咕噜...");
        }
    }

    public static void main(String[] args) {
        System.out.println("假如你妈和你媳妇一同掉入水里，该救谁？");
        Man man = new Man();
        man.help();
    }
}
