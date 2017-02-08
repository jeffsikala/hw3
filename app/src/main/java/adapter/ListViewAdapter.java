package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.ListAdapter;

/**
 * Created by Jeff on 1/25/17.
 */

public class ListViewAdapter extends BaseAdapter {
    private static final  R = ;

    private final LayoutInflater mInflater;
    private final Context mContext;


    public ListViewAdapter(Context context) {
        mContext = context;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.Layout_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        Textview view = new TextView(mContext);
//        view.setText(String.valueOf(position));
//        return view;

        ViewHolder holder;
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.textView = (Textview)convertView.findViewById(R.id.list_view_tv);
            convertView.setTag(holder);
        }
        else {
            holder = (viewHolder) convertView.getTag();
        }

        holder.textView.setText(String.valueOf(position));
//        View rowView = mInflater.inflate(R.layout.list_item, parent, false);
//        TextView textView = (Textview)rowView.findViewById(R.id.list_view_tv);
//        textView.setText(String.valueOf(position));
//        textView
//        return rowView;
    }
}

class ViewHolder{
    TextView textView;
    TextView textView2;
    TextView textView3;

}
