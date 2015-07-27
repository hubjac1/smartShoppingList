package hubjac1.mysmartshoppinglist.listManagement;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import hubjac1.mysmartshoppinglist.DAO.CaddyDao;
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

    private CategoryData[] mCategoryData = new CategoryData[] {
            new CategoryData(R.mipmap.baby, R.string.baby),
            new CategoryData(R.mipmap.bakery, R.string.bakery),
            new CategoryData(R.mipmap.chiller, R.string.chiller),
            new CategoryData(R.mipmap.deli, R.string.deli),
            new CategoryData(R.mipmap.frozen, R.string.frozen),
            new CategoryData(R.mipmap.fruits, R.string.fruits),
            new CategoryData(R.mipmap.grocery, R.string.grocery),
            new CategoryData(R.mipmap.herbs, R.string.herbs),
            new CategoryData(R.mipmap.household, R.string.household),
            new CategoryData(R.mipmap.personal, R.string.personal),
            new CategoryData(R.mipmap.vegetables, R.string.vegetables)
    };

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
        CategoryArrayAdapter adapter = new CategoryArrayAdapter(this, mCategoryData,
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
