package hubjac1.mysmartshoppinglist.DAO;

/**
 * Data model for Caddy storage
 */
public class CaddyModel {
    private long mKey;
    private int mStatus;
    private int mProduct;

    public CaddyModel(int status, int product){
        mStatus = status;
        mProduct = product;
    }

    public int getId(){
        return (int) mKey;
    }

    public String getKey() {
        return String.valueOf(mKey);
    }

    public void setKey(long mKey) {
        this.mKey = mKey;
    }

    public int getStatus() {
        return mStatus;
    }

    public void setStatus(int mStatus) {
        this.mStatus = mStatus;
    }

    public int getProduct() {
        return mProduct;
    }

    public void setProduct(int mProduct) {
        this.mProduct = mProduct;
    }
}
