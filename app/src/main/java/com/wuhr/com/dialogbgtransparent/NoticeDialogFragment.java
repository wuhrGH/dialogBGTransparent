package com.wuhr.com.dialogbgtransparent;


import android.app.Activity;
import android.support.v4.app.DialogFragment;

/**
 * Created by wuhr_pc on 2016-1-14.
 */
public class NoticeDialogFragment extends DialogFragment {
   //让Activity继承下面接口
    public interface NoticeDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

   //接口的实例
    NoticeDialogListener mListener;

    //重写方法实例化监听
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            //验证Activity是否实现了监听接口
            mListener = (NoticeDialogListener) activity;
        } catch (ClassCastException e) {
            //没的实现接口
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener");
        }
    }
}
