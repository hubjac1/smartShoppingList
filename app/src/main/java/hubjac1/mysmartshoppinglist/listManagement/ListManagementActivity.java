package hubjac1.mysmartshoppinglist.listManagement;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import hubjac1.mysmartshoppinglist.DAO.CaddyDao;
import hubjac1.mysmartshoppinglist.DAO.CategoryDao;
import hubjac1.mysmartshoppinglist.DAO.ProductDao;
import hubjac1.mysmartshoppinglist.DAO.ProductModel;
import hubjac1.mysmartshoppinglist.common.HorizontalListView;
import hubjac1.mysmartshoppinglist.R;

/**
 * Activity class. Allow the user to prepare is shopping list.
 */
public class ListManagementActivity extends AppCompatActivity {
    private HorizontalListView mCategoriesList = null;
    private ListView mProductList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_management);

        setupCategories();
    }

    /**
     * Setup categories selection method
     */
    private void setupCategories() {
        mCategoriesList = (HorizontalListView) findViewById(R.id.categoriesList);
        CategoryData[] categoryData = CategoryDao.getCategory();
        CategoryArrayAdapter adapter = new CategoryArrayAdapter(this, categoryData,
                new CategoryArrayAdapter.Callback() {
                    public void onCategorySelection(int category) {
                        ArrayList<ProductModel> products = ProductDao.getProducts(category);
                        ProductData[] productsData = ProductData.buildArrayFromModels(products, CaddyDao.getProducts());
                        setupProducts(productsData);
                    }
                });
        mCategoriesList.setAdapter(adapter);
    }
    /**
     * Setup Product selection method
     */
    private void setupProducts(ProductData [] productData) {
        mProductList = (ListView) findViewById(R.id.productList);
        ProductArrayAdapter adapter = new ProductArrayAdapter(this, productData);
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
