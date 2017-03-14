package com.example.christianbauer.se_ii_dividierer;

import android.widget.EditText;

/**
 * Created by christianbauer on 14/03/2017.
 */

public class StringActivity {

    protected double checkForInvalidInputAndInsertIntoDouble(EditText checkText) {
        String checkForDouble = stringCorrection(checkText.getText().toString());
        return Double.parseDouble(checkForDouble);

		/* Regex did not work out. Kept for later check.

		String regexPatternPoint = "-?([0-9]+[0-9]*\\.{1}[0-9]+[0-9]* | [0-9]+)";
		String regexPatternInteger = "-?[0-9]";

		if (checkForDouble.matches(regexPatternPoint) || checkForDouble.matches(regexPatternInteger)){
			return Double.parseDouble(checkForDouble);
		}*/

    }

    protected String stringCorrection(String text) {

    // For better user experience, try to save as many wrong inputs as acceptable

        int index = findIndex(text);

        // If String is empty, set it to 0.0
        if (text.isEmpty()){
            text = "0.0";
        }
        // If greater -1 than there is a period or comma in String
        else if (index > -1) {
            // If String starts with period, append a zero in front
            if (text.charAt(0) == '.') {
                text = "0" + text;
            }
            // If String starts with minus and second char is a period, insert zero at second index and append substring.
            else if (text.charAt(0) =='-' && text.charAt(1) == '.') {
                text = text.charAt(0) + "0" + text.substring(1) + "0";
                if (text.equals("-0.0")){
                    text = "0.0";
                }
            }
        }
        return text;
    }

    // Returns the index of a period or a comma, if none found returns -1.
    private int findIndex(String text) {
        int index = -1;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '.') {
                return i;
            }
        }
        return index;
    }
}
