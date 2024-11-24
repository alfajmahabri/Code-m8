package in.buildbytes.codem8;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HackathonDetails extends AppCompatActivity {
    private TextView hackathonName, hackathonVenue, hackathonDate, hackathonTeamCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hackathon_details);

        hackathonName = findViewById(R.id.hackathon_name);
        hackathonVenue = findViewById(R.id.hackathon_venue);
        hackathonDate = findViewById(R.id.hackathon_date);
        hackathonTeamCount = findViewById(R.id.hackathon_teamcount);
        Button connectButton = findViewById(R.id.connect_button);

        // Get data from the intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("hackathonName");
        String venue = intent.getStringExtra("hackathonVenue");
        String date = intent.getStringExtra("hackathonDate");
        String teamCount = intent.getStringExtra("hackathonTeamCount");

        // Set data to the views
        hackathonName.setText(name);
        hackathonVenue.setText("Venue: " + venue);
        hackathonDate.setText("Date: " + date);
        hackathonTeamCount.setText("Team Size: " + teamCount);

        connectButton.setOnClickListener(view -> {
            // Change button color on click
            connectButton.setBackgroundColor(getResources().getColor(R.color.colorPressed));
            // Disable the button after clicking (optional)
            connectButton.setEnabled(false);
        });
    }
}
