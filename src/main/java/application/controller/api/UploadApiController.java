package application.controller.api;

import application.model.api.FileUploadResult;
import application.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/upload")
public class UploadApiController {

    @Autowired
    private FileStorageService storageService;

    @PostMapping("/upload-image")
    public FileUploadResult uploadResult(
            @RequestParam("file") MultipartFile multipartFile
    ) {
        String message = "";
        FileUploadResult result = new FileUploadResult();


        try {
            String newFileName = storageService.store(multipartFile);
            message = "You successfully upload " + multipartFile.getOriginalFilename() + "!";

            result.setSuccess(true);
            result.setMessage(message);
            result.setLink("/link/" + newFileName);

        } catch (Exception ex) {
            result.setMessage(ex.getMessage());
            result.setSuccess(false);
        }

        return result;

    }

}
