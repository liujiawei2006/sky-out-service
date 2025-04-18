package com.sky.controller.admin;

import com.sky.result.Result;
import com.sky.utils.AliOssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/admin/common")
@Api(tags = "通用接口")
@Slf4j
public class CommonController {

    @Autowired
    private AliOssUtil aliOssUtil;

    @PostMapping("/upload")
    @ApiOperation("文件上传")
    public Result<String>upload(MultipartFile file) throws IOException {
        log.info("文件上传:{}",file);
//原始文件名
        String originalFilename = file.getOriginalFilename();
//获取原始文件名后缀
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
//构建新的文件名:UUID防止重命名
        String newFileName = UUID.randomUUID().toString() + extension;

        String filePath  = aliOssUtil.upload(file.getBytes(), newFileName);
        return Result.success(filePath);
    }
}
