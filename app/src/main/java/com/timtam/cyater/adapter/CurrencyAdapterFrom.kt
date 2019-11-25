package com.timtam.cyater.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.timtam.cyater.R
import com.timtam.cyater.data.model.Country
import kotlinx.android.synthetic.main.spinner_custom_item.view.*

class CurrencyAdapterFrom(
    private val dataSet: ArrayList<Country>, internal var onViewItemClickListener:
    RecyclerViewItemClickListener
): RecyclerView.Adapter<CurrencyAdapterFrom.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.spinner_custom_item, parent, false)

        return CustomViewHolder(itemView)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val data = dataSet[position]
        holder.idText.text = data.id
        holder.symbolText.text = data.currencySymbol
    }


    inner class CustomViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {
        var idText: TextView
        var symbolText: TextView

        init {
            idText = view.tvSpinnerId
            symbolText = view.tvSpinnerSymbol
            view.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            onViewItemClickListener.itemFromClicked(dataSet[this.adapterPosition])
        }

    }

    interface RecyclerViewItemClickListener {
        fun itemFromClicked(country: Country)
    }
}