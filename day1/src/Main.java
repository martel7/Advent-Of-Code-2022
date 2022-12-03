import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        part1();
        System.out.println("#############################");
        part2();
    }

    public static void part1(){
        File input = new File("input.txt");

        Scanner scanner = null;

        try {
            scanner = new Scanner(input);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int maxCalElfIndex = 0, elfCals = 0, i = 0, maxElfCals = 0;
        String line;

        while(scanner.hasNextLine()){
            line = scanner.nextLine();

            if(!line.equals("")){
                elfCals += Integer.parseInt(line);
            }
            else{
                if(elfCals > maxElfCals){
                    maxCalElfIndex = i;
                    maxElfCals = elfCals;
                }

                elfCals = 0;

                i++;
            }
        }

        System.out.println("Max calories elf index is: " + maxCalElfIndex);
        System.out.println("He has: " + maxElfCals + " calories on him");
    }

    public static void part2() {

        File input = new File("input.txt");

        Scanner scanner = null;

        try {
            scanner = new Scanner(input);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int elfCals = 0;
        String line;
        List<Integer> caloriesList = new ArrayList<>();

        while(scanner.hasNextLine()){
            line = scanner.nextLine();

            if(!line.equals("")){
                elfCals += Integer.parseInt(line);
            }
            else{
                caloriesList.add(elfCals);
                elfCals = 0;
            }
        }

        Collections.sort(caloriesList);
        Collections.reverse(caloriesList);

        System.out.println("Max calories elf: " + caloriesList.get(0));
        System.out.println("second Max calories elf: " + caloriesList.get(1));
        System.out.println("trhind Max calories elf: " + caloriesList.get(2));
        System.out.println("");
        System.out.printf("Together they have %s%n", caloriesList.get(0) + caloriesList.get(1) + caloriesList.get(2));
    }
}