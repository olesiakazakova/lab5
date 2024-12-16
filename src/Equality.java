import java.util.Queue;
import java.util.LinkedList;

public class Equality {
    public static <T> boolean sectionQueue (Queue<T> queue, int i, int j) {
        if (i >= j || i < 0 || j >= queue.size()) {
            throw new IllegalArgumentException("Некорректные индексы");
        }
        T firstValue = null;
        Queue<T> tempQueue = new LinkedList<>(queue);
        for (int index = 0; index <= j; index++) {
            if (i<=index && j>=index){
                if ( firstValue == null )
                    firstValue = tempQueue.poll();
                else if (!firstValue.equals(tempQueue.poll())) return false;
            } else {
                tempQueue.poll();
            }
        }
        return true;
    };
}
