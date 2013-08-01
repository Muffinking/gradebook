import java.util.ArrayList;

/**
 * GradingScheme objects are used by 
 * Student objects to calculate scores and letter grades.
 * @author Aidan Arrowood
 *
 */
public class GradingScheme {
    private ArrayList<GradebookItem> gradebookItems;

    public GradingScheme(ArrayList<GradebookItem> gradebookItems) {
        this.gradebookItems = gradebookItems;
    }

    public void setWeight(String name, double weight) {
        int length = gradebookItems.size();
        for (int i=0; i<length; i++) {
            if (gradebookItems.get(i).getName().equals(name)) {
                gradebookItems.get(i).setWeight(weight);
            }
        }
    }
    public ArrayList<GradebookCategory> returnWeights() {
        int length = gradebookItems.size();
        ArrayList<GradebookCategory> category = new ArrayList<GradebookCategory>();
        ArrayList<GradebookItem> tempList = new ArrayList<GradebookItem>(0);
        for (int i=0; i<length; i++) {
            if (!GradebookItem.contains(tempList, gradebookItems.get(i))) {
 //             tempList.add(gradebookItems.get(i));
                category.add(tempList.get(i).getCategory());
            }
        }
        return category;
    }

}
