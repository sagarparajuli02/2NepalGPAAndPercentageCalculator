package com.sagar.plustwonepal;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {
    private String[] array = new String[]{"A+", "A", "B+", "B", "C+", "C", "D+", "D", "E", "N"};
    private TextView gpaPercentage;
    private Spinner s1;
    private Spinner s2;
    private Spinner s3;
    private Spinner s4;
    private Spinner s5;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdView mAdView = (AdView) findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        this.s1 = (Spinner) findViewById(R.id.spinner);
        this.s2 = (Spinner) findViewById(R.id.spinner2);
        this.s3 = (Spinner) findViewById(R.id.spinner3);
        this.s4 = (Spinner) findViewById(R.id.spinner4);
        this.s5 = (Spinner) findViewById(R.id.spinner5);
        this.gpaPercentage = (TextView) findViewById(R.id.gpa_tv);
        this.s1.setAdapter(new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, this.array));
        this.s2.setAdapter(new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, this.array));
        this.s3.setAdapter(new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, this.array));
        this.s4.setAdapter(new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, this.array));
        this.s5.setAdapter(new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, this.array));

    }

    public void calculate(View view) {

        float gpa = ((((getGPA(this.s1.getSelectedItem().toString()) + getGPA(this.s2.getSelectedItem().toString())) + getGPA(this.s3.getSelectedItem().toString())) + getGPA(this.s4.getSelectedItem().toString())) + getGPA(this.s5.getSelectedItem().toString()));
        this.gpaPercentage.setText("Your GPA : " + (gpa / 5.0f) + "\n" + "Your Grade: " + overallGrade(gpa / 5.0f) + "\n" + "Percentage:" + ((((((((getMeanPercentage(this.s1.getSelectedItem().toString()) + getMeanPercentage(this.s2.getSelectedItem().toString())) + getMeanPercentage(this.s3.getSelectedItem().toString())) + getMeanPercentage(this.s4.getSelectedItem().toString())) + getMeanPercentage(this.s5.getSelectedItem().toString())) ) ) ) / 5.0f) + "% +/-5%");
    }

    public float getGPA(String grade) {
        if (grade.equals("A+")) {
            return 4.0f;
        }
        if (grade.equals("A")) {
            return 3.6f;
        }
        if (grade.equals("B+")) {
            return 3.2f;
        }
        if (grade.equals("B")) {
            return 2.8f;
        }
        if (grade.equals("C+")) {
            return 2.4f;
        }
        if (grade.equals("C")) {
            return 2.0f;
        }
        if (grade.equals("D+")) {
            return 1.6f;
        }
        if (grade.equals("D")) {
            return 1.2f;
        }
        if (grade.equals("E")) {
            return 0.8f;
        }
        return 0.0f;
    }

    public String overallGrade(float gpa) {
        if (gpa >= 3.6f) {
            return "A+";
        }
        if (gpa >= 3.2f) {
            return "A";
        }
        if (gpa >= 2.8f) {
            return "B+";
        }
        if (gpa >= 2.4f) {
            return "B";
        }
        if (gpa >= 2.0f) {
            return "C+";
        }
        if (gpa >= 1.6f) {
            return "C";
        }
        if (gpa >= 1.2f) {
            return "D+";
        }
        if (gpa >= 0.8f) {
            return "D";
        }
        if (gpa > 0.0f) {
            return "E";
        }
        return "N";
    }

    public float getMeanPercentage(String grade) {
        if (grade.equals("A+")) {
            return 95.0f;
        }
        if (grade.equals("A")) {
            return 85.0f;
        }
        if (grade.equals("B+")) {
            return 75.0f;
        }
        if (grade.equals("B")) {
            return 65.0f;
        }
        if (grade.equals("C+")) {
            return 55.0f;
        }
        if (grade.equals("C")) {
            return 45.0f;
        }
        if (grade.equals("D+")) {
            return 35.0f;
        }
        if (grade.equals("D")) {
            return 25.0f;
        }
        if (grade.equals("E")) {
            return 10.0f;
        }
        return 0.0f;
    }

}
