package com.omug.androidfinalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button calculate;
    Spinner spCountry;
    TextView totalamount, capital, discount, txtNumberOfvisit, txtSelectedPlace;
    ImageView imageCountry;
    ListView placesOfVisit;
    public static int index;

    List<Country> countries = new ArrayList<>();
    List<Places> places = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spCountry = findViewById(R.id.spCountries);
        totalamount = findViewById(R.id.txtTotalAmount);
        capital = findViewById(R.id.txtCapital);
        discount = findViewById(R.id.txtDiscountsApplied);
        imageCountry = findViewById(R.id.imageCountry);
        placesOfVisit = findViewById(R.id.lvPoi);
        calculate = findViewById(R.id.btnCalculate);
        txtNumberOfvisit = findViewById(R.id.txtNumberOfvisit);
        txtSelectedPlace = findViewById(R.id.txtSelectedPlace);

        fillCountries();

        ArrayAdapter adapterCountry = new ArrayAdapter(this,android.R.layout.simple_spinner_item,countries);
        adapterCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCountry.setAdapter(adapterCountry);
        spCountry.setOnItemSelectedListener(new SpinnersEvents());

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtNumberOfvisit.getText().toString().isEmpty()){
                    Toast.makeText(getBaseContext(),"Indicate number of visitors",Toast.LENGTH_LONG).show();
                }else if(txtSelectedPlace.getText().toString().isEmpty()){
                    Toast.makeText(getBaseContext(),"Select a Place to Visit",Toast.LENGTH_LONG).show();
                }else{
                    int qty = Integer.parseInt(txtNumberOfvisit.getText().toString());
                    totalamount.setText("Total Amount::  $"+ String.valueOf(calculateAmount(places.get(index).getAmount(), qty)));

                    if(qty>15){
                        discount.setText("Discounts Applied 5%");
                    }else{
                        discount.setText("");
                    }
                }
            }
        });

    }

    private double calculateAmount(double amount, int qty) {
        double total = 0;

        if (qty > 15){
            total = amount * qty - ((amount * qty) * 0.05);
        }else{
            total = amount * qty;
        }
        return total;
    }

    private void fillCountries() {
        countries.add(new Country("Canada", "Ottawa", placeOfInterest1(), R.mipmap.canada));
        countries.add(new Country("Venezuela", "Caracas", placeOfInterest2(), R.mipmap.venezuela));
        countries.add(new Country("USA", "Washington", placeOfInterest3(), R.mipmap.usa));
    }

    private List<Places> placeOfInterest1() {
        List<Places> placesCanada = new ArrayList<>();
        placesCanada.add(new Places("Niagara Falls", R.mipmap.canada, 100.0));
        placesCanada.add(new Places("CN Tower", R.mipmap.canada, 30.0));
        placesCanada.add(new Places("The Butchart Gardens", R.mipmap.canada, 30.0));
        placesCanada.add(new Places("Notre-Dame Basilica", R.mipmap.canada, 50.0));
        return placesCanada;
    }

    private List<Places> placeOfInterest2() {
        List<Places> placesVenezuela = new ArrayList<>();
        placesVenezuela.add(new Places("Mochima", R.mipmap.venezuela, 100.0));
        placesVenezuela.add(new Places("Gran Sabana", R.mipmap.venezuela, 500.0));
        placesVenezuela.add(new Places("Choroni", R.mipmap.venezuela, 60.0));
        placesVenezuela.add(new Places("Galipan", R.mipmap.venezuela, 30.0));
        return placesVenezuela;
    }

    private List<Places> placeOfInterest3() {
        List<Places> placesUsa = new ArrayList<>();
        placesUsa.add(new Places("The Statue of Liberty", R.mipmap.usa, 90.0));
        placesUsa.add(new Places("The White House", R.mipmap.usa, 60.0));
        placesUsa.add(new Places("Times Square", R.mipmap.usa, 75.0));
        return placesUsa;
    }


    private class SpinnersEvents implements android.widget.AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            txtSelectedPlace.setText("");
            places = countries.get(position).getPoi();
            capital.setText("Capital:  "+String.valueOf(countries.get(position).getCapital()));
            imageCountry.setImageResource(countries.get(position).getImgCountry());
            placesOfVisit.setAdapter(new PlacesAdapter(MainActivity.this, places));

            placesOfVisit.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    index=position;
                    txtSelectedPlace.setText("Selected Place: "+places.get(position).getPlace().toString());
                }
            });
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}