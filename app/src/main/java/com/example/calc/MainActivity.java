package com.example.calc;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button one, two, three, four, five, six, seven, eight, nine, zero, dot, equals, backspc, div, multi, subtract, addi;
    Button sin , ln,deci,zeroo;
    TextView calc;
    ImageView imageView;
    EditText value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potraite);
        setButtons();
        imageView = findViewById(R.id.rotate);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,landscape.class);
                startActivity(intent);
            }
        });
        setListener();

    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }


    private void setButtons() {

        //Instantiate all Buttons
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        equals = findViewById(R.id.equals);
        value = findViewById(R.id.value);
        calc = findViewById(R.id.result);
        addi = findViewById(R.id.addition);
        subtract = findViewById(R.id.sub);
        div = findViewById(R.id.divide);
        multi = findViewById(R.id.multiply);
        backspc = findViewById(R.id.clear);
        deci = findViewById(R.id.decimal);
        zeroo = findViewById(R.id.zero);


        // Landscape

        sin = findViewById(R.id.sin);
        ln = findViewById(R.id.log);
        backspc.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                value.setText("");
                calc.setText("");
                return false;
            }
        });

    }

    private void setListener() {
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        backspc.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        addi.setOnClickListener(this);
        subtract.setOnClickListener(this);
        div.setOnClickListener(this);
        multi.setOnClickListener(this);
       deci.setOnClickListener(this);
       zeroo.setOnClickListener(this);
        equals.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.one:
                value.append(one.getText());
                break;
            case R.id.two:
                value.append(two.getText());
                break;
            case R.id.three:
                value.append(three.getText());
                break;
            case R.id.four:
                value.append(four.getText());
                break;
            case R.id.five:
                value.append(five.getText());
                break;
            case R.id.six:
                value.append(six.getText());
                break;
            case R.id.seven:
                value.append(seven.getText());
                break;
            case R.id.eight:
                value.append(eight.getText());
                break;
            case R.id.nine:
                value.append(nine.getText());
                break;
            case R.id.sub:
                value.append(subtract.getText());
                break;
            case R.id.divide:
                value.append(div.getText());
                break;
            case R.id.decimal:
                value.append(deci.getText());
                break;
            case R.id.zero:
                value.append(zeroo.getText());
                break;

            case R.id.multiply:
                value.append(multi.getText());
                break;
            case R.id.sin:
                value.append(sin.getText());
            case R.id.equals:
                getSum();
                break;
            case R.id.addition:
                if (value.getText() == null) {
                    break;
                }
                value.append(addi.getText());
                break;
            case R.id.clear:
                int length = value.getText().length();
                if (length > 0) {
                    value.getText().delete(length - 1, length);
                    calc.setText("");
                    Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
                }
                break;

            default:
                break;
        }

    }
    private void getSum() {
        // Read the expression
        String txt = value.getText().toString();
        // Create an Expression (A class from exp4j library)

        try {
            Expression expression = new ExpressionBuilder(txt).build();
            double result = expression.evaluate();
            calc.setText(String.valueOf(result));
        } catch (IllegalArgumentException e) {
            Toast.makeText(this, "Enter The Values", Toast.LENGTH_SHORT).show();
        } catch (ArithmeticException ex) {
            // Display an error message
            calc.setText(ex.getLocalizedMessage());

        }
    }
}
