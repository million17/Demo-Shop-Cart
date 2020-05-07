package application.data.service;

import application.data.model.Color;
import application.data.repository.ColorRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class ColorService {

    private static final Logger logger = LogManager.getLogger(ColorService.class);

    @Autowired
    private ColorRepository colorRepository;


    @Transactional
    public boolean addNewColor(Color color) {
        try {
            colorRepository.save(color);
            return true;
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return false;
    }

    @Transactional
    public void addNewListColor(List<Color> colorList) {
        colorRepository.save(colorList);
    }

    public Color findOne(int colorId) {
        try {
            return colorRepository.findOne(colorId);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return null;
    }

    @Transactional
    public boolean updateColor(Color color) {
        try {
            colorRepository.save(color);
            return true;
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return false;

    }

    public boolean deleteColor(int colorId) {
        try {
            colorRepository.delete(colorId);
            return true;
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return false;
    }

    public List<Color> getAll() {
        return colorRepository.findAll();
    }
}
