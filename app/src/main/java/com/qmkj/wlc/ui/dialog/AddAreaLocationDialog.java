package com.qmkj.wlc.ui.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.qmkj.wlc.R;


/**
 * 创建日期：2018/6/13
 * @author Yi Shan Xiang
 * 文件名称： 新增区域位置弹出框
 * email: 380948730@qq.com
 */
public class AddAreaLocationDialog extends BaseDialog {
    private EditText areNameEdt;//选择区域
    private EditText locationNameEdt;//名称
    private EditText personAmountEdt;//可容纳人数
    private OnAddAreaListener onAddAreaListener;

    public void setOnAddAreaLocationListener(OnAddAreaListener onAddAreaListener) {
        this.onAddAreaListener = onAddAreaListener;
    }

    public interface OnAddAreaListener {
        void onAddArea(String locationName,String personName);
    }

    public AddAreaLocationDialog(Context context) {
        super(context);
    }

    @Override
    protected View setContentView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_add_location_area, null);
        return view;
    }

    @Override
    protected void initContentView(View contentView) {
        setTitleText("新增位置");
        areNameEdt = contentView.findViewById(R.id.area_location_edt);//区域
        locationNameEdt = contentView.findViewById(R.id.area_location_name_edt);//名称
        personAmountEdt = contentView.findViewById(R.id.area_location_person_amount_edt);//人数
        setOnPositiveButtonClickListener((dialog, view) -> {
            if (onAddAreaListener != null) {
                onAddAreaListener.onAddArea(locationNameEdt.getText().toString(),personAmountEdt.getText().toString());
            }
        });
    }
}
