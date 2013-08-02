package gradebook.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SectionTest {
    private ArrayList<GradebookItem> scores;
    private ArrayList<GradebookItem> scores2;
    private GradingScheme scheme;
    private Student student;
    private Student student2;
    private ArrayList<Student> studentList;
    private Section section;

    @Before
    public void setUp() throws Exception {
        GradebookCategory testGradeCategory = new GradebookCategory("Test", 0.70);
        GradebookItem testGrade = new GradebookItem("Final", 81.6, testGradeCategory);
        GradebookCategory homeworkGradeCategory = new GradebookCategory("Homework", 0.30);
        GradebookItem homeworkGrade = new GradebookItem("homeworkGrade", 85.4, homeworkGradeCategory);

        GradebookCategory midterm1Category = new GradebookCategory("Midterm1Category", 0.5);
        GradebookItem midterm1 = new GradebookItem("Midterm1", 70.35, midterm1Category);
        GradebookCategory midterm2Category = new GradebookCategory("Midterm2Category", 0.5);
        GradebookItem midterm2 = new GradebookItem("Midterm2", 96.72, midterm2Category);
        scores = new ArrayList<GradebookItem>();
        scores.add(testGrade);
        scores.add(homeworkGrade);
        
        scores2 = new ArrayList<GradebookItem>();
        scores2.add(midterm1);
        scores2.add(midterm2);
        
        scheme = new GradingScheme(scores);
        student = new Student(scores, scheme);
        student2 = new Student(scores2);
        
        studentList = new ArrayList<Student>();
        studentList.add(student);
        studentList.add(student2);
        
        section = new Section(studentList);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAverageScore() {
        double scoreTest = section.averageScore();
        assertEquals(scoreTest, 83.13, 0.01);
    }

    @Test
    public void testSection() {
        Section sectionScores = new Section(studentList);
        assertTrue(sectionScores.getStudents().equals(studentList));
    }

}
