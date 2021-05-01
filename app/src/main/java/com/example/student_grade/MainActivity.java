package com.example.student_grade;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editGrade1, editGrade2, editGrade3;
    EditText editSubName1, editSubName2, editSubName3;
    TextView textMaxGrade, textMinGrade, textAvgGrade;

    public static String sub1 = "Subject 1", sub2 = "Subject 2", sub3 = "Subject 3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onSubmit(View view) {
        editGrade1  = (EditText) findViewById(R.id.editGrade1);
        editGrade2  = (EditText) findViewById(R.id.editGrade2);
        editGrade3  = (EditText) findViewById(R.id.editGrade3);

        String message = "";

        int grade1 = 0;
        int grade2 = 0;
        int grade3 = 0;
        int maxGrade = 0;
        int minGrade = 0;
        int avgGrade = 0;

        try {
            grade1 = Integer.parseInt(editGrade1.getText().toString());
            grade2 = Integer.parseInt(editGrade2.getText().toString());
            grade3 = Integer.parseInt(editGrade3.getText().toString());

            if (grade1 > 100 || grade2 > 100 || grade3 > 100) {
                throw new Exception();
            }
            else {
                textMinGrade  = (TextView) findViewById(R.id.textViewMinGrade);
                textMaxGrade  = (TextView) findViewById(R.id.textViewMaxGrade);
                textAvgGrade  = (TextView) findViewById(R.id.textViewAvgGrade);

                message = "Grades = " + grade1 + " " + grade2 + " " + grade3;

                if (grade1 > maxGrade)
                    maxGrade = grade1;
                if (grade2 > maxGrade)
                    maxGrade = grade2;
                if (grade3 > maxGrade)
                    maxGrade = grade3;

                minGrade = maxGrade;

                if (grade1 < maxGrade)
                    minGrade = grade1;
                if (grade2 < minGrade)
                    minGrade = grade2;
                if (grade3 < minGrade)
                    minGrade = grade3;

                avgGrade = (grade1 + grade2 + grade3) / 3;

                textMinGrade.setText("Min : " + this.getLetterGrade(minGrade));
                textMaxGrade.setText("Max : " + this.getLetterGrade(maxGrade));
                textAvgGrade.setText("Avg : " + this.getLetterGrade(avgGrade));
            }
        }
        catch (Exception e) {
            message = "Make sure grades are numbers and are between 1-100!";
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void register_click(View view) {
        editSubName1  = (EditText) findViewById(R.id.editSubName1);
        editSubName2  = (EditText) findViewById(R.id.editSubName2);
        editSubName3  = (EditText) findViewById(R.id.editSubName3);

        String sub1Text = editSubName1.getText().toString();
        String sub2Text = editSubName2.getText().toString();
        String sub3Text = editSubName3.getText().toString();

        String message = "";

        if (!sub1Text.trim().isEmpty() && !sub2Text.trim().isEmpty() && !sub3Text.trim().isEmpty()) {
            sub1 = sub1Text;
            sub2 = sub2Text;
            sub3 = sub3Text;
            message = "Subjects added click back.";
        }
        else {
            message = "All subject names are required!";
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public String getLetterGrade(int grade) {
        String result = "F";
        if (grade >= 90)
            result = "A";
        if (grade >= 80 && grade < 90)
            result = "B";
        if (grade >= 70 && grade < 80)
            result = "C";

        return result;
    }
}