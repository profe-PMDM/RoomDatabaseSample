package es.davidcorcuera.roomdatabasesample.viewmodel

import android.app.Application
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.AndroidViewModel
import androidx.room.*
import es.davidcorcuera.roomdatabasesample.model.User
import es.davidcorcuera.roomdatabasesample.model.UserDao
import es.davidcorcuera.roomdatabasesample.model.UserDatabase

class UserViewModel(application: Application): AndroidViewModel(application) {
    private val database: UserDao = UserDatabase.getInstance(application).userDao()

    fun insertUser(user: User){
        database.insertUser(user)
    }

    fun deleteUser(user: User){
        database.deleteUser(user)
    }

    fun updateUser(user: User){
        database.updateUser(user)
    }

    fun getAllUsers(): List<User>{
        return database.getAllUsers()
    }

    fun deleteAllUsers(){
        database.deleteAllUsers()
    }

    fun getUserByName(name: String): List<User>{
        return database.getUserByName(name)
    }

    fun getUsersByAge(age: Int): List<User>{
        return database.getUsersByAge(age)
    }

    fun getAllUserOrderedByAge(): List<User>{
        return database.getAllUserOrderedByAge()
    }

}