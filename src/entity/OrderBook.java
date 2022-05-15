package entity;

public class OrderBook {
    private Reader reader;
    private OrderBookDetail[] orderBookDetails;

    public OrderBook() {
    }

    public OrderBook(Reader reader, OrderBookDetail[] orderBookDetails) {
        this.reader = reader;
        this.orderBookDetails = orderBookDetails;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public OrderBookDetail[] getOrderBookDetails() {
        return orderBookDetails;
    }

    public int getBookQuantity(){
        int sum = 0;
        for (int i = 0; i < orderBookDetails.length; i++) {
            if (orderBookDetails[i]!=null)
                sum += orderBookDetails[i].getQuantity();
        }
        return sum;
    }
}
