package com.example.bundleshare

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.bundleshare.databinding.FragmentOneBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FragmentOne : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val binding: FragmentOneBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_one, container, false)

        val PolylineList = arrayListOf<PolylineModel>()

        val fragmentTwo = FragmentTwo()

        val ss = "a".repeat(10000)

        binding.switchButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("key", ss)
            fragmentTwo.arguments = bundle
            Log.i("lol", "bundle send: $bundle")

            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_holder, fragmentTwo)
                commit()
            }
        }


//        binding.switchButton.setOnClickListener {
//
//            val ss = "a".repeat(100000)
//
//            GlobalScope.launch {
//                putTask("key", ss, fragmentTwo)
//            }
//
//            parentFragmentManager.beginTransaction().apply {
//                replace(R.id.fragment_holder, fragmentTwo)
//                commit()
//            }
//        }
//        return binding.root
//    }
//
//    private suspend fun putTask(key: String, value: String, fragment: Fragment) {
//        withContext(Dispatchers.Default){
//            val bundle = Bundle()
//            bundle.putString(key, value)
////            Log.i("lol", "bundle: $bundle")
//            fragment.arguments = bundle
//        }

        return binding.root
    }
}