package pl.tattooshop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.tattooshop.exceptions.ItemNotFoundException;
import pl.tattooshop.repositories.OrderItemRepository;
import pl.tattooshop.repositories.OrderRepository;
import pl.tattooshop.repositories.UserRepository;
import pl.tattooshop.models.Order;
import pl.tattooshop.models.OrderItem;
import pl.tattooshop.services.OrderService;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<Order> getAllOrdersByActiveUser(Pageable pageable) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        Page page = orderRepository.findAllByUserId(userRepository.findByUsername(userName).getId(), pageable);
        return page;
    }

    @Override
    public Page<Order> getAllOrders(Pageable pageable) {
        Page page = orderRepository.findAll(pageable);
        return page;
    }

    @Override
    public Order getOrder(Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        Order order = optionalOrder.orElseThrow(()->new ItemNotFoundException(id));
        return order;
    }

    @Override
    public void deleteOrder(Long id) {
        List<OrderItem> list = orderRepository.getOne(id).getItems();
        orderRepository.deleteById(id);
        for (OrderItem o : list){
            orderItemRepository.deleteById(o.getId());
        }
    }
}
