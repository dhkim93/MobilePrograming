package kdh.com.mediaplayerservice2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    final String MUSIC_DIR = "/storage/sdcard/Music/";
    String[] fileNames = new File("/storage/sdcard/Music/").list();
    MediaPlayer mPlayer;

    ListView listView;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView1);

        Arrays.sort(fileNames);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, fileNames);
        listView.setAdapter(adapter);

        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        intent = new Intent(this, MyMusicService.class);


    }

    public void playMusic(View v) {

        try {
            intent.putExtra("MEDIA_FILE", fileNames[listView.getCheckedItemPosition()]);
            startService(intent);

        }catch (Exception e){
            Log.e("Main",e.getMessage());
            Toast.makeText(this, "음악을 선택해주세요", Toast.LENGTH_LONG).show();
        }
    }

    public void stopMusic(View v) {
        intent = new Intent(this, MyMusicService.class);
        stopService(intent);



    }
}



