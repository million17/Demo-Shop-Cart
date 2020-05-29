package application.data.service;

import application.data.model.Order;
import application.data.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findOrderByGuidOrUserName(String guid, String userName) {
        return orderRepository.findOrderByGuidOrUserName(guid, userName);
    }

    public boolean addNewOrder(Order order) {
        try {
            orderRepository.save(order);
            return true;
        } catch (Exception ex) {
            ex.getMessage();
        }
        return false;

    }
}
