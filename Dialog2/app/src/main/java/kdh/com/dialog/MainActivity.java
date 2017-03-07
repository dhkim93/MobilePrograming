package kdh.com.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text1;
    TextView text2;
    TextView text3;
    EditText edit1, edit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);


    }

    public void setDialog(View v) {
        new MyDialogBulider(this).show();


    }

    class MyDialogBulider extends AlertDialog.Builder {
        String[] versionArray = {"젤리빈", "킷캣", "롤리팝"};
        String selectedItem = versionArray[0];
        View dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog1, null);

        public MyDialogBulider(Context context) {
            super(context);
        }

        @Override
        public AlertDialog create() {
            setTitle("제목입니다.");
            setView(dialogView);

            setIcon(R.mipmap.ic_launcher);

            setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    edit1 = (EditText) dialogView.findViewById(R.id.edit1);
                    edit2 = (EditText) dialogView.findViewById(R.id.edit2);

                    text2.setText(edit1.getText().toString());
                    text3.setText(edit2.getText().toString());
                }
            });
            setNegativeButton("취소", null);
            return super.create();
        }

    }
}
