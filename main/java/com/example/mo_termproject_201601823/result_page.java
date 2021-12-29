package com.example.mo_termproject_201601823;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class result_page extends AppCompatActivity {
    final ArrayList<String> arrayList = new ArrayList<String>();
    ArrayAdapter adapter;

    //전역변수 선언
    static int orderNumber = 0;
    Date date = new Date(System.currentTimeMillis());
    SimpleDateFormat nowday = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    String formatDate = nowday.format(date);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.result_page);

        //인텐트 선언, 리스트 받아오기
        Intent intent = getIntent();
        adapter= new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);


        ListView resultListView = (ListView)findViewById(R.id.resultListView);
        TextView totalPriceResult = (TextView)findViewById(R.id.totalPriceResult);
        Button resultOKBtn = (Button)findViewById(R.id.resultOKBtn);
        Button resultCancelBtn = (Button)findViewById(R.id.resultCancelBtn);

        //인텐트 받아오기
        String items = intent.getStringExtra("shoppingList");
        String items2 = items.replaceAll("[\\[\\]]", "");
        String ordertype = intent.getStringExtra("orderType");

        int totalPrice = 0;
        String[] items_split = items2.split(",");


        resultListView.setAdapter(adapter);

        //가격,버거메뉴 출력
        for(int i =0; i<items_split.length;i++){
            arrayList.add(items_split[i]);
            String price = items_split[i].replaceAll("[^0-9]","");
            totalPrice += Integer.parseInt(price);
            //Toast.makeText(getApplicationContext(),String.valueOf(totalPrice),Toast.LENGTH_SHORT).show();
            adapter.notifyDataSetChanged();
        }
        totalPriceResult.setText("총 결제 가격은 : " + totalPrice + "원 입니다.");

        String purchaceResult = totalPrice + "원 결제되었습니다.\n주문번호 : " + orderNumber + "번\n" + "주문시간 : " + formatDate +"\n 주문 타입 : " + ordertype;
        resultOKBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderNumber +=1;
                Toast.makeText(getApplicationContext(),purchaceResult,Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(),startpage.class);
                startActivity(intent);
            }
        });

        resultCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });




    }
}
