package com.example.mo_termproject_201601823;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

public class Dialog2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dialog2);

        //버튼 선언
        ImageButton small = (ImageButton)findViewById(R.id.drink_small);
        ImageButton medium = (ImageButton)findViewById(R.id.drink_medium);
        ImageButton large = (ImageButton)findViewById(R.id.drink_large);
        Button optionCancelBtn = (Button)findViewById(R.id.drink_optionBack);
        String selMenu[] = {" 스몰 1000원"," 미디움 2000원"," 라지 3000원"};

        //인텐트 선언
        Intent intent = getIntent();
        String DrinkName = intent.getStringExtra("DrinkName");

        //스몰 버튼 선택시
        small.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("단품클릭",String.valueOf(BurgerImgId));
                intent.putExtra("itemName",DrinkName);
                intent.putExtra("selmenu",selMenu[0]);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        //미디엄 버튼 선택시
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("itemName",DrinkName);
                intent.putExtra("selmenu",selMenu[1]);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        //라지 버튼 선택시
        large.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("itemName",DrinkName);
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
