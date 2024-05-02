package edu.canisius.csc213.project2.quotes;

public class StockQuote {
    private String symbol;
    private double closePrice;
    private double highestPrice;
    private double lowestPrice;
    private int numberOfTransactions;
    private double openPrice;
    private long timestamp;
    private double tradingVolume;

    public StockQuote(String symbol, double closePrice, double highestPrice, double lowestPrice,
                      int numberOfTransactions, double openPrice, long timestamp, double tradingVolume) {
        this.symbol = symbol;
        this.closePrice = closePrice;
        this.highestPrice = highestPrice;
        this.lowestPrice = lowestPrice;
        this.numberOfTransactions = numberOfTransactions;
        this.openPrice = openPrice;
        this.timestamp = timestamp;
        this.tradingVolume = tradingVolume;
    }

    // Getters for all fields
    public String getSymbol() {
        return symbol;
    }

    public double getClosePrice() {
        return closePrice;
    }

    public double getHighestPrice() {
        return highestPrice;
    }

    public double getLowestPrice() {
        return lowestPrice;
    }

    public int getNumberOfTransactions() {
        return numberOfTransactions;
    }

    public double getOpenPrice() {
        return openPrice;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public double getTradingVolume() {
        return tradingVolume;
    }
    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();
        sb.append("Symbol: ").append(symbol).append("\n");
        sb.append("Close Price: ").append(closePrice).append("\n");
        sb.append("Highest Price: ").append(highestPrice).append("\n");
        sb.append("Lowest Price: ").append(lowestPrice).append("\n");
        sb.append("Number of Transactions: ").append(numberOfTransactions).append("\n");
        sb.append("Open Price: ").append(openPrice).append("\n");
        sb.append("Trading Volume: ").append(tradingVolume).append("\n");
        return sb.toString();
    }


}
