package com.qmkj.wlc.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qmkj.wlc.R;
import com.qmkj.wlc.model.StoreManagerModel;

import java.util.List;

/**
 * author：rongkui.xiao --2018/5/16
 * email：dovexiaoen@163.com
 * description:
 */

public class StoreManagementGrideAdapter extends BaseAdapter {

    private final Context context;
    private final int layoutId;
    private final List<StoreManagerModel> data;

    public StoreManagementGrideAdapter(Context mContext, int layoutId, List<StoreManagerModel> data) {
        this.context = mContext;
        this.layoutId = layoutId;
        this.data = data;

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        StoreManagerModel storeManagerModel = data.get(position);
        Holder holder;
        if (convertView == null) {
            convertView = View.inflate(context, layoutId, null);
            holder = new Holder();
            holder.iv = convertView.findViewById(R.id.gride_iv);
            holder.tv = convertView.findViewById(R.id.gride_text);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        if (storeManagerModel != null) {
            if (!TextUtils.isEmpty(storeManagerModel.getName())) {
                holder.tv.setText(storeManagerModel.getName());
            }
            holder.iv.setImageResource(storeManagerModel.getResId());
        }

        return convertView;
    }

    private class Holder {
        TextView tv;
        ImageView iv;
    }
}
