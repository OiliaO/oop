package uni;
import base.Person;
import java.util.*;

public class Transcript {
    public int studentID;
    public HashMap<Integer, Double> transcript = new HashMap<>();

    public Transcript(int studentID) {
        this.studentID = studentID;
    }

    public void setGrade(int presentedCourseID, double grade) {
        PresentedCourse presentedCourse = PresentedCourse.findByID(presentedCourseID);
        if (presentedCourse != null && presentedCourse.studentIds.contains(studentID)) {
            transcript.put(presentedCourseID, grade);
        } else {
            System.out.println("دانشجو در این درس ثبت نام نکرده است");
        }
    }

    public void printTranscript() {
        Student student = Student.findByID(studentID);
        if (student != null) {
            Person person = Person.findByID(student.personID);
            System.out.println("نام دانشجو: " + person.name);
            System.out.println("شماره دانشجویی: " + student.studentID);
            for (Integer courseID : transcript.keySet()) {
                PresentedCourse presentedCourse = PresentedCourse.findByID(courseID);
                Course course = Course.findByID(presentedCourse.courseID);
                System.out.println("نام درس: " + course.title + " - نمره: " + transcript.get(courseID));
            }
        }
    }

    public double getGPA() {
        double totalGrade = 0;
        int totalUnits = 0;
        for (Integer courseID : transcript.keySet()) {
            PresentedCourse presentedCourse = PresentedCourse.findByID(courseID);
            Course course = Course.findByID(presentedCourse.courseID);
            totalGrade += transcript.get(courseID) * course.units;
            totalUnits += course.units;
        }
        return totalGrade / totalUnits;
    }
}