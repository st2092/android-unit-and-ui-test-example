package bddevlabs.com.bdunittestexample.ui;

import java.io.InputStream;

public interface MainActivityContract {

    /**
     * Allows presenter to talk to the view.
     */
    interface View {
        void showPlaceInformation(String information);
        void showPlaceNotFound();
    }

    /**
     * Allows the view to talk to the presenter.
     */
    interface Listener {
        void parseInputStream(InputStream inputStream);
    }
}
