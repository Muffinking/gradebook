package gradebook.model;
/**
 * GradebookCategory has a name and a weight to be used in 
 * calculating a Student's average score from the scores they 
 * received on each GradebookItem.
 * @author Aidan Arrowood
 */

public class GradebookCategory {
    private String name;
    private double weight;

    public GradebookCategory(String name) {
        this.name = name;
        this.weight = 0.15;
    }
    public GradebookCategory(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
    public String getName() {
        return name;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void setName(String name) {
        this.name = name;
    }
}
