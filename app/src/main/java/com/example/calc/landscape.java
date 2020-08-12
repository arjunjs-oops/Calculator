package com.example.calc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class landscape extends AppCompatActivity implements View.OnClickListener {
   private   ImageView imageView;
   private Button one, two, three, four, five, six, seven, eight, nine, zero, dot, equals, backspc, div, multi, subtract, addi;
   private Button sin,cos,tan,log,deci,zeroo,pie,exp,lbrace,rbrace,root,pow,mod;
   private TextView calc;
   private EditText value;
    private static final String TAG = "landscape";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landscape);
        imageView = findViewById(R.id.rotate);
        setButtons();
        setListener();

        Bundle data = getIntent().getExtras();
        if (data!= null){
            value.setText(data.getString("Data"));
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_val = value.getText().toString();
                String res = calc.getText().toString();
                Intent intent = new Intent(landscape.this,MainActivity.class);
                if(res.length()!=0)
                    intent.putExtra("Data_Land",res);

                else
                intent.putExtra("Data_Land",user_val);
                startActivity(intent);

            }
        });
    }

    boolean doubleBackToExitPressedOnce = false;



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
        cos = findViewById(R.id.cos);
        tan = findViewById(R.id.tan);
        log = findViewById(R.id.log);
        pie = findViewById(R.id.piey);
        root = findViewById(R.id.root);
        pow = findViewById(R.id.pow);
        exp = findViewById(R.id.expo);
        lbrace = findViewById(R.id.lfbrac);
        rbrace = findViewById(R.id.rtbarce);
        mod = findViewById(R.id.mod);
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


        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        tan.setOnClickListener(this);
        log.setOnClickListener(this);
        lbrace.setOnClickListener(this);
        rbrace.setOnClickListener(this);
        exp.setOnClickListener(this);
        pie.setOnClickListener(this);
        equals.setOnClickListener(this);
        root.setOnClickListener(this);
        mod.setOnClickListener(this);
        pow.setOnClickListener(this);

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
            case R.id.sin:
                value.append(sin.getText());
                break;
            case R.id.mod:
                value.append(mod.getText());
                break;
            case R.id.cos:
                value.append(cos.getText());
                break;
            case R.id.tan:
                value.append(tan.getText());
                break;
            case R.id.piey:
                value.append(pie.getText());
                break;
            case R.id.zero:
                value.append(zeroo.getText());
                break;

            case R.id.expo:
                value.append(exp.getText());
                break;
            case R.id.lfbrac:
                value.append(lbrace.getText());
                break;
            case R.id.rtbarce:
                value.append(rbrace.getText());
                break;
            case R.id.log:
                value.append(log.getText());
                break;
            case R.id.pow:
                value.append(pow.getText());
                break;
            case R.id.root:
                value.append("sqrt");
                break;

            case R.id.multiply:
                value.append(multi.getText());
                break;
            case R.id.equals:
                Sum.getSum(value,calc);
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
                }
                break;

            default:
                break;
        }
    }

}