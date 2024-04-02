package com.example.seethepet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox start;
        TextView favoritepet;
        RadioGroup petgroup;
        ImageView pet;
        int[] dogimg = {R.drawable.dog1,R.drawable.dog2,R.drawable.dog3};
        ImageButton left, right;

        start = (CheckBox) findViewById(R.id.stachb1);
        favoritepet = (TextView) findViewById(R.id.favpet);
        petgroup = (RadioGroup) findViewById(R.id.petgrp);
        pet = (ImageView) findViewById(R.id.petimg);
        left = (ImageButton) findViewById(R.id.lefimg);
        right = (ImageButton) findViewById(R.id.ritimg);

        start.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    favoritepet.setVisibility(TextView.VISIBLE);
                    petgroup.setVisibility(RadioGroup.VISIBLE);
                }
                else{
                    favoritepet.setVisibility(TextView.INVISIBLE);
                    petgroup.setVisibility(RadioGroup.INVISIBLE);
                    pet.setVisibility(ImageView.INVISIBLE);
                    left.setVisibility(ImageButton.INVISIBLE);
                    right.setVisibility(ImageButton.INVISIBLE);
                }
            }
        });

        petgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkId) {

                if (checkId == R.id.dograb){
                    left.setVisibility(ImageButton.VISIBLE);
                    right.setVisibility(ImageButton.VISIBLE);
                    pet.setImageResource(dogimg[i]);
                    left.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            i--;
                            if(i < 0)
                                i = 2;
                            pet.setImageResource(dogimg[i]);
                        }
                    });

                    right.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            i++;
                            if(i > 2)
                                i = 0;
                            pet.setImageResource(dogimg[i]);
                        }
                    });
                }
                else if (checkId == R.id.catrab) {
                    left.setVisibility(ImageButton.INVISIBLE);
                    right.setVisibility(ImageButton.INVISIBLE);
                    pet.setImageResource(R.drawable.cat);
                }
                else if (checkId == R.id.rabrab) {
                    left.setVisibility(ImageButton.INVISIBLE);
                    right.setVisibility(ImageButton.INVISIBLE);
                    pet.setImageResource(R.drawable.rabbit);
                }
                pet.setVisibility(ImageView.VISIBLE);
            }
        });

    }

}