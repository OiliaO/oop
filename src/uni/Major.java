package uni;
import java.util.*;

public class Major {
    public int id;
    public String name;
    public final int capacity;
    public int numberOfStudents = 0;
    public static ArrayList<Major> majorList = new ArrayList<>();

    public Major(String name, int capacity) {
        this.id = majorList.size() + 1;
        this.name = name;
        this.capacity = capacity;
        majorList.add(this);
    }

    public static Major findByID(int id) {
        for (Major major : majorList) {
            if (major.id == id) {
                return major;
            }
        }
        return null;
    }

    public void addStudent() {
        if (numberOfStudents < capacity) {
            numberOfStudents++;
        } else {
            System.out.println("ظرفیت رشته پر است");
        }
    }
}