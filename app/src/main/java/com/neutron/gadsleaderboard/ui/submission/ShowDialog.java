package com.neutron.gadsleaderboard.ui.submission;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;

import com.neutron.gadsleaderboard.R;

public class ShowDialog extends Dialog implements View.OnClickListener {
    private int layout;
    private UserDetailsModel user;
    private Context context;

    public ShowDialog(@NonNull Context context, int layout) {
        super(context);
        this.context = context;
        this.layout = layout;
    }

    public ShowDialog(@NonNull Context context, int layout,UserDetailsModel user) {
        super(context);
        this.context = context;
        this.layout = layout;
        this.user = user;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(layout);
        if(layout == R.layout.verification_dialog){
            Button yes = findViewById(R.id.yes_btn);
            ImageButton no = findViewById(R.id.cancel_submit);

            yes.setOnClickListener(this);
            no.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.yes_btn:
                int response = SubmitApiBuilder.submitDetails(user);
                if(response != 0){
                    ShowDialog showDialog = new ShowDialog(context,R.layout.submission_successful_dialog);
                    showDialog.show();
                    dismiss();
                }else{
                    ShowDialog showDialog = new ShowDialog(context,R.layout.submission_failed_dialog);
                    showDialog.show();
                    dismiss();
                }
                break;
            case R.id.cancel_submit:
                dismiss();
                break;
        }
    }
}
