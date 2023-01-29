package es.davidcorcuera.roomdatabasesample.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import es.davidcorcuera.roomdatabasesample.R
import es.davidcorcuera.roomdatabasesample.databinding.FragmentListBinding
import es.davidcorcuera.roomdatabasesample.model.User
import es.davidcorcuera.roomdatabasesample.viewmodel.UserViewModel

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    // get or instantiate viewmodel (shared between activity and fragments)
    val userViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater)
        return binding.root}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val usersObserver = Observer<List<User>>{
            updateDisplayText(it)
        }
        userViewModel.mAllUsers.observe(viewLifecycleOwner, usersObserver)
        updateDisplayText(userViewModel.mAllUsers.value)

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
    }

    private fun updateDisplayText(users: List<User>?) {
        var displayText = ""
        if (users != null) {
            for (user in users) {
                displayText += "${user.name}  ${user.lastName} - ${user.age}\n\n"       }
        }
        binding.users.text = displayText
    }
}