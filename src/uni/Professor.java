package uni;
import base.Person;
import java.util.*;

public class Professor {
    public int id;
    public int personID;
    public int majorID;
    public static ArrayList<Professor> professorList = new ArrayList<>();

    public Professor(int personID, int majorID) {
        this.id = professorList.size() + 1;
        this.personID = personID;
        this.majorID = majorID;
        professorList.add(this);
    }

    public static Professor findByID(int id) {
        for (Professor professor : professorList) {
            if (professor.id == id) {
                return professor;
            }
        }
        return null;
    }
}