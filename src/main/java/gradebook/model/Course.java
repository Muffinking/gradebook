package gradebook.model;
import java.util.ArrayList;

/**
 * Course contains a name, subject, course number and the prerequisite classes
 * needed to take the course.
 * @author MuffinKing
 *
 */
public class Course extends GradeCalculator {
    private String name;
    private String subject;
    private int courseNumber;
    private ArrayList<Class> prerequisites;
    private ArrayList<Class> classes;

    public Course(String name, String subject,
            int courseNumber, ArrayList<Class> prequisites,
            ArrayList<Class> classes) {
        this.name = name;
        this.subject = subject;
        this.courseNumber = courseNumber;
        this.prerequisites = prerequisites;
        this.classes = classes;
    }
    public double averageScore() {
        double totalAverage = 0;
        double currentAverage = 0;
        double currentCount = 0;

        for (int i=0; i<classes.size(); i++) {
            currentAverage += classes.get(i).averageScore();
            currentCount++;
        }
        totalAverage = (currentAverage/currentCount);
        return totalAverage;
    }
    public ArrayList<Class> getClasses() {
        return classes;
    }
}
