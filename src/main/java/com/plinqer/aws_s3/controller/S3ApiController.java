package com.plinqer.aws_s3.controller;

import com.plinqer.aws_s3.dto.S3Dto;
import com.plinqer.aws_s3.exception.BaseResponse;
import com.plinqer.aws_s3.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = RequestMethod.POST)
//@RequestMapping("/file")
@RequiredArgsConstructor
public class S3ApiController {

    private final S3Service s3Service;

    @PostMapping("/upload")
    public BaseResponse fileUpload(@RequestPart List<MultipartFile> file){
        List<String> uploadFile = s3Service.uploadFile(file);
        return BaseResponse.success(new S3Dto(uploadFile));
    }

    @DeleteMapping("/delete")
    public BaseResponse deleteFile(@RequestParam String fileName){
        s3Service.deleteFile(fileName);
        return BaseResponse.success(fileName);
    }
}
