package com.example.uefa

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.uefa.databinding.FragmentJogosBinding


class JogosFragment : Fragment() {

    private var  binding:FragmentJogosBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentJogosBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        val fragmentsList = listOf(SerieaFragment(), SeriebFragment(),SeriecFragment())
        val fragmentsTitleList = listOf("série A", "série B", "série C")



        activity?.let {
            val viewPagerAdapter = ViewPagerAdapter(
                fragmentManager = it.supportFragmentManager,
                fragmentsList = fragmentsList,
                fragmentsTitleList = fragmentsTitleList

            )

            binding?.let {
                with(it){
                    vpJogoTabs.adapter = viewPagerAdapter
                    tlJogoTabs.setupWithViewPager(vpJogoTabs)

                }
            }
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}