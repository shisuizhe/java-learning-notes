/*
 * 银行有一个账户。
 * 有两个储户分别向同一个账户存30元，每次存10，存3次。每次存完打印账户余额。
 *
 * 分析：
 *      1.是否是多线程问题？ 是，两个储户线程
 *      2.是否有共享数据？ 有，账户（或账户余额）
 *      3.是否有线程安全问题？有
 *      4.需要考虑如何解决线程安全问题？同步机制：有三种方式。
 */

class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    // 存钱
    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ":存钱成功。余额为：" + balance);
        }
    }
}

class Customer extends Thread {

    private Account account;

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.deposit(10);
        }
    }
}

public class Practice1 {
    public static void main(String[] args) {
        Account acct = new Account(0);
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();
    }
}
