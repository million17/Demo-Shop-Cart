package application.controller.api;

import application.data.model.User;
import application.data.service.UserService;
import application.model.api.BaseApiResult;
import application.model.api.DataApiResult;
import application.model.dto.UserDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private static final Logger logger = LogManager.getLogger(UserApiController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/detail/{userId}")
    public BaseApiResult detailUser(@PathVariable Integer userId) {
        DataApiResult result = new DataApiResult();

        try {
            User userEntity = userService.findOne(userId);
            if (userEntity == null) {
                result.setMessage("Can't not find User !");
                result.setSuccess(false);
                return result;
            } else {
                UserDTO userDTO = new UserDTO();
                userDTO.setId(userEntity.getId());
                userDTO.setEmail(userEntity.getEmail());
                userDTO.setAddress(userEntity.getAddress());
                userDTO.setGender(userEntity.getGender());
                userDTO.setPhoneNumber(userEntity.getPhoneNumber());
                userDTO.setUserName(userEntity.getUserName());
                userDTO.setName(userEntity.getName());
                userDTO.setCreatedDate(userEntity.getCreatedDate());
                userDTO.setAvatar(userEntity.getAvatar());

                result.setData(userDTO);
                result.setMessage("Details User ");
                result.setSuccess(true);

                return result;
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            result.setMessage("Fails !");
            result.setSuccess(false);
            return result;
        }
    }

    @PostMapping("/update/{userId}")
    public BaseApiResult updateUser(@PathVariable Integer userId,
                                    @RequestBody UserDTO userDTO) {
        BaseApiResult rs = new BaseApiResult();

        try {
            User userEntity = userService.findOne(userId);
            if (userEntity == null) {
                rs.setMessage("Can't not find User !");
                rs.setSuccess(false);

                return rs;
            } else {
                userEntity.setEmail(userDTO.getEmail());
                userEntity.setAddress(userDTO.getAddress());
                userEntity.setGender(userDTO.getGender());
                userEntity.setPhoneNumber(userDTO.getPhoneNumber());
                userEntity.setName(userDTO.getName());
                userEntity.setCreatedDate(new Date());
                userEntity.setAvatar(userDTO.getAvatar());

                userService.updateUser(userEntity);

                rs.setMessage("Update Success ! ");
                rs.setSuccess(true);


                return rs;

            }


        } catch (Exception ex) {
            logger.error(ex.getMessage());
            rs.setMessage("Fails !");
            rs.setSuccess(false);

            return rs;
        }


    }

    @PostMapping("/create")
    public BaseApiResult create

}
