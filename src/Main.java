import base.Person;
import uni.Major;
import uni.Student;
import uni.Professor;
import uni.Course;
import uni.PresentedCourse;
import uni.Transcript;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("ایلیا", "123456789");
        Person person2 = new Person("مهرداد", "223456789");
        Person person3 = new Person("مبین", "333456789");
        Person person4 = new Person("ژینا", "444456789");
        Person person5 = new Person("شیرین", "555556789");

        Major major1 = new Major("ریاضی", 40);
        Major major2 = new Major("علوم کامپیوتر", 45);

        Student student1 = new Student(1, 1401, 1);
        Student student2 = new Student(2, 1402, 1);
        Student student3 = new Student(3, 1403, 2);

        System.out.println("دانشجویان:");
        for (Student student : Student.studentList) {
            Person person = Person.findByID(student.personID);
            System.out.println("نام: " + person.name + " - شماره دانشجویی: " + student.studentID);
        }

        Professor professor1 = new Professor(4, 1);
        Professor professor2 = new Professor(5, 2);

        System.out.println("اساتید:");
        for (Professor professor : Professor.professorList) {
            Person person = Person.findByID(professor.personID);
            System.out.println("نام: " + person.name + " - آیدی استاد: " + professor.id);
        }

        Course course1 = new Course("برنامه‌نویسی پیشرفته", 4);
        Course course2 = new Course("مبانی ترکیبیات", 3);
        Course course3 = new Course("تاریخ امامت", 2);

        PresentedCourse presentedCourse1 = new PresentedCourse(1, 1, 30);
        PresentedCourse presentedCourse2 = new PresentedCourse(2, 1, 25);
        PresentedCourse presentedCourse3 = new PresentedCourse(3, 2, 20);

        presentedCourse1.addStudent(1);
        presentedCourse1.addStudent(2);
        presentedCourse2.addStudent(1);
        presentedCourse2.addStudent(2);
        presentedCourse2.addStudent(3);
        presentedCourse3.addStudent(3);

        Transcript transcript1 = new Transcript(1);
        transcript1.setGrade(1, 18.5);
        transcript1.setGrade(2, 17.0);

        Transcript transcript2 = new Transcript(2);
        transcript2.setGrade(1, 19.0);
        transcript2.setGrade(2, 16.5);

        Transcript transcript3 = new Transcript(3);
        transcript3.setGrade(2, 15.0);
        transcript3.setGrade(3, 20.0);

        System.out.println("\nکارنامه‌ها:");
        transcript1.printTranscript();
        System.out.println("معدل: " + transcript1.getGPA());
        System.out.println();

        transcript2.printTranscript();
        System.out.println("معدل: " + transcript2.getGPA());
        System.out.println();

        transcript3.printTranscript();
        System.out.println("معدل: " + transcript3.getGPA());
    }
}