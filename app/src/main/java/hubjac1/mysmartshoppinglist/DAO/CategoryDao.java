package hubjac1.mysmartshoppinglist.DAO;

import hubjac1.mysmartshoppinglist.R;
import hubjac1.mysmartshoppinglist.listManagement.CategoryData;

/**
 * DAO class to access category model from storage
 */
public class CategoryDao {
    private static CategoryData[] mCategoryData = new CategoryData[] {
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

    public static  CategoryData[] getCategory(){
        return mCategoryData.clone();
    }
}
