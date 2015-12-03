package csci325.csu.spendingtracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class SetupActivity extends AppCompatActivity {
    //Resources res = getResources();
    private Button mSubmit;
    private EditText mIncomeEdit;
    private String incomeAmount;
    private TextView incomeUp;

    private double income;
    public ArrayList categoryList = new ArrayList();
    //private String incomeUpdate = getResources().getString(R.string.SUUpdate);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSubmit = (Button)findViewById(R.id.button);
        mIncomeEdit = (EditText)findViewById(R.id.editText);
        incomeUp = (TextView)findViewById(R.id.textView3);

        mSubmit.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        Log.v("EditText", mIncomeEdit.getText().toString());
                        incomeAmount = mIncomeEdit.getText().toString();
                        String incomeUpdate = new String();
                        incomeUp.append(incomeAmount);
                    }

                }
        );

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



}
