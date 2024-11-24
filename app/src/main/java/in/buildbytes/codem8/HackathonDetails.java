package in.buildbytes.codem8;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HackathonDetails extends AppCompatActivity {
    private TextView hackathonName, hackathonVenue, hackathonDate, hackathonTeamCount, leaderNameTextView, currentTeamCountTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hackathon_details);

        hackathonName = findViewById(R.id.hackathon_name);
        hackathonVenue = findViewById(R.id.hackathon_venue);
        hackathonDate = findViewById(R.id.hackathon_date);
        hackathonTeamCount = findViewById(R.id.hackathon_teamcount);
        leaderNameTextView = findViewById(R.id.leader_name);
        currentTeamCountTextView = findViewById(R.id.current_teamcount);
        Button connectButton = findViewById(R.id.connect_button);

        // Get data from the intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("hackathonName");
        String venue = intent.getStringExtra("hackathonVenue");
        String date = intent.getStringExtra("hackathonDate");
        String leaderName = intent.getStringExtra("leaderName");
        int currentTeamCount = intent.getIntExtra("currentTeamCount", 0);
        int teamCount = intent.getIntExtra("hackathonTeamCount", 0);

        // Set data to the views
        hackathonName.setText(name);
        hackathonVenue.setText(venue);
        hackathonDate.setText(date);
        hackathonTeamCount.setText(String.valueOf(teamCount));
        leaderNameTextView.setText(leaderName);
        currentTeamCountTextView.setText(String.valueOf(currentTeamCount));

        connectButton.setOnClickListener(view -> {
            // Change button color on click
            connectButton.setBackgroundColor(getResources().getColor(R.color.colorPressed));
            // Disable the button after clicking (optional)
            connectButton.setEnabled(false);
        });
    }
}