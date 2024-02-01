package com.example.listatelefone.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.listatelefone.model.Contato
import java.net.IDN

@Dao
interface ContatoDAO {

    @Insert
    fun insert(contato:Contato):Long
    @Update
    fun update(contato:Contato):Int
    @Delete
    fun delete(contato:Contato):Int
    @Query("Select * FROM Contato")
    fun selectAll():List<Contato>
    @Query("Select * FROM Contato WHERE id=:id")
    fun select(id: Int): Contato
}