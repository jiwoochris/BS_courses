package juicyjung.gachon.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {
    Intent passedIntent;
    Bundle passedBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        EditText txtUrl = findViewById(R.id.url);
        EditText txtPhoneNumber = findViewById(R.id.phoneNumber);

        passedIntent = getIntent();
        if(passedIntent != null){
            passedBundle = passedIntent.getExtras();
            String userName = passedBundle.getString("userName");
            String userDepartment = passedBundle.getString("userDepartment");
            String userStudentId = passedBundle.getString("userStudentId");

            String text = "Student Info : " + userName + ", "
                    + userDepartment + ", "
                    + userStudentId;
            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
        }

        Button backButton = findViewById(R.id.back);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String url = txtUrl.getText().toString();
                String phoneNumber = txtPhoneNumber.getText().toString();

                passedBundle.putString("url", url);
                passedBundle.putString("phoneNumber", phoneNumber);

                passedIntent.putExtras(passedBundle);
                setResult(RESULT_OK, passedIntent);
                finish();
            }
        });
    }
}
