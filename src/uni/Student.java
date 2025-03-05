package uni;
import base.Person;
import java.util.*;

public class Student {
    public int id;
    public int personID;
    public final int entranceYear;
    public int majorID;
    public String studentID;
    public static ArrayList<Student> studentList = new ArrayList<>();

    public Student(int personID, int entranceYear, int majorID) {
        this.id = studentList.size() + 1;
        this.personID = personID;
        this.entranceYear = entranceYear;
        this.majorID = majorID;
        Major major = Major.findByID(majorID);
        if (major != null) {
            major.addStudent();
        }
        this.setStudentCode();
        studentList.add(this);
    }

    public static Student findByID(int id) {
        for (Student student : studentList) {
            if (student.id == id) {
                return student;
            }
        }
        return null;
    }

    public void setStudentCode() {
        Major major = Major.findByID(majorID);
        if (major != null) {
            this.studentID = String.valueOf(entranceYear) + String.valueOf(major.id) + String.valueOf(major.numberOfStudents);
        }
    }
}