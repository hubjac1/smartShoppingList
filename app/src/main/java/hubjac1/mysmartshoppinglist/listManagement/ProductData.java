package hubjac1.mysmartshoppinglist.listManagement;

/** This is just a simple class for holding data that is used to render our product view */
public class ProductData {
    private int mImage;
    private int mLabel;
    private boolean selected = false;

    public ProductData(int image, int label) {
        mImage = image;
        mLabel = label;
    }

    public int getImage() {
        return mImage;
    }

    public int getLabel() {
        return mLabel;
    }

    public boolean isSelected() {
        return selected;
    }
}
