package com.example.christianbauer.se_ii_dividierer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

	EditText nominator;
	EditText denominator;
	TextView resultView;
	Button calculate;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		// Calculation starts here

		denominator = (EditText) findViewById(R.id.denominator);
		nominator = (EditText) findViewById(R.id.numerator);


		calculate = (Button) findViewById(R.id.calculate);
		calculate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				double nomD = Double.parseDouble(nominator.getText().toString());
				double denomD = Double.parseDouble(denominator.getText().toString());

				double result = calculation(nomD, denomD);
				resultView.setText(Double.toString(result));

			}
		});
	}


	// Handles the calculation + exceptions
	protected double calculation(double nominator, double denominator) {
		double result = 0.0;


		if (denominator == 0) {
			throw new ArithmeticException("Can't divide with zero!");
		} else {
			result = nominator / denominator;
		}

		return result;
	}


}
