package com.example.example;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv_ketqua;
    TextView tv_ketqua2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlertDialog.Builder mydialog = new AlertDialog.Builder(this);
        mydialog.setTitle("Message");
        mydialog.setIcon(R.drawable.images);

        tv_ketqua = (TextView)findViewById(R.id.textView_ketqua);
        tv_ketqua2 = (TextView)findViewById(R.id.textView_ketqua2);

        final  CharSequence[] items = {"Đỏ", "Cam", "Vàng"};
        final boolean[] arraycheck = {false,false,false};

        mydialog.setMultiChoiceItems(items, arraycheck, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                arraycheck[i] = b;
            }
        });

        mydialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String s = "";
                for (int j = 0; j < items.length; j++)
                    if (arraycheck[j])
                        s += items[j].toString() + "\n";
                    tv_ketqua2.setText(s);
            }
        });

        mydialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

       /*final CharSequence[] items = {"do", "cam", "vang"};
        mydialog.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tv_ketqua2.setText(items[i].toString());
            }
        });
        */

        /*mydialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                tv_ketqua.setText("You choice yes.");
            }
        });
    */
        AlertDialog alertDialog = mydialog.create();
        alertDialog.show();

    }
}
