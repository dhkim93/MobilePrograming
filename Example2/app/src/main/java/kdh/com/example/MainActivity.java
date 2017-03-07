package kdh.com.example;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    RadioGroup rGroup1;
    RadioButton rbtn1;
    RadioButton rbtn2;
    ImageView imgAnd;
    EditText Edtx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        btn1=(Button) findViewById(R.id.btn1);
        btn2=(Button) findViewById(R.id.btn2);
        rGroup1=(RadioGroup) findViewById(R.id.rGroup1);
        rbtn1=(RadioButton) findViewById(R.id.rbtn1);
        rbtn2=(RadioButton) findViewById(R.id.rbtn2);
        imgAnd=(ImageView) findViewById(R.id.imgAnd);
        Edtx=(EditText) findViewById(R.id.Edtx);

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String mystr = Edtx.getText().toString();
                Toast.makeText(getApplicationContext(), mystr, Toast.LENGTH_SHORT).show();
            }

        });
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String mystr = Edtx.getText().toString();
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+mystr));
                startActivity(mIntent);
            }

        });
        rbtn1.setChecked(true);
        rbtn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                imgAnd.setImageResource(R.drawable.kitkat);
            }
        });

        rbtn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                imgAnd.setImageResource(R.drawable.lollipop);
            }
        });



    }


}

