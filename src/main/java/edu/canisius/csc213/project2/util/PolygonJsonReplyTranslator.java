package edu.canisius.csc213.project2.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.canisius.csc213.project2.quotes.*;


import java.io.IOException;

public class PolygonJsonReplyTranslator {

    public StockQuote translateJsonToFinancialInstrument(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(json);
    
        // Extract relevant fields from the JSON response
        String symbol = rootNode.path("ticker").asText();
        JsonNode resultsNode = rootNode.path("results");
        double closePrice = resultsNode.get(0).path("c").asDouble();
        double highestPrice = resultsNode.get(0).path("h").asDouble();
        double lowestPrice = resultsNode.get(0).path("l").asDouble(); 
        int numberOfTransactions = resultsNode.get(0).path("n").asInt(); 
        double openPrice = resultsNode.get(0).path("o").asDouble(); 
        long timestamp = resultsNode.get(0).path("t").asLong(); 
        double tradingVolume = resultsNode.get(0).path("v").asDouble(); 
    
        // Create and return a new StockQuote object
        return new StockQuote(symbol, closePrice, highestPrice, lowestPrice, numberOfTransactions,
                openPrice, timestamp, tradingVolume);
    }
}
    