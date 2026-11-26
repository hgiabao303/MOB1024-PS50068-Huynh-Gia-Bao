package lab4.bai1.model;

public class Student {

    private String id;
    private String name;
    private double gpa;

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void inThongTin() {
        System.out.printf("%-6s | %-20s | GPA: %.2f%n", id, name, gpa);
    }

    @Override
    public String toString() {
        return String.format("Student[%s, %s, %.2f]", id, name, gpa);
    }
}