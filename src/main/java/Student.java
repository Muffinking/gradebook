import java.util.ArrayList;

/**
 * Student acts as a student and contains GradebookItems with
 * scores for the assesments.
 * @author Aidan Arrowood
 *
 */
public class Student implements GradeCalculator {
    private ArrayList<GradebookItem> scores;
    private GradingScheme scheme;
    
    public Student() {
        this.scores = null;
        this.scheme = null;
    }
    public Student(ArrayList<GradebookItem> scores) {
        this.scores = scores;
        this.scheme = new GradingScheme(scores);
    }
    public Student(ArrayList<GradebookItem> scores, GradingScheme scheme) {
        this.scores = scores;
        this.scheme = scheme;
    }

    public double averageScore() {
        ArrayList<GradebookCategory> weights = scheme.returnWeights();
        int weightLength = weights.size();
        int scoresLength = scores.size();
        double currentAverage = 0;
        double currentCount = 0;
        double totalAverage = 0;

        for (int i=0; i<weightLength ; i++) {
            double currentWeight = weights.get(i).getWeight();
            for (int j=0; j<scoresLength; j++) {
                String scoreCategoryName = scores.get(j).getCategory().getName();
                if (weights.get(i).getName().equals(scoreCategoryName)) {
                    currentAverage += scores.get(i).getScore();
                    currentCount++;
                }
            }
            totalAverage += (currentAverage/currentCount) * currentWeight;
            
        }
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
