package com.example.mo_termproject_201601823;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Dialog extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog);

        //버튼 선언
        ImageButton single = (ImageButton)findViewById(R.id.single);
        ImageButton setMenu = (ImageButton)findViewById(R.id.setMenu);
        ImageButton largeSetMenu = (ImageButton)findViewById(R.id.largeSet);
        Button optionCancelBtn = (Button)findViewById(R.id.optionBack);
        String selMenu[] = {" 단품 2000원"," 세트 3500원"," 라지세트 4300원"};

        //인텐트 선언
        Intent intent = getIntent();
        String BurgerName = intent.getStringExtra("itemName");

        //단품 버튼 선택시
        single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("단품클릭",String.valueOf(BurgerImgId));
                intent.putExtra("itemName",BurgerName);
                intent.putExtra("selmenu",selMenu[0]);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        //세트 버튼 선택시
        setMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("itemName",BurgerName);
                intent.putExtra("selmenu",selMenu[1]);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        //라지세트 버튼 선택시
        largeSetMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("itemName",BurgerName);
                intent.putExtra("selmenu",selMenu[2]);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        //돌아가기 버튼 클릭시
        optionCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
