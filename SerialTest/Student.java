import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable {
    private static int count = 1;
    private String name;
    private int marks;
    private int id;
    transient Scanner in;

    public Student(){
        in = new Scanner((System.in));
        setupStudent();
    }

    public Student(String name, int marks){
        this.id = count;
        this.name = name;
        this.marks = marks;
        count++;
    }

    private void setupStudent(){
        this.id = count;
        System.out.print("Name: ");
        this.name = in.next();
        System.out.print("Marks: ");
        this.marks = in.nextInt();
        count++;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setMarks(int marks){
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public int getId() {
        return id;
    }
}
