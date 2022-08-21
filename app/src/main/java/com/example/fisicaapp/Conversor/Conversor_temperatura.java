package com.example.fisicaapp.Conversor;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fisicaapp.R;
import com.example.fisicaapp.Search.FurnitureAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Conversor_temperatura extends AppCompatActivity {

    SearchView searchView;
    Toolbar toolbarHome;
    RecyclerView recyclerHome;
    List<Integer> imageList = new ArrayList<>();
    List<String> titleList = new ArrayList<>();
    List<String> priceList = new ArrayList<>();

    List<HashMap<String,Object>> furnitureList = new ArrayList<>();
    FurnitureAdapter furnitureAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor_temperatura);

        initialize();

        searchView = findViewById(R.id.actionSearch);
        recyclerHome.setVisibility(View.INVISIBLE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (s.isEmpty()) {
                    recyclerHome.setVisibility(View.INVISIBLE);
                } else {
                    recyclerHome.setVisibility(View.VISIBLE);
                }

                furnitureAdapter.getFilter().filter(s);
                return false;
            }
        });
    }

    private void initialize() {

        recyclerHome = findViewById(R.id.resultBusca);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerHome.setLayoutManager(layoutManager);

        imageList.add(R.drawable.icon_mru);
        imageList.add(R.drawable.icon_mruv);
        imageList.add(R.drawable.ic_cronometro);
        imageList.add(R.drawable.icon_pendulo2);
        imageList.add(R.drawable.ic_dinamica);
        imageList.add(R.drawable.ic_torricelii);

        titleList.add("MRU");
        titleList.add("MRUV");
        titleList.add("Cronometro");
        titleList.add("Pendulo Simples");
        titleList.add("Dinâmica");
        titleList.add("Torricelli");

        priceList.add("$200");
        priceList.add("$100");
        priceList.add("$15");
        priceList.add("$120");
        priceList.add("$400");
        priceList.add("$80");

        for(int i=0;i<imageList.size();i++){

            HashMap<String,Object> map = new HashMap<>();
            map.put("Image",imageList.get(i));
            map.put("Title",titleList.get(i));
            //map.put("Price",priceList.get(i));

            furnitureList.add(map);
        }

        furnitureAdapter = new FurnitureAdapter(furnitureList);
        recyclerHome.setAdapter(furnitureAdapter);

        if (furnitureList.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(this, "Nada encontrado...", Toast.LENGTH_SHORT).show();
            recyclerHome.setVisibility(View.INVISIBLE);
        }
        }



    }

