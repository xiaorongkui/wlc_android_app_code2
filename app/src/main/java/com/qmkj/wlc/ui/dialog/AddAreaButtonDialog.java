package com.qmkj.wlc.ui.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.qmkj.wlc.R;
import com.qmkj.wlc.ui.dialog.base.BaseButtonDialog;

/**
 * 创建日期：2018/6/13
 * @author Yi Shan Xiang
 * 文件名称： 新增区域弹出框
 * email: 380948730@qq.com
 */
public class AddAreaButtonDialog extends BaseButtonDialog {
    private EditText areaNameEdt;
    private OnAddAreaListener onAddAreaListener;

    public void setOnAddAreaListener(OnAddAreaListener onAddAreaListener) {
        this.onAddAreaListener = onAddAreaListener;
    }

    public interface OnAddAreaListener {
        void onAddArea(String areaName);
    }

    public AddAreaButtonDialog(Context context) {
        super(context);
    }

    @Override
    protected View setContentView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_add_area, null);
        return view;
    }

    @Override
    protected void initContentView(View contentView) {
        setTitleText("新增区域");
        areaNameEdt = contentView.findViewById(R.id.area_name_edt);//名称
        setOnPositiveButtonClickListener((dialog, view) -> {
            if (onAddAreaListener != null) {
                onAddAreaListener.onAddArea(areaNameEdt.getText().toString());
            }
        });
    }
}
