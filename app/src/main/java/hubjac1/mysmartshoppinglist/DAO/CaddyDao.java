package hubjac1.mysmartshoppinglist.DAO;

import java.util.HashSet;
import java.util.Set;

/**
 * DAO class to access caddy model from storage
 */
public class CaddyDao {
    //private static int [] prod = new int[]{R.string.Bath, R.string.Bottles};
    private  static Set<Integer> product = new HashSet<Integer>();

    /**
     * Reset caddy. Will empty the caddy
     */
    public void reset(){
        product.clear();
    }

    /**
     * Add product to caddy
     * @param productId : int
     * @param status
     */
    public static void update(int productId, boolean status){
        if (status)
            product.add(productId);
        else if (product.contains(productId))
        {
            product.remove(productId);
        }
    }

    /**
     * Get list of product in the caddy
     * @return list of product
     */
    public static Set<Integer> getProductsId(){
        return product;

    }

    /**
     * get table of product in the Caddy
     * @return ProductModel []
     */
    public static ProductModel [] getProducts(){
        return ProductDao.getProducts(product).toArray(new ProductModel []{});
    }
}
