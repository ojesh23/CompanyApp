package com.kullabs.kullabsapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class PhysicsLessons extends Activity {

    Spinner spinner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physics_lessons);

        spinner1 = (Spinner) findViewById(R.id.spn1);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               /* if(position==0){
                    Intent nIntent=new Intent(PhysicsLessons.this,Notes.class);
                    startActivity(nIntent);
                }
                if(position==1){
                    Intent vIntent=new Intent(PhysicsLessons.this,Videos.class);
                    startActivity(vIntent);

                }*/
                Toast.makeText(getBaseContext(), spinner1.getSelectedItem().toString(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


}
