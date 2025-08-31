package com.example.orders;

import java.util.List;

public class OrderService {

    public Order createOrder(String id, String email, List<OrderLine> lines, Integer discount, boolean expedited, String notes) {
        Order o = new Order.Builder().setId(id).setCustomerEmail(email).setDiscountPercent(discount).setExpedited(expedited).setNotes(notes).build();
        if (lines != null) for (OrderLine l : lines) o.addLine(l);
        return o;
    }
}
