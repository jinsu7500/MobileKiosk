package com.example.mo_termproject_201601823;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class startpage extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.start_page);

        Button orderHere = (Button)findViewById(R.id.orderHere);
        Button orderTogo = (Button)findViewById(R.id.orderTogo);



        orderHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                String orderHereString = orderHere.getText().toString();
                intent.putExtra("orderType",orderHereString);
                startActivity(intent);
            }
        });

        orderTogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                String orderTogoString = orderTogo.getText().toString();
                intent.putExtra("orderType",orderTogoString);
                startActivity(intent);
            }
        });
    }

}
