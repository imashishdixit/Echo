package com.ashish.echo.fragments


import android.app.Activity
import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.TextView
import com.ashish.echo.CurrentSongHelper
import com.ashish.echo.R
import com.ashish.echo.Songs
import kotlinx.android.synthetic.main.app_bar_main.view.*
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList


/**
 * A simple [Fragment] subclass.
 *
 */
class SongPlayingFragment : Fragment() {

    var myActivity: Activity? = null
    var mediaplayer: MediaPlayer? = null
    var startTimeText: TextView? = null
    var endTimeText: TextView? = null
    var playpauseImageButton: ImageButton? = null
    var previousImageButton: ImageButton? = null
    var nextImageButton: ImageButton? = null
    var loopImageButton: ImageButton? = null
    var seekbar: SeekBar? = null
    var songArtistView: TextView? = null
    var songTitleView: TextView? = null
    var shuffleImageButton: ImageButton? = null

    var currentPosition: Int = 0
    var fetchSOngs: ArrayList<Songs>? = null
    var currentSongHelper: CurrentSongHelper? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater!!.inflate(R.layout.fragment_song_playing2, container, false)
        seekbar = view?.findViewById(R.id.seekBar)
        startTimeText = view?.findViewById(R.id.startTime)
        endTimeText = view?.findViewById(R.id.endTime)
        playpauseImageButton = view?.findViewById(R.id.playPauseButton)
        nextImageButton = view?.findViewById(R.id.nextButton)
        previousImageButton = view?.findViewById(R.id.previousButton)
        loopImageButton = view?.findViewById(R.id.loopButton)
        shuffleImageButton = view?.findViewById(R.id.shuffleButton)
        songArtistView = view?.findViewById(R.id.songArtitst)
        songTitleView = view?.findViewById(R.id.songTitle)



        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        myActivity = activity

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        currentSongHelper = CurrentSongHelper()
        currentSongHelper?.isPlaying = true
        currentSongHelper?.isLoop=false
        currentSongHelper?.isShuffle=false

        var path: String? = null
        var songTitle: String? = null
        var songArtist: String? = null
        var songId: Long = 0
        try {
            path = arguments?.getString("path")
            songTitle = arguments?.getString("songTitle")
            songArtist = arguments?.getString("songArtitst")
            songId = arguments?.getInt("songId")?.toLong()!!

            currentPosition = arguments!!.getInt("songPosition")
            fetchSOngs = arguments!!.getParcelableArrayList("songData")
            currentSongHelper?.songPath = path
            currentSongHelper?.songTitle = songTitle
            currentSongHelper?.songArtist = songArtist
            currentSongHelper?.songId = songId

            currentSongHelper?.currentPosition = currentPosition


        } catch (e: Exception) {
            e.printStackTrace()
        }
        mediaplayer = MediaPlayer()
        mediaplayer?.setAudioStreamType(AudioManager.STREAM_MUSIC)
        try {
            mediaplayer?.setDataSource(myActivity, Uri.parse(path))
            mediaplayer?.prepare()

        } catch (e: Exception) {
            e.printStackTrace()

        }
        mediaplayer?.start()
        if(currentSongHelper?.isPlaying as Boolean){
            playpauseImageButton?.setBackgroundResource(R.drawable.pause_icon)

        }
        else{
            playpauseImageButton?.setBackgroundResource(R.drawable.play_icon)
        }
    }

    fun clickHandler() {
        shuffleImageButton?.setOnClickListener({

        })
        nextImageButton?.setOnClickListener({
        })
        previousImageButton?.setOnClickListener({

        })
        playpauseImageButton?.setOnClickListener({
            if (mediaplayer?.isPlaying as Boolean) {
                mediaplayer?.pause()
                currentSongHelper?.isPlaying=false

                playpauseImageButton?.setBackgroundResource(R.drawable.play_icon)

            } else {
                mediaplayer?.start()
                currentSongHelper?.isPlaying=true
                playpauseImageButton?.setBackgroundResource(R.drawable.pause_icon)
            }
        })
    }

    fun playNext(check:String){
        if(check.equals("PlayNextNormal",true)){
            currentPosition=currentPosition+1

        }
        else if(check.equals("PlayNextLikeNormalShuffle",true)){
            var randomObject=Random()
            var randomPosition=randomObject.nextInt(fetchSOngs?.size?.plus(1)as Int)

        }
    }
}
