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
		resultView = (TextView) findViewById(R.id.result);


		calculate = (Button) findViewById(R.id.calculate);
		calculate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				double nomD = 0.0;
				double denomD = 0.0;

				nomD = checkForInvalidInputAndInsertIntoDouble(nominator);
				denomD = checkForInvalidInputAndInsertIntoDouble(denominator);

				calculation(nomD, denomD);


			}
		});
	}


	// Handles the calculation + exceptions
	protected void calculation(double nominator, double denominator) {
		double result = 0.0;


		if (denominator == 0) {
			resultView.setText(R.string.zeroOrWrongInput);
		} else {
			result = nominator / denominator;
			resultView.setText(Double.toString(result));
		}

	}

	// Check with regex if input is double
	// If not, zero will be returned to get error message
	protected double checkForInvalidInputAndInsertIntoDouble(EditText checkText) {
		String checkForDouble = checkText.getText().toString();
		String regexPatternPoint = "-?([0-9]+[0-9]*\\.{1}[0-9]+[0-9]* | [0-9]+)";

		String regexPatternInteger = "-?[0-9]";

		if (checkForDouble.matches(regexPatternPoint) || checkForDouble.matches(regexPatternInteger)){
			return Double.parseDouble(checkForDouble);
		}
		return 0.0;
	}

}
