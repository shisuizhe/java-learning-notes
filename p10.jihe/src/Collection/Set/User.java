package Collection.Set;

public class User implements Comparable {
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', age='" + age + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("User equals()....");
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        User user = (User) obj;

        if (this.age != user.age) {
            return false;
        }

        return this.name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age;
    }

    // 按照姓名从大到小排列, 年龄从小到大排列
    @Override
    public int compareTo(Object obj) throws RuntimeException {
        if (obj instanceof User) {
            User user = (User) obj;
            // return -this.name.compareTo(user.name);
            int compare = -this.name.compareTo(user.name);
            if (compare != 0) {
                return compare;
            } else {
                return Integer.compare(this.age, user.age);
            }
        } else {
            throw new RuntimeException("输入的类型不匹配");
        }
    }
}
