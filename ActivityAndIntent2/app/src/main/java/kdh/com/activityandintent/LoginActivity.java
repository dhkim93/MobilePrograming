package kdh.com.activityandintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class LoginActivity extends Activity {
    Button btnLogin, btnCancle;
    EditText edit1;
    public static final String Login = "login";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        btnCancle = (Button) findViewById(R.id.btnCancle);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        edit1 = (EditText) findViewById(R.id.edit1);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(LoginActivity.this,MainActivity.class);
                intent3.putExtra(Login,edit1.getText().toString());
                setResult(RESULT_OK,intent3);
                finish();
            }
        });

        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();;
            }
        });
    }
}
