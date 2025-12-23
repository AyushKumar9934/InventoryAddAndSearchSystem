package pojo;

public class Item {

    private String brand;
    private String category;
    private int price;
    private int quantity;

    public Item(String category,String brand, int price) {
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.quantity=0;
    }

    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
    public void addQuantity(int quantity){
        this.quantity+=quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
