package gradebook.model;
import java.util.ArrayList;

/**
 * Gradebook tests all of the classes and demonstrates their functionality.
 * @author Aidan Arrowood
 *
 */
public class Gradebook {
    private Course course;
    private Class courseClass;
    private Section section;
    private Student student;
    private Student student2;
    private GradingScheme scheme;

    public Gradebook() {
        //GradebookItem Midterms
        GradebookCategory midterm1Category = new GradebookCategory("Midterm1Category", 0.35);
        GradebookItem midterm1 = new GradebookItem("Midterm1", 80.35, midterm1Category);
        GradebookCategory midterm2Category = new GradebookCategory("Midterm2Category", 0.35);
        GradebookItem midterm2 = new GradebookItem("Midterm2", 86.72, midterm2Category);
        
        GradebookCategory midterm1Category2 = new GradebookCategory("Midterm1Category", 0.5);
        GradebookItem midterm12 = new GradebookItem("Midterm1", 70.35, midterm1Category2);
        GradebookCategory midterm2Category2 = new GradebookCategory("Midterm2Category", 0.5);
        GradebookItem midterm22 = new GradebookItem("Midterm2", 96.72, midterm2Category2);
        
        //GradebookItem Homeworks
        GradebookCategory homework1Category = new GradebookCategory("homework1Category", 0.15);
        GradebookItem homework1 = new GradebookItem("homework1", 97.63, homework1Category);
        GradebookCategory homework2Category = new GradebookCategory("homework2Category", 0.15);
        GradebookItem homework2 = new GradebookItem("homework2", 65.37, homework2Category);
        
        //GradebookItem Arrays
        ArrayList<GradebookItem> scores = new ArrayList<GradebookItem>();
        scores.add(midterm1);
        scores.add(midterm2);
        scores.add(homework1);
        scores.add(homework2);
        
        ArrayList<GradebookItem> scores2 = new ArrayList<GradebookItem>();
        scores2.add(midterm12);
        scores2.add(midterm22);

        //GradingSchemes
        GradingScheme scheme = new GradingScheme(scores);
        scheme.setWeight("Midterm1", 0.25);
        
        //Students
        student2 = new Student(scores2);
        student = new Student(scores, scheme);
        
        //Student Array
        ArrayList<Student> studentList = new ArrayList<Student>();
        studentList.add(student);
        studentList.add(student2);
 
        //Sections
        section = new Section(studentList);
        
        //Section Array
        ArrayList<Section> sectionList = new ArrayList<Section>();
        sectionList.add(section);
        
        //Classes
        courseClass = new Class(sectionList);
        Class prerequisiteCass = new Class();
        
        //Classes Array
        ArrayList<Class> classList = new ArrayList<Class>();
        classList.add(courseClass);
        ArrayList<Class> prerequisiteClassList = new ArrayList<Class>();
        classList.add(courseClass);
        
        //Courses
        course = new Course("cs2340", "Objects and Design", 1,
                prerequisiteClassList, classList);
    }

    public static void main(String[] a) {
        Gradebook gradebook = new Gradebook();
        
        System.out.println("Course Average: " +
        gradebook.course.averageScore());
        
        System.out.println("Class Average: " +
        gradebook.courseClass.averageScore());
        
        System.out.println("Section Average: " +
        gradebook.section.averageScore());
        
        System.out.println("Student1 Average: " +
        gradebook.student.averageScore() +
        " Letter Grade: " + gradebook.student.letterGrade());
        
        System.out.println("Student2 Average: " +
        gradebook.student2.averageScore() +
        " Letter Grade: " + gradebook.student2.letterGrade());
    }
}