package adventofcode.day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Measurement {

    private List<String>measurements = new ArrayList<>();

    public void addToList(Path path) throws IOException {
        List<String> temp = Files.readAllLines(path);
        measurements = temp;
    }

    public int getNumberOfIncreasing(List<String> measurements){
        int counter = 0;
        for (int i = 1; i < measurements.size(); i++){
            if(Integer.parseInt(measurements.get(i)) > Integer.parseInt(measurements.get(i - 1))){
                counter++;
            }
        }
        return counter;
    }

    public List<String> getMeasurements() {
        return measurements;
    }

    public static void main(String[] args) {
        Measurement measurement = new Measurement();
        try{
            measurement.addToList(Paths.get("src/main/resources/measurement.txt"));
        }catch (IOException ioe){
            throw new IllegalStateException("Cant read",ioe);
        }
        System.out.println(measurement.getNumberOfIncreasing(measurement.measurements));

    }
}
