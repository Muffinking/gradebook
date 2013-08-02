package gradebook.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradingSchemeTest {
    private ArrayList<GradebookItem> scores;
    private GradingScheme scheme;

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
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGradingScheme() {
        GradingScheme schemeTest = new GradingScheme(scores);
        assertTrue(schemeTest.getScores().equals(scores));
    }

    @Test
    public void testSetWeight() {
        scheme.setWeight("homeworkGrade", 0.2);
        double testWeight = scheme.getScores().get(1).getCategory().getWeight();
        assertEquals(testWeight, 0.2, 0.01);
    }

    @Test
    public void testReturnWeights() {
        ArrayList<GradebookCategory> weights = scheme.returnWeights();
        assertEquals(weights.get(0).getName(), "Test");
    }

}
