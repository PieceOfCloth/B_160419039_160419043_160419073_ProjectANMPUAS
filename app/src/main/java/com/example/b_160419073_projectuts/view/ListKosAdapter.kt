package com.example.b_160419073_projectuts.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.b_160419073_projectuts.R
import com.example.b_160419073_projectuts.model.Kos
import kotlinx.android.synthetic.main.list_kos_item.view.*

class ListKosAdapter(val listkos:ArrayList<Kos>):RecyclerView.Adapter<ListKosAdapter.KosViewHolder>(){
    class KosViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KosViewHolder {
        TODO("Not yet implemented")
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_kos_item, parent, false)

        return KosViewHolder(view)

    }

    override fun onBindViewHolder(holder: KosViewHolder, position: Int) {
        TODO("Not yet implemented")
        holder.view.txtNamaKos.text = listkos[position].nama_kos
        holder.view.txtAlamat.text = listkos[position].alamat
        holder.view.txtRangeHarga.text = listkos[position].range_harga

        holder.view.btnDetail.setOnClickListener {
            val action = HomeFragmentDirections.actionDetailKos()
            Navigation.findNavController(it).navigate(action)
        }


    }

    override fun getItemCount(): Int {
        return listkos.size
    }

    fun updateListKos(newListKos: List<Kos>) {
        listkos.clear()
        listkos.addAll(newListKos)
        notifyDataSetChanged()
    }

}