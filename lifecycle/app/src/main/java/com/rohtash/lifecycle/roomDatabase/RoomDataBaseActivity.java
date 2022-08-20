package com.rohtash.lifecycle.roomDatabase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.rohtash.lifecycle.R;

import java.util.List;
import java.util.UUID;

public class RoomDataBaseActivity extends AppCompatActivity {
    RoomDataBaseViewModel viewModel;
    RecyclerView recyclerView;
    NotesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_data_base);
        init();
        viewModel= ViewModelProviders.of(this).get(RoomDataBaseViewModel.class);

        LiveData<List<Note>> liveData=viewModel.getAllNotes();
        liveData.observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                adapter=new NotesAdapter(RoomDataBaseActivity.this,notes);
                recyclerView.setAdapter(adapter);
            }
        });
    }

    private void init(){
        TextView addTV=findViewById(R.id.addTV);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        addTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RoomDataBaseActivity.this,NewNoteActivity.class);
                startActivityForResult(intent,100);
            }
        });
    }

    public void itemClick(Note note){
        viewModel.deleteNote(note);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100 && resultCode==RESULT_OK){
            String id= UUID.randomUUID().toString();
            String noteAdded=data.getStringExtra("note");
            Note note=new Note(id,noteAdded);
            viewModel.insert(note);

            Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Not Saved",Toast.LENGTH_SHORT).show();
        }
    }
}