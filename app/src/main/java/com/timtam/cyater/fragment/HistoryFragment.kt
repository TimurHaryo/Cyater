package com.timtam.cyater.fragment


import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.timtam.cyater.PassVariables

import com.timtam.cyater.R
import com.timtam.cyater.Toast
import com.timtam.cyater.adapter.CurrencyAdapterFrom
import com.timtam.cyater.adapter.CurrencyAdapterTo
import com.timtam.cyater.helper.CustomListViewDialog
import com.timtam.cyater.data.model.Country
import kotlinx.android.synthetic.main.fragment_history.*
import kotlinx.android.synthetic.main.fragment_history.view.*

/**
 * A simple [Fragment] subclass.
 */
class HistoryFragment : Fragment(), CurrencyAdapterFrom.RecyclerViewItemClickListener,
CurrencyAdapterTo.RecyclerViewItemClickListener{

    private var fromValueH: String? = null
    private var toValueH: String? = null
    private var mCustomDialogH: CustomListViewDialog? = null
    private var listCountry: ArrayList<Country> = arrayListOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        refreshLayoutHistory.setOnRefreshListener {
            Handler().postDelayed({
                refreshLayoutHistory.isRefreshing = false
            }, 1500)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_history, container, false)

        view.spinnerFromHist.setOnClickListener {
            fromSpinnerAction()
        }

        view.spinnerToHist.setOnClickListener {
            toSpinnerAction()
        }

        view.btnSwapHistory.setOnClickListener {
            switcher()
        }

        view.btnShowHistory.setOnClickListener {
            PassVariables.test.Toast(context!!)
        }

        return view
    }

    override fun itemFromClicked(country: Country) {
        tvSelectedFromHist.text = country.id

        if (mCustomDialogH != null) {
            mCustomDialogH!!.dismiss()
        }
    }

    override fun itemToClicked(country: Country) {
        tvSelectedToHist.text = country.id

        if (mCustomDialogH != null) {
            mCustomDialogH!!.dismiss()
        }
    }

    private fun fromSpinnerAction() {
        listCountry.clear()
        val data = resources.getStringArray(R.array.testFrom)
        for (i in data.indices) {
            val items = Country(
                currencyName = "d",
                currencySymbol = "$",
                id = data[i]
            )
            listCountry.add(items)
        }
        val dataAdapter = CurrencyAdapterFrom(listCountry, this)
        mCustomDialogH = CustomListViewDialog(activity!!, dataAdapter)
        mCustomDialogH!!.show()
        mCustomDialogH!!.setCanceledOnTouchOutside(true)
    }

    private fun toSpinnerAction() {
        listCountry.clear()
        val data = resources.getStringArray(R.array.testFrom)
        for (i in data.indices) {
            val items = Country(
                currencyName = "d",
                currencySymbol = "$",
                id = data[i]
            )
            listCountry.add(items)
        }
        val dataAdapter = CurrencyAdapterTo(listCountry, this)
        mCustomDialogH = CustomListViewDialog(activity!!, dataAdapter)
        mCustomDialogH!!.show()
        mCustomDialogH!!.setCanceledOnTouchOutside(true)
    }

    private fun switcher() {
        fromValueH = tvSelectedFromHist.text.toString()
        toValueH = tvSelectedToHist.text.toString()

        val temp = fromValueH
        fromValueH = toValueH
        toValueH = temp

        tvSelectedFromHist.text = fromValueH
        tvSelectedToHist.text = toValueH
    }

    companion object {
        fun newInstance(): HistoryFragment {
            val fragment = HistoryFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}
