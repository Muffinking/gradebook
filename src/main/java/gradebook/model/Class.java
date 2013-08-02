package gradebook.model;
import java.util.ArrayList;
/**
 * Class contains Sections and reports the average score
 * and letter grade for the course.
 * @author MuffinKing
 *
 */
public class Class extends GradeCalculator {
    private ArrayList<Section> sections;

    public Class() {
        this.sections = null;
    }
    public Class(ArrayList<Section> sections) {
        this.sections = sections;
    }

    public double averageScore() {
        double totalAverage = 0;
        double currentAverage = 0;
        double currentCount = 0;

        for (int i=0; i<sections.size(); i++) {
            currentAverage += sections.get(i).averageScore();
            currentCount++;
        }
        totalAverage = (currentAverage/currentCount);
        return totalAverage;
    }
}
