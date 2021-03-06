package hubjac1.mysmartshoppinglist.DAO;

/**
 * Data model of stored product
 */
public class ProductModel {
    private int mText;
    private int mImage;
    private int mId;
    private boolean mStatus;

    private static CaddyDao mCaddyDao = new CaddyDao(null);
    public static void setCaddyDao (CaddyDao caddyDao){
        mCaddyDao =  caddyDao;
    }

    ProductModel(int text, int image){
        mText = text;
        mImage = image;
        mStatus = false;
        mId = mText;
    }

    /**
     *
     * @return image ID: int
     */
    public int getImage() {
        return mImage;
    }

    /**
     *
     * @return text ID: int
     */
    public int getText() {
        return mText;
    }

    public int getId() {
        return mId;
    }

    public boolean isSelected(){
        return mStatus;
    }

    public void setSelected(boolean selected) {
        mStatus = selected;
        mCaddyDao.update(mId, selected);
    }
}
