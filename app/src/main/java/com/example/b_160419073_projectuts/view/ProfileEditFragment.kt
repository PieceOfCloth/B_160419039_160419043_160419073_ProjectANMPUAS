package com.example.b_160419073_projectuts.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.b_160419073_projectuts.R
import com.example.b_160419073_projectuts.model.User
import com.example.b_160419073_projectuts.viewmodel.UserVM
import kotlinx.android.synthetic.main.fragment_profile_edit.*

class ProfileEditFragment : Fragment() {

    private lateinit var userModel: UserVM
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userModel = ViewModelProvider(this).get(UserVM::class.java)
        var user = User("Dendi", "Laki-laki", "0850555")
        //userModel.insertUser(user)
        userModel.refresh(1)
        observeViewModel()

        btnSubmitProfile.setOnClickListener{
            var name = txtInputEditName.text
            var gender = txtInputEditGender.text
            var hp = txtInputEditHP.text
            userModel.editUser(1, name.toString(), gender.toString(), hp.toString())
            Toast.makeText(view.context, "Profile berhasil diubah", Toast.LENGTH_LONG).show()
            Navigation.findNavController(it).popBackStack()
        }
    }

    fun observeViewModel() {
        userModel.userLD.observe(viewLifecycleOwner, Observer {
            txtInputEditName.setText(it.nama)
            txtInputEditGender.setText(it.kelamin)
            txtInputEditHP.setText(it.noHP)
            Log.d("ROOM", it.toString())
        })
    }
}