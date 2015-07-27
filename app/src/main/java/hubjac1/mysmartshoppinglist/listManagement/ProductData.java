package hubjac1.mysmartshoppinglist.listManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import hubjac1.mysmartshoppinglist.DAO.CaddyDao;
import hubjac1.mysmartshoppinglist.DAO.ProductModel;

/** This is just a simple class for holding data that is used to render our product view */
class ProductData {
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
        CaddyDao.update(mLabel, selected);
    }
    /**
     * Build a ArrayList of Category data form a array of models
     * @param modelArray: ArrayList<ProductModel>
     * @return array of product data
     */
    public static ProductData[] buildArrayFromModels(ArrayList<ProductModel> modelArray, Integer [] selectedProduct) {
        Map<Integer, ProductData> dataArray = new HashMap<>();

        for (ProductModel model : modelArray) {
            dataArray.put(model.getId(), new ProductData(model));
        }
        for(int product : selectedProduct){
            if(dataArray.containsKey(product)) {
                dataArray.get(product).setSelected(true);
            }
        }
        return  dataArray.values().toArray(new ProductData[]{});
    }
}
