package hubjac1.mysmartshoppinglist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/** An array adapter that knows how to render views when given CategoryData classes */
public class CategoryArrayAdapter extends ArrayAdapter<CategoryData> {
    private LayoutInflater mInflater;

    /**
     * Constructor
     * @param context: calling context
     * @param values: Array of values to display
     */
    public CategoryArrayAdapter(Context context, CategoryData[] values) {
        super(context, R.layout.category_view, values);
        mInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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

        return convertView;
    }

    /** View holder for the views we need access to */
    private static class Holder {
        public TextView textView;
        public ImageView imageView;
    }
}