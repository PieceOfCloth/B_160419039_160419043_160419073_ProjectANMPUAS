package com.example.b_160419073_projectuts.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.b_160419073_projectuts.R
import com.example.b_160419073_projectuts.model.Kos
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

        viewModel = ViewModelProvider(this).get(ListVM::class.java)
        viewModel.refresh()

        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = listKosAdapter

        btnHelp.setOnClickListener {
            val action = HomeFragmentDirections.actionHelp()
            Navigation.findNavController(it).navigate(action)
            var kos = Kos("https://cdn-2.tstatic.net/jabar/foto/bank/images/kos_20151013_063433.jpg", "widodo kos",
                "This enormous house has a fairytale-like look to it and is in average condition. The interior is done in colors that remind you of a coral reef. The yard is large and resembles a meadow. Also, rumor has it an old witch used to live here",
                "0811306171",
                "Jl. Tenggilis Mejoyo Blk. AN No.26",
                "IDR 1.000.000 - 1.350.000")
            var list = listOf(kos)
            viewModel.createData(list)
        }

        btnCouponPromo.setOnClickListener {
            val action = HomeFragmentDirections.actionPromoCode()
            Navigation.findNavController(it).navigate(action)
        }

        refreshLayout.setOnRefreshListener {
            recView.visibility = View.GONE
            txtError.visibility = View.GONE
            progressLoad.visibility = View.VISIBLE
            viewModel.refresh()
            refreshLayout.isRefreshing = false
        }

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.kosLD.observe(viewLifecycleOwner, Observer {
            //listKosAdapter.updateListKos(it)
            Log.d("data", it.toString())
            listKosAdapter.updateListKos(it)
            if(it.isEmpty()) {
                txtError.visibility = View.VISIBLE
            }else{
                txtError.visibility = View.GONE
            }
        })
/*
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
        })*/
    }
}