package Hw9;

public class Course implements Courses {
    private String name;

    public Course(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  name;
    }
}
