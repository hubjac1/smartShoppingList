package hubjac1.mysmartshoppinglist.listManagement;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import hubjac1.mysmartshoppinglist.R;

/** An array adapter that knows how to render views when given CategoryData classes */
 class CategoryArrayAdapter extends ArrayAdapter<CategoryData> {
    private LayoutInflater mInflater;
    private Callback mCallback;

    /**
     * Constructor
     * @param context: calling context
     * @param values: Array of values to display
     */
    public CategoryArrayAdapter(Context context, CategoryData[] values, Callback callback) {
        super(context, R.layout.category_view, values);
        mInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mCallback = callback;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;

        if (convertView == null) {
            // Inflate the view since it does not exist
            convertView = mInflater.inflate(R.layout.category_view, parent, false);

            // Create and save off the holder in the tag so we get quick access to inner fields
            // This must be done for performance reasons
            holder = new Holder();
            holder.textView = (TextView) convertView.findViewById(R.id.textView);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        // Populate the text
        holder.textView.setText(getItem(position).getText());
        holder.imageView.setImageResource(getItem(position).getImage());
        holder.imageView.setOnClickListener(new SelectionListener(getItem(position).getId()));

        return convertView;
    }

    /** View holder for the views we need access to */
    private static class Holder {
        public TextView textView;
        public ImageView imageView;
    }

    private class SelectionListener implements View.OnClickListener {
        private int mProductId;

        SelectionListener(int productId) {
            mProductId = productId;
        }

        @Override
        public void onClick(View v) {
            //Todo send product click notification
            Log.v("app", "click on: " + mProductId);
            mCallback.onCategorySelection(mProductId);
        }
    }
    public interface Callback {
        void onCategorySelection(int category);
    }
}