package com.kaream.ehap.quranapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.felipecsl.gifimageview.library.GifImageView;
import com.kaream.ehap.quranapp.DataBase.DBHelper;
import com.kaream.ehap.quranapp.Model.FavoriteModel;
import com.kaream.ehap.quranapp.utials.SongsManager;
import com.kaream.ehap.quranapp.utials.Utilities;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ActivityMediaPlayer extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener,MediaPlayer.OnCompletionListener{



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 100){
            currentSongIndex = data.getExtras().getInt("songIndex");
            // play selected song
            playSong(currentSongIndex);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK )
        {
            if(mediaPlayer.isPlaying())
                if(mediaPlayer!=null)
                    mediaPlayer.pause();

            this.finish();
        }

        return super.onKeyDown(keyCode, event);
    }
    Typeface typeface ;
    String songTitle = "";
    private ImageView img_back;
    private ImageView img_addFavorite ;
    private TextView txt_ReaderName;
    private TextView txt_AyaName;
    private ImageView reader_img;
    private TextView txt_timeStart, txt_timeEnd;
    private SeekBar seekBar;
    private ImageView img_rotate, img_next, img_pervious, img_play, img_shuffel,menu_popup;
    private static MediaPlayer mediaPlayer;
    private Handler mHandler;
    private SongsManager songManager;
    private Utilities utils;
    private int currentSongIndex = 0;
    private boolean isShuffle = false;
    private boolean isRepeat = false;
    String RecitesName = "";
    String RecitesAYA = "";
    String realNameForReader ="";
    String realName = "";
    String stateName ="";
    String ImgUrl = "";
    String serverName ="";
    String testStateName ="";
    int img_Drawable ;
    boolean playTheGifWallper = false ;
    private FrameLayout frameLayout;
    private ArrayList<HashMap<String, String>> songsList ;
    private GifImageView gifImageView;
    String themeValue = "White";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);
        themeValue = getThemeValue() ;
        setUp();
        setUpPopUpMenu();
        setUpTheme();
        if(themeValue.equals("Wallper")){
            playTheGifWallper = true;
            gifImageView.setVisibility(View.VISIBLE);
            playGif();
        }
        Bundle b = getIntent().getExtras();
        RecitesName=b.getString("RecitesName");
        RecitesAYA=b.getString("RecitesAYA");
        realNameForReader =b.getString("RealNameForReader");
        realName =b.getString("RealName");
        stateName=b.getString("StateName");
        ImgUrl =b.getString("ImageUrl");
        serverName =b.getString("ServerName");
        img_Drawable =b.getInt("ImgDrawable");
        testStateName ="من الهاتف";
        seekBar.setOnSeekBarChangeListener(this);
        mediaPlayer.setOnCompletionListener(this);
        reader_img.setImageResource(img_Drawable);
        songsList = songManager.getSongsList(RecitesName);
        DBHelper dbHelper = new DBHelper(getApplicationContext());
        String res =  dbHelper.getRecitesAya(realName);
        String resReader = dbHelper.getReaderName(realName);
        if(res.contains(RecitesAYA) && resReader.contains(realNameForReader)){
            if(themeValue.equals("White")){
                img_addFavorite.setImageResource(R.drawable.ic_favorite_black);
            }else if(themeValue.equals("Black")) {
                img_addFavorite.setImageResource(R.drawable.ic_favorite_white);
            }else {
                img_addFavorite.setImageResource(R.drawable.ic_favorite_white);
            }

        }else {
            if(themeValue.equals("White")){
                img_addFavorite.setImageResource(R.drawable.ic_favorite_unchecked_black);
            }else if(themeValue.equals("Black")){
                img_addFavorite.setImageResource(R.drawable.ic_favorite_unchecked);
            }else {
                img_addFavorite.setImageResource(R.drawable.ic_favorite_unchecked);
            }

            }
        currentSongIndex=Integer.parseInt(RecitesAYA);
        if(getNetworkAvailability() || testStateName.equals(stateName) ){
            if(mediaPlayer.isPlaying()){
                mediaPlayer.release();
            }
            playSong(currentSongIndex);
        }else {
            Toast.makeText(getApplicationContext(),"Please Check Internet Connection",Toast.LENGTH_SHORT).show();
            songTitle = songsList.get(currentSongIndex).get("songTitle");
            typeface = Typeface.createFromAsset(getAssets(),"Fonts/Droid_Sans_Arabic.ttf");
            txt_AyaName.setTypeface(typeface);
            txt_ReaderName.setTypeface(typeface);
            txt_AyaName.setText(songTitle);
            txt_ReaderName.setText(realNameForReader);
        }


        /**
         * Button Play action when press
         */
        img_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check for already playing
                if(mediaPlayer.isPlaying()){
                    if(mediaPlayer!=null){
                        mediaPlayer.pause();
                        // Changing button image to play button
                        if(themeValue.equals("White")){
                            img_play.setImageResource( R.drawable.ic_play_black);
                        }else if(themeValue.equals("Black")){
                            img_play.setImageResource( R.drawable.ic_play);
                        }else {
                            img_play.setImageResource( R.drawable.ic_play);
                        }

                    }
                }else{
                    // Resume song
                    if(mediaPlayer!=null){
                        mediaPlayer.start();
                        // Changing button image to pause button
                        if(themeValue.equals("White")){
                            img_play.setImageResource( R.drawable.ic_pause_black);
                        }else if(themeValue.equals("Black")){
                            img_play.setImageResource( R.drawable.ic_pause);
                        }else {
                            img_play.setImageResource( R.drawable.ic_pause);
                        }
                    }
                }
            }
        });

        /**
          * Next button click event
          * Plays next song by taking currentSongIndex + 1
         * * */

        img_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check if next song is there or not
                if(currentSongIndex < (songsList.size() - 1)){
                    if(getNetworkAvailability()|| testStateName.equals(stateName)){
                           playSong(currentSongIndex + 1);

                        currentSongIndex = currentSongIndex + 1;
                    }else {
                        Toast.makeText(getApplicationContext(),"Please Check Internet Connection",Toast.LENGTH_SHORT).show();
                    }

                }else{
                    //play first song
                    if(getNetworkAvailability() || testStateName.equals(stateName) ){
                          playSong(0);
                        currentSongIndex = 0;
                    }else {
                        Toast.makeText(getApplicationContext(),"Please Check Internet Connection",Toast.LENGTH_SHORT).show();
                    }



                }
            }
        });
        /**
         * Back button click event
         * Plays previous song by currentSongIndex - 1
         * */
        img_pervious.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(currentSongIndex > 0){
                    if(getNetworkAvailability() || testStateName.equals(stateName) ){
                         playSong(currentSongIndex - 1);
                        currentSongIndex = currentSongIndex - 1;
                    }else {
                        Toast.makeText(getApplicationContext(),"Please Check Internet Connection",Toast.LENGTH_SHORT).show();
                    }

                }else{

                    if(getNetworkAvailability() || testStateName.equals(stateName) ){

                                playSong(songsList.size() - 1);

                        currentSongIndex = songsList.size() - 1;
                    }else {
                        Toast.makeText(getApplicationContext(),"Please Check Internet Connection",Toast.LENGTH_SHORT).show();
                    }


                }

            }
        });

        /**
         * Button Click event for Repeat button
         * Enables repeat flag to true
         * */
        img_rotate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(isRepeat){
                    isRepeat = false;
                    Toast.makeText(getApplicationContext(), "Repeat is OFF", Toast.LENGTH_SHORT).show();

                    if(themeValue.equals("White")){
                        img_rotate.setImageResource( R.drawable.ic_rotate_black);
                    }else if(themeValue.equals("Black")){
                        img_rotate.setImageResource( R.drawable.ic_rotate);
                    }else {
                        img_rotate.setImageResource( R.drawable.ic_rotate);
                    }
                }else{
                    // make repeat to true
                    isRepeat = true;
                    Toast.makeText(getApplicationContext(), "Repeat is ON", Toast.LENGTH_SHORT).show();
                    // make shuffle to false
                    if(themeValue.equals("White")){
                        isShuffle = false;
                        img_rotate.setImageResource( R.drawable.ic_rotate_black);
                        img_shuffel.setImageResource( R.drawable.ic_shaffle_black);
                    }else if(themeValue.equals("Black")){
                        isShuffle = false;
                        img_rotate.setImageResource( R.drawable.ic_rotate);
                        img_shuffel.setImageResource( R.drawable.ic_shaffle);
                    }else {
                        isShuffle = false;
                        img_rotate.setImageResource( R.drawable.ic_rotate);
                        img_shuffel.setImageResource( R.drawable.ic_shaffle);
                    }

                }
            }
        });

        /**
         * Button Click event for Shuffle button
         * Enables shuffle flag to true
         * */
        img_shuffel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(isShuffle){
                    isShuffle = false;
                    Toast.makeText(getApplicationContext(), "Shuffle is OFF", Toast.LENGTH_SHORT).show();
                    if(themeValue.equals("White")){
                        img_shuffel.setImageResource( R.drawable.ic_shaffle_black);
                    }else if(themeValue.equals("Black")){
                        img_shuffel.setImageResource( R.drawable.ic_shaffle);
                    }else {
                        img_shuffel.setImageResource( R.drawable.ic_shaffle);
                    }
                }else{
                    // make repeat to true
                    isShuffle= true;
                    Toast.makeText(getApplicationContext(), "Shuffle is ON", Toast.LENGTH_SHORT).show();
                    if(themeValue.equals("White")){
                        isRepeat = false;
                        img_shuffel.setImageResource( R.drawable.ic_shaffle_black);
                        img_rotate.setImageResource( R.drawable.ic_rotate_black);
                    }else if(themeValue.equals("Black")){
                        isRepeat = false;
                        img_shuffel.setImageResource( R.drawable.ic_shaffle);
                        img_rotate.setImageResource( R.drawable.ic_rotate);
                    }else {
                        isRepeat = false;
                        img_shuffel.setImageResource( R.drawable.ic_shaffle);
                        img_rotate.setImageResource( R.drawable.ic_rotate);
                    }
                    // make shuffle to false

                }
            }
        });
     img_back.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
              Intent intent = new Intent(getApplicationContext(),activity_sour.class);
               intent.putExtra("RecitesName",RecitesName);
               intent.putExtra("RealNameObject",realNameForReader);
               intent.putExtra("ImgDrawable",img_Drawable);
              startActivity(intent);
             if(mediaPlayer.isPlaying()){
                 mediaPlayer.release();
             }
         }
     });
     img_addFavorite.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             DBHelper dbHelper = new DBHelper(getApplicationContext());
             String res =  dbHelper.getRecitesAya(realName);
             String resReader = dbHelper.getReaderName(realName);
             if(res.contains(RecitesAYA)  && resReader.contains(realNameForReader)){
                 dbHelper.delete(realName);
                 if(themeValue.equals("White")){
                     img_addFavorite.setImageResource(R.drawable.ic_favorite_unchecked_black);
                 }else if(themeValue.equals("Black")){
                     img_addFavorite.setImageResource(R.drawable.ic_favorite_unchecked);
                 }else {
                     img_addFavorite.setImageResource(R.drawable.ic_favorite_unchecked);
                 }

                 Toast.makeText(getApplicationContext(),"تمت الازالة بنجاح",Toast.LENGTH_SHORT).show();
             }else {
                 FavoriteModel favoriteModel = new FavoriteModel(serverName, realName,stateName,ImgUrl,activity_sour.img_drawable,RecitesAYA,RecitesName,realNameForReader );
                 saveData(favoriteModel);

             }

         }
     });
    }
    private void setUpPopUpMenu(){
        menu_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(ActivityMediaPlayer.this, menu_popup);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu_media, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if(menuItem.getItemId() == R.id.themeBlack){

                             themeValue = "Black" ;
                             setUpTheme();
                        }else if(menuItem.getItemId() == R.id.themeWhite){

                            themeValue = "White" ;
                             setUpTheme();
                        }else if(menuItem.getItemId() == R.id.themeWallper){

                            themeValue ="Wallper";
                            setUpTheme();
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }
    private void svaeThemeState(){
        SharedPreferences settings = getSharedPreferences("THEME_STATE", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("STATE",themeValue);
        editor.commit();
    }
    private String getThemeValue(){
        SharedPreferences settings = getSharedPreferences("THEME_STATE", 0);
        String themeState = settings.getString("STATE", "White");
        return themeState;
    }
    private void  setUpTheme(){
        if(themeValue.equals("White")){
           playTheGifWallper = false ;
           gifImageView.setVisibility(View.GONE);
          frameLayout.setBackgroundResource(R.color.white);
          menu_popup.setImageResource(R.drawable.ic_icon_popup_menu_black);
          img_addFavorite.setImageResource(R.drawable.ic_favorite_unchecked_black);
          img_back.setImageResource(R.drawable.ic_backarrow_black);
          txt_ReaderName.setTextColor(Color.BLACK);
          txt_AyaName.setTextColor(Color.BLACK);
          txt_timeStart.setTextColor(Color.BLACK);
          txt_timeEnd.setTextColor(Color.BLACK);
          img_pervious.setImageResource(R.drawable.ic_backword_black);
          img_next.setImageResource(R.drawable.ic_forward_black);
          if(mediaPlayer.isPlaying()){
              img_play.setImageResource(R.drawable.ic_pause_black);
          }else {
              img_play.setImageResource(R.drawable.ic_play_black);
          }

          img_shuffel.setImageResource(R.drawable.ic_shaffle_black);
          img_rotate.setImageResource(R.drawable.ic_rotate_black);
          svaeThemeState();

       }else if(themeValue.equals("Black")){
           playTheGifWallper = false;
            gifImageView.setVisibility(View.GONE);
           frameLayout.setBackgroundResource(R.color.black);
           menu_popup.setImageResource(R.drawable.ic_icon_popup_menu_white);
           img_addFavorite.setImageResource(R.drawable.ic_favorite_unchecked);
           img_back.setImageResource(R.drawable.ic_backarrow);
           txt_ReaderName.setTextColor(Color.WHITE);
           txt_AyaName.setTextColor(Color.WHITE);
           txt_timeStart.setTextColor(Color.WHITE);
           txt_timeEnd.setTextColor(Color.WHITE);
           img_pervious.setImageResource(R.drawable.ic_backword);
           img_next.setImageResource(R.drawable.ic_forward);
            if(mediaPlayer.isPlaying()){
                img_play.setImageResource(R.drawable.ic_pause);
            }else {
                img_play.setImageResource(R.drawable.ic_play);
            }
           img_shuffel.setImageResource(R.drawable.ic_shaffle);
           img_rotate.setImageResource(R.drawable.ic_rotate);
           svaeThemeState();
       }else if(themeValue.equals("Wallper")){
           playTheGifWallper = true;
           gifImageView.setVisibility(View.VISIBLE);
           menu_popup.setImageResource(R.drawable.ic_icon_popup_menu_white);
           img_addFavorite.setImageResource(R.drawable.ic_favorite_unchecked);
           img_back.setImageResource(R.drawable.ic_backarrow);
           txt_ReaderName.setTextColor(Color.WHITE);
           txt_AyaName.setTextColor(Color.WHITE);
           txt_timeStart.setTextColor(Color.WHITE);
           txt_timeEnd.setTextColor(Color.WHITE);
           img_pervious.setImageResource(R.drawable.ic_backword);
           img_next.setImageResource(R.drawable.ic_forward);
            if(mediaPlayer.isPlaying()){
                img_play.setImageResource(R.drawable.ic_pause);
            }else {
                img_play.setImageResource(R.drawable.ic_play);
            }
           img_shuffel.setImageResource(R.drawable.ic_shaffle);
           img_rotate.setImageResource(R.drawable.ic_rotate);
            playGif();
           svaeThemeState();
        }

    }
    public boolean getNetworkAvailability() {
        return Utilities.isNetworkAvailable(getApplicationContext());
    }
    private void saveData(FavoriteModel model ) {
        DBHelper dbHelper = new DBHelper(getApplicationContext());

        if (dbHelper.addFavoriate(model)){
            if(themeValue.equals("White")){
                img_addFavorite.setImageResource(R.drawable.ic_favorite);
            }else if(themeValue.equals("Black")){
                img_addFavorite.setImageResource(R.drawable.ic_favorite_white);
            }else {
                img_addFavorite.setImageResource(R.drawable.ic_favorite_white);
            }
            Toast.makeText(getApplicationContext(),"تمت الاضافة بنجاح",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(),"لم تتم الاضافة",Toast.LENGTH_SHORT).show();

        }

    }
    public void setUp() {
        frameLayout = findViewById(R.id.parentView);
        gifImageView = findViewById(R.id.gifImageView);
        menu_popup = findViewById(R.id.menu_select);
        img_back = findViewById(R.id.img_back);
        img_addFavorite = findViewById(R.id.img_favorite);
        txt_ReaderName = findViewById(R.id.txt_readerName);
        txt_AyaName = findViewById(R.id.txt_ayaName);
        reader_img = findViewById(R.id.reader_img);
        txt_timeStart = findViewById(R.id.txt_timeStart);
        txt_timeEnd = findViewById(R.id.txt_timeEnd);
        seekBar = findViewById(R.id.seekBar);
        img_rotate = findViewById(R.id.img_rotate);
        img_next = findViewById(R.id.img_forword);
        img_play = findViewById(R.id.img_play);
        img_pervious = findViewById(R.id.img_backword);
        img_shuffel = findViewById(R.id.img_shuffel);
        songsList =new ArrayList<HashMap<String, String>>();
        mHandler = new Handler();
        mediaPlayer = new MediaPlayer();
        songManager = new SongsManager();
        utils = new Utilities();
    }

    private void playGif(){
        //Set GIFImageView resource
        try{
            InputStream inputStream = getAssets().open("wallber_background4.gif");
            byte[] bytes = IOUtils.toByteArray(inputStream);
            gifImageView.setBytes(bytes);
            gifImageView.startAnimation();
        }
        catch (IOException ex)
        {
             ex.printStackTrace();
        }
    }

    /**
     * the function for play song
     */
    public void playSong(int songIndex) {

        try {

            mediaPlayer.reset();
            Log.d("error.. ",songsList.get(songIndex).get("songPath"));
            mediaPlayer.setDataSource(songsList.get(songIndex).get("songPath"));
            mediaPlayer.prepare();
            mediaPlayer.start();
            // Displaying Song title
            songTitle = songsList.get(songIndex).get("songTitle");
            typeface = Typeface.createFromAsset(getAssets(),"Fonts/Droid_Sans_Arabic.ttf");
            txt_AyaName.setTypeface(typeface);
            txt_ReaderName.setTypeface(typeface);
            txt_AyaName.setText(songTitle);
            txt_ReaderName.setText(realNameForReader);
            if(themeValue.equals("White")){
                // show image pause
                img_play.setImageResource(R.drawable.ic_pause_black);
            }else if(themeValue.equals("Black")){
                // show image pause
                img_play.setImageResource(R.drawable.ic_pause);
            }else {
                // show image pause
                img_play.setImageResource(R.drawable.ic_pause);
            }
            seekBar.setProgress(0);
            seekBar.setMax(100);
            //Updating Progress bar
            updateProgressBar();
        }catch (IllegalArgumentException e){
               e.printStackTrace();
        }catch (IllegalStateException e){
              e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    /**
     * Update timer on seekbar
     * */
    private void updateProgressBar() {
        mHandler.postDelayed(mUpdateTimeTask, 100);
    }

    /**
     * Background Runnable thread
     * */
    private Runnable mUpdateTimeTask = new Runnable() {
        public void run() {
            try{
                long totalDuration = mediaPlayer.getDuration();
                long currentDuration = mediaPlayer.getCurrentPosition();

                // Displaying Total Duration time
                txt_timeEnd.setText(""+utils.milliSecondsToTimer(totalDuration));
                // Displaying time completed playing
                txt_timeStart.setText(""+utils.milliSecondsToTimer(currentDuration));

                // Updating progress bar
                int progress = (utils.getProgressPercentage(currentDuration, totalDuration));
                //Log.d("Progress", ""+progress);
                seekBar.setProgress(progress);

                // Running this thread after 100 milliseconds
                mHandler.postDelayed(this, 100);

            }
            catch (Exception ex){}
        }
    };


    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        mHandler.removeCallbacks(mUpdateTimeTask);
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        mHandler.removeCallbacks(mUpdateTimeTask);
        int totalDuration = mediaPlayer.getDuration();
        int currentPosition = utils.progressToTimer(seekBar.getProgress(), totalDuration);

        // forward or backward to certain seconds
        mediaPlayer.seekTo(currentPosition);

        // update timer progress again
        updateProgressBar();
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        // check for repeat is ON or OFF
        if(isRepeat){
            // repeat is on play same song again
            if(getNetworkAvailability() || testStateName.equals(stateName) ){
                 playSong(currentSongIndex);
             }else {
                Toast.makeText(getApplicationContext(),"Please Check Internet Connection",Toast.LENGTH_SHORT).show();
            }


        } else if(isShuffle){
            // shuffle is on - play a random song
            Random rand = new Random();
            currentSongIndex = rand.nextInt((songsList.size() - 1) - 0 + 1) + 0;
            if(getNetworkAvailability() || testStateName.equals(stateName) ){
                        playSong(currentSongIndex);
                 }else {
                Toast.makeText(getApplicationContext(),"Please Check Internet Connection",Toast.LENGTH_SHORT).show();
            }

        } else{
            // no repeat or shuffle ON - play next song
            if(currentSongIndex < (songsList.size() - 1)){
                if(getNetworkAvailability() || testStateName.equals(stateName) ){
                     playSong(currentSongIndex + 1);
                    currentSongIndex = currentSongIndex + 1;
                }else {
                    Toast.makeText(getApplicationContext(),"Please Check Internet Connection",Toast.LENGTH_SHORT).show();
                }

            }else{
                if(getNetworkAvailability() || testStateName.equals(stateName) ){
                    playSong(0);
                  currentSongIndex = 0;
                }else {
                    Toast.makeText(getApplicationContext(),"Please Check Internet Connection",Toast.LENGTH_SHORT).show();
                }


            }
        }
    }
    @Override
    public void onDestroy(){

        mediaPlayer.release();
        super.onDestroy();
    }
}
