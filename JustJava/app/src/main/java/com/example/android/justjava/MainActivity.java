package com.example.android.justjava;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Decrement quantity button
     */
    public void decrement(View view)
    {
        if(quantity == 1)
        {
            Toast.makeText(this, "Cannot less more 1 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity--;
        displayQuantity();
    }

    /**
     * Increment quantity button
     */
    public void increment(View view)
    {
        if(quantity == 100)
        {
            Toast.makeText(this, "Cannot more than 100 coffees", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity++;
        displayQuantity();
    }

    /**
     * Order button
     */
    public void submitOrder(View view)
    {
        CheckBox checkboxWhippedCream = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = checkboxWhippedCream.isChecked();

        CheckBox checkboxChocolate = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = checkboxChocolate.isChecked();

        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        String summary = "Name: "+ name;
        summary += "\nAdd whipped cream? "+ hasWhippedCream;
        summary += "\nAdd Chocolate? "+ hasChocolate;
        summary += "\nQuantity: "+ quantity;
        summary += "\nTotal: $"+ calculatePrice(5, hasWhippedCream, hasChocolate);
        summary += "\n"+getString(R.string.thank_you);

        /**
         * Intent Email
         */

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, "Just Java order for "+name);
        intent.putExtra(Intent.EXTRA_SUBJECT, summary);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * METHODS
     */

    /**
     * Display quantity
     */
    public void displayQuantity()
    {
        TextView quantity = (TextView) findViewById(R.id.quantity_text_view);
        quantity.setText("" + this.quantity);
    }

    /**
     * caculate Price
     */
    public int calculatePrice(int basePrice, boolean addWhippedCream, boolean addChocolate)
    {
        if(addWhippedCream)
            basePrice += 1;
        if(addChocolate)
            basePrice += 2;
        return quantity * basePrice;
    }
}
