package kdh.com.activityandintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class DialActivity extends Activity {
    Button btnDial,btnCancle2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dial);
        btnDial = (Button) findViewById(R.id.dial);
        btnCancle2 = (Button) findViewById(R.id.btnCancle2);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(Intent.ACTION_DIAL );
                startActivity(intent5);
            }
        });

        btnCancle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
