package raditya.labs.albahjah.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import raditya.labs.albahjah.R;
import raditya.labs.albahjah.model.NavDrawerItemModel;

/**
 * Created by raditya on 12/15/2014.
 */
public class NavDrawerListAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<NavDrawerItemModel> mNavDrawerItemModels;

    public NavDrawerListAdapter(Context context, ArrayList<NavDrawerItemModel> navDrawerItemModels){
        this.mContext = context;
        this.mNavDrawerItemModels = navDrawerItemModels;
    }

    @Override
    public int getCount() {
        return mNavDrawerItemModels.size();
    }

    @Override
    public Object getItem(int position) {
        return mNavDrawerItemModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)
                    mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.drawer_list_item, null);
        }

        ImageView icon = (ImageView)convertView.findViewById(R.id.iv_icon);
        TextView title = (TextView)convertView.findViewById(R.id.tv_title);
        TextView counter = (TextView)convertView.findViewById(R.id.tv_counter);

        icon.setImageResource(mNavDrawerItemModels.get(position).getIcon());
        title.setText(mNavDrawerItemModels.get(position).getTitle());

        // displaying count
        // check whether it set visible or not
        if(mNavDrawerItemModels.get(position).getCounterVisible()){
            counter.setText(mNavDrawerItemModels.get(position).getCount());
        }else{
            // hide the counter view
            counter.setVisibility(View.GONE);
        }

        return convertView;
    }
}
