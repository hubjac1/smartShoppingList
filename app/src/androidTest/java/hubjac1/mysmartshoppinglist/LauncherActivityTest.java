package hubjac1.mysmartshoppinglist;


import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;

/**
 * Functional test class for Launcher activity.
 */
public class LauncherActivityTest extends ActivityInstrumentationTestCase2<LauncherActivity> {

    /**
     * Default Constructor
      *
     */
    public LauncherActivityTest() {
        super(LauncherActivity.class);
    }

    private LauncherActivity mLauncherActivity;
    private Button mOverviewBtn = null;
    private Button mListManagementBtn = null;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mLauncherActivity = getActivity();
        mOverviewBtn = (Button) mLauncherActivity.findViewById(R.id.Overview_btn);
        mListManagementBtn = (Button) mLauncherActivity.findViewById(R.id.List_Management_btn);
    }

    public void testButtonLabel() {
        final String expectedListManagementLabel = mLauncherActivity.
                getString(R.string.list_management_activity);
        final String listManagementLabel = mListManagementBtn.getText().toString();
        assertEquals(expectedListManagementLabel, listManagementLabel);

        final String expectedOverviewLabel = mLauncherActivity.getString(R.string.overview_activity);
        final String overviewLabel = mOverviewBtn.getText().toString();
        assertEquals(expectedOverviewLabel, overviewLabel);
    }

}
