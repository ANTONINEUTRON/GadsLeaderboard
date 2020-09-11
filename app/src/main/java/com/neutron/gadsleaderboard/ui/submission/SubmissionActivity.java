package com.neutron.gadsleaderboard.ui.submission;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.neutron.gadsleaderboard.R;

public class SubmissionActivity extends AppCompatActivity {
    EditText fname,lname,email,github;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fname = findViewById(R.id.first_name);
        lname = findViewById(R.id.last_name);
        email = findViewById(R.id.email);
        github = findViewById(R.id.github);

        submit = findViewById(R.id.submit_btn);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserDetailsModel user = new UserDetailsModel(
                        email.getText().toString(),
                        fname.getText().toString(),
                        lname.getText().toString(),
                        github.getText().toString()
                );
                ShowDialog showDialog = new ShowDialog(SubmissionActivity.this,R.layout.verification_dialog,user);
                showDialog.show();
            }
        });


    }
}