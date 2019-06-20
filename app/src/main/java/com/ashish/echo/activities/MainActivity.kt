package com.ashish.echo.activities

import android.os.Bundle
import android.os.RecoverySystem
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.ashish.echo.R
import com.ashish.echo.adapters.NavigationDrawerAdapter
import com.ashish.echo.fragments.MainScreenFragment

class MainActivity : AppCompatActivity(){

    var navigationDrawerIconsList:ArrayList<String> =arrayListOf()
    var images_for_navdrawer = intArrayOf(R.drawable.navigation_allsongs,R.drawable.navigation_favorites
    ,R.drawable.navigation_settings,R.drawable.navigation_aboutus)

object Statified {
    var drawerLayout : DrawerLayout?=null
}



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar=findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        MainActivity.Statified.drawerLayout=findViewById(R.id.drawer_layout)

        navigationDrawerIconsList.add("All songs")
        navigationDrawerIconsList.add("Favourite")
        navigationDrawerIconsList.add("Settings")
        navigationDrawerIconsList.add("About Us")





        val toggle=ActionBarDrawerToggle(this@MainActivity,MainActivity.Statified.drawerLayout,toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        MainActivity.Statified.drawerLayout?.setDrawerListener(toggle)
        toggle.syncState()

        val mainScreenFragement= MainScreenFragment()
        this.supportFragmentManager
            .beginTransaction()
            .add(R.id.details_fragments,mainScreenFragement,"MainScreenFragment")
            .commit()

        var _navigationAdapter=NavigationDrawerAdapter(navigationDrawerIconsList,images_for_navdrawer,this)
        _navigationAdapter.notifyDataSetChanged()

        var navigation_recyler_view=findViewById<RecyclerView>(R.id.navigation_recycler_view)
        navigation_recyler_view.layoutManager=LinearLayoutManager(this)
        navigation_recyler_view.itemAnimator= DefaultItemAnimator()

        navigation_recyler_view.adapter=_navigationAdapter
        navigation_recyler_view.setHasFixedSize(true)





    }

    override fun onStart() {
        super.onStart()
    }
}
