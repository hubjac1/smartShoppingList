package hubjac1.mysmartshoppinglist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class LauncherActivity extends AppCompatActivity {

    private Button mOverviewBtn = null;
    private Button mListManagementBtn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        // Connect overview activity
        mOverviewBtn = (Button) findViewById(R.id.Overview_btn);
        mOverviewBtn.setOnClickListener(launchOverviewActivity);

        //Connect list management activity
        mListManagementBtn = (Button) findViewById(R.id.List_Management_btn);
        mListManagementBtn.setOnClickListener(launchListManagementActivity);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_launcher, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Listener to start overview activity
    private View.OnClickListener launchOverviewActivity = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Start overview activity
            Intent overviewLauncher = new Intent(LauncherActivity.this, OverviewActivity.class);
            startActivity(overviewLauncher);
        }
    };

    // Listener to start list management activity
    private View.OnClickListener launchListManagementActivity = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Start activity
            Intent listManagementLauncher = new Intent(LauncherActivity.this, ListManagementActivity.class);
            startActivity(listManagementLauncher);
        }
    };
}
