package gradebook.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StudentTest {
    private ArrayList<GradebookItem> scores;
    private GradingScheme scheme;
    private Student student;

    @Before
    public void setUp() throws Exception {
        GradebookCategory testGradeCategory = new GradebookCategory("Test", 0.70);
        GradebookItem testGrade = new GradebookItem("Final", 81.6, testGradeCategory);
        GradebookCategory homeworkGradeCategory = new GradebookCategory("Homework", 0.30);
        GradebookItem homeworkGrade = new GradebookItem("homeworkGrade", 85.4, homeworkGradeCategory);
        scores = new ArrayList<GradebookItem>();
        scores.add(testGrade);
        scores.add(homeworkGrade);
        scheme = new GradingScheme(scores);
        student = new Student(scores, scheme);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testStudent() {
        Student studentNoParams = new Student();
        assertNull(studentNoParams.getScores());
        assertNull(studentNoParams.getScheme());
        
        Student studentScores = new Student(scores);
        assertTrue(studentScores.getScores().equals(scores));
        
        Student studentScoresAndScheme = new Student(scores, scheme);
        assertTrue(studentScoresAndScheme.getScores().equals(scores));
        assertTrue(studentScoresAndScheme.getScheme().equals(scheme));
    }

    @Test
    public void testAverageScore() {
        System.out.println(student.averageScore());
        assertEquals(student.averageScore(), 82.74, 0.01);
    }

    @Test
    public void testLetterGrade() {
        assertEquals(student.letterGrade(),"B");
    }

}
