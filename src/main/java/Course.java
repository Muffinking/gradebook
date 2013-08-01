
/**
 * Course contains a name, subject, course number and the prerequisite classes
 * needed to take the course.
 * @author MuffinKing
 *
 */
public class Course {
    private String name;
    private String subject;
    private int courseNumber;
    private Class[] prerequisites;

    public Course(String name, String subject,
            int courseNumber, Class prequisites) {
        this.name = name;
        this.subject = subject;
        this.courseNumber = courseNumber;
        this.prerequisites = prerequisites;
    }
}
