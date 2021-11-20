package Hw9;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Course course1 = new Course("HTML/CSS");
        Course course2 = new Course("Введение в тестирование");
        Course course3 = new Course("Компьютерные сети");
        Course course4 = new Course("Linux. Рабочая станция");
        Course course5 = new Course("Тестирование веб-приложений");
        Course course6 = new Course("Подготовка к собеседованию");
        Course course7 = new Course("Тестирование мобильных приложений");
        Course course8 = new Course("Java. Уровень 1");
        Course course9 = new Course("Java Core");
        Course course10 = new Course("WEB UI на Java");

        Student student1 = new Student("Renar", Arrays.asList(course1, course2, course3, course4, course5, course8, course9));
        Student student2 = new Student("Ilya", Arrays.asList(course3, course4, course5, course6, course7));
        Student student3 = new Student("Stanislav", Arrays.asList(course5, course6, course7, course8));
        Student student4 = new Student("Alexandr", Arrays.asList(course7, course8, course9));
        Student student5 = new Student("Yuriy", Arrays.asList(course8, course9));
        Student student6 = new Student("Alexey", Arrays.asList(course10));

        List<Student> studentList = new ArrayList<Student>(Arrays.asList(student1, student2, student3, student4, student5, student6));

        System.out.println(uniqCourse(studentList));

        System.out.println(curious(studentList));

        System.out.println(subscribe(studentList, course9));
    }

    private static List uniqCourse(List<Student> studentList) {
        return studentList.stream()
                .map(Student::getAllCourses)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    private static List subscribe(List<Student> studentList, Course course) {
        return studentList.stream()
                .filter(x -> x.getAllCourses().contains(course))
                .map(Student::getName)
                .collect(Collectors.toList());
    }

    private static List curious(List<Student> studentList) {
        return studentList.stream()
                .sorted(Comparator.comparing(x -> x.getAllCourses().toArray().length, Comparator.reverseOrder()))
                .limit(3)
                .map (Student::getName)
                .collect(Collectors.toList());
    }
}
