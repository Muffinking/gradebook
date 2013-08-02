package gradebook.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradebookItemTest {
    private ArrayList<GradebookItem> scores;
    private GradingScheme scheme;
    private GradebookItem homeworkGrade;

    @Before
    public void setUp() throws Exception {
        GradebookCategory testGradeCategory = new GradebookCategory("Test", 0.70);
        GradebookItem testGrade = new GradebookItem("Final", 81.6, testGradeCategory);
        GradebookCategory homeworkGradeCategory = new GradebookCategory("Homework", 0.30);
        homeworkGrade = new GradebookItem("homeworkGrade", 85.4, homeworkGradeCategory);
        scores = new ArrayList<GradebookItem>();
        scores.add(testGrade);
        scores.add(homeworkGrade);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGradebookItem() {
        GradebookCategory testGradeCategory = new GradebookCategory("Test", 0.70);
        GradebookItem item = new GradebookItem("Final", 35.43, testGradeCategory);
        assertTrue(item.getName().equals("Final"));
        assertEquals(item.getScore(), 35.43, 0.01);
        assertEquals(item.getCategory().getWeight(), 0.70, 0.01);
    }

    @Test
    public void testContains() {
        assertTrue(scores.contains(homeworkGrade));
    }

}
