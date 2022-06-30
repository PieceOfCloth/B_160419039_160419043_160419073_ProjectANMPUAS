package com.example.b_160419073_projectuts.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.b_160419073_projectuts.R
import com.example.b_160419073_projectuts.model.User
import com.example.b_160419073_projectuts.viewmodel.UserVM
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {
    private lateinit var userModel: UserVM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userModel = ViewModelProvider(this).get(UserVM::class.java)
        var user = User("Dendi", "Laki-laki", "0850555")
        //userModel.insertUser(user)
        //userModel.refresh(1)
        observeViewModel()

        btnEditProfile.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileEdit()
            Navigation.findNavController(it).navigate(action)
            var user = User("Dendi", "Laki-laki", "0850555")
            var list = listOf(user)
            userModel.createData(list)
        }
    }

    fun observeViewModel() {
        userModel.userLD.observe(viewLifecycleOwner, Observer {
            txtInputName.setText(it.nama)
            txtInputGender.setText(it.kelamin)
            txtInputHp.setText(it.noHP)
            Log.d("ROOM", it.toString())
        })
    }
}