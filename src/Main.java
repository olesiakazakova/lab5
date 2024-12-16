import static java.lang.System.out;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.*;
import java.util.Scanner;
import java.util.Set;
import java.util.Queue;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.Arrays;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //задание 1
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(-5, 2);
        Fraction f3 = new Fraction(4, 5);
        out.println("Задание 1\nСоздание класса Дробь и добавление " +
                "двух методов: получение вещ. значения и " +
                "установки числ. и знам.\nДробь 1: " + f1 + "\nДробь 2: " + f2 + "\nДробь 3: " + f3 +
                "\nЗначение дроби 1 в вещественном виде: " + f1.getValue() +
                "\nЗначение дроби 2 в вещественном виде: " + f2.getValue() +
                "\nЗначение дроби 3 в вещественном виде: " + f3.getValue());
        f1.setFraction(3,5);
        out.println("Изменение дроби 1, числитель = 3, знаменатель = 5: " + f1);
        f1.setFraction(3,-5);
        out.println("Изменение дроби 1, числитель = 3, знаменатель = -5: " + f1 +
                "\nИзменение дроби 1, числитель = 3, знаменатель = 0");
      // f1.setFraction(3,0);
        //задание 2
        Cat cat = new Cat("Барсик");
        out.println("\nЗадание 2\nКоличество мяуканий");
        List<Meowable> m = List.of(cat, cat, cat);
        Funs.meowsCare(m);
        out.println("\nКот мяукал " +
                 cat.getMeowCount()+ " раз(а)");
        //задание 3
        List<Integer> L1 = List.of(1,2,3,4);
        List<Integer> L2 = List.of(3,4,5,6);
        List<Integer> L = new ArrayList<>(UniqueElements.find(L1, L2));
        out.print("\nЗадание 3\nФормирование списка, который будет содержать элементы," +
                "\nвходящие только в один из двух списков\nДаны два списка:\n" +
                L1 + "\n" + L2 + "\nРезультат: " + L);
        //задание 4
        out.println("\n\nЗадание 4\nОпределить номера школ, в которых средний " +
                "балл за экзамен выше, чем средний по району" +
                "\nВведите количество учеников:");
        if (in.hasNextInt()) {
            Schools.upperMiddle(Integer.parseInt(in.nextLine()));
        } else {
            out.println("Неверный ввод");
        }
        //задание 5
        String file ="C:\\Users\\olesi\\OneDrive\\Desktop\\java work\\lab5\\src\\input.txt";//путь к файлу
        Set<Character> res = new HashSet<>(Searching.numbers(file));
        out.println("\n\nЗадание 5\nДан файл с текстом:");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.println("Какие цифры встречаются в тексте?");
        for (Character n : res) {
            out.print(n + " ");
        }
        //задание 6
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(2);
        q.add(3);
        q.add(3);
        q.add(3);
        out.println("\n\nЗадание 6\nПроверить равенство участка " +
                "очереди с i-го по j-й элемент (i < j)\nДана очередь: "
                + q + "\ni = 3, j = 5\nРезультат: "
                + Equality.sectionQueue(q,3,5) + "\ni = 0, j = 5\nРезультат: "
                + Equality.sectionQueue(q,0,5));
        Queue<String> q2 = new LinkedList<>();
        q2.add("qwer");
        q2.add("qwer");
        q2.add("123");
        out.println("Дана очередь: "
                + q2 + "\ni = 0, j = 1\nРезультат: "
                + Equality.sectionQueue(q2,0,1) + "\ni = 0, j = 2\nРезультат: "
                + Equality.sectionQueue(q2,0,2));
        //задание 7.1
       Point[] points = {
               new Point(1, -1),
               new Point(1, 1),
               new Point(1, 2),
               new Point(2, 3),
               new Point(2, -2),
               new Point(3, 4),
               new Point(2, 3)
       };
        Polyline polyline = new Polyline(Arrays.stream(points)
                .map(p -> new Point(p.getX(), Math.abs(p.getY())))
                .distinct()
                .sorted(Comparator.comparingDouble(Point::getX))
                .toArray(Point[]::new));
        out.println("\nЗадание 7.1\nДан набор объектов типа Point: \n" +
                Arrays.toString(points) +
                "\nнеобходимо взять все Point в разных координатах," +
                "\nубрать с одинаковыми X,Y, отсортировать по X," +
                "\nотрицательные Y сделать положительными и собрать" +
                "\nэто все в ломаную (объект типа Polyline)\nРезультат: " + polyline);
        //задание 7.2
        String file1 = "C:\\Users\\olesi\\OneDrive\\Desktop\\java work\\lab5\\src\\file.txt";
        out.println("\nЗадание 7.2\nДан текстовый файл:");
        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            String line;
            while ((line = br.readLine()) != null) {
                out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.println("Все имена привести " +
                "к нижнему регистру, но с первой буквой в верхнем регистре," +
                "\nубрать из перечня всех людей без номеров, а имена оставшихся " +
                "\nсгруппировать по их номеру\nРезультат:");
        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            Map<Integer, List<String>> groupedNames = br.lines()
                    .map(line -> line.split(":")) // Разделяем имя и номер
                    .filter(parts -> parts.length == 2 && !parts[1].trim().isEmpty()) // Убираем недопустимые строки
                    .collect(Collectors.groupingBy(
                            parts -> Integer.parseInt(parts[1].trim()), // Группируем по номеру
                            Collectors.mapping(
                                    parts -> Name.right(parts[0].trim()), // Приводим к нужному регистру
                                    Collectors.toList() // Собираем в список
                            )
                    ));
            out.println(groupedNames);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

