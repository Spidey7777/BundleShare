package com.example.bundleshare

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.bundleshare.databinding.FragmentTwoBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FragmentTwo : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: FragmentTwoBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_two, container, false)

        val fragmentOne = FragmentOne()

        val bundle = this.arguments
        Log.i("lol", "bundle: $bundle")
        if (bundle != null) {
            binding.tv.text = bundle.get("key").toString()
        }

        binding.backButton.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_holder, fragmentOne)
                commit()
            }
        }

//        var bundle = Bundle()
//        GlobalScope.launch {
//            bundle = getArgs()
//            Log.i("lol", "bundle2: $bundle")
//        }
//
//        binding.tv.text = bundle.get("key").toString()
//        Log.i("lol", "bundle3: $bundle")
//
//        binding.backButton.setOnClickListener {
//            parentFragmentManager.beginTransaction().apply {
//                replace(R.id.fragment_holder, fragmentOne)
//                commit()
//            }
//        }
//
//        return binding.root
//    }
//
//    private suspend fun getArgs() : Bundle {
//        var bundle1: Bundle
//        withContext(Dispatchers.Default) {
//            bundle1 = this@FragmentTwo.requireArguments()
//            Log.i("lol", "bundle1: $bundle1")
//        }
//        return bundle1
//    }
        return binding.root
    }
}