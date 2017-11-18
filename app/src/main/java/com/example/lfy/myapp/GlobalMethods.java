package com.example.lfy.myapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class GlobalMethods extends AppCompatActivity {
    public static void showToast(String msg, Context ctx) {
        Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show();
    }
}