package codes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CurrencyConverter {

    public static void main(String[] args) {
        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter the code of the source currency: ");
            String sourceCurrency = reader.readLine().toUpperCase();

            System.out.print("Enter the code of the target currency: ");
            String targetCurrency = reader.readLine().toUpperCase();

            System.out.print("Enter amount to convert: ");
            double amount = Double.parseDouble(reader.readLine());

            double convertedAmount = convertCurrency(amount, sourceCurrency, targetCurrency);
            System.out.printf("%.2f %s is equivalent to %.2f %s%n", amount, sourceCurrency, convertedAmount, targetCurrency);

            reader.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }


    public static double convertCurrency(double amount, String sourceCurrency, String targetCurrency) throws IOException, ParseException {
        String urlString = String.format("https://api.exchangerate-api.com/v4/latest/%s", sourceCurrency);
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject jsonObject = (JSONObject) new JSONParser().parse(response.toString());
            double targetRate = (double) ((JSONObject) jsonObject.get("rates")).get(targetCurrency);
            return amount * targetRate;
        } else {
            System.out.println("Failed to fetch exchange rates.");
            return -1; // Error code
        }
    }
}
