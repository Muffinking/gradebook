import java.util.ArrayList;

/**
 * GradebookItem contains a String name and a GradebookCategory object
 * to store the value of Student scores on assessments.
 * @author Aidan Arrowood
 *
 */
public class GradebookItem {
    private String name;
    private GradebookCategory category;
    private double score;

    public GradebookItem(String name, double score,
            GradebookCategory category) {
        this.name = name;
        this.score = score;
        this.category = category;
    }

    public String getName() {
        return name;
    }
    public GradebookCategory getCategory() {
        return category;
    }
    public double getScore() {
        return score;
    }
    public void setWeight(double weight) {
        category.setWeight(weight);
    }
    public static boolean contains(ArrayList<GradebookItem> itemList, GradebookItem item) {
        int length = itemList.size();
        boolean isContains = false;
        for(int i=0; i<length; i++) {
            if (itemList.get(i).getName().equals(item.getName())) {
                isContains = true;
            }
        }
        return isContains;
    }
}
