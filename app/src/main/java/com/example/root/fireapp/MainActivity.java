package com.example.root.fireapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button sendata;
    private EditText editText;
    DatabaseReference ref,demoref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.evedittext) ;
        sendata = (Button)findViewById(R.id.btbutton);

        ref = FirebaseDatabase.getInstance().getReference();
         
        demoref = ref.child("demo");

        sendata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String value = editText.getText().toString();

                demoref.push().setValue(value);
            }
        });


    }
}
