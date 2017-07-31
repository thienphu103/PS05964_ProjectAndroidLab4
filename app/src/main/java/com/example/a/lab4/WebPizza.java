package com.example.a.lab4;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class WebPizza extends AppCompatActivity {
Button btnorder,btn;
EditText txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_pizza);
        btnorder =(Button) findViewById(R.id.btnOrderPizza);
btnorder.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final Dialog dialog = new Dialog(WebPizza.this);
        dialog.setTitle("Name Customer");
        dialog.setContentView(R.layout.dialog);
        btn = (Button) dialog.findViewById(R.id.button);
        txt = (EditText) dialog.findViewById(R.id.editText);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(getApplicationContext(),OrderPizza.class);
                Bundle mBundle = new Bundle();
                String profile =txt.getText().toString();
                mBundle.putString("profile",profile );
                intent.putExtras(mBundle);
                startActivity(intent);
            }

        });
        dialog.show();

    }
});

    }
}
