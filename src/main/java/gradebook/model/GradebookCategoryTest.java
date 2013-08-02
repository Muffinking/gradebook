package gradebook.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradebookCategoryTest {
    private GradebookCategory testGradeCategory;

    @Before
    public void setUp() throws Exception {
        GradebookCategory testGradeCategory = new GradebookCategory("Test", 0.70);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGradebookCategory() {
        GradebookCategory testCategory = new GradebookCategory("Test", 0.70);
        assertEquals(testCategory.getName(), "Test");
        assertEquals(testCategory.getWeight(), 0.70, 0.01);
    }
}
