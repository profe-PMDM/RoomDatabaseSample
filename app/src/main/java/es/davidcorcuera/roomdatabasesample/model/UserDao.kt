package es.davidcorcuera.roomdatabasesample.model

import androidx.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(vararg user: User)

    @Delete
    fun deleteUser(user: User)

    @Update
    fun updateUser(user: User)

    @Query("SELECT * FROM users")
    fun getAllUsers(): List<User>

    @Query("DELETE FROM users")
    fun deleteAllUsers()

    @Query("SELECT * FROM users WHERE first_name = :name")
    fun getUserByName(name: String): List<User>

    @Query("SELECT * FROM users WHERE age = :age")
    fun getUsersByAge(age: Int): List<User>

    @Query("SELECT * FROM users ORDER BY age ASC")
    fun getAllUserOrderedByAge(): List<User>


}