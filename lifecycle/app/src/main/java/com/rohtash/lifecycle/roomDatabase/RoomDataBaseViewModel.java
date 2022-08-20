package com.rohtash.lifecycle.roomDatabase;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class RoomDataBaseViewModel extends AndroidViewModel {

    String TAG=this.getClass().getSimpleName();
    NoteDao noteDao;
    NoteRoomDatabase noteDB;
    LiveData<List<Note>> mAllNotes;


    public RoomDataBaseViewModel(@NonNull Application application) {
        super(application);
        noteDB=NoteRoomDatabase.getRoomDatabase(application);
        noteDao=noteDB.noteDao();
        mAllNotes=noteDao.getAllNotes();
    }

    public void insert(Note note){
        new InsertAsynTask(noteDao).execute(note);
    }

    public LiveData<List<Note>> getAllNotes(){
        return mAllNotes;
    }

    public void deleteNote(Note note){
        new DeleteAsynTask(noteDao).execute(note);
    }

    private class DeleteAsynTask extends AsyncTask<Note,Void,Void>{
        NoteDao mNoteDao;
        public DeleteAsynTask(NoteDao mNoteDao){
            this.mNoteDao=mNoteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            mNoteDao.deleteNote(notes[0]);
            return null;
        }
    }

    private class InsertAsynTask extends AsyncTask<Note,Void,Void>{
        NoteDao mNoteDao;
        public InsertAsynTask(NoteDao mNoteDao){
            this.mNoteDao=mNoteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            mNoteDao.insert(notes[0]);
            return null;
        }
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG," ViewModel Cleared");
    }


}
