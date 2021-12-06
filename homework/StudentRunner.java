package com.galeeva.lesson21.homework;

import java.util.*;
import static java.util.stream.Collectors.*;

/**
 * Дан список студентов с полями:
 * - Имя
 * - Фамилия
 * - Номер курса в университете
 * - Список оценок за учебу
 * Преобразовать этот список студентов в ассоциативный массив, где ключом является номер курса, а значением:
 * Средняя оценка студентов этого курса, количество оценок у которых больше 3-х
 * Список студентов данного курса, но только с полями Имя и Фамилия.
 * Список должен быть отсортированы по этим двум полям
 * Объект с двумя полями:
 * - Отсортированный список студентов с пункта 2
 * - Средняя оценка этих студентов
 * Подумать, как ассоциативный массив можно было представить в коде в виде отсортированного - TreeMap
 */
public class StudentRunner {

    public static void main(String[] args) {
        List<Student> list = List.of(
                new Student("Ivan", "Ivanov", 1, List.of(3, 4, 3, 4, 5, 3, 4, 5)),
                new Student("Petr", "Petrov", 2, List.of(3, 4, 3, 4, 2)),
                new Student("Sveta", "Svetikova", 3, List.of(3, 4)),
                new Student("Anya", "Kotova", 1, List.of(2, 2, 3, 5)),
                new Student("Dima", "Dimov", 4, List.of(3, 4, 3, 4)),
                new Student("Artem", "Artemov", 5, List.of(2, 2)),
                new Student("Emily", "Clark", 1, List.of(3, 4)),
                new Student("Veronika", "Galeeva", 2, List.of(3, 4, 2, 4, 3)),
                new Student("Olga", "Zotova", 3, List.of(3, 4, 3, 4)),
                new Student("Artem", "Kotov", 5, List.of(3, 4, 3)));

        Map<Integer, Double> result1 = getMapByAverageMarks(list);
        System.out.println(result1);
        Map<Integer, String> result2 = getMapByFullName(list);
        System.out.println(result2);

//        Stream stream = Stream.of(result1, result2).map(Map::entrySet).flatMap(Collection::stream)
//                .collect(groupingBy(Map.Entry::getKey),toCollection(Map.Entry::getValue )))
    }

    public static Map<Integer, Double> getMapByAverageMarks(List<Student> list) {
        return list.stream()
                .filter(marks -> marks.getMarks().size() > 3)
                .collect(groupingBy(Student::getNumberCourse,
                        mapping(Student::getMarks, averagingDouble(marks -> marks.stream().mapToDouble(value -> value).average().getAsDouble()))));
    }

    public static Map<Integer, String> getMapByFullName(List<Student> list) {
        return list.stream()
                .sorted(Comparator.comparing(Student::getFirstName))
                .collect(toMap(Student::getNumberCourse, Student::getFullName, (s, a) -> s + ", " + a));
    }
}
