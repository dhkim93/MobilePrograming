package kdh.com.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtx1, edtx2;
    Button btnAdd, btnSub, btnMlt, btnDiv, btnAc, btnClear;

    TextView txResult;
    String num1, num2;
    Double result;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = {R.id.Btn0, R.id.Btn1, R.id.Btn2, R.id.Btn3, R.id.Btn4, R.id.Btn5,
            R.id.Btn6, R.id.Btn7, R.id.Btn8, R.id.Btn9};
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtx1 = (EditText) findViewById(R.id.EdTx1);
        edtx2 = (EditText) findViewById(R.id.EdTx2);
        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMlt = (Button) findViewById(R.id.BtnMlt);
        btnDiv = (Button) findViewById(R.id.BtnDiv);
        btnAc = (Button) findViewById(R.id.BtnAc);
        btnClear = (Button) findViewById(R.id.BtnClear);
        txResult = (TextView) findViewById(R.id.TxResult);

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

    }


}

