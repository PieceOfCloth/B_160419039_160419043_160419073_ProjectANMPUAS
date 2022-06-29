package com.example.b_160419073_projectuts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.b_160419073_projectuts.R
import com.example.b_160419073_projectuts.loadImage
import com.example.b_160419073_projectuts.viewmodel.DetilVM
import kotlinx.android.synthetic.main.fragment_detail_kos.*

class DetailKosFragment : Fragment() {

    private lateinit var viewModel: DetilVM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_kos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var id = ""
        if(arguments != null){
            id = DetailKosFragmentArgs.fromBundle(requireArguments()).kosId
        }

        viewModel = ViewModelProvider(this).get(DetilVM::class.java)

        viewModel.detail(id.toInt())

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.detailLD.observe(viewLifecycleOwner, Observer {
            txtNama.setText(it.nama_kos)
            txtDeskripsi.setText(it.deskripsi)
            txtTelp.setText(it.phone_number)
            txtAlamat2.setText(it.alamat)
            txtHarga.setText(it.range_harga)
            imageView2.loadImage(it.photoUrl.toString(), progressBar2)
        })
    }
}