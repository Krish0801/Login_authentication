package com.example.artinstituteofchicagoapi.ui.events

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.artinstituteofchicagoapi.R
import com.example.artinstituteofchicagoapi.data.model.events.DataModel
import com.example.artinstituteofchicagoapi.databinding.ItemEventsBinding
import com.example.artinstituteofchicagoapi.ui.events.EventsAdapter

class EventsAdapter(val events: List<DataModel>?) :
    RecyclerView.Adapter<EventsAdapter.ViewHolder>() {

    var onItemClick: ((DataModel) -> Unit)? = null

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemEventsBinding.bind(view)

        fun handleData(item: DataModel?) {
            binding.eventsId.text = item?.id.toString()
            binding.eventsTitle.text = item?.title.toString()
            binding.eventsLocation.text = item?.location.toString()
        }

    }

    // Creates the ITEM/ROW for the UI
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsAdapter.ViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_events, parent, false)

        return ViewHolder(view)
    }

    // Size of the list
    override fun getItemCount(): Int = events?.size ?: 0

    // Handle the CURRENT item you are on
    override fun onBindViewHolder(holder: EventsAdapter.ViewHolder, position: Int) {
        holder.handleData(events?.get(position))
        holder.itemView.setOnClickListener {
            events?.get(position)?.let {
                onItemClick?.invoke(it)
            }
        }
    }
}