import java.util.*;

public class UniqueElements {
    public static <T> List<T> find(List<T> L1, List<T> L2) {
       List<T> L = new ArrayList<>();
        for (T element : L1) {
            if (!L2.contains(element)) {
                L.add(element);
            }
        }
        for (T element : L2) {
            if (!L1.contains(element)) {
                L.add(element);
            }
        }
        return new ArrayList<>(L);
    }
}
