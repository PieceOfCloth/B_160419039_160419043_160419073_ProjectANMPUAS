package com.example.b_160419073_projectuts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.b_160419073_projectuts.R
import com.example.b_160419073_projectuts.viewmodel.ListVM
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var viewModel: ListVM
    private val listKosAdapter  = ListKosAdapter(arrayListOf())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnHelp.setOnClickListener {
            val action = HomeFragmentDirections.actionHelp()
            Navigation.findNavController(it).navigate(action)
        }

        btnCouponPromo.setOnClickListener {
            val action = HomeFragmentDirections.actionPromoCode()
            Navigation.findNavController(it).navigate(action)
        }

        viewModel = ViewModelProvider(this).get(ListVM::class.java)
        viewModel.refresh()

        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = listKosAdapter

        observeViewModel()
    }

    fun observeViewModel() {

        viewModel.kosLD.observe(viewLifecycleOwner, Observer {
            listKosAdapter.updateListKos(it)
        })

        viewModel.kosLoadErrorLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                txtError.visibility = View.VISIBLE
            } else {
                txtError.visibility = View.GONE
            }
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                recView.visibility = View.GONE
                progressLoad.visibility = View.VISIBLE
            } else {
                recView.visibility = View.VISIBLE
                progressLoad.visibility = View.GONE
            }
        })
    }
}