package com.example.mo_termproject_201601823;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

public class Dioalog4 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dioalog4);
        //버튼 선언
        ImageButton choko = (ImageButton)findViewById(R.id.dessert_choko);
        ImageButton strawberry = (ImageButton)findViewById(R.id.dessert_strawberry);
        ImageButton caramel = (ImageButton)findViewById(R.id.dessert_caramel);
        Button optionCancelBtn = (Button)findViewById(R.id.dessert_optionBack);
        String selMenu[] = {" 초코 1500원"," 딸기 1500원"," 카라멜 1500원"};

        //인텐트 선언
        Intent intent = getIntent();
        String DessertName = intent.getStringExtra("DessertName");

        //단품 버튼 선택시
        choko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("단품클릭",String.valueOf(BurgerImgId));
                intent.putExtra("itemName",DessertName);
                intent.putExtra("selmenu",selMenu[0]);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        //딸기 버튼 선택시
        strawberry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("itemName",DessertName);
                intent.putExtra("selmenu",selMenu[1]);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        //카라멜 버튼 선택시
        caramel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("itemName",DessertName);
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