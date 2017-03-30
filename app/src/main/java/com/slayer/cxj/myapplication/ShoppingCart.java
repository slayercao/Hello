package com.slayer.cxj.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;

public class ShoppingCart extends AppCompatActivity {

    private CheckBox cb_tmall;
    private CheckBox cb_tmall_market;
    private CheckBox cb_iphone7;
    private CheckBox cb_iphone6;
    private CheckBox cb_cola;
    private CheckBox cb_pepsi;
    private CheckBox cb_select_all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        OnAllClickListener onAllClickListener = new OnAllClickListener();
        OnItemClickListener onItemClickListener = new OnItemClickListener();
        OnShopClickListener onShopClickListener = new OnShopClickListener();

        cb_select_all = (CheckBox) findViewById(R.id.select_all);
        cb_tmall = (CheckBox) findViewById(R.id.tmall);
        cb_tmall_market = (CheckBox) findViewById(R.id.tmall_market);
        cb_cola = (CheckBox) findViewById(R.id.cola);
        cb_pepsi = (CheckBox) findViewById(R.id.pepsi);
        cb_iphone7 = (CheckBox) findViewById(R.id.iphone7plus);
        cb_iphone6 = (CheckBox) findViewById(R.id.iphone6splus);

        cb_cola.setOnClickListener(onItemClickListener);
        cb_iphone6.setOnClickListener(onItemClickListener);
        cb_iphone7.setOnClickListener(onItemClickListener);
        cb_pepsi.setOnClickListener(onItemClickListener);
        cb_select_all.setOnClickListener(onAllClickListener);
        cb_tmall.setOnClickListener(onShopClickListener);
        cb_tmall_market.setOnClickListener(onShopClickListener);

    }

    class OnShopClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (((CheckBox) v).isChecked()) {
                if (v.getId() == R.id.tmall) {
                    cb_iphone7.setChecked(true);
                    cb_iphone6.setChecked(true);
                    if (cb_tmall_market.isChecked()) {
                        cb_select_all.setChecked(true);
                    }
                } else {
                    cb_pepsi.setChecked(true);
                    cb_cola.setChecked(true);
                    if (cb_tmall.isChecked()) {
                        cb_select_all.setChecked(true);
                    }
                }
            } else {
                if (v.getId() == R.id.tmall) {
                    cb_iphone6.setChecked(false);
                    cb_iphone7.setChecked(false);
                } else {
                    cb_cola.setChecked(false);
                    cb_pepsi.setChecked(false);
                }

                cb_select_all.setChecked(false);
            }
        }
    }

    class OnAllClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (((CheckBox) v).isChecked()) {
                cb_tmall.setChecked(true);
                cb_tmall_market.setChecked(true);
                cb_iphone6.setChecked(true);
                cb_iphone7.setChecked(true);
                cb_pepsi.setChecked(true);
                cb_cola.setChecked(true);
            } else {
                cb_tmall.setChecked(false);
                cb_tmall_market.setChecked(false);
                cb_iphone6.setChecked(false);
                cb_iphone7.setChecked(false);
                cb_pepsi.setChecked(false);
                cb_cola.setChecked(false);
            }
        }
    }

    class OnItemClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }
}
