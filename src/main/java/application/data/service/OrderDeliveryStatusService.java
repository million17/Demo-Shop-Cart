package application.data.service;

import application.data.model.OrderDeliveryStatus;
import application.data.repository.OrderDeliveryStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDeliveryStatusService {

    @Autowired
    private OrderDeliveryStatusRepository orderDeliveryStatusRepository;

    public void addNewOrderDeliveryStatus(OrderDeliveryStatus orderDeliveryStatus) {
        orderDeliveryStatusRepository.save(orderDeliveryStatus);
    }

    public void updateOrderDeliveryStatus(OrderDeliveryStatus orderDeliveryStatus) {
        orderDeliveryStatusRepository.save(orderDeliveryStatus);
    }
}
