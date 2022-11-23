package com.example.sfutransiter.views

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import com.example.sfutransiter.R
import com.example.sfutransiter.backend.RetrofitAPI
import com.example.sfutransiter.databinding.ActivityMainBinding
import com.example.sfutransiter.repository.Repository
import com.example.sfutransiter.util.Util
import com.example.sfutransiter.views.components.BaseActivity
import com.example.sfutransiter.views.search_by.SearchBy
import com.example.sfutransiter.views.select_bus.SelectBus

class MainActivity : BaseActivity(),
    MainFragment.MainFragmentInterface,
    SearchBy.SearchByFragmentInterface {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Util.checkPermissions(this)
        Log.d("swag", "onCreate: ok")
        val repo = Repository(RetrofitAPI.getInstance()).getBuses(6657)

        addFragment(R.id.mainFragmentContainer, MainFragment.newInstance(), MainFragment.TAG, false)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == Util.PERM_REQUEST_CODE) {
            for (i in permissions.indices) {
                if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                    Util.checkPermissions(this)
                    return
                }
            }
        }
    }

    override fun swapToSearchBy() {
        replaceFragment(R.id.mainFragmentContainer, SearchBy.newInstance(), SearchBy.TAG, false)
    }

    override fun swapToSelectBus() {
        replaceFragment(R.id.mainFragmentContainer, SelectBus.newInstance(), SelectBus.TAG)
    }
}