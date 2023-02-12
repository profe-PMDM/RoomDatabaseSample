package es.davidcorcuera.roomdatabasesample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.davidcorcuera.roomdatabasesample.R
import es.davidcorcuera.roomdatabasesample.model.User

class UserAdapter(): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var mUsers: List<User> = listOf()

    class UserViewHolder(val row: View): RecyclerView.ViewHolder(row) {
        val name: TextView = row.findViewById(R.id.name)
        val surname: TextView = row.findViewById(R.id.surname)
        val age: TextView = row.findViewById(R.id.age)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layout = LayoutInflater
            .from(parent.context).
            inflate(R.layout.item_list, parent, false)
        return UserViewHolder(layout)
    }

    override fun getItemCount() = mUsers.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = mUsers[position]
        holder.name.text = user.name
        holder.surname.text = user.lastName
        holder.age.text = user.age.toString()
    }

    fun setData(data: List<User>){
        mUsers = data
        notifyDataSetChanged()
    }
}

