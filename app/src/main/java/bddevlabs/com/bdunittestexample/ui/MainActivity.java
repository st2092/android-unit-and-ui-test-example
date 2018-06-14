package bddevlabs.com.bdunittestexample.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.InputStream;

import bddevlabs.com.bdunittestexample.R;
import bddevlabs.com.bdunittestexample.data.model.Place;

public class MainActivity extends AppCompatActivity {

    public void showDisneylandInfo(View view) {
        InputStream inputStream = getApplication().getResources().openRawResource(R.raw.disneyland);
        Place disneyland = Place.readFromStream(inputStream);

        updateTextViewWithPlaceInfo(disneyland);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Place Info");
    }

    private void updateTextViewWithPlaceInfo(Place place) {
        if (place == null) return;
        TextView placeInfoTextView = findViewById(R.id.placeInfoTextView);
        String placeInfo = place.name + "\n" + place.description;

        placeInfoTextView.setText(placeInfo);
    }
}
