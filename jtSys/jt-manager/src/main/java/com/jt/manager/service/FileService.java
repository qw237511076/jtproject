package com.jt.manager.service;

import com.jt.common.vo.PicUploadResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author sumail
 * @date 2019/8/27 0027-${time}
 */
public interface FileService {
    PicUploadResult fileUpload(MultipartFile uploadFile);
}
