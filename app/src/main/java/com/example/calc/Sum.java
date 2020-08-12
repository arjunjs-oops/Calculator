package com.example.calc;

import android.widget.EditText;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Sum {
    public static void getSum(EditText value, TextView calc) {
        // Read the expression
        String txt = value.getText().toString();
        // Create an Expression (A class from exp4j library)

        try {
            Expression expression = new ExpressionBuilder(txt).build();
            double result = expression.evaluate();
            calc.setText(String.valueOf(result));
        } catch (IllegalArgumentException e) {
        } catch (ArithmeticException ex) {
            // Display an error message
            calc.setText(ex.getLocalizedMessage());

        }
    }
}
