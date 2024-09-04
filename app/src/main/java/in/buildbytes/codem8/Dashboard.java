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
    private FloatingActionButton fab,fabOption1,fabOption2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        emailview = findViewById(R.id.emailview);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageSlider imageSlider =  findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.cmn, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.slides, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.cmo, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.sli, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels,ScaleTypes.FIT);
        CardView searchbarCardView = findViewById(R.id.searchbar);
        final SearchView searchView = findViewById(R.id.searchView);
        Intent intent = getIntent();
        String email = intent.getStringExtra("EMAIL");
        emailview.setText(email);
        searchbarCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchView.onActionViewExpanded();
                searchView.requestFocus();
            }
        });
        fab=findViewById(R.id.fab);
        FloatingActionButton fabOption1 = findViewById(R.id.fab_option1);
        FloatingActionButton fabOption2 = findViewById(R.id.fab_option2);
        fab.setOnClickListener(new View.OnClickListener() {
            boolean isFabOpen = false;

            @Override
            public void onClick(View v) {
                if (!isFabOpen) {
                    fabOption1.setVisibility(View.VISIBLE);
                    fabOption2.setVisibility(View.VISIBLE);

                   

                    isFabOpen = true;
                } else {
                    fabOption1.animate().translationY(0);
                    fabOption2.animate().translationY(0).withEndAction(new Runnable() {
                        @Override
                        public void run() {
                            fabOption1.setVisibility(View.GONE);
                            fabOption2.setVisibility(View.GONE);
                        }
                    });

                    isFabOpen = false;
                }
            }
        });
    }
}