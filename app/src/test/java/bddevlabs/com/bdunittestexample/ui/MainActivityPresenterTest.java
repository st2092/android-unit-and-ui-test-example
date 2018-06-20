package bddevlabs.com.bdunittestexample.ui;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.io.InputStream;

import static org.junit.Assert.*;

public class MainActivityPresenterTest {
    private MainActivityContract.View view;
    private MainActivityPresenter presenter;

    /**
     * Runs before each test.
     */
    @Before
    public void setup() {
        view = Mockito.mock(MainActivityContract.View.class);
        presenter = new MainActivityPresenter(view);
    }

    @Test
    public void placeNotFound() {
        presenter.parseInputStream(null);

        Mockito.verify(view, Mockito.times(1)).showPlaceNotFound();
    }

    @Test
    public void loadDisneylandInfo() {
        InputStream stream = MainActivityPresenterTest.class.getResourceAsStream("/disneyland.txt");
        presenter.parseInputStream(stream);

        // captures the argument passed into function and compare it to the expected result
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        Mockito.verify(view, Mockito.times(0)).showPlaceNotFound();
        Mockito.verify(view, Mockito.times(1))
                .showPlaceInformation(stringArgumentCaptor.capture());

        String expectedResult = "Disneyland\n" +
                "1313 Disneyland Dr\n" +
                "Anaheim, CA 92802\n" +
                "\n" +
                "Disneyland Park, originally Disneyland, is the first of two theme parks built at " +
                "the Disneyland Resort in Anaheim, California, opened on July 17, 1955. It is the " +
                "only theme park designed and built under the direct supervision of Walt Disney";
        assertEquals(expectedResult, stringArgumentCaptor.getAllValues().get(0));
    }

}