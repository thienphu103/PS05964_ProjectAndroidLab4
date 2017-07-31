package com.example.a.lab4;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

public class OrderPizza extends AppCompatActivity {
    Button btn, btn1;
    TextView namecustomer;
    NumberPicker np1, np2;
    TextView txt1, txt2, txt3;
    int pizza1, pizza2;
    String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_pizza);
        namecustomer = (TextView) findViewById(R.id.txtname);
        btn = (Button) findViewById(R.id.btnsave);
        final Intent intent = getIntent();
        Intent mIntent = new Intent(this, WebPizza.class);
        mIntent.putExtra("profile", value);
        value = getIntent().getExtras().getString("profile");
        namecustomer.setText("Customer: " + value + "");
        np1 = (NumberPicker) findViewById(R.id.numberPicker4);
        np1.setMinValue(0);
        np1.setMaxValue(20);
        np2 = (NumberPicker) findViewById(R.id.numberPicker5);
        np2.setMinValue(0);
        np2.setMaxValue(20);
        np1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int indexnumber2) {
                pizza2 = indexnumber2;
            }
        });
        np2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int indexnumber1) {
                pizza1 = indexnumber1;
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(OrderPizza.this, BullPizza.class);
//                Bundle mBundle1 = new Bundle();
//                Bundle mBundle2 = new Bundle();
//                mBundle1.putString("pizza1", pizza1 + "");
//                mBundle2.putString("pizza2", pizza2 + "");
//                intent.putExtras(mBundle1);
//                intent.putExtras(mBundle2);
                final Dialog dialog = new Dialog(OrderPizza.this);
                dialog.setTitle("Bull Pizza");
                dialog.setContentView(R.layout.activity_bull_pizza);
                txt1 = (TextView) dialog.findViewById(R.id.txtbull1);
                txt2 = (TextView) dialog.findViewById(R.id.txtbull2);
                txt3=(TextView) dialog.findViewById(R.id.textView9);
                btn1 = (Button) dialog.findViewById(R.id.btnReturn);
                txt1.setText("Pizza Thập Cẩm: "+pizza1 + "");
                txt2.setText("Pizza Hải Sản: " +pizza2 + "");
                txt3.setText("Customer: " + value + "");
                dialog.show();
            }

        });

    }
}
