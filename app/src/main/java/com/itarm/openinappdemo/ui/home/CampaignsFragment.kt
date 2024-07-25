package com.itarm.openinappdemo.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itarm.openinappdemo.R
import com.itarm.openinappdemo.databinding.FragmentCampaignsBinding

class CampaignsFragment : Fragment() {
    private lateinit var binding: FragmentCampaignsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCampaignsBinding.inflate(inflater, container, false)
        return binding.root
    }
}