import java.io.*;
import java.util.Scanner;

public class Main {

    static School mySchool;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        setupSchool();
        int choice = 0;
        while(choice!=7){
            System.out.println("1. Display all Students");
            System.out.println("2. Add new Student");
            System.out.println("3. Change Student Name");
            System.out.println("4. Change Student Marks");
            System.out.println("5. Save");
            System.out.println("6. Load");
            System.out.println("7. Exit");
            choice = in.nextInt();
            if(choice == 1){
                displaySchool();
            }
            else if (choice == 2) {
                addSchoolStudent();
            }
            else if(choice == 3) {
                changeSchoolStudentName();
            }
            else if(choice == 4) {
                changeSchoolStudentMarks();
            }
            else if(choice == 5) {
                saveSchool();
            }
            else if(choice == 6) {
                loadSchool();
            }
        }
    }

    public static void setupSchool(){
        mySchool = new School();
    }

    public static void displaySchool(){
        mySchool.displayStudents();
    }

    public static void addSchoolStudent(){
        mySchool.addStudent();
    }

    public static void changeSchoolStudentName(){
        mySchool.changeStudentName();
    }

    public static void changeSchoolStudentMarks(){
        mySchool.changeStudentMarks();
    }

    public static void saveSchool(){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("school.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            out.writeObject(mySchool);
            out.close();
            fileOutputStream.close();
            System.out.println("Serialized data is saved in school.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadSchool(){
        try{
            FileInputStream fileInputStream = new FileInputStream("school.txt");
            ObjectInputStream in = new ObjectInputStream(fileInputStream);
            mySchool = (School) in.readObject();
            in.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found F");
            e.printStackTrace();
        }
    }
}

