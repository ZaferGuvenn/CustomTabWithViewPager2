package com.lafimsize.customtab

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
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

        TabLayoutMediator(binding.tLayout2,binding.viewPager){tab,position->

            when(position){

                1->{
                    tab.icon=getDrawable(android.R.drawable.ic_dialog_email)

                    val badgeDrawable=tab.orCreateBadge
                    badgeDrawable.backgroundColor=ContextCompat.getColor(applicationContext,R.color.purple_500)
                    badgeDrawable.isVisible = true
                    badgeDrawable.number=100
                    badgeDrawable.maxCharacterCount=2
                }

                2->{
                    tab.icon=getDrawable(android.R.drawable.ic_menu_call)

                    val badgeDrawable=tab.orCreateBadge
                    badgeDrawable.backgroundColor=ContextCompat.getColor(applicationContext,R.color.teal_200)
                    badgeDrawable.isVisible = true
                    badgeDrawable.number=100
                    badgeDrawable.maxCharacterCount=3
                }



            }


            tab.text=(position+1).toString()


        }.attach()


        binding.tLayout2.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{

            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity,"selected "+tab?.text,Toast.LENGTH_SHORT).show()

                when(tab?.position){1->tab.badge?.isVisible=false}
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