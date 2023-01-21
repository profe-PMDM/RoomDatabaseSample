package es.davidcorcuera.roomdatabasesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContentProviderCompat.requireContext
import es.davidcorcuera.roomdatabasesample.databinding.ActivityMainBinding
import es.davidcorcuera.roomdatabasesample.model.UserDao
import es.davidcorcuera.roomdatabasesample.model.UserDatabase

class MainActivity : AppCompatActivity() {

    lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set toolbar as ActionBar
        setSupportActionBar(binding.toolbar)

        // Get or create (if not created yet) DataBase instance and get its DAO
        userDao = UserDatabase.getInstance(applicationContext).userDao()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.action_delete -> {
                userDao.deleteAllUsers()
            }
        }
        return true
    }
}