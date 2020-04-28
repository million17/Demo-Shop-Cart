package application.data.service;

import application.data.model.Size;
import application.data.repository.SizeRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SizeService {

    private static final Logger logger = LogManager.getLogger(SizeService.class);

    @Autowired
    private SizeRepository sizeRepository;

    @Transactional
    public boolean addNewSize(Size size) {
        try {
            sizeRepository.save(size);
            return true;
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return false;
    }

    public boolean findOne(Integer sizeId) {
        try {
            sizeRepository.findOne(sizeId);
            return true;
        } catch (Exception ex) {
            logger.error(ex.getMessage());

        }
        return false;
    }

    @Transactional
    public boolean updateSize(Size size) {
        try {
            sizeRepository.save(size);
            return true;
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return false;

    }
}
