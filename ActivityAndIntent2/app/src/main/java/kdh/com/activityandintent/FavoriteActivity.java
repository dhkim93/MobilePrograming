package kdh.com.activityandintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class FavoriteActivity extends Activity {
    RadioGroup drama;
    Button btnCheck, btnCancle1;
    public static final String checkdrama = "checkDrama";
    public static final Integer REQUEST_CODE_THREE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite_drama);
        drama = (RadioGroup) findViewById(R.id.drama);
        btnCheck = (Button) findViewById(R.id.btnCheck);
        btnCancle1 = (Button) findViewById(R.id.btnCancle1);

        btnCancle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void showTitle(View v) {
        int checkedButtonId = drama.getCheckedRadioButtonId();
        switch (checkedButtonId) {
            case R.id.jodlho:

                break;
            case R.id.monster:

                break;
            case R.id.daebak:

                break;
            default:
                Toast.makeText(this, "드라마를 선택해주세요.", Toast.LENGTH_SHORT).show();
                return;
        }

        RadioButton starButton = (RadioButton) findViewById(checkedButtonId);
        Intent intent4 = new Intent(FavoriteActivity.this, MainActivity.class);
        intent4.putExtra(checkdrama, starButton.getText());
        setResult(REQUEST_CODE_THREE,intent4);
        finish();
    }
}
