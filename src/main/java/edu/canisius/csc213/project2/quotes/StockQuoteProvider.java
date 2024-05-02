package edu.canisius.csc213.project2.quotes;

import java.io.IOException;

public interface StockQuoteProvider {
   
    public String getEndpointUrl(String symbolName, String date, String apiKey);
  
    public StockQuote getStockQuote(String endpointUrl) throws IOException;
}
