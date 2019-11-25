package com.kaream.ehap.quranapp.utials;

import android.os.Environment;

import com.kaream.ehap.quranapp.Model.QuranModel;
import com.kaream.ehap.quranapp.Model.ReaderData;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class SongsManager {
    /**
     * sdCard Path
     */
    final String MEDIA_PATH = new String(Environment.getExternalStorageDirectory().getPath());
    private ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();

    // Constructor
    public SongsManager() {

    }

    public ArrayList<HashMap<String, String>> getSongsList(String RecitesName) {
        File home = new File(MEDIA_PATH);
        ArrayList<QuranModel> list = new ArrayList<>();
        ReaderData lc = new ReaderData();
        list = lc.GuranAya(RecitesName);
        for (QuranModel temp : list) {

/// / MainActivity.PathQuran="http://www.mp3quran.net/newMedia.php?id=" + String.valueOf(IDSelect) + "&file=http://server11.mp3quran.net/" + MajorDeprtment + "/" +  IDString + ".mp3";
            HashMap<String, String> song = new HashMap<String, String>();
            song.put("songTitle", temp.realName);
            song.put("songPath", temp.ImgUrl);

            // Adding each song to SongList
            songsList.add(song);
        }


        // return songs list array
        return songsList;
    }

}
