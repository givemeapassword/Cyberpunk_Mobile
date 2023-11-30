package com.example.rp_cyberpunk_list.list_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.rp_cyberpunk_list.R


class ConditionInjuriesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_condition_injuries, container, false)
    }
    companion object{
        @JvmStatic
        fun newInstance() = ConditionInjuriesFragment()
    }

}