package bddevlabs.com.bdunittestexample.data.model;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Place {
    public static final String ID_PREFIX = "id=";
    public static final String NAME_PREFIX = "name=";
    public final String id;
    public final String name;
    public final String description;


    private Place(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public static Place readFromStream(InputStream stream) {
        if (stream == null) return null;

        String id = null;
        String name = null;
        StringBuilder descriptionBuilder = new StringBuilder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        try {
            String line = reader.readLine();
            while (line != null) {
                if (line.startsWith(ID_PREFIX)) {
                    id = line.substring(ID_PREFIX.length());
                } else if (line.startsWith(NAME_PREFIX)) {
                    name = line.substring(NAME_PREFIX.length());
                } else {
                    if (descriptionBuilder.length() > 0) {
                        descriptionBuilder.append("\n");
                    }
                    descriptionBuilder.append(line);
                }

                line = reader.readLine();
            }

        } catch  (Exception e) {
            e.printStackTrace();
            return null;
        }

        return new Place(id, name, descriptionBuilder.toString());
    }
}
