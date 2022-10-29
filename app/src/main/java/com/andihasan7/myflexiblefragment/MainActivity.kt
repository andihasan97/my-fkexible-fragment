package com.andihasan7.myflexiblefragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //fragmenttransaction proses pemasangan objek HomeFragment hingga dapat tampil ke layar
        //menggunakan instance dari FragmentManager yg merupakan antarmuka u/ mengorganisir objek fragment dlm activity
        val mFragmentManager = supportFragmentManager
        val mHomeFragment = HomeFragment()
        val fragment = mFragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)

        /*
        Kode di bawah ini digunakan untuk memvalidasi apakah suatu fragment adalah instance dari suatu kelas
         */
        if (fragment !is HomeFragment) {
            Log.d("MyFlexibleFragment", "Fragment Name :" + HomeFragment::class.java.simpleName)
            mFragmentManager.commit {
                add(R.id.frame_container, mHomeFragment, HomeFragment::class.java.simpleName) // menggunakan fragment ktx
            }
        }
    }
}