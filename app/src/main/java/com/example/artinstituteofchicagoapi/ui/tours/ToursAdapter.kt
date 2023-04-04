package com.example.artinstituteofchicagoapi.ui.tours

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.artinstituteofchicagoapi.R
import com.example.artinstituteofchicagoapi.data.model.tours.DataModel
import com.example.artinstituteofchicagoapi.databinding.ItemToursBinding

class ToursAdapter(val tours: List<DataModel>?) :
    RecyclerView.Adapter<ToursAdapter.ViewHolder>() {

    var onItemClick: ((DataModel) -> Unit)? = null

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemToursBinding.bind(view)

        fun handleData(item: DataModel?) {
            binding.toursId.text = item?.id.toString()
            binding.toursTitle.text = item?.title.toString()
            binding.toursDescription.text = item?.description.toString()
        }

    }

    // Creates the ITEM/ROW for the UI
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToursAdapter.ViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_tours, parent, false)

        return ViewHolder(view)
    }

    // Size of the list
    override fun getItemCount(): Int = tours?.size ?: 0

    // Handle the CURRENT item you are on
    override fun onBindViewHolder(holder: ToursAdapter.ViewHolder, position: Int) {
        holder.handleData(tours?.get(position))
        holder.itemView.setOnClickListener {
            tours?.get(position)?.let {
                onItemClick?.invoke(it)
            }
        }
    }
}