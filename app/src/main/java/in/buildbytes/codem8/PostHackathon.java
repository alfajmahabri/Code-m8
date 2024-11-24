package in.buildbytes.codem8;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostHackathon extends AppCompatActivity {
    EditText noh, venue, eventdate, teamcount,leader,currentteamcount;
    Button upload;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_hackathon);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.white));
            getWindow().setNavigationBarColor(getResources().getColor(R.color.white)); // Set the navigation bar color
        }
        // Initialize Firebase Database reference
        databaseReference = FirebaseDatabase.getInstance().getReference("Hackathons");

        // Bind views
        noh = findViewById(R.id.noh);
        venue = findViewById(R.id.venue);
        eventdate = findViewById(R.id.event_date);
        teamcount = findViewById(R.id.teamcount);
        upload = findViewById(R.id.submit);
        leader = findViewById(R.id.leader);
        currentteamcount = findViewById(R.id.currentteamcount);

        // Set listener for the submit button
        upload.setOnClickListener(v -> {
            // Get data from the input fields
            String hackathonName = noh.getText().toString();
            String hackathonVenue = venue.getText().toString();
            String hackathonDate = eventdate.getText().toString();
            String leaderName = leader.getText().toString();
            int teamSize,currentTeamCount;

            try {
                teamSize = Integer.parseInt(teamcount.getText().toString());
                currentTeamCount = Integer.parseInt(currentteamcount.getText().toString());
            } catch (NumberFormatException e) {
                teamSize = 0;  // Handle the case if input is not a number
                currentTeamCount=0;
            }

            // Create a DataClass object
            DataClass hackathon = new DataClass(hackathonName, hackathonVenue, teamSize, hackathonDate,leaderName,currentTeamCount);

            // Store the data in Firebase
            String hackathonId = databaseReference.push().getKey();  // Generate a unique key for each hackathon
            if (hackathonId != null) {
                databaseReference.child(hackathonId).setValue(hackathon)
                        .addOnSuccessListener(aVoid -> {
                            // Data successfully written
                            Toast.makeText(PostHackathon.this, "Hackathon submitted successfully!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(PostHackathon.this, Dashboard.class);
                            startActivity(intent);
                            finish();
                        })
                        .addOnFailureListener(e -> {
                            // Data write failed
                            Toast.makeText(PostHackathon.this, "Failed to submit hackathon.", Toast.LENGTH_SHORT).show();
                        });
            }
        });
    }
}
