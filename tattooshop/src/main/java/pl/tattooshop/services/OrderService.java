package pl.tattooshop.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.tattooshop.models.Order;

public interface OrderService {
    Page<Order> getAllOrdersByActiveUser(Pageable pageable);

    Page<Order> getAllOrders(Pageable pageable);

    Order getOrder(Long id);

    void deleteOrder(Long id);
}
