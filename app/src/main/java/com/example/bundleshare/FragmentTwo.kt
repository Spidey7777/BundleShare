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

        var s = ""
        val bundle = this.arguments
        if (bundle != null) {

            val ss = bundle.getParcelableArrayList<Records>("key")
            ss?.forEach {
                s += it.record_id
            }

            binding.tv.text = s
        }

        binding.backButton.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_holder, fragmentOne)
                commit()
            }
        }

        return binding.root
    }
}