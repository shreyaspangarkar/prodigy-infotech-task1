import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Conversion Program");
        System.out.println("-------------------------------");

        System.out.print("Enter the temperature value: ");
        double temperature = scanner.nextDouble();

        scanner.nextLine();

        System.out.print("Enter the original unit (Celsius, Fahrenheit, or Kelvin): ");
        String originalUnit = scanner.nextLine().toLowerCase();

        double convertedFahrenheit = 0;
        double convertedKelvin = 0;
        double convertedCelsius = 0;

        switch (originalUnit) {
            case "celsius":
                convertedFahrenheit = celsiusToFahrenheit(temperature);
                convertedKelvin = celsiusToKelvin(temperature);
                convertedCelsius = temperature; // No conversion needed for Celsius
                break;
            case "fahrenheit":
                convertedKelvin = fahrenheitToKelvin(temperature);
                convertedCelsius = fahrenheitToCelsius(temperature);
                convertedFahrenheit = temperature; // No conversion needed for Fahrenheit
                break;
            case "kelvin":
                convertedCelsius = kelvinToCelsius(temperature);
                convertedFahrenheit = kelvinToFahrenheit(temperature);
                convertedKelvin = temperature; // No conversion needed for Kelvin
                break;
            default:
                System.out.println("Invalid input unit. Please enter Celsius, Fahrenheit, or Kelvin.");
                System.exit(1);
        }

        System.out.println(temperature + " " + originalUnit + " is equal to:");
        System.out.printf("%.2f Fahrenheit%n", convertedFahrenheit);
        System.out.printf("%.2f Kelvin%n", convertedKelvin);
        System.out.printf("%.2f Celsius%n", convertedCelsius);
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double fahrenheitToKelvin(double fahrenheit) {
        double celsius = fahrenheitToCelsius(fahrenheit);
        return celsiusToKelvin(celsius);
    }

    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static double kelvinToFahrenheit(double kelvin) {
        double celsius = kelvinToCelsius(kelvin);
        return celsiusToFahrenheit(celsius);
    }
}
