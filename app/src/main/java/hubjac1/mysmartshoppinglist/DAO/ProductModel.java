package hubjac1.mysmartshoppinglist.DAO;

/**
 *
 */
public class ProductModel {
    private int mText;
    private int mImage;

    ProductModel(int text, int image){
        mText = text;
        mImage = image;
    }

    public int getImage() {
        return mImage;
    }

    public int getText() {
        return mText;
    }
}
