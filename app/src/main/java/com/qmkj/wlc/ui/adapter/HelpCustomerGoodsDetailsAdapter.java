package com.qmkj.wlc.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.qmkj.wlc.R;
import com.qmkj.wlc.model.HelpCustomerGoodsDetailsRes;
import com.qmkj.wlc.ui.adapter.base.XBaseAdapter;
import com.qmkj.wlc.ui.adapter.base.XBaseViewHolder;

/**
 * 创建日期：2018/6/12
 * @author Yi Shan Xiang
 * 文件名称：助客点单商品名称商品类别详情适配器
 * email: 380948730@qq.com
 */
public class HelpCustomerGoodsDetailsAdapter extends XBaseAdapter<HelpCustomerGoodsDetailsRes>{

    public HelpCustomerGoodsDetailsAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.help_customer_goods_details_adapter;
    }


    @Override
    protected void convert(XBaseViewHolder helper, HelpCustomerGoodsDetailsRes item) {
        //减 按钮
        Button subtractButton = helper.getView(R.id.help_customer_goods_details_subtract_btn);
        //加 按钮
        Button addButton = helper.getView(R.id.help_customer_goods_details_add_btn);
        //数字框
        EditText numberEt = helper.getView(R.id.help_customer_goods_details_number_et);

        numberEt.setText(item.getBuy_number()+"");

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number = item.getBuy_number();
                if(number == 0){
                    return;
                }else {
                    number = number-1;
                    item.setBuy_number(number);
                    numberEt.setText(number+"");
                }
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number = item.getBuy_number();
                number = number+1;
                item.setBuy_number(number);
                numberEt.setText(number+"");
            }
        });


    }
}
