package edu.canisius.csc213.project2;

import java.io.IOException;
import edu.canisius.csc213.project2.quotes.*;

//import edu.canisius.csc213.project2.quotes.StockQuoteProvider;
//import edu.canisius.csc213.project2.quotes.StockQuote;
//import edu.canisius.csc213.project2.quotes.PolygonStockQuoteProvider;


public class Controller {

    private StockQuote stockQuote;

    public static void main(String[] args) throws IOException{
        String symbol = "AAPL"; //args[0];
        String apiKey = "s4C2tmMzIg_gC_FCke56f27Z1wUmHTwJ";  //args[1];
        StockQuoteProvider sqp = new PolygonStockQuoteProvider();
        Controller controller = new Controller(sqp, symbol, apiKey);
        System.out.println(controller.getStockQuote().prettyPrint());
    }

    public Controller(StockQuoteProvider sqp, String symbol, String apiKey) throws IOException{
        String url = sqp.getEndpointUrl(symbol, "2024-03-04", apiKey);
        stockQuote = sqp.getStockQuote(url);
    }

    public StockQuote getStockQuote(){
        return stockQuote;
    }
}
