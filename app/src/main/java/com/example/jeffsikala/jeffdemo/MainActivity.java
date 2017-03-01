package com.example.jeffsikala.jeffdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    private ImageButton btn1;
    private ImageButton btn3;

    @OnClick(R.id.btn2)
    public void button2Click(){
        Intent intent = new Intent(this, DialogActivity.class);
        startActivityForResult(intent, 2);
        //toActivity(DialogActivity.class);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        initialListener();
        ButterKnife.bind(this);
    }



    private void initialView(){

        btn1 =(ImageButton)findViewById(R.id.btn1);
        btn3 =(ImageButton)findViewById(R.id.btn3);
    }

    // Uses Reflection to search source code for on click method

    private void initialListener(){

        // Android Best Practice for Listeners
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toastShort("Button 1 was tapped");
                Intent intent = new Intent(v.getContext(), ViewPagerActivity.class);
                intent.putExtra("key", "value");
                Bundle bundle = new Bundle();
                bundle.putInt("Integer", 12345);
                Book book = new Book();
                book.setName("Android");
                book.setAuthor("Viraj");
                bundle.putSerializable("book",book);

                intent.putExtras(bundle);
                startActivityForResult(intent,1);
                //toActivity(ViewPagerActivity.class);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toastShort("Button 2 was clicked!");
                Intent intent = new Intent(v.getContext(),ListViewActivity.class);
                startActivityForResult(intent,3);
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        toastShort("onStart");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                String message = data.getStringExtra("message");
                toastShort(message);
                break;
            case 2:
                toastShort("Dialog");
                break;
            case 3:
                toastShort("ListView");
                break;
            default:
        }

    }
}
