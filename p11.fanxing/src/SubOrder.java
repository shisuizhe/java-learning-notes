import java.util.ArrayList;
import java.util.List;

// SubOrder: 不是泛型类
public class SubOrder extends Order<Integer> {

    public static <E> List<E> copyFromArrayToList(E[] arr) {

        ArrayList<E> list = new ArrayList<>();

        for (E e : arr) {
            list.add(e);
        }
        return list;
    }
}
