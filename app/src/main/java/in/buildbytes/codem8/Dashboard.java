package in.buildbytes.codem8;

import android.os.Bundle;
import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {
    private TextView emailview;
    FloatingActionButton mainbtn,post,manage;
    boolean aBoolean=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        mainbtn=findViewById(R.id.mainbtn);
        post=findViewById(R.id.posting);
        manage=findViewById(R.id.manage);
        emailview = findViewById(R.id.emailview);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // IMAGE SLIDER
        ImageSlider imageSlider =  findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.cmn, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slides, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.cmo, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.sli, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        CardView searchbarCardView = findViewById(R.id.searchbar);
        final SearchView searchView = findViewById(R.id.searchView);

        Intent intent = getIntent();
        String email = intent.getStringExtra("EMAIL");
        emailview.setText(email);

        // SEARCH BAR
        searchbarCardView.setOnClickListener(v -> {
            searchView.onActionViewExpanded();
            searchView.requestFocus();
        });

        mainbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(aBoolean){
                    post.show();
                    manage.show();
                    aBoolean=false;
                }else{
                    post.hide();
                    manage.hide();
                    aBoolean=true;
                }
            }
        });
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, PostHackathon.class);
                startActivity(intent);
            }
        });



    }
}