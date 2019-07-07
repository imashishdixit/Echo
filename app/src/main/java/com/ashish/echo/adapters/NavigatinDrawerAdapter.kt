package com.ashish.echo.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.ashish.echo.R
import com.ashish.echo.activities.MainActivity
import com.ashish.echo.fragments.AboutUsFragment
import com.ashish.echo.fragments.FavouriteFragment
import com.ashish.echo.fragments.MainScreenFragment
import com.ashish.echo.fragments.SettingFragment



class NavigationDrawerAdapter(_contentList:ArrayList<String>,_getImages:IntArray,_context:Context):RecyclerView.Adapter<NavigationDrawerAdapter.NavViewHolder>(){
    var contentlist:IntArray?=null
    var getImages:IntArray?=null
    var mContext: Context?=null

    override fun onBindViewHolder(p0: NavViewHolder, p1: Int) {

      p0?.icon_GET?.setBackgroundResource(getImages?.get(p1) as Int)
        p0?.text_GET?.setText(contentlist?.get(p1) as Int)
        p0?.contentHolder?.setOnClickListener({
            if(p1==0){
                val mainScreenFragment=MainScreenFragment()
                (mContext as MainActivity).supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.details_fragments,mainScreenFragment)
                    .commit()

            }
            else if(p1==1){
                val favouriteFragment=FavouriteFragment()
                (mContext as MainActivity).supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.details_fragments,favouriteFragment)
                    .commit()
            }
            else if(p1==2){
                val settingsFragment=SettingFragment()
                (mContext as MainActivity).supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.details_fragments,settingsFragment)
                    .commit()
            }

            else {
                val aboutFragment=AboutUsFragment()
                (mContext as MainActivity).supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.details_fragments,aboutFragment)
                    .commit()
            }
            MainActivity.Statified.drawerLayout?.closeDrawers()

        })






    }

    override fun getItemCount(): Int {

        return (contentlist as ArrayList<*>).size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NavViewHolder {
      var itemView = LayoutInflater.from(p0?.context)
           .inflate(R.layout.row_custom_navigationdrawer,p0,false)
        val returnThis=NavViewHolder(itemView)
        return  returnThis
    }

    class NavViewHolder(itemView: View?):RecyclerView.ViewHolder(itemView!!){

      var icon_GET: ImageView?=null
        var text_GET: TextView?=null
        var contentHolder: RelativeLayout?=null
        init {
            icon_GET=itemView?.findViewById(R.id.icon_navdrawer)
            text_GET=itemView?.findViewById(R.id.text_navdrawer)
            contentHolder=itemView?.findViewById(R.id.navdrawer_item_content_holder)

        }

    }
}