package in.buildbytes.codem8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class HackathonAdapter extends RecyclerView.Adapter<HackathonAdapter.HackathonViewHolder> {
    private Context context;
    private List<DataClass> hackathonList;

    public HackathonAdapter(Context context, List<DataClass> hackathonList) {
        this.context = context;
        this.hackathonList = hackathonList;
    }

    @NonNull
    @Override
    public HackathonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_hackathon, parent, false);
        return new HackathonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HackathonViewHolder holder, int position) {
        DataClass hackathon = hackathonList.get(position);
        holder.name.setText(hackathon.getDataNoh());
        holder.venue.setText("Venue: " + hackathon.getDataVenue());
        holder.date.setText("Date: " + hackathon.getData_date());
        holder.teamCount.setText("Team Size: " + hackathon.getData_count());

        // Set OnClickListener for the "View Details" button
        holder.viewDetailsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start a new activity with the selected hackathon data
                Intent intent = new Intent(context, HackathonDetails.class);
                intent.putExtra("hackathonName", hackathon.getDataNoh());
                intent.putExtra("hackathonVenue", hackathon.getDataVenue());
                intent.putExtra("hackathonDate", hackathon.getData_date());
                intent.putExtra("hackathonTeamCount", hackathon.getData_count());
                intent.putExtra("leaderName", hackathon.getLeaderName());
                intent.putExtra("currentTeamCount", hackathon.getCurrentTeamCount());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return hackathonList.size();
    }

    public static class HackathonViewHolder extends RecyclerView.ViewHolder {
        TextView name, venue, date, teamCount;
        Button viewDetailsBtn;

        public HackathonViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.hackathon_name);
            venue = itemView.findViewById(R.id.hackathon_venue);
            date = itemView.findViewById(R.id.hackathon_date);
            teamCount = itemView.findViewById(R.id.hackathon_teamcount);
            viewDetailsBtn = itemView.findViewById(R.id.view_details_btn);
        }
    }
}
