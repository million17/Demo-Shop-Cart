package application.data.service;

import application.data.model.DeliveryStatus;
import application.data.repository.DeliveryStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryStatusService {
    @Autowired
    private DeliveryStatusRepository deliveryStatusRepository;

    public DeliveryStatus findOne(int deliveryStatusId) {


        return deliveryStatusRepository.findOne(deliveryStatusId);
    }
}
