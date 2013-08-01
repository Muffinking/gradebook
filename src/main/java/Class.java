import java.util.ArrayList;


/**
 * Class contains Sections and reports the average score
 * and letter grade for the course.
 * @author MuffinKing
 *
 */
public class Class implements GradeCalculator {
    private ArrayList<Section> sections;

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

    public String letterGrade() {
        String letterGrade = "";
        int grade = (int)averageScore();
        if (grade>90) { letterGrade = "A"; }
        if (grade>80) { letterGrade = "B"; }
        if (grade>70) { letterGrade = "C"; }
        if (grade>60) { letterGrade = "D"; }
        if (grade<60) { letterGrade = "F"; }
        return letterGrade;
    }
}
