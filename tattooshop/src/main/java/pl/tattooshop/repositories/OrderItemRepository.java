package pl.tattooshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tattooshop.models.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
