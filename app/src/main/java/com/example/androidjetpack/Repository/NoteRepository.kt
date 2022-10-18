package com.example.androidjetpack.Repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.androidjetpack.Database.NoteDatabase
import com.example.androidjetpack.Model.Note
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class NoteRepository {
    companion object {
        private var noteRepository: NoteRepository? = null
        private var noteDatabase: NoteDatabase? = null

        private fun initialiseDB(context: Context): NoteDatabase? {
            return NoteDatabase.getInstance(context)
        }

        fun insert(context: Context, note: Note) {
            noteDatabase = initialiseDB(context)
            CoroutineScope(IO).launch {
                noteDatabase?.getDao()?.insert(note)
            }
        }

        fun getCardData(context: Context) : LiveData<List<Note>>? {
            noteDatabase = initialiseDB(context)
            return noteDatabase?.getDao()?.getCardsData()
        }

        fun update(context: Context, note: Note) {
            noteDatabase = initialiseDB(context)
            CoroutineScope(IO).launch {
                noteDatabase?.getDao()?.update(note)
            }
        }


        fun getInstance(): NoteRepository {
            if (noteRepository == null) {
                noteRepository = NoteRepository()
            }
            return noteRepository!!
        }

        fun search(context: Context, data: String): LiveData<List<Note>>?
        {
            noteDatabase = initialiseDB(context)
            return noteDatabase?.getDao()?.search(data)
        }

        fun delete(context: Context, note: Note)
        {
            noteDatabase = initialiseDB(context)
            CoroutineScope(IO).launch {
                noteDatabase?.getDao()?.delete(note)
            }
        }
    }
}