package com.timtam.cyater.fragment


import android.os.Bundle
import android.os.Handler
import android.view.*
import androidx.fragment.app.Fragment
import com.timtam.cyater.PassVariables

import com.timtam.cyater.R
import com.timtam.cyater.Toast
import com.timtam.cyater.adapter.CurrencyAdapterFrom
import com.timtam.cyater.adapter.CurrencyAdapterTo
import com.timtam.cyater.helper.CustomListViewDialog
import com.timtam.cyater.data.model.Country
import kotlinx.android.synthetic.main.fragment_converter.*
import kotlinx.android.synthetic.main.fragment_converter.view.*

/**
 * A simple [Fragment] subclass.
 */
class ConverterFragment : Fragment(), CurrencyAdapterFrom.RecyclerViewItemClickListener,
CurrencyAdapterTo.RecyclerViewItemClickListener {

    private var fromValue: String? = null
    private var toValue: String? = null
    private var mCustomDialog: CustomListViewDialog? = null
    private var dataCountry: ArrayList<Country> = arrayListOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        refreshLayoutConverter.setOnRefreshListener {
            Handler().postDelayed({
                refreshLayoutConverter.isRefreshing = false
            }, 1500)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_converter, container, false)

        view.spinnerFromConv.setOnClickListener {
            fromFieldAction()
        }

        view.spinnerToConv.setOnClickListener {
            toFieldAction()
        }

        view.btnSwapConvertion.setOnClickListener {
            swaper()
        }

        view.btnConvert.setOnClickListener {
            PassVariables.test = "Wadidaww"
        }

        return view
    }

    override fun itemFromClicked(country: Country) {
        tvSelectedFromConv.text = country.id
        country.currencyName.Toast(context!!)

        if (mCustomDialog != null) {
            mCustomDialog!!.dismiss()
        }
    }

    override fun itemToClicked(country: Country) {
        tvSelectedToConv.text = country.id
        country.currencyName.Toast(context!!)

        if (mCustomDialog != null) {
            mCustomDialog!!.dismiss()
        }
    }

    fun fromFieldAction() {
        dataCountry.clear()
        val currArr = resources.getStringArray(R.array.testFrom)
        for (i in currArr.indices) {
            val items = Country(
                currencyName = "uuu",
                currencySymbol = "$",
                id = currArr[i]
            )
            dataCountry.add(items)
        }
        val dataAdapter = CurrencyAdapterFrom(dataCountry, this)
        mCustomDialog = CustomListViewDialog(activity!!, dataAdapter)
        mCustomDialog!!.show()
        mCustomDialog!!.setCanceledOnTouchOutside(true)
    }

    fun toFieldAction() {
        dataCountry.clear()
        val currArr = resources.getStringArray(R.array.testFrom)
        for (i in currArr.indices) {
            val items = Country(
                currencyName = "d",
                currencySymbol = "$",
                id = currArr[i]
            )
            dataCountry.add(items)
        }
        val dataAdapter = CurrencyAdapterTo(dataCountry, this)
        mCustomDialog = CustomListViewDialog(activity!!, dataAdapter)
        mCustomDialog!!.show()
        mCustomDialog!!.setCanceledOnTouchOutside(true)
    }

    private fun swaper() {
        fromValue = tvSelectedFromConv.text.toString()
        toValue = tvSelectedToConv.text.toString()

        val temp = fromValue
        fromValue = toValue
        toValue = temp

        tvSelectedFromConv.text = fromValue
        tvSelectedToConv.text = toValue
    }

    companion object {
        fun newInstance(): ConverterFragment {
            val fragment = ConverterFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}
