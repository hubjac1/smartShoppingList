package hubjac1.mysmartshoppinglist.listManagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import hubjac1.mysmartshoppinglist.R;


public class ProductArrayAdapter extends ArrayAdapter<ProductData> {
    private LayoutInflater mInflater;

    /**
     * Constructor
     *
     * @param context: calling context
     * @param values:  Array of values to display
     */
    public ProductArrayAdapter(Context context, ProductData[] values) {
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
        holder.textView.setText(getItem(position).getLabel());
        holder.imageView.setImageResource(getItem(position).getImage());
        holder.selectionProduct.setEnabled(getItem(position).isSelected());

        return convertView;
    }

    /**
     * View holder for the views we need access to
     */
    private static class Holder {
        public TextView textView;
        public ImageView imageView;
        public CheckBox selectionProduct;
    }
}
