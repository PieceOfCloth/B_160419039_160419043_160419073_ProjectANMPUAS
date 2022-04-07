package com.example.b_160419073_projectuts.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.b_160419073_projectuts.R
import com.example.b_160419073_projectuts.loadImage
import com.example.b_160419073_projectuts.model.Kos
import kotlinx.android.synthetic.main.list_kos_item.view.*

class ListKosAdapter(val listKos:ArrayList<Kos>):RecyclerView.Adapter<ListKosAdapter.KosViewHolder>(){
    class KosViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KosViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_kos_item, parent, false)

        return KosViewHolder(view)
    }

    override fun onBindViewHolder(holder: KosViewHolder, position: Int) {
        holder.view.txtId.text = listKos[position].id
        holder.view.txtNamaKos.text = listKos[position].nama_kos
        holder.view.txtAlamat.text = listKos[position].alamat
        holder.view.txtRangeHarga.text = listKos[position].range_harga
        holder.view.imageView.loadImage(listKos[position].photoUrl, holder.view.progressBar)

        holder.view.btnDetail.setOnClickListener {
            val action = HomeFragmentDirections.actionDetailKos(holder.view.txtId.text.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return listKos.size
    }

    fun updateListKos(newListKos: List<Kos>) {
        listKos.clear()
        listKos.addAll(newListKos)
        notifyDataSetChanged()
    }

}