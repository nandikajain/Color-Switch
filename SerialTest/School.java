import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class School implements Serializable {
    private ArrayList<Student> studentList;
    transient Scanner in;

    public School(){
        in = new Scanner(System.in);
        studentList = new ArrayList<Student>();
        studentList.add(new Student("ABC",45));
        studentList.add(new Student("DBC",55));
        studentList.add(new Student("CBA",30));
    }

    public void addStudent(){
        studentList.add(new Student());
    }

    public void displayStudents(){
        for(Student s : studentList){
            System.out.println("ID: "+ s.getId());
            System.out.println("Name: "+ s.getName());
            System.out.println("Marks: "+ s.getMarks());
        }
    }

    public void changeStudentName(){
        System.out.println("Enter ID: ");
        int tempID = in.nextInt();
        for(Student s : studentList){
            if(tempID == s.getId()){
                System.out.println("Enter new Name: ");
                String newName = in.next();
                s.setName(newName);
                break;
            }
        }
    }

    public void changeStudentMarks(){
        System.out.println("Enter ID: ");
        int tempID = in.nextInt();
        for(Student s : studentList){
            if(tempID == s.getId()){
                System.out.println("Enter new Marks: ");
                int newMarks = in.nextInt();
                s.setMarks(newMarks);
                break;
            }
        }
    }
}
