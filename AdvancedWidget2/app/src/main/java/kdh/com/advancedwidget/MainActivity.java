package kdh.com.advancedwidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    RadioGroup rGroup;
    Button btnOK, btnRv, btnRe;
    TextView txTime;
    DatePicker dtPk;
    TimePicker tiPk;
    ProgressBar pBar;
    SeekBar sBar;
    RatingBar rBar;
    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rGroup = (RadioGroup) findViewById(R.id.RGroup);
        btnOK = (Button) findViewById(R.id.BtnOK);
        btnRv = (Button) findViewById(R.id.BtnRv);
        btnRe = (Button) findViewById(R.id.BtnRe);
        txTime = (TextView) findViewById(R.id.TxTime);
        dtPk = (DatePicker) findViewById(R.id.DtPk);
        tiPk = (TimePicker) findViewById(R.id.TiPk);
        pBar = (ProgressBar) findViewById(R.id.PBar);
        sBar = (SeekBar) findViewById(R.id.SBar);
        rBar = (RatingBar) findViewById(R.id.RBar);
        text1 = (TextView) findViewById(R.id.text1);

        btnRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rGroup.setVisibility(View.VISIBLE);
                btnOK.setVisibility(View.VISIBLE);
                txTime.setVisibility(View.VISIBLE);
                pBar.setVisibility(View.INVISIBLE);
                sBar.setVisibility(View.INVISIBLE);
                rBar.setVisibility(View.INVISIBLE);
                text1.setVisibility(View.INVISIBLE);
            }
        });

        btnRv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pBar.setVisibility(View.VISIBLE);
                sBar.setVisibility(View.VISIBLE);
                rBar.setVisibility(View.VISIBLE);
                text1.setVisibility(View.VISIBLE);
                rGroup.setVisibility(View.INVISIBLE);
                btnOK.setVisibility(View.INVISIBLE);
                txTime.setVisibility(View.INVISIBLE);
                dtPk.setVisibility(View.INVISIBLE);
                tiPk.setVisibility(View.INVISIBLE);
            }
        });
        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.RbtnDate:
                        dtPk.setVisibility(View.VISIBLE);
                        tiPk.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.RbtnTime:
                        tiPk.setVisibility(View.VISIBLE);
                        dtPk.setVisibility(View.INVISIBLE);
                        break;
                }
            }
        });

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txTime.setText(String.format("예약 시간 : %4d - %02d - %02d %02d:%02d", dtPk.getYear(), dtPk.getMonth() + 1, dtPk.getDayOfMonth(),
                        tiPk.getCurrentHour(), tiPk.getCurrentMinute()));
                tiPk.setVisibility(View.INVISIBLE);
                dtPk.setVisibility(View.INVISIBLE);

            }
        });

        sBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    pBar.setProgress(progress);
                    rBar.setRating(progress / 20.0f);
                    text1.setText("진행률 : " + progress + "%");
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });

        rBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                int progress = (int) (rating * 20);
                if(fromUser) {
                    pBar.setProgress(progress);
                    sBar.setProgress(progress);
                    text1.setText("진행률 : " + progress + "%");
                }
            }
        });




    }


}
