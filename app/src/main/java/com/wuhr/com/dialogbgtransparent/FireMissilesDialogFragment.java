package com.wuhr.com.dialogbgtransparent;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

/**
 * Created by wuhr_pc on 2016-1-6.
 */
//为了兼容版本请确保您导入的是 android.support.v4.app.DialogFragment 类，而不是 android.app.DialogFragment。
public class FireMissilesDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setMessage("您确定要拨打电话?");//设置提示信息，也可以设置标题setTitle
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {//设置确定按钮及点元事件
            public void onClick(DialogInterface dialog, int id) {
                //用intent启动拨打电话
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "10000"));
                startActivity(intent);
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {//设置取消按钮及点击事件
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
       return  builder.create();//获取 AlertDialog用create方法
    }
}
