package kdh.com.project_4_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Switch chbx;
    TextView text;
    RadioGroup rgroup;
    RadioButton rbtn1;
    RadioButton rbtn2;
    Button btnFin;
    Button btnReset;
    ImageView imgpet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        chbx = (Switch) findViewById(R.id.chBx);
        text = (TextView) findViewById(R.id.text1);
        rgroup = (RadioGroup) findViewById(R.id.rGroup);
        btnFin = (Button) findViewById(R.id.btnFin);
        btnReset = (Button) findViewById(R.id.btnFir);
        imgpet = (ImageView) findViewById(R.id.imgPet);
        rbtn1 = (RadioButton) findViewById(R.id.rBtn1);
        rbtn2 = (RadioButton) findViewById(R.id.rBtn2);

        chbx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean arg1) {

                if (chbx.isChecked() == true) {
                    text.setVisibility(View.VISIBLE);
                    rgroup.setVisibility(View.VISIBLE);
                    btnFin.setVisibility(View.VISIBLE);
                    btnReset.setVisibility(View.VISIBLE);
                    imgpet.setVisibility(View.VISIBLE);
                } else {
                    text.setVisibility(View.INVISIBLE);
                    rgroup.setVisibility(View.INVISIBLE);
                    btnFin.setVisibility(View.INVISIBLE);
                    btnReset.setVisibility(View.INVISIBLE);
                    imgpet.setVisibility(View.INVISIBLE);
                }
            }
        });


        rbtn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                imgpet.setImageResource(R.drawable.dog);
                imgpet.setVisibility(View.VISIBLE);
            }

        });
        rbtn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                imgpet.setImageResource(R.drawable.cat);
                imgpet.setVisibility(View.VISIBLE);
            }

        });

        btnFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                chbx.setChecked(false);
                imgpet.setImageResource(0);
                rbtn1.setChecked(false);
                rbtn2.setChecked(false);
            }


        });

    }


}

