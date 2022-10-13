package com.example.androidjetpack

import android.content.Context
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.androidjetpack.NoteDatabase.Companion.instance
import io.reactivex.internal.operators.maybe.MaybeToPublisher.instance
import io.reactivex.internal.schedulers.TrampolineScheduler.instance
import io.reactivex.rxjava3.internal.util.ListAddBiConsumer.instance

@Database(entities = [Note::class], version =1)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object{
        private var instance: NoteDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): NoteDatabase{
            if (instance == null){

                instance = Room.databaseBuilder(ctx.applicationContext, NoteDatabase::class.java,
                    "note_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build()
            }
            return instance!!
        }
        private val roomCallback = object : RoomDatabase.Callback(){
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                populateDb(instance!!)
            }
        }

        private fun populateDb(instance: NoteDatabase) {
            val noteDao = instance.noteDao()
            noteDao.insert(Note("Title 1", "Description 1", 1))
            noteDao.insert(Note("Title 2", "Description 2", 2))
            noteDao.insert(Note("Title 3", "Description 3", 3))

        }
    }
}
