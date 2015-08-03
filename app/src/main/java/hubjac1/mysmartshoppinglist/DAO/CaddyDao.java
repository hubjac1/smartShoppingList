package hubjac1.mysmartshoppinglist.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.HashSet;
import java.util.Set;

/**
 * DAO class to access caddy model from storage
 */
public class CaddyDao extends DAOBase {
    //private static int [] prod = new int[]{R.string.Bath, R.string.Bottles};
    private  static Set<Integer> product = new HashSet<>();

    public CaddyDao(Context pContext) {
        super(pContext);
    }

    /**
     * Reset caddy. Will empty the caddy table
     */
    public void reset(){
        mDb.execSQL(DatabaseSchema.Caddy.TABLE_DROP);
        mDb.execSQL(DatabaseSchema.Caddy.TABLE_CREATE);
    }

    /**
     *  Add a product to a caddy
     * @param product CaddyModel
     */
    private void add(CaddyModel product) {
        ContentValues value = new ContentValues();
        value.put(DatabaseSchema.Caddy.PRODUCT, product.getProduct());
        value.put(DatabaseSchema.Caddy.STATUS, product.getStatus());

        mDb.insert(DatabaseSchema.Caddy.TABLE_NAME, null, value);
    }

    private void delete(CaddyModel product){
        mDb.delete(DatabaseSchema.Caddy.TABLE_NAME,
                DatabaseSchema.Caddy.KEY + " = ?", new String[]{product.getKey()});
    }
    private void delete(long key){
        mDb.delete(DatabaseSchema.Caddy.TABLE_NAME,
                DatabaseSchema.Caddy.KEY + " = ?", new String[]{String.valueOf(key)});
    }

    private void update(CaddyModel product){
        ContentValues value = new ContentValues();
        value.put(DatabaseSchema.Caddy.PRODUCT, product.getProduct());
        value.put(DatabaseSchema.Caddy.STATUS, product.getStatus());

        mDb.update(DatabaseSchema.Caddy.TABLE_NAME, value,
                DatabaseSchema.Caddy.KEY + " = ?", new String[]{product.getKey()});
    }

    private CaddyModel get(int id){
        Cursor cursor = mDb.rawQuery("select * from " + DatabaseSchema.Caddy.TABLE_NAME +
                "where " + DatabaseSchema.Caddy.KEY + "= ?", new String[]{String.valueOf(id)});
        CaddyModel product = new CaddyModel(cursor.getInt(2), cursor.getInt(1));
        product.setKey(cursor.getLong(0));
        cursor.close();
        return product;
    }

    /**
     * Add product to caddy
     * @param productId : int
     * @param status: boolean
     */
    public void update(int productId, boolean status){
        if (status) {
            CaddyModel product = new CaddyModel(1, productId);
            add(product);
        }
        else
        {
            delete(productId);
        }
    }

    /**
     * Get list of product in the caddy
     * @return list of product
     */
    public Set<Integer> getProductsId(){
        Set<Integer> products = new HashSet<>();
        Cursor cursor = mDb.rawQuery("select " + DatabaseSchema.Caddy.PRODUCT + " from " + DatabaseSchema.Caddy.TABLE_NAME, new String[]{});

        while (cursor.moveToNext()) {
            products.add(cursor.getInt(0));
        }
        cursor.close();

        return products;

    }

    /**
     * get table of product in the Caddy
     * @return ProductModel []
     */
    public ProductModel [] getProducts(ProductDao productDao){
        return productDao.getProducts(getProductsId()).toArray(new ProductModel[]{});
    }
}
