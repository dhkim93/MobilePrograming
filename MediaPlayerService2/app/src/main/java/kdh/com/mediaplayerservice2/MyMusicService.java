package kdh.com.mediaplayerservice2;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Chris on 2016-05-20.
 */
public class MyMusicService extends Service {
    MediaPlayer mPlayer;
    final String MUSIC_DIR = "/storage/sdcard/Music/";
    String[] fileNames = new File(MUSIC_DIR).list();


   // @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();


        Arrays.sort(fileNames);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String mediaFile = intent.getStringExtra("MEDIA_FILE");

        if(mPlayer == null){
            mPlayer = new MediaPlayer();
            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp1) {
                    mPlayer.release();
                    mPlayer = null;
                }
            });
            mPlayer.reset();
            try{

                mPlayer.setDataSource(MUSIC_DIR + mediaFile);
                mPlayer.prepare();
                mPlayer.start();
                Toast.makeText(this, "재생", Toast.LENGTH_LONG).show();
            }
            catch(IOException e){
                Log.e("Main", e.getMessage());
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean stopService(Intent name) {
        if (mPlayer != null && mPlayer.isPlaying()) {
            releaseMediaPlayer();
        }
        return super.stopService(name);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mPlayer !=null) {
            releaseMediaPlayer();
        }
    }

    private void releaseMediaPlayer() {
        mPlayer.release();
        mPlayer = null;
        Log.d("Main", "미디어 플레이어 해제");
        Toast.makeText(this, "미디어 플레이어 해제", Toast.LENGTH_LONG).show();
    }
}
