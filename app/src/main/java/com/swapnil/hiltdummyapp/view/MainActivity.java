package com.swapnil.hiltdummyapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.swapnil.hiltdummyapp.R;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//    @Inject
//    ArtistViewModel viewModel;

    public View parent;
    public EditText userName,password;
    public Button loginBtn;
    public TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parent = findViewById(R.id.parentContainer);
        userName = findViewById(R.id.etUserName);
        password = findViewById(R.id.etPassword);
        loginBtn = findViewById(R.id.btnLogin);
        resultView = findViewById(R.id.tvResult);

        loginBtn.setOnClickListener(this);

//        Single<ApiResponse> fromApi = service.getResponseFromApi();
//        viewModel.getDataFromApi("alanwalker");

    }

    @Override
    public void onClick(View view) {
        if(view == loginBtn){
            if(validateCreds(userName.getText().toString(),password.getText().toString())){
                resultView.setText("Login Success");
                parent.setBackgroundColor(Color.GREEN);
            }else{
                resultView.setText("Login Failure");
                parent.setBackgroundColor(Color.RED);
            }
        }
    }

    public boolean validateCreds(String userName, String password) {
        if(verifyInput(userName) && verifyInput(password)){
            return checkCredentials(userName,password);
        }else{
            return false;
        }

    }

    public boolean verifyInput(String userInput) {
        if (userInput == null || userInput.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkCredentials(String userName, String password){
        return userName.equals("xyz")  && password.equals("xyz");
    }
}