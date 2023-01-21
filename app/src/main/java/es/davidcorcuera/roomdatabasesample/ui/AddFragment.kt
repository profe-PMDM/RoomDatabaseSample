package es.davidcorcuera.roomdatabasesample.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import es.davidcorcuera.roomdatabasesample.R
import es.davidcorcuera.roomdatabasesample.databinding.FragmentAddBinding
import es.davidcorcuera.roomdatabasesample.model.User
import es.davidcorcuera.roomdatabasesample.model.UserDao
import es.davidcorcuera.roomdatabasesample.model.UserDatabase

class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    lateinit var userDao: UserDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get or create (if not created yet) DataBase instance and get its DAO
        userDao = UserDatabase.getInstance(requireContext()).userDao()

        // Set Listener on button to add a new User
        binding.button.setOnClickListener {
            addUser()
        }

    }

    private fun addUser() {

        if (allFieldsFilled()) {
            // Instantiate new User from View Inputs
            val newUser: User = User(
                binding.name.text.toString(),
                binding.surname.text.toString(),
                binding.age.text.toString().toInt()
            )
            // Insert User into Database
            userDao.insertUser(newUser)

            // Clear View Inputs
            binding.name.setText("")
            binding.surname.setText("")
            binding.age.setText("")
        } else {
            Toast.makeText(requireContext(), "Please, Fill all fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun allFieldsFilled(): Boolean =
        !(binding.name.text.isNullOrBlank() || binding.surname.text.isNullOrBlank() || binding.age.text.isNullOrBlank())
}