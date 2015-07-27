package hubjac1.mysmartshoppinglist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import hubjac1.mysmartshoppinglist.DAO.CaddyDao;
import hubjac1.mysmartshoppinglist.DAO.ProductModel;
import hubjac1.mysmartshoppinglist.listManagement.ProductArrayAdapter;

/**
 * Activity that present the shopping list
 */
public class ShoppingActivity extends AppCompatActivity {

    private ListView mProductList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        setupProductsList();
    }

    /**
     * Setup Product selection method
     */
    private void setupProductsList() {
        mProductList = (ListView) findViewById(R.id.productList);
        ProductModel [] productList = CaddyDao.getProducts();
        ProductArrayAdapter adapter = new ProductArrayAdapter(this, productList);
        mProductList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_management, menu);
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
}
