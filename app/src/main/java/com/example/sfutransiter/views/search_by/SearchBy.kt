package com.example.sfutransiter.views.search_by

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.sfutransiter.databinding.FragmentSearchByBinding
import com.example.sfutransiter.views.MainFragment


class SearchBy : Fragment() {
    private var _binding: FragmentSearchByBinding? = null
    private val binding get() = _binding!!

    private lateinit var searchByFragmentInterface: SearchByFragmentInterface

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SearchByFragmentInterface)
            searchByFragmentInterface = context
        else Log.e(
            MainFragment.TAG,
            "onAttach: MainActivity must implement SearchByFragmentInterface"
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchByBinding.inflate(inflater, container, false)

        searchBar(binding.searchView)
        setupButtons()

        return binding.root
    }

    private fun searchBar(searchView : SearchView) {
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByFragmentInterface.swapToBusSummary(searchView.query.toString())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }


    private fun setupButtons() {
        binding.btnBus.setOnClickListener {
            searchByFragmentInterface.swapToSelectBus()


        }
        binding.btnBusStop.setOnClickListener {
            searchByFragmentInterface.swapToSelectStation()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SearchBy()

        val TAG: String = SearchBy::class.java.simpleName
    }

    interface SearchByFragmentInterface {
        fun swapToSelectBus()
        fun swapToSelectStation()
        fun swapToBusSummary(routeId: String)
    }
}