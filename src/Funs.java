import java.util.List;

public class Funs {
    public static void meowsCare(List<Meowable> meowables) {
        for (Meowable meowable : meowables) {
            meowable.meow();
        }
    }
}
