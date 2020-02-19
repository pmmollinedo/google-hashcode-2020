package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import app.model.MyInputFile;
import app.model.MyOutputFile;
import app.model.Pizza;

public class App {

    private static final String INPUT_PATH = "./src/resources/input/";
    private static final String INPUT_EXTENSION = ".in";
    private static final String OUTPUT_PATH = "./src/resources/output/";
    private static final String OUTPUT_EXTENSION = ".out";

    private static String[] fileNameList = { "a_example", "b_small", "c_medium", "d_quite_big", "e_also_big" };

    public static void main(String[] args) throws Exception {

        for (String fileName : fileNameList) {

            File inputDataFile = new File(INPUT_PATH + fileName + INPUT_EXTENSION);
            File outputDataFile = new File(OUTPUT_PATH + fileName + OUTPUT_EXTENSION);

            // 1.- Read data from given file
            MyInputFile myInputFile = readInputFile(inputDataFile);
            // 2.- Do the logic to solve the problem
            MyOutputFile myOutputFile = solveProblem(myInputFile);
            // 3.- Write data
            writeOutputFile(outputDataFile, myOutputFile);
        }

    }

    private static MyInputFile readInputFile(File inputDataFile) {

        System.out.println("Reading data from file \"" + inputDataFile.getName() + "\"");

        MyInputFile myInputFile = new MyInputFile();

        String firstLine;
        String secondLine;

        try {
            // Read file
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputDataFile));

            // Read lines
            firstLine = bufferedReader.readLine();
            secondLine = bufferedReader.readLine();
            bufferedReader.close();

            // Extract data from first line
            String[] firstLineItems = firstLine.split(" ");
            myInputFile.setMaxSlices(Integer.parseInt(firstLineItems[0]));
            myInputFile.setNumberOfPizzas(Integer.parseInt(firstLineItems[1]));

            // Extract data from second line
            List<Pizza> pizzas = new ArrayList<>();
            String[] secondLineItems = secondLine.split(" ");
            for (int i = 0; i < secondLineItems.length; i++) {
                Pizza pizza = new Pizza();
                pizza.setPosition(i);
                pizza.setSlices(Integer.parseInt(secondLineItems[i]));
                pizzas.add(pizza);
            }
            myInputFile.setPizzas(pizzas);

            System.out.println("Data reading completed.");
        } catch (IOException e) {
            System.out.println("Error in data reading.");
            e.printStackTrace();
        }
        return myInputFile;
    }

    private static void writeOutputFile(File outputDataFile, MyOutputFile myOutputFile) {

        // Print output data and create output file
        FileWriter output;
        try {
            System.out.println("Writing data to file \"" + outputDataFile.getName() + "\"");

            output = new FileWriter(outputDataFile);

            // Write first line
            output.write(myOutputFile.getNumberOfOrderedPizzas() + "\n");

            // Write second line
            List<Integer> outputList = myOutputFile.getPizzaPositionsList();
            for (int i = 0; i < outputList.size(); i++) {
                if (i != (outputList.size() - 1)) {
                    output.write(outputList.get(i) + " ");// Add space after each item except the last
                } else {
                    output.write(outputList.get(i) + "");
                }
            }
            output.close();

            System.out.println("Data writing completed.");
        } catch (IOException e) {
            System.out.println("Error in data writing.");
            e.printStackTrace();
        }
    }

    private static MyOutputFile solveProblem(MyInputFile myInputFile) {

        MyOutputFile myOutputFile = new MyOutputFile();
        List<Integer> positionsList = new ArrayList<>();

        // Save the necessary data in variables.
        int max = myInputFile.getMaxSlices();
        int size = myInputFile.getNumberOfPizzas();
        int sum = 0;

        // Sum all possible values starting with the last item in the list.
        for (int i = size - 1; i >= 0; i--) {
            int currentPosition = myInputFile.getPizzas().get(i).getPosition();
            int currentNumber = myInputFile.getPizzas().get(i).getSlices();
            if (sum + currentNumber <= max) {
                sum += currentNumber;
                positionsList.add(currentPosition);
            }
        }

        // Sort the list with Collections class (in this case reverse method).
        Collections.reverse(positionsList);

        int numberOfOrderedPizzas = positionsList.size();
        myOutputFile.setNumberOfOrderedPizzas(numberOfOrderedPizzas);
        myOutputFile.setPizzaPositionsList(positionsList);

        return myOutputFile;
    }
}