package hubjac1.mysmartshoppinglist.DAO;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

import hubjac1.mysmartshoppinglist.R;

/**
 * DAO class to access product model from storage
 */
public class ProductDao {
    static private ArrayList<ProductModel> mBabyProducts =
            new ArrayList<>(Arrays.asList(new ProductModel[]{
            new ProductModel(R.string.Bath, R.mipmap.bath),
            new ProductModel(R.string.Bottles, R.mipmap.bottles),
            new ProductModel(R.string.Creams, R.mipmap.creams),
            new ProductModel(R.string.Food_and_Formula, R.mipmap.food_and_formula),
            new ProductModel(R.string.Medicine, R.mipmap.medicine),
            new ProductModel(R.string.Nappies, R.mipmap.nappies),
            new ProductModel(R.string.Nappy_Wipes, R.mipmap.nappy_wipes)
    }));
    static private ArrayList<ProductModel> mBakeryProducts =
            new ArrayList<>(Arrays.asList(new ProductModel[]{
            new ProductModel(R.string.Rolls, R.mipmap.rolls),
            new ProductModel(R.string.Bread_Loaf, R.mipmap.bread_loaf),
            new ProductModel(R.string.Bread_Stick, R.mipmap.bread_stick),
            new ProductModel(R.string.Cakes, R.mipmap.cakes),
            new ProductModel(R.string.Crumpets, R.mipmap.crumpets),
            new ProductModel(R.string.Hot_Dog_Rolls, R.mipmap.hot_dog_rolls),
            new ProductModel(R.string.Muffins, R.mipmap.muffins),
            new ProductModel(R.string.Pikelets, R.mipmap.pikelets),
            new ProductModel(R.string.Wraps, R.mipmap.wraps)
    }));

    static public ArrayList<ProductModel> getProducts(int category)
    {
        if (category == R.string.baby){
            return mBabyProducts;
        }
        else if (category == R.string.bakery) {
            return mBakeryProducts;
        }
        else {
            return new ArrayList<>();
        }
    }
}
