package com.mrkumar.hashgeneratorapp

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.mrkumar.hashgeneratorapp.databinding.FragmentHomeBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {

    private  var _binding:FragmentHomeBinding?=null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentHomeBinding.inflate(inflater,container,false)

        val hasAlgorithm=resources.getStringArray(R.array.hash_algorthim)
        val arrayAdapter=ArrayAdapter(requireContext(),R.layout.drop_down_item,hasAlgorithm)
        binding.edtInput.setAdapter(arrayAdapter)


        setHasOptionsMenu(true)

        binding.btnGenerate.setOnClickListener {
           lifecycleScope.launch {
               applyAnimation()
           }

        }
        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
            inflater.inflate(R.menu.home_menu,menu)

    }
    private suspend fun applyAnimation() {
        binding.tvHeader.animate().alpha(0f).duration=400L
        binding.btnGenerate.animate().alpha(0f).duration=400L
        binding.textInputLayout.animate()
            .alpha(0f).translationXBy(1200f)
            .duration=400L
        binding.editTextTextPersonName.animate()
            .alpha(0f)
            .translationXBy(-1200f)
            .duration=400L

        delay(300)

        binding.successBg.animate().alpha(1f).duration=600L
        binding.successBg.animate().rotationBy(720f).duration=600L
        binding.successBg.animate().scaleXBy(900f).duration=800L
        binding.successBg.animate().scaleYBy(900f).duration=800L

        delay(300)

        binding.ivSuccess.animate().alpha(1f).duration=1000L
        
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }


}