package com.qmkj.wlc.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.qmkj.wlc.R;
import com.qmkj.wlc.model.HelpCustomerGoodsNumberRes;
import com.qmkj.wlc.model.HelpCustomerGoodsTypeBean;
import com.qmkj.wlc.ui.adapter.base.XBaseAdapter;
import com.qmkj.wlc.ui.adapter.base.XBaseViewHolder;

/**
 * 创建日期：2018/6/12
 * @author Yi Shan Xiang
 * 文件名称：助客点单商品名称商品类别适配器
 * email: 380948730@qq.com
 */
public class HelpCustomerGoodsTypeAdapter extends XBaseAdapter<HelpCustomerGoodsTypeBean>{
    Context context;
    public HelpCustomerGoodsTypeAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.help_customer_goods_type_adapter;
    }


    @Override
    protected void convert(XBaseViewHolder helper, HelpCustomerGoodsTypeBean item) {
        TextView typeName = helper.getView(R.id.help_customer_type_name);
        typeName.setText(item.getTypeName());

        if(item.isSelect()){
            typeName.setBackgroundColor(context.getResources().getColor(R.color.textGray));
        }else {
            typeName.setBackgroundColor(context.getResources().getColor(R.color.white));
        }

    }
}
