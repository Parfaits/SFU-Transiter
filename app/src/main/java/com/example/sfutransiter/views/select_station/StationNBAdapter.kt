package com.example.sfutransiter.views.select_station

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sfutransiter.R
import com.example.sfutransiter.model.BusStop

class StationNBAdapter(myInterface: SelectStation.SelectStationInterface) : RecyclerView.Adapter<StationNBAdapter.ViewHolder>() {

    private val myStops = ArrayList<BusStop>()
    private var selectInterface = myInterface
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.station_near_item, parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val busItem = myStops.get(position)

        holder.stationName.text = busItem.name
        holder.stationDistance.text = busItem.distance.toString()

        holder.stationName.setOnClickListener {
            selectInterface.swapToBusSummary(busItem.stopNo.toString())
        }
    }

    override fun getItemCount(): Int {
        return myStops.size
    }

    fun replaceList(newArray: Array<BusStop>){
        myStops.clear()
        myStops.addAll(newArray)
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val stationName: TextView = itemView.findViewById(R.id.txtStationNB)
        val stationDistance: TextView = itemView.findViewById(R.id.txtDistance)
    }
}