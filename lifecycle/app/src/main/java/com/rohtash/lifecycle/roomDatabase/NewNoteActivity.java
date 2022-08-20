package com.rohtash.lifecycle.roomDatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.rohtash.lifecycle.R;

public class NewNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);
        init();
    }

    private void init(){
        final EditText noteET=findViewById(R.id.noteET);


        TextView saveTV=findViewById(R.id.saveTV);

        saveTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent=new Intent();
                if(noteET.getText().toString().isEmpty()){
                    setResult(RESULT_CANCELED,resultIntent);
                }else{
                    resultIntent.putExtra("note",noteET.getText().toString());
                    setResult(RESULT_OK,resultIntent);
                }
                finish();
            }
        });

    }
}