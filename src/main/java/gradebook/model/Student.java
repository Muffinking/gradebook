package gradebook.model;
import java.util.ArrayList;
/**
 * Student acts as a student and contains GradebookItems with
 * scores for the assesments.
 * @author Aidan Arrowood
 *
 */
public class Student extends GradeCalculator {
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
 //           System.out.println(weights.get(i).getName() + " " + currentWeight);
            for (int j=0; j<scoresLength; j++) {
                String scoreCategoryName = scores.get(j).getCategory().getName();
                String weightCategoryName = weights.get(i).getName();
                if (weightCategoryName.equals(scoreCategoryName)) {
                    currentAverage += scores.get(i).getScore();
 //                   System.out.println("Current Average: " + currentAverage);
                    currentCount++;
                }
            }
            totalAverage += (currentAverage/currentCount) * currentWeight;
//            System.out.println("totalAverage: " + totalAverage +
//                    " currentAverage: " + currentAverage + 
//                    " currentCount: " + currentCount + " currentWeight: " + currentWeight);
            currentCount = 0;
            currentAverage = 0;
        }
        return totalAverage;
    }
    public ArrayList<GradebookItem>  getScores() {
        return scores;
    }
    public GradingScheme  getScheme() {
        return scheme;
    }
}
