package com.qmkj.wlc.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.qmkj.wlc.R;
import com.qmkj.wlc.model.PaymethodModel;
import com.qmkj.wlc.utils.ResourcesUtil;

import java.util.List;

/**
 * author：rongkui.xiao --2018/5/16
 * email：dovexiaoen@163.com
 * description:
 */

public class CharitableGrideAdapter extends BaseAdapter {

    private final Context context;
    private final int layoutId;
    private final List<PaymethodModel> data;

    public CharitableGrideAdapter(Context mContext, int layoutId, List<PaymethodModel> data) {
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
        PaymethodModel paymethodModel = data.get(position);
        Holder holder;
        if (convertView == null) {
            convertView = View.inflate(context, layoutId, null);
            holder = new Holder();
            holder.tv = convertView.findViewById(R.id.gride_text);
            holder.ll = convertView.findViewById(R.id.charitable_donation_pyamethod_ll);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.tv.setText(paymethodModel.getName());
        holder.ll.setBackground(ResourcesUtil.getDrawable(paymethodModel.isSelect() ? R.drawable
                .shape_paymethod_select : R.drawable.shape_paymethod_unselect));
        return convertView;
    }

    private class Holder {
        TextView tv;
        View ll;
    }
}
