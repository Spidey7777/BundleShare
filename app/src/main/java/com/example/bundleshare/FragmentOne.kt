package com.example.bundleshare

import android.content.Context
import android.os.Bundle
import android.os.Parcel
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.bundleshare.databinding.FragmentOneBinding
import com.squareup.moshi.Moshi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException
class FragmentOne : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val binding: FragmentOneBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_one, container, false)

        val fragmentTwo = FragmentTwo()

        val recordsList = ArrayList<Records>()


        if (savedInstanceState?.getInt("lol") == null) {
            val jsonFileString =
                MainActivity().getJsonDataFromAsset(this.requireContext(), "Aug_16.json")!!


            val jsonObject = JSONObject(jsonFileString)
            val records: JSONArray = jsonObject.getJSONArray("records")
            recordsList.clear()

            for (i in 0 until records.length()) {
                val item = records.getJSONObject(i)
//            val polyline = item.getString("record_id")
//            Log.i("lol", "id: $polyline")

                recordsList.add(
                    Records(
                        item.getString("record_id"),
                        item.getString("precise_polyline")
                    )
                )
            }
        }

        savedInstanceState?.putInt("lol", 1)

        binding.switchButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putParcelableArrayList("key", recordsList)
            Log.i("lol", "put done")
            fragmentTwo.arguments = bundle
            Log.i("lol", "bundle assigned")

            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_holder, fragmentTwo)
                Log.i("lol", "1")
                commit()
                Log.i("lol", "2")
            }
        }
        return binding.root
    }

//    fun getBundleSizeInBytes(bundle : Bundle) : Int {
//        val parcel = Parcel.obtain()
//        parcel.writeValue(bundle)
//
//        val bytes = parcel.marshall()
//        parcel.recycle()
//
//        return bytes.size
//    }
}