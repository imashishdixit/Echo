package com.ashish.echo.fragments


import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.RelativeLayout
import android.widget.TextView
import com.ashish.echo.R
import com.ashish.echo.Songs


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MainScreenFragment : Fragment() {

    var nowPlayingBottomBar:RelativeLayout?=null
    var playPauseButton :ImageButton?=null
    var songTitle:TextView?=null
    var visibleLayout:RelativeLayout?=null
    var noSongs:RelativeLayout?=null
    var recyclerView: RecyclerView?=null

    var myAcitivity:Activity?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view =inflater!!.inflate(R.layout.fragment_main_screen,container,false)
        visibleLayout=view?.findViewById<RelativeLayout>(R.id.visibleLayout)
        noSongs=view?.findViewById<RelativeLayout>(R.id.noSongs)
        nowPlayingBottomBar=view?.findViewById<RelativeLayout>(R.id.hiddenBarMainScreen)
        songTitle=view?.findViewById<TextView>(R.id.songTitleMainScreen)
        playPauseButton=view?.findViewById<ImageButton>(R.id.playPauseButton)
        recyclerView=view?.findViewById<RecyclerView>(R.id.contentMain)
        return view


    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        myAcitivity=context as Activity
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        myAcitivity=activity
    }

    fun getSongsFromPhone():ArrayList<Songs>{
       var arrayList=ArrayList<Songs>()
        var contentResolver=myActivity?.contentResolver



    }



}
