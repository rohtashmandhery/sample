package com.rohtash.lifecycle.roomDatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class},version = 1)
public abstract class NoteRoomDatabase extends RoomDatabase {

    public abstract NoteDao noteDao();

    // instance on database must be singleton
    public static volatile NoteRoomDatabase roomDatabase;

    public static NoteRoomDatabase getRoomDatabase(final Context context){
        if(roomDatabase==null){
            synchronized (NoteRoomDatabase.class){
                if(roomDatabase==null){

                    roomDatabase= Room.databaseBuilder(context.getApplicationContext(),
                            NoteRoomDatabase.class,"note_roomdatabase").build();
                }
            }
        }
        return roomDatabase;
    }
}