package edu.canisius.csc213.project2.quotes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import edu.canisius.csc213.project2.util.*;

public class PolygonStockQuoteProvider implements StockQuoteProvider{

    @Override
    public StockQuote getStockQuote(String stockQuoteEndpoint) throws IOException {
        String json = sendGetRequest(stockQuoteEndpoint);
        PolygonJsonReplyTranslator jft = new PolygonJsonReplyTranslator();
        return jft.translateJsonToFinancialInstrument(json);

    }

    public static String sendGetRequest(String endpointUrl) throws IOException {
        URL url = new URL(endpointUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();
            return response.toString();
        } else {
            throw new IOException("GET request failed with response code: " + responseCode);
        }
    }

    @Override
    public String getEndpointUrl(String symbolName, String date, String apiKey) {
        // Validate the date format
        if (!isValidDateFormat(date)) {
            throw new IllegalArgumentException("Invalid date format: " + date);
        }

        // Construct the endpoint URL using the provided parameters
        String baseUrl = "https://api.polygon.io/v2/aggs/ticker/";
        return baseUrl + symbolName + "/range/1/day/" + date + "/" + date + "?apiKey=" + apiKey;
    }

    private boolean isValidDateFormat(String date) {
        try {
            // Try parsing the date using the ISO_DATE format
            LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
            return true; // Date format is valid
        } catch (DateTimeParseException e) {
            return false; // Date format is invalid
        }
    }
}