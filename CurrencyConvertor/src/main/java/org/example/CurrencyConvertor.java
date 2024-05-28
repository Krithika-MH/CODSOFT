package org.example;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Scanner;

public class CurrencyConvertor
{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter base currency (e.g., USD): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter target currency (e.g., EUR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();

        try {
            double exchangeRate = fetchExchangeRate(baseCurrency, targetCurrency);
            double convertedAmount = amount * exchangeRate;
            System.out.println("Converted Amount: " + convertedAmount + " " + targetCurrency);
        } catch (IOException e) {
            System.out.println("Error fetching exchange rate.");
            e.printStackTrace();
        }
    }

    private static double fetchExchangeRate(String baseCurrency, String targetCurrency) throws IOException {
        String apiKey = "e23c7b4af7ca406b8f10c001f282def0"; // Replace with your actual API key
        String apiUrl = "https://openexchangerates.org/api/latest.json?app_id=" + apiKey;

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(apiUrl);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String result = EntityUtils.toString(entity);
                    System.out.println("JSON Response: " + result); // Print JSON response
                    JSONObject jsonObject = new JSONObject(result);
                    JSONObject rates = jsonObject.getJSONObject("rates");
                    double baseRate = rates.getDouble(baseCurrency);
                    double targetRate = rates.getDouble(targetCurrency);
                    return targetRate / baseRate;
                }
            }
        }
        return 0;

    }
}
