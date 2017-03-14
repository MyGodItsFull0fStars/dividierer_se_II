package com.example.christianbauer.se_ii_dividierer;

import android.widget.EditText;

/**
 * Created by christianbauer on 14/03/2017.
 */

public class StringActivity {

    protected double checkForInvalidInputAndInsertIntoDouble(EditText checkText) {
        String checkForDouble = checkText.getText().toString();


		/*String regexPatternPoint = "-?([0-9]+[0-9]*\\.{1}[0-9]+[0-9]* | [0-9]+)";

		String regexPatternInteger = "-?[0-9]";

		if (checkForDouble.matches(regexPatternPoint) || checkForDouble.matches(regexPatternInteger)){
			return Double.parseDouble(checkForDouble);
		}*/
        return 0.0;
    }

    private String stringCorrection(String text) {

        // If String starts with period, append a zero in front
        if (text.indexOf(0) == '.') {
            text = "0" + text;
        }
        // If String starts with a comma, insert zero with a period instead
        else if (text.indexOf(0) == ',') {
            text = "0." + text.substring(1, text.length());
        }
        return text;
    }
}
