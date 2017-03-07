package kdh.com.homeworkflipper2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    Button btnPre;
    Button btnNxt;
    ViewFlipper viewFlip;
    EditText edtx1, edtx2;
    Button btnAdd, btnSub, btnMlt, btnDiv, btnAc, btnClear;
    TextView txResult;
    String num1, num2;
    Double result;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = {R.id.Btn0, R.id.Btn1, R.id.Btn2, R.id.Btn3, R.id.Btn4, R.id.Btn5,
            R.id.Btn6, R.id.Btn7, R.id.Btn8, R.id.Btn9};
    RadioGroup rGroup;
    Button btnOK;
    TextView txTime;
    DatePicker dtPk;
    TimePicker tiPk;
    ProgressBar pBar;
    SeekBar sBar;
    RatingBar rBar;
    TextView text1;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPre = (Button) findViewById(R.id.btnPre);
        btnNxt = (Button) findViewById(R.id.btnNxt);
        viewFlip = (ViewFlipper) findViewById(R.id.viewFlipper);
        edtx1 = (EditText) findViewById(R.id.EdTx1);
        edtx2 = (EditText) findViewById(R.id.EdTx2);
        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMlt = (Button) findViewById(R.id.BtnMlt);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        btnAc = (Button) findViewById(R.id.BtnAc);
        btnClear = (Button) findViewById(R.id.BtnClear);
        txResult = (TextView) findViewById(R.id.TxResult);

        rGroup = (RadioGroup) findViewById(R.id.RGroup);
        btnOK = (Button) findViewById(R.id.BtnOK);
        txTime = (TextView) findViewById(R.id.TxTime);
        dtPk = (DatePicker) findViewById(R.id.DtPk);
        tiPk = (TimePicker) findViewById(R.id.TiPk);
        pBar = (ProgressBar) findViewById(R.id.PBar);
        sBar = (SeekBar) findViewById(R.id.SBar);
        rBar = (RatingBar) findViewById(R.id.RBar);
        text1 = (TextView) findViewById(R.id.text1);


        btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlip.showPrevious();
            }
        });

        btnNxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFlip.showNext();
            }
        });

        btnAdd.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                try {
                    num1 = edtx1.getText().toString();
                    num2 = edtx2.getText().toString();
                    result = Double.parseDouble(num1) + Double.parseDouble(num2);
                    txResult.setText("계산 결과 : " + result);
                } catch(NumberFormatException e) {
                    Toast.makeText(getApplicationContext(),"숫자를 입력하세요",
                            Toast.LENGTH_SHORT).show();
                }

                return false;

            }

        });

        btnSub.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                try {
                    num1 = edtx1.getText().toString();
                    num2 = edtx2.getText().toString();
                    result = Double.parseDouble(num1) - Double.parseDouble(num2);
                    txResult.setText("계산 결과 : " + result);
                } catch(NumberFormatException e) {
                    Toast.makeText(getApplicationContext(),"숫자를 입력하세요",
                            Toast.LENGTH_SHORT).show();
                }

                return false;
            }

        });

        btnMlt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                try {
                    num1 = edtx1.getText().toString();
                    num2 = edtx2.getText().toString();
                    result = Double.parseDouble(num1) * Double.parseDouble(num2);
                    txResult.setText("계산 결과 : " + result);
                } catch(NumberFormatException e) {
                    Toast.makeText(getApplicationContext(),"숫자를 입력하세요",
                            Toast.LENGTH_SHORT).show();
                }

                return false;
            }

        });

        btnDiv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                try {
                    num1 = edtx1.getText().toString();
                    num2 = edtx2.getText().toString();
                    result = Double.parseDouble(num1) / Double.parseDouble(num2);
                    txResult.setText("계산 결과 : " + result);
                } catch(NumberFormatException e) {
                    Toast.makeText(getApplicationContext(),"숫자를 입력하세요",
                            Toast.LENGTH_SHORT).show();
                }

                return false;
            }

        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtx1.isFocused() == true) {
                    Editable editable = edtx1.getText();
                    int st = editable.length();
                    if (st > 1) {
                        editable.delete(st - 1, st);
                        edtx1.setText(editable);
                    } else if (st <= 1) {
                        edtx1.setText("");
                    }
                } else if(edtx2.isFocused() == true) {
                    Editable editable = edtx2.getText();
                    int st = editable.length();
                    if (st > 1) {
                        editable.delete(st - 1, st);
                        edtx2.setText(editable);
                    } else if (st <= 1) {
                        edtx2.setText("");
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "먼저 에디트텍스트를 선택하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnAc.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                edtx1.setText("");
                edtx2.setText("");
                txResult.setText("계산 결과 : ");
                return false;
            }

        });





        for(i=0; i<numBtnIDs.length; i++) {
            numButtons[i] = (Button) findViewById(numBtnIDs[i]);
        }

        for(i=0; i<numBtnIDs.length; i++) {
            final int index;
            index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(edtx1.isFocused() == true) {
                        num1 = edtx1.getText().toString() + numButtons[index].getText().toString();
                        edtx1.setText(num1);
                    } else if(edtx2.isFocused() == true) {
                        num2 = edtx2.getText().toString() + numButtons[index].getText().toString();
                        edtx2.setText(num2);
                    } else {
                        Toast.makeText(getApplicationContext(), "먼저 에디트텍스트를 선택하세요.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

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
                if (fromUser) {
                    pBar.setProgress(progress);
                    sBar.setProgress(progress);
                    text1.setText("진행률 : " + progress + "%");
                }
            }
        });

    }



}

