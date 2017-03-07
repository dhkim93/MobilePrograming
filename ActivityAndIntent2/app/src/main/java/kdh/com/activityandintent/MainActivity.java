package kdh.com.activityandintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup check;
    Button btnOk;
    public static final Integer REQUEST_CODE_ONE = 1;
    public static final Integer REQUEST_CODE_TWO = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        check = (RadioGroup) findViewById(R.id.check);
        btnOk = (Button) findViewById(R.id.btnOk);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (check.getCheckedRadioButtonId()){
                    case R.id.login :
                        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                        startActivityForResult(intent,REQUEST_CODE_ONE);
                        break;
                    case R.id.favorite :
                        Intent intent1 = new Intent(MainActivity.this,FavoriteActivity.class);
                        startActivityForResult(intent1,REQUEST_CODE_TWO);
                        break;
                    case R.id.call :
                        Intent intent2 = new Intent(Intent.ACTION_DIAL);
                        startActivity(intent2);
                        break;
                    default:
                        Toast.makeText(MainActivity.this,"하나라도 선택하세요",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            String message = data.getStringExtra(LoginActivity.Login);
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
        }
        else if(resultCode==FavoriteActivity.REQUEST_CODE_THREE){
            String message1 = data.getStringExtra(FavoriteActivity.checkdrama);
            Toast.makeText(this,message1,Toast.LENGTH_SHORT).show();
        }
    }
}
