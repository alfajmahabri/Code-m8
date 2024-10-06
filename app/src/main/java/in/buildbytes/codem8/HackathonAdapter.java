package in.buildbytes.codem8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

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
        holder.venue.setText("Venue: " +hackathon.getDataVenue());
        holder.date.setText(String.valueOf("Date: " + hackathon.getData_date()));
        holder.teamCount.setText(String.valueOf("Time Size: " + hackathon.getData_count()));
    }

    @Override
    public int getItemCount() {
        return hackathonList.size();
    }

    public static class HackathonViewHolder extends RecyclerView.ViewHolder {
        TextView name, venue, date, teamCount;

        public HackathonViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.hackathon_name);
            venue = itemView.findViewById(R.id.hackathon_venue);
            date = itemView.findViewById(R.id.hackathon_date);
            teamCount = itemView.findViewById(R.id.hackathon_teamcount);
        }
    }
}
