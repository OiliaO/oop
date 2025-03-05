package uni;
import java.util.*;

public class PresentedCourse {
    public int id;
    public int courseID;
    public int professorID;
    public int capacity;
    public ArrayList<Integer> studentIds;
    public static ArrayList<PresentedCourse> presentedCourseList = new ArrayList<>();

    public PresentedCourse(int courseID, int professorID, int capacity) {
        this.id = presentedCourseList.size() + 1;
        this.courseID = courseID;
        this.professorID = professorID;
        this.capacity = capacity;
        this.studentIds = new ArrayList<>(capacity);
        presentedCourseList.add(this);
    }

    public static PresentedCourse findByID(int id) {
        for (PresentedCourse presentedCourse : presentedCourseList) {
            if (presentedCourse.id == id) {
                return presentedCourse;
            }
        }
        return null;
    }

    public void addStudent(int studentID) {
        if (studentIds.size() < capacity) {
            studentIds.add(studentID);
        } else {
            System.out.println("ظرفیت درس پر است");
        }
    }
}