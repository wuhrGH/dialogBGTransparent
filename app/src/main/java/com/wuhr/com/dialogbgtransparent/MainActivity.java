package com.wuhr.com.dialogbgtransparent;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button alertDialogBTN=(Button)findViewById(R.id.alertDialog);
        alertDialogBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });
        Button dialogFragment=(Button)findViewById(R.id.dialogFragment);
        dialogFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               FireMissilesDialogFragment fireMissilesDialogFragment=new FireMissilesDialogFragment();//Fragment实例
                fireMissilesDialogFragment.show(getSupportFragmentManager(), "dialog");//调用show()方法显示对话框
            }
        });

        Button customAlertDialog=(Button)findViewById(R.id.customAlertDialog);
        customAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomAlertDialog();
            }
        });

        Button customdialogFragment=(Button)findViewById(R.id.customdialogFragment);
        customdialogFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomFireMissilesDialogFragment customFireMissilesDialogFragment=new CustomFireMissilesDialogFragment();//Fragment实例
                customFireMissilesDialogFragment.show(getSupportFragmentManager(), "dialog");//调用show()方法显示对话框

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showAlertDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);//实例化 AlertDialog.Builder
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
        AlertDialog dialog=builder.create();//获取 AlertDialog用create方法
        dialog.show();
    }

    public void showCustomAlertDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);//实例化 AlertDialog.Builder
        View view=getLayoutInflater().inflate(R.layout.alertdialog_layout,null);
        builder.setView(view);
        EditText phoneNoTV=(EditText)view.findViewById(R.id.phone);
        final  String phoneNo= phoneNoTV.getText()==null?"1000":phoneNoTV.getText().toString();
      //  builder.setMessage("您确定要拨打电话?");//设置提示信息，也可以设置标题setTitle
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {//设置确定按钮及点元事件
            public void onClick(DialogInterface dialog, int id) {
                //用intent启动拨打电话
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNo));
                startActivity(intent);
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {//设置取消按钮及点击事件
public void onClick(DialogInterface dialog, int id) {
        dialog.dismiss();
        }
        });
        AlertDialog dialog=builder.create();//获取 AlertDialog用create方法
        dialog.show();
        }
}
