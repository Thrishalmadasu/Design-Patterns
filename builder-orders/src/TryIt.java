import com.example.orders.*;
import java.util.List;

public class TryIt {
    public static void main(String[] args) {
        OrderLine l1 = new OrderLine("A", 1, 200);
        OrderLine l2 = new OrderLine("B", 3, 100);
        Order o = new Order.Builder().setId("o2").setCustomerEmail("a@b.com").addLine(l1).addLine(l2).setDiscountPercent(10).build();
        System.out.println("Before: " + o.totalAfterDiscount());
        l1.setQuantity(999);
        System.out.println(o.getLines().get(0).getQuantity());
        System.out.println(l1.getQuantity());
        System.out.println("After:  " + o.totalAfterDiscount());
    }
}
