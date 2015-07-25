package hubjac1.mysmartshoppinglist;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    public void testTrial() {
        Application app = getApplication();
        // Todo: implement test case
        //assertEquals(true, false);
    }
}