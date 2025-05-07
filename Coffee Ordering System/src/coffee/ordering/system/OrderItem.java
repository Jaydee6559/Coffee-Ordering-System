/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coffee.ordering.system;

/**
 *
 * @author jayde
 */
public class OrderItem {
    String name;
    String size;
    int quantity;
    double price;

    public OrderItem(String name, String size, int quantity, double price) {
        this.name = name;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
    }

    public Object[] toTableRow() {
        return new Object[]{name, quantity, size, price};
    }

    public double getPrice() {
        return price;
    }
}

