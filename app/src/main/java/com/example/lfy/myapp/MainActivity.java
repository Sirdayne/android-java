package com.example.lfy.myapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int numberOfCoffees = 0;
    boolean withMilk = false;
    String withMilkResult = "No";
    String yourName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This methods inc or dec numberOfCoffees
     */
    public void increment(View view) {
        numberOfCoffees++;
        display(numberOfCoffees);
    }

    public void decrement(View view) {
        numberOfCoffees--;
        if (numberOfCoffees < 0){
            numberOfCoffees = 0;
            GlobalMethods.showToast("You cant order less than 0", this);
        }

        display(numberOfCoffees);
    }

    public void showToast (String message){
        Toast mToast = new Toast(getApplicationContext());
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        mToast.show();
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        //displayPrice(numberOfCoffees * 5);
        //String priceMessage="Ordered number: " + numberOfCoffees + ", price: " + numberOfCoffees*5;
        EditText editTextName = (EditText) findViewById(R.id.edit_text_name);
        yourName = editTextName.getText().toString();

        CheckBox checkBoxMilk = (CheckBox) findViewById(R.id.checkbox_milk);
        if (checkBoxMilk.isChecked()) {
            withMilk = true;
        } else {
            withMilk = false;
        }

        String priceMessage = "\nName: " + yourName;
        if (withMilk) {
            withMilkResult = "Yes";
        } else {
            withMilkResult = "No";
        }
        priceMessage += "\nWith milk: " + withMilkResult;
        priceMessage += "\nQuantity: " + numberOfCoffees;
        priceMessage += "\nTotal: " + numberOfCoffees * 5;
        priceMessage += "\nThank you!";
        displayMessage(priceMessage);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}