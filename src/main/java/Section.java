import java.util.ArrayList;

/**
 * Section belongs to a Class, contains Students 
 * and reports the average score and letter grade for the section.
 * @author Aidan Arrowood
 *
 */
public class Section implements GradeCalculator {
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
