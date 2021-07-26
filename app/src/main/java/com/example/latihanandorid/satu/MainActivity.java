package com.example.latihanandorid.satu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

        private String title = "Home";
    CardView[][] penampung = new CardView[6][6];

    ImageButton btn_bawah, btn_atas, btn_kiri,btn_kanan;

    int x=0;
    int y=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBarTitle(title);

        btn_atas = (ImageButton) findViewById(R.id.btnAtas);
        btn_bawah = (ImageButton) findViewById(R.id.btnBawah);
        btn_kiri = (ImageButton) findViewById(R.id.btnKiri);
        btn_kanan =(ImageButton) findViewById(R.id.btnKanan);


        for (int i = 0 ; i<6;i++){
            for (int j=0;j<6;j++){
                String temp = "card"+i+j;
                penampung[i][j] = findViewById(getResources().getIdentifier(temp,"id",getPackageName()));
            }
        }

        //SET PLAYER
        penampung[0][0].setCardBackgroundColor(Color.BLACK);

        btn_bawah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((y < 5)&&(y >= 0)){
                    y=y+1;
                }

                if(penampung[y][x].getCardBackgroundColor().getDefaultColor() == -16777216){

                    penampung[y][x].setCardBackgroundColor(Color.WHITE);
                }else{
                    penampung[y][x].setCardBackgroundColor(Color.BLACK);

                }

            }
        });


        btn_kanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((x<5)&&(y>=0)){
                    x+=1;
                }
                if(penampung[y][x].getCardBackgroundColor().getDefaultColor() == -16777216){

                    penampung[y][x].setCardBackgroundColor(Color.WHITE);
                }else{
                    penampung[y][x].setCardBackgroundColor(Color.BLACK);

                }
            }
        });

        btn_atas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((y<=5)&&(y>0)){
                    y-=1;
                }
                if(penampung[y][x].getCardBackgroundColor().getDefaultColor() == -16777216){

                    penampung[y][x].setCardBackgroundColor(Color.WHITE);
                }else{
                    penampung[y][x].setCardBackgroundColor(Color.BLACK);

                }

            }
        });

        btn_kiri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((x<=5)&&(x>0)){
                    x-=1;
                }

                if(penampung[y][x].getCardBackgroundColor().getDefaultColor() == -16777216){

                    penampung[y][x].setCardBackgroundColor(Color.WHITE);
                }else{
                    penampung[y][x].setCardBackgroundColor(Color.BLACK);

                }
            }
        });

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.optionmenu, menu);
        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }



   public void setMode(int selectedMode){
        switch (selectedMode){
            case R.id.miCompose:
                title = "About";
            Intent iAbout = new Intent(this.getApplication(), About.class);
            startActivity(iAbout);
            break;
        }
   }
    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }


}