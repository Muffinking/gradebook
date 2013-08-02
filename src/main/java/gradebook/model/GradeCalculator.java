package gradebook.model;

/**
 * Grade Calculator sets a standard for the Class, Section and Student classes
 * to be able to return  average score and letter grade values.
 * @author Aidan Arrowood
 *
 */
public abstract class GradeCalculator {
    public double averageScore() {
        return 0.0;
    }
     public String letterGrade() {
         String letterGrade = "";
         int grade = (int)averageScore();
         if (grade>90) { letterGrade = "A"; }
         else if (grade>80) { letterGrade = "B"; }
         else if (grade>70) { letterGrade = "C"; }
         else if (grade>60) { letterGrade = "D"; }
         else if (grade<60) { letterGrade = "F"; }
         return letterGrade;
     }
}
