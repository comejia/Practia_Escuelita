package compliance.providers;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVProvider {

    public static Object[] provideCheckArrayTestData() {
        ArrayList<Object> data = new ArrayList<Object>();

        String csvFile = "./input/sampleMultiplyCSVData.csv";

        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            //TODO: Should add some expected columns or format validation to avoid csv definition errors in test
            while ((line = reader.readNext()) != null) {

                //TODO: Should add type and existence validation
                int x = Integer.parseInt(line[0]);
                int y = Integer.parseInt(line[1]);
                int expected = Integer.parseInt(line[2]);

                System.out.println("X = " + x + ", Y = " + y + " , Expected Result = " + expected + "]");
                data.add(new Object[]{x, y, expected});
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return data.toArray();
    }

}
