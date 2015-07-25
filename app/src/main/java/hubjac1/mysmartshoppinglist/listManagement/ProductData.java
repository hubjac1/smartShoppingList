package hubjac1.mysmartshoppinglist.listManagement;

import java.util.ArrayList;

import hubjac1.mysmartshoppinglist.DAO.ProductModel;

/** This is just a simple class for holding data that is used to render our product view */
public class ProductData {
    private int mImage;
    private int mLabel;
    private boolean mSelected = false;

    public ProductData(int image, int label) {
        mImage = image;
        mLabel = label;
    }

    public ProductData(ProductModel productModel) {
        mImage = productModel.getImage();
        mLabel = productModel.getText();
    }

    public int getImage() {
        return mImage;
    }

    public int getLabel() {
        return mLabel;
    }

    public boolean isSelected() {
        return mSelected;
    }

    public void setSelected(boolean selected) {
        mSelected = selected;
    }
    /**
     * Build a ArrayList of Category data form a array of models
     * @param modelArray: ArrayList<ProductModel>
     * @return array of product data
     */
    public static ProductData[] buildArrayFromModels(ArrayList<ProductModel> modelArray) {
        ArrayList<ProductData> dataArray = new ArrayList<> ();

        for (ProductModel model : modelArray) {
            dataArray.add(new ProductData(model));
        }
        return  dataArray.toArray(new ProductData[]{});
    }
}
