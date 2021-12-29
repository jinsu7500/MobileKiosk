package com.example.mo_termproject_201601823;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

public class Dialog3 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog3);

        //버튼 선언
        ImageButton single = (ImageButton)findViewById(R.id.side_single);
        ImageButton combo = (ImageButton)findViewById(R.id.side_combo);
        Button optionCancelBtn = (Button)findViewById(R.id.side_optionBack);
        String selMenu[] = {" 단품 2000원"," 콤보 3500원"};

        //인텐트 선언
        Intent intent = getIntent();
        String SideName = intent.getStringExtra("SideName");

        //단품 버튼 선택시
        single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("단품클릭",String.valueOf(BurgerImgId));
                intent.putExtra("itemName",SideName);
                intent.putExtra("selmenu",selMenu[0]);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        //미디엄 버튼 선택시
        combo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("itemName",SideName);
                intent.putExtra("selmenu",selMenu[1]);
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