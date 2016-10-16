package cn.edu.gdmec.s07150723.alertdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private AlertDialog.Builder builder;
    private AlertDialog dialog;
    private TextView tView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tView = (TextView) this.findViewById(R.id.textView);
        Button button1 = (Button) this.findViewById(R.id.button1);
        Button button2 = (Button) this.findViewById(R.id.button2);
        Button button3 = (Button) this.findViewById(R.id.button3);
        Button button4 = (Button) this.findViewById(R.id.button4);
        Button button5 = (Button) this.findViewById(R.id.button5);
        Button button6 = (Button) this.findViewById(R.id.button6);
        Button button7 = (Button) this.findViewById(R.id.button7);
        View.OnClickListener listener = new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                   switch(v.getId()){
                       case R.id.button1:
                           dialog1();
                           break;
                       case R.id.button2:
                           dialog2();
                           break;
                       case R.id.button3:
                           dialog3();
                           break;
                       case R.id.button4:
                           dialog4();
                           break;
                       case R.id.button5:
                           dialog5();
                           break;
                       case R.id.button6:
                           dialog6();
                           break;
                       case R.id.button7:
                           dialog7();
                           break;
                   }
            }

        };
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
    }
    public void dialog1(){
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("两个按钮");
        dialog.setMessage("确定退出吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);

        DialogInterface.OnClickListener list1 = new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which==DialogInterface.BUTTON_POSITIVE){
                    dialog.dismiss();
                    MainActivity.this.finish();

                }else if(which==DialogInterface.BUTTON_NEGATIVE){
                    dialog.dismiss();
                }
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",list1);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",list1);
        dialog.show();
    }
    public void dialog2(){
        dialog=new AlertDialog.Builder(this).create();
        dialog.setTitle("三个按钮");
        dialog.setMessage("你平时忙吗");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        DialogInterface.OnClickListener list2 = new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "";
                switch(which){
                    case DialogInterface.BUTTON_POSITIVE:
                        str="平时很忙";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str="平时一般";
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        str="平时轻松";
                        break;
                }
                tView.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"忙碌",list2);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"一般",list2);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"不忙",list2);
        dialog.show();
    }
    public void dialog3(){
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("显示视图");
        dialog.setMessage("你平时忙吗");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        final EditText tEdit = new EditText(this);
        dialog.setView(tEdit);
        DialogInterface.OnClickListener list3 = new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                tView.setText("输入的是"+tEdit.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",list3);
        dialog.show();
    }
    public void dialog4(){
        final String item[] = new String[]{"北京","上海","广州"};
        final boolean bSelect[] = new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener mListener = new DialogInterface.OnMultiChoiceClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                bSelect[which] = isChecked;
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(item,null,mListener);
        dialog=builder.create();
        dialog.setTitle("复选框");
        DialogInterface.OnClickListener list4 = new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了:";
                for(int i=0;i<bSelect.length;i++){
                    if(bSelect[i]){
                        str = str+"\n"+item[i];
                    }
                }
                tView.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",list4);
        dialog.show();
    }
    public void dialog5(){
        final String item[] = new String[]{"北京","上海","广州"};
        final boolean bSelect[] = new boolean[item.length];
        DialogInterface.OnClickListener slistenter = new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                bSelect[which]=true;
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(item,-1,slistenter);
        dialog=builder.create();
        dialog.setTitle("单选框");
        DialogInterface.OnClickListener list5 = new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了:";
                for(int i=0;i<item.length;i++){
                    if(bSelect[i]){
                        str = str+"\n"+item[i];
                    }
                }
                tView.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",list5);
        dialog.show();
    }
    public void dialog6(){
        final String item[] = new String[]{"北京","上海","广州"};
        final boolean bSelect[] = new boolean[item.length];
        DialogInterface.OnClickListener slistenter = new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选择了:" +item[which];
                tView.setText(str);
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setItems(item,slistenter);
        dialog=builder.create();
        dialog.setTitle("列表框");
        DialogInterface.OnClickListener list6 = new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",list6);
        dialog.show();
    }
    public void dialog7(){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.diydialog,null);
        final EditText tEdit = (EditText) layout.findViewById(R.id.editText1);
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("自定义布局");
        dialog.setView(layout);
        DialogInterface.OnClickListener list7 = new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                tView.setText("输入的是"+tEdit.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"确定",list7);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",list7);
        dialog.show();
    }
}
