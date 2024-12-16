import java.util.*;

import static java.lang.System.out;

public class Schools {
    public static void upperMiddle (int N) {
        Scanner in = new Scanner(System.in);
        out.println("Введите данные учеников в следующем формате:" +
                "\n<Фамилия><Имя><Школа><Балл>\n" +
                "где <Фамилия> – строка, состоящая не более, " +
                "чем из 20 символов без пробелов,\n<Имя>– строка, " +
                "состоящая не более, чем из 20 символов без пробелов,\n" +
                "<Школа> – целое число от 1 до 99,\n" +
                "<Балл> – целое число от 1 до 100");
        Map<Integer, List<Integer>> schoolScores = new HashMap<>();//баллы по школам
        for (int i = 0; i < N; i++) {
            String line = in.nextLine();
            String[] parts = line.split(" ");
            // String lastname = parts[0];
            // String name = parts[1];
            int schoolNumber = Integer.parseInt(parts[2]);
            int score = Integer.parseInt(parts[3]);
            //добавляем баллы в конкретные школы
            schoolScores.putIfAbsent(schoolNumber, new ArrayList<>());// Для з
            schoolScores.get(schoolNumber).add(score);//вставка баллов школы в лист
        }
        double sumScores = 0;//сумма всех баллов
        int sumStudents = 0;//кол-во всех учеников
        for (List<Integer> scores : schoolScores.values()) {
            for (int score : scores) {
                sumScores += score;
                sumStudents++;
            }
        }
        out.println("Результат: ");
        double districtAverage = sumScores / sumStudents;//средний балл по району
        for (Map.Entry<Integer, List<Integer>> entry : schoolScores.entrySet()) {//перебираем все записи в мап schoolScores
            int schoolNumber = entry.getKey(); //получаем номер школы
            List<Integer> scores = entry.getValue(); //получаем список баллов этой школы
            double schoolAverage = scores.stream().mapToInt(Integer::intValue).average().orElse(0);//преобразование списка в поток целых чисел
           // Метод average() вычисляет среднее значение из этого потока. Если список пуст, используется orElse(0), чтобы избежать исключения и вернуть 0.
            if (schoolAverage > districtAverage) {
                out.print(schoolNumber + " ");
            }
        }
    }

}
