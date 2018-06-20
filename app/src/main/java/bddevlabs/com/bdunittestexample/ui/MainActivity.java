package bddevlabs.com.bdunittestexample.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.InputStream;

import bddevlabs.com.bdunittestexample.R;
import bddevlabs.com.bdunittestexample.data.model.Place;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {
    private MainActivityPresenter presenter = null;
    public final String ERROR_MESSAGE = "Can't find the designated place";

    public void showDisneylandInfo(View view) {
        InputStream inputStream = getApplication().getResources().openRawResource(R.raw.disneyland);
        presenter.parseInputStream(inputStream);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Place Info");

        presenter = new MainActivityPresenter(this);
    }

    private void updateTextViewWithPlaceInfo(Place place) {
        if (place == null) return;
        TextView placeInfoTextView = findViewById(R.id.placeInfoTextView);
        String placeInfo = place.name + "\n" + place.description;

        placeInfoTextView.setText(placeInfo);
    }

    @Override
    public void showPlaceInformation(String information) {
        TextView placeInfoTextView = findViewById(R.id.placeInfoTextView);

        placeInfoTextView.setText(information);
    }

    @Override
    public void showPlaceNotFound() {
        TextView placeInfoTextView = findViewById(R.id.placeInfoTextView);

        placeInfoTextView.setText(ERROR_MESSAGE);
    }
}
