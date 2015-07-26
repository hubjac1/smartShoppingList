package hubjac1.mysmartshoppinglist.DAO;

/**
 *
 */
public class ProductModel {
    private int mText;
    private int mImage;
    private boolean mSelected;

    ProductModel(int text, int image){
        mText = text;
        mImage = image;
        mSelected = false;
    }

    public int getImage() {
        return mImage;
    }

    public int getText() {
        return mText;
    }

    public boolean isSelected() {
        return mSelected;
    }

    public void setSelected(boolean selected) {
        mSelected = selected;
    }
    /**
     * @return Product ID
     */
    public int getId() {
        return mText;
    }

}
