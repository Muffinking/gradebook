package gradebook.model;
/**
 * GradeModifiyer is a class that provides the Student and GradingScheme
 * class with concrete methods for manipulating GradbookItem objects
 * @author MuffinKing
 *
 */
public class GradeModifiyer {
     GradebookItem[] gradebookItems;

     GradeModifiyer() {
         this.gradebookItems = null;
     }     
     GradeModifiyer(GradebookItem[] gradebookItems) {
        this.gradebookItems = gradebookItems;
    }

     public void addGrade(GradebookItem item) {
         gradebookItems = append(gradebookItems, item);
     }
     public void removeGrade(GradebookItem item) {
         int length = gradebookItems.length;
         int index = findGrade(item.getName());
         GradebookItem[] temp = new GradebookItem[length-1];
         for (int i=0; i<length-1; i++) {
             if (i < index) {
                 temp[i] = gradebookItems[i];
             }
             else {
                 temp[i] = gradebookItems[i+1];
             }
         }
         gradebookItems = temp;
     }
     public int findGrade(String name) {
         int length = gradebookItems.length;
         int index = 0;
         for (int i=0; i<length; i++) {
             if (gradebookItems[i].getName().equals(name)) {
                 index = i;
             }
         }
         return index;
     }
    public GradebookItem[] append(GradebookItem[] itemList,
            GradebookItem item) {
        int length = itemList.length;
        GradebookItem[] temp = new GradebookItem[length+1];
        for(int i=0; i<length; i++) {
            temp[i] = itemList[i];
        }
        temp[length+1] = item;
        return temp;
    }
}
