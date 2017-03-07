package kdh.com.alertdialogimage;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup music;
    ImageView musicImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        music = (RadioGroup) findViewById(R.id.music);


    }

    public void imageView(View v) {
        new MyDialogBuilder(this).show();

        switch (music.getCheckedRadioButtonId()) {
            case R.id.ballad:
                musicImage.setImageResource(R.drawable.dog);
                break;
            case R.id.dance:
                musicImage.setImageResource(R.drawable.cat);
                break;
            case R.id.hiphop:
                musicImage.setImageResource(R.drawable.rabbit);
                break;
        }


    }

    class MyDialogBuilder extends AlertDialog.Builder {
        View dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog, null);

        public MyDialogBuilder(Context context) {

            super(context);
        }

        @Override
        public AlertDialog create() {
            musicImage = (ImageView) dialogView.findViewById(R.id.musicImage);
            setTitle("애완동물");
            setView(dialogView);
            setNegativeButton("닫기", null);
            return super.create();
        }
    }
}

