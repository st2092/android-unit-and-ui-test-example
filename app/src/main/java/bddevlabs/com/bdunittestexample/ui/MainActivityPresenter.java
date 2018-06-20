package bddevlabs.com.bdunittestexample.ui;

import java.io.InputStream;

import bddevlabs.com.bdunittestexample.data.model.Place;

public class MainActivityPresenter implements MainActivityContract.Listener {
    private final MainActivityContract.View view;

    public MainActivityPresenter(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void parseInputStream(InputStream inputStream) {
        Place disneyland = Place.readFromStream(inputStream);
        if (disneyland == null) {
            view.showPlaceNotFound();
            return;
        }

        String disneylandInfo = placeInformation(disneyland);
        view.showPlaceInformation(disneylandInfo);
    }

    private String placeInformation(Place place) {
        String info = place.name + "\n" + place.description;

        return info;
    }
}
