package com.slayer.cxj.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {

    public static String tag = "DEMO";
    public static int REQUEST_CODE_PICK_IMAGE = 1;
    private CheckBox bx;
    private CheckBox bm;
    private CheckBox all;
    private Button button;

    private RadioButton rmale;
    private RadioButton rfemale;
    private RadioButton r3rd;
    private RadioGroup rg;

    private Button images;
    private Button layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bx = (CheckBox) findViewById(R.id.x_art);

        bm = (CheckBox) findViewById(R.id.met_art);

        all = (CheckBox) findViewById(R.id.all);

        button = (Button) findViewById(R.id.button);

        rmale = (RadioButton) findViewById(R.id.male);
        rfemale = (RadioButton) findViewById(R.id.female);
        r3rd = (RadioButton) findViewById(R.id.g3rd);
        rg = (RadioGroup) findViewById(R.id.gender);

        images = (Button) findViewById(R.id.img_button);
        layout = (Button) findViewById(R.id.layout);

        bm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (((CheckBox) v).isChecked()) {
                    Log.i(tag, "button x is checked.");
                    if (bx.isChecked()) {
                        all.setChecked(true);
                    }
                } else {
                    Log.i(tag, "button x is not checked.");
                    all.setChecked(false);
                }
            }
        });


        bx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    Log.i(tag, "button b is checked.");
                    if (bm.isChecked()) {
                        all.setChecked(true);
                    }
                } else {
                    Log.i(tag, "button b is no checked.");
                    all.setChecked(false);
                }
            }
        });


        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    bm.setChecked(true);
                    bx.setChecked(true);
                    Log.i(tag, "button x and m are set to checked.");
                } else {
                    bm.setChecked(false);
                    bx.setChecked(false);
                    Log.i(tag, "button x and m are set to not checked.");
                }

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShoppingCart.class);
                startActivity(intent);
            }
        });

        rg.setOnCheckedChangeListener(new OnCheckedChangeListener());

        images.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ImageActivity.class);
                startActivity(intent);

//                Intent intent = new Intent(Intent.ACTION_PICK);
//                intent.setType("image/*");//相片类型
//                startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE);
            }
        });

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LayoutActivity.class);
                startActivity(intent);
            }
        });
    }

    private class OnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            if (checkedId == rmale.getId()) {
                Log.i(tag, "the male button is checked.");
            } else if (checkedId == rfemale.getId()) {
                Log.i(tag, "the female button is checked.");
            } else {
                Log.i(tag, "the 3rd gender button is checked.");
            }
        }
    }
}




