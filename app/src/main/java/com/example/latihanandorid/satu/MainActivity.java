package com.example.latihanandorid.satu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
        private RecyclerView rv_Hewan;
        private ArrayList<Hewan> list = new ArrayList<>();
        private String title = "Home";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBarTitle(title);

        rv_Hewan = findViewById(R.id.rv_hewan);
        rv_Hewan.setHasFixedSize(true);

        list.addAll(HewanData.getListData());
        showRecyclerList();

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

    private void showRecyclerList() {
        rv_Hewan.setLayoutManager(new GridLayoutManager(this, 5));
        ListHewanAdapter listHewanAdapter = new ListHewanAdapter(list);
        rv_Hewan.setAdapter(listHewanAdapter);
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