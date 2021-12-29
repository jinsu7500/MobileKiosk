package com.example.mo_termproject_201601823;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

        final static int selectedMenu =0;

    int checked;
    int item;
    //String test="";
    final ArrayList<String> arrayList = new ArrayList<String>();
    ArrayAdapter adapter;


    //onCreate함수
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, arrayList);


        //버튼 변수들 선언
        Button burgerBtn = (Button) findViewById(R.id.burger);
        Button drinkBtn = (Button) findViewById(R.id.drink);
        Button sideBtn = (Button) findViewById(R.id.side);
        Button dessertBtn = (Button)findViewById(R.id.dessert);

        Button cancelBtn = (Button)findViewById(R.id.cancelBtn);
        Button OKBtn = (Button)findViewById(R.id.OKBtn);
        Button menuCancel = (Button)findViewById(R.id.menuCancel);

        //인텐트 변수들 선언
        Intent intent = getIntent();
        //String selMenu = intent.getStringExtra("selmenu");
        String ordertype = intent.getStringExtra("orderType");

        //리스트뷰 선언
        ListView shoppingList = (ListView)findViewById(R.id.shoppingList);

        // 햄버거 버튼 선언
        ImageButton BurgerImgBtn[] = new ImageButton[9];
        Integer BurgerImgId[] = {R.id.burger1,R.id.burger2,R.id.burger3,R.id.burger4,R.id.burger5,R.id.burger6,R.id.burger7,R.id.burger8,R.id.burger9};
        final String BurgerName[] ={"빅맥","상하이","슈슈버거","맥치킨","베토디","불고기","쿼터파운더치즈","치즈","리치 포테이토"};

        //버거별로 클릭시 이벤트
        for(int i =0; i<BurgerImgId.length;i++){
            final int index;
            index =i;
            BurgerImgBtn[index] = (ImageButton) findViewById(BurgerImgId[index]);
            BurgerImgBtn[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(),BurgerName[index],Toast.LENGTH_SHORT).show();
                    Intent intent2 = new Intent(getApplicationContext(),Dialog.class);
                    intent2.putExtra("itemName",BurgerName[index]);
                    startActivityForResult(intent2,selectedMenu);
                }
            });
        }

        // 음료 버튼 선언
        ImageButton DrinkImgBtn[] = new ImageButton[3];
        Integer DrinkImgId[] = {R.id.drink1,R.id.drink2,R.id.drink3};
        final String DrinkName[] ={"콜라","사이다","환타"};

        //음료별로 클릭시 이벤트
        for(int i =0; i<DrinkImgId.length;i++){
            final int index;
            index =i;
            DrinkImgBtn[index] = (ImageButton) findViewById(DrinkImgId[index]);
            DrinkImgBtn[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(),DrinkName[index],Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),Dialog2.class);
                    intent.putExtra("DrinkName",DrinkName[index]);
                    startActivityForResult(intent,selectedMenu);
                }
            });
        }

        // 사이드 버튼 선언
        ImageButton SideImgBtn[] = new ImageButton[6];
        Integer SideImgId[] = {R.id.side1,R.id.side2,R.id.side3,R.id.side4,R.id.side5,R.id.side6};
        final String SideName[] ={"치킨 스낵랩","비프 스낵랩","맥너겟","치킨 텐더","치즈 스틱","애플 파이"};

        //사이드별로 클릭시 이벤트
        for(int i =0; i<SideImgId.length;i++){
            final int index;
            index =i;
            SideImgBtn[index] = (ImageButton) findViewById(SideImgId[index]);
            SideImgBtn[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(),SideName[index],Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),Dialog3.class);
                    intent.putExtra("SideName",SideName[index]);
                    startActivityForResult(intent,selectedMenu);
                }
            });
        }

        // 디저트 버튼 선언
        ImageButton DessertImgBtn[] = new ImageButton[3];
        Integer DessertImgId[] = {R.id.dessert1,R.id.dessert2,R.id.dessert3};
        final String DessertName[] ={"아이스크림 콘","선데이 아이스크림","오레오 맥플러리"};

        //디저트별로 클릭시 이벤트
        for(int i =0; i<DessertImgId.length;i++){
            final int index;
            index =i;
            DessertImgBtn[index] = (ImageButton) findViewById(DessertImgId[index]);
            DessertImgBtn[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(),DessertName[index],Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),Dioalog4.class);
                    intent.putExtra("DessertName",DessertName[index]);
                    startActivityForResult(intent,selectedMenu);
                }
            });
        }



        //카테고리 버거-메뉴 선택버튼
        burgerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //메뉴 레이아웃 초기화
                clearMenu();
                //버거메뉴 출력
                TableLayout burgerMenu = (TableLayout)findViewById(R.id.burgermenu);
                burgerMenu.setVisibility(View.VISIBLE);
            }
        });

        //카테고리 음료-메뉴 선택버튼
        drinkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //메뉴 레이아웃 초기화
                clearMenu();
                //음료 메뉴 출력
                TableLayout drink = (TableLayout)findViewById(R.id.drinkmenu);
                drink.setVisibility(View.VISIBLE);
            }
        });

        //카테고리 사이드-메뉴 선택버튼
        sideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //메뉴 레이아웃 초기화
                clearMenu();
                //음료 메뉴 출력
                TableLayout side = (TableLayout)findViewById(R.id.sidemenu);
                side.setVisibility(View.VISIBLE);
            }
        });

        //카테고리 디저트-메뉴 선택버튼
        dessertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //메뉴 레이아웃 초기화
                clearMenu();
                //음료 메뉴 출력
                TableLayout dessert = (TableLayout)findViewById(R.id.dessertmenu);
                dessert.setVisibility(View.VISIBLE);
            }
        });


        //구매 버튼 클릭시
        OKBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(getApplicationContext(),String.valueOf(arrayList),Toast.LENGTH_SHORT).show();
                if(String.valueOf(arrayList) != "[]"){
                Intent intent = new Intent(getApplicationContext(),result_page.class);
                intent.putExtra("shoppingList", String.valueOf(arrayList));
                intent.putExtra("orderType",ordertype);
                startActivity(intent);
                }
                else
                    Toast.makeText(getApplicationContext(),"상품을 선택해 주세요",Toast.LENGTH_SHORT).show();
            }
        });

        //취소 버튼 클릭시
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),startpage.class);
                startActivity(intent);
            }
        });

        //장바구니 클릭시
        shoppingList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               checked = shoppingList.getCheckedItemPosition();
               item = i;
               //Log.d("클릭",String.valueOf(checked));
               //Log.d("아이템",String.valueOf(item));
            }
        });

        //주문 취소버튼
        menuCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checked == item){
                    arrayList.remove(item);
                    adapter.notifyDataSetChanged();
                    checked = 1;
                }
            }
        });
    }
    //oncreate끝


    //메뉴 선택시 응답 함수
    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == selectedMenu) {
            if (resultCode == RESULT_OK) {
                String selmenu = intent.getStringExtra("selmenu");
                String itemName = intent.getStringExtra("itemName");
                //String DrinkName = intent.getStringExtra("DrinkName");
                ListView shoppingList = (ListView)findViewById(R.id.shoppingList);
                shoppingList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
                shoppingList.setAdapter(adapter);
                //test += BurgerName + selmenu +"+";
                arrayList.add(itemName + selmenu);
                adapter.notifyDataSetChanged();
            }
        }
    }

    //메뉴 초기화 함수
    public void clearMenu(){
        TableLayout burgerMenu = (TableLayout)findViewById(R.id.burgermenu);
        TableLayout drinkMenu = (TableLayout)findViewById(R.id.drinkmenu);
        TableLayout sideMenu = (TableLayout)findViewById(R.id.sidemenu);
        TableLayout dessertMenu = (TableLayout)findViewById(R.id.dessertmenu);

        burgerMenu.setVisibility(View.GONE);
        drinkMenu.setVisibility(View.GONE);
        sideMenu.setVisibility(View.GONE);
        dessertMenu.setVisibility(View.GONE);
    }


}

