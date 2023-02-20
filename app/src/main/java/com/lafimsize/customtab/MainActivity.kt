package com.lafimsize.customtab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.lafimsize.customtab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.adapter=ViewPagerAdapter()



        TabLayoutMediator(binding.tLayout,binding.viewPager){tab,position->

            tab.text=(position+1).toString()

        }.attach()


        binding.tLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{

            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity,"selected "+tab?.text,Toast.LENGTH_SHORT).show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

                Toast.makeText(this@MainActivity,"reselected "+tab?.text,Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

                Toast.makeText(this@MainActivity,"unselected "+tab?.text,Toast.LENGTH_SHORT).show()
            }
        })

    }



}