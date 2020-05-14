package application.data.service;

import application.data.model.Blog;
import application.data.repository.BlogRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    private static final Logger logger = LogManager.getLogger(BlogService.class);

    public List<Blog> getListBlogByUserId(Integer userId) {
        try {
            return blogRepository.getListBlogByUserId(userId);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return null;
    }

    public List<Blog> getListBlogByNoLoginRandom() {
        try {
            return blogRepository.getListBlogByNoLoginRandom();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return null;
    }
}
