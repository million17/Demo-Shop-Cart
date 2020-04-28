package application.controller.api;

import application.data.model.Size;
import application.data.service.SizeService;
import application.model.api.BaseApiResult;
import application.model.api.DataApiResult;
import application.model.dto.SizeDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/size")
public class SizeApiController {

    private static final Logger logger = LogManager.getLogger(SizeApiController.class);

    @Autowired
    private SizeService sizeService;

    @PostMapping("/create")
    public BaseApiResult createSize(@RequestBody SizeDTO sizeDTO) {
        BaseApiResult result = new BaseApiResult();
        try {
            Size size = new Size();
            size.setName(sizeDTO.getName());
            size.setShortDesc(sizeDTO.getShortDesc());
            size.setCreatedDate(new Date());
            sizeService.addNewSize(size);
            result.setSuccess(true);
            result.setMessage("Create success size !");
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            result.setSuccess(false);
            result.setMessage("Create fails size !");
        }
        return result;
    }

    @PostMapping("/detail/{sizeId}")
    public DataApiResult detail(@PathVariable Integer sizeId) {
        DataApiResult result = new DataApiResult();

        try {
            Size sizeEntity = sizeService.findOne(sizeId);
            if (sizeEntity == null) {
                result.setSuccess(false);
                result.setMessage("Can't find size !");
            } else {
                SizeDTO sizeDTO = new SizeDTO();
                sizeDTO.setId(sizeEntity.getSizeId());
                sizeDTO.setName(sizeEntity.getName());
                sizeDTO.setShortDesc(sizeEntity.getShortDesc());
                sizeDTO.setCreatedDate(sizeEntity.getCreatedDate());

                result.setData(sizeDTO);
                result.setMessage("Details size success !");
                result.setSuccess(true);

            }

        } catch (Exception ex) {
            logger.error(ex.getMessage());
            result.setSuccess(false);
            result.setMessage("Details fails size !");
        }

        return result;
    }

    @PostMapping("/update/{sizeId}")
    public BaseApiResult updateSize(@RequestBody SizeDTO sizeDTO,
                                    @PathVariable Integer sizeId) {
        BaseApiResult result = new BaseApiResult();

        try {
            Size size = sizeService.findOne(sizeId);
            if (size != null) {
                size.setName(sizeDTO.getName());
                size.setShortDesc(sizeDTO.getShortDesc());
                size.setCreatedDate(new Date());
                sizeService.updateSize(size);
                result.setSuccess(true);
                result.setMessage("Update success size !");
            } else {
                result.setSuccess(false);
                result.setMessage("Can't find size !");
            }

        } catch (Exception ex) {
            logger.error(ex.getMessage());
            result.setSuccess(false);
            result.setMessage("Update fails size !");
        }

        return result;
    }

}
