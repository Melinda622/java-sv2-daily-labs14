package day01;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class OrderService {

    private List<Order> orders = new ArrayList<>();

    public void saveOrder(Order order) {
        orders.add(order);
    }

    public List<Order> findOrdersByStatus(String status) {
        return orders.stream().filter(order -> order.getStatus().equals(status)).toList();
    }

    public long countOrdersByStatus(String status) {
        return orders.stream().filter(order -> order.getStatus().equals(status)).count();
    }

    public List<Order> getOrdersBetweenDates(LocalDate date1, LocalDate date2) {
        return orders.stream().filter(order -> order.getOrderDate().isAfter(date1) && order.getOrderDate().isBefore(date2)).toList();
    }

    public boolean isOrderWithLessProductThan(int numberOfProducts) {
        return orders.stream().anyMatch(order -> order.getProducts().size() < numberOfProducts);
    }


    public Order getOrderWithMaxProucts() {
        return orders.stream().sorted(Collections.reverseOrder(Comparator.comparing(order -> order.getProducts().size()))).findFirst().orElseThrow(() -> new IllegalArgumentException("No element found"));
    }

    public List<Order> getOrderWithProductCategory(String category) {
        return orders.stream().filter(order -> order.getProducts().stream().anyMatch(product -> product.getCategory().equals(category))).toList();
    }
}
