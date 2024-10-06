package in.buildbytes.codem8;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    private Button button;
    private TextView login;
    private FirebaseAuth auth;
    private EditText EmailAddress,Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
            getWindow().setNavigationBarColor(getResources().getColor(R.color.bg)); // Set the navigation bar color
        }
        button=findViewById(R.id.button);
        login=findViewById(R.id.login);
        auth = FirebaseAuth.getInstance();
        EmailAddress=findViewById(R.id.EmailAddress);
        Password=findViewById(R.id.Password);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String user=EmailAddress.getText().toString().trim();
                String pass=Password.getText().toString().trim();
                auth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Register.this, "Signin Successfull", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Register.this, Dashboard.class));
                        }
                    }
                });
            }
        });
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View V){
                Intent i = new Intent(Register.this, Login.class);
                startActivity(i);
                finish();
            }
        });
    }
}