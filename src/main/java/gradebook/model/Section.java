package gradebook.model;
import java.util.ArrayList;
/**
 * Section belongs to a Class, contains Students 
 * and reports the average score and letter grade for the section.
 * @author Aidan Arrowood
 *
 */
public class Section extends GradeCalculator {
    private ArrayList<Student> students;

    public Section(ArrayList<Student> students) {
        this.students = students;
    }

    public double averageScore() {
        double totalAverage = 0;
        double currentAverage = 0;
        double currentCount = 0;

        for (int i=0; i<students.size(); i++) {
            currentAverage += students.get(i).averageScore();
            currentCount++;
        }
        totalAverage = (currentAverage/currentCount);
        return totalAverage;
    }
    public ArrayList<Student> getStudents() {
        return students;
    }

}
