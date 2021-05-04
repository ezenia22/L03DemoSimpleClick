package sg.edu.rp.c346.id20011155.demosimpleclick;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    Button btnDisplay;
    TextView tvDisplay;
    EditText etInput;
    ToggleButton tgButton;
    RadioGroup rgGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDisplay = findViewById(R.id.btnDisplay);
        tvDisplay = findViewById(R.id.tvDisplay);
        etInput = findViewById(R.id.etInput);
        tgButton = findViewById(R.id.tgButton);
        rgGender = findViewById(R.id.rgGender);

        String abc = tvDisplay.getText().toString();

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String abc = etInput.getText().toString();
                if (abc.isEmpty()) {
                    tvDisplay.setText("Nothing has been entered");
                    Toast.makeText(MainActivity.this,
                            "Please input something", Toast.LENGTH_SHORT).show();
                } else {
                    tvDisplay.setText(abc);
                    int checkRadioId = rgGender.getCheckedRadioButtonId();
                    if (checkRadioId == R.id.rbMale) {
                        tvDisplay.setText("He says " + abc);
                    } else {
                        tvDisplay.setText("She says " + abc);
                    }
                }
            }
        });
        tgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tgButton.isChecked() == true) {
                    etInput.setEnabled(true);
                    etInput.setBackgroundColor(Color.TRANSPARENT);
                } else {
                    etInput.setEnabled(false);
                    etInput.setBackgroundColor(Color.GRAY);
                }
            }
        });
    }
}