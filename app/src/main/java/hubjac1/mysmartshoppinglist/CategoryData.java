package hubjac1.mysmartshoppinglist;

/** This is just a simple class for holding data that is used to render our category view */
public class CategoryData {
    private int mText;
    private int mImage;

    /**
     * Constructor
     * @param image: image resource id
     * @param resourceText: text resource id
     */
    public CategoryData(int image, int resourceText) {
        mImage = image;
        mText = resourceText;
    }

    /**
     * @return the text
     */
    public int getText() {
        return mText;
    }

    /**
     * @return the image
     */
    public int getImage() {
        return mImage;
    }
}