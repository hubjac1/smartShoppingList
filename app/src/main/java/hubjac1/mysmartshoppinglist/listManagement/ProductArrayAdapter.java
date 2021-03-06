package hubjac1.mysmartshoppinglist.listManagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import hubjac1.mysmartshoppinglist.DAO.ProductModel;
import hubjac1.mysmartshoppinglist.R;


public class ProductArrayAdapter extends ArrayAdapter<ProductModel> {
    private LayoutInflater mInflater;

    /**
     * Constructor
     *
     * @param context: calling context
     * @param values:  Array of values to display
     */
    public ProductArrayAdapter(Context context, ProductModel[] values) {
        super(context, R.layout.product_view, values);
        mInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;

        if (convertView == null) {
            // Inflate the view since it does not exist
            convertView = mInflater.inflate(R.layout.product_view, parent, false);

            // Create and save off the holder in the tag so we get quick access to inner fields
            // This must be done for performance reasons
            holder = new Holder();
            holder.textView = (TextView) convertView.findViewById(R.id.textViewProd);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageViewProd);
            holder.selectionProduct = (CheckBox)convertView.findViewById(R.id.selectionProduct);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        // Populate the text
        holder.textView.setText(getItem(position).getText());
        holder.imageView.setImageResource(getItem(position).getImage());
        holder.selectionProduct.setOnClickListener(new SelectionListener(getItem(position)));
        holder.setSelectionProduct(getItem(position).isSelected());

        return convertView;
    }

    /**
     * View holder for the views we need access to
     */
    private static class Holder {
        public TextView textView;
        public ImageView imageView;
        public CheckBox selectionProduct;

        /**
         * Checked text box in an other thread.
         * @param value: boolean
         */
        public void setSelectionProduct(final boolean value) {
            final CheckBox cb = selectionProduct;
            cb.post(new Runnable() {
                @Override
                public void run() {
                    cb.setChecked(value);
                }
            });
        }
    }

    /**
     * On Click listener for selected/unselected product
     */
    private static class SelectionListener implements View.OnClickListener {
        private ProductModel mProduct;

        public SelectionListener(ProductModel product){
            mProduct = product;
        }

        @Override
        public void onClick(View v) {
            CheckBox box = (CheckBox)v;
            boolean status = box.isChecked();
            mProduct.setSelected(status);
        }
    }
}
