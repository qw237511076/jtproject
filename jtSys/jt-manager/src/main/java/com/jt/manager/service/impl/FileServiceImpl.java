package com.jt.manager.service.impl;

import com.jt.common.vo.PicUploadResult;
import com.jt.manager.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @author sumail
 * @date 2019/8/27 0027-${time}
 */
@Service
public class FileServiceImpl implements FileService {
    @Value("${image.localPath}")
    private String localPath; //= "e:/jt-upload/";
    @Value("${image.urlPath}")
    private String urlPath;//="http://image.jt.com/";

    /**
     * 1.判断图片类型 jpg|png|git
     * 2.判断是否为恶意程序
     * 3.为了提供检索效率，将文件分文件存储。
     * 3.1:UUID hash随机算法（当前的毫秒数+算法+hash）=32位hash值
     * aaaaaaaa-bbbbbbbb-cccccccc-dddddddd/1.jpg
     * 优点：几乎永远不需要修改代码
     * 3.2yyyy/MM/dd
     * 4.杜绝文件重名现象
     * uuid+随机数（100）.jpg
     * 5.实现文件上传
     *
     * @param uploadFile
     * @return
     */
    @Override
    public PicUploadResult fileUpload(MultipartFile uploadFile) {
        PicUploadResult uploadResult = new PicUploadResult();
        //1.判断是否为图片类型
        //1.1获取文件名
        String filename = uploadFile.getOriginalFilename();
        //1.1.1文件名全部小写
        filename=filename.toLowerCase();//将字符全部转化为小写
        if (!filename.matches("^.*\\.(jpg|png|gif)$")) {
            //文件不是图片
            uploadResult.setError(1);
            return uploadResult;
        }
        //2.判断是否为恶意程序
        try {
            BufferedImage bufferedImage = ImageIO.read(uploadFile.getInputStream());
            int height = bufferedImage.getHeight();
            int width = bufferedImage.getWidth();

            if (height == 0 || width == 0) {
                //表示不是图片
                uploadResult.setError(1);
                return uploadResult;
            }
            //到此为止程序是一张图片
            //为文件进行文件存储
            String dataPath = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
            //定义文件保存路径
            String dirPath = localPath + dataPath;
            //判断文件夹是否存在
            File dirFile = new File(dirPath);
            if (!dirFile.exists()) {
                //文件不存在时，应该创建文件夹
                dirFile.mkdirs();
            }
            //重命名上传的文件UUID方式
            String uuid = UUID.randomUUID().toString().replace("-", "");
            int randomNum = new Random().nextInt(1000);
            String imageFileType = filename.substring(filename.lastIndexOf("."));
            String imageFileName = uuid + randomNum + imageFileType;
            //5.实现文件上传
            String imageLocalPath = dirPath + "/" + imageFileName;
//            System.out.println(imageFileName);
            uploadFile.transferTo(new File(imageLocalPath));
            //6.封装数据
            uploadResult.setHeight(height + "");
            uploadResult.setWidth(width + "");
            //7.准备虚拟路径
            String imageUrlPath=urlPath+dataPath+"/"+imageFileName;
            uploadResult.setUrl(imageUrlPath);
        } catch (IOException e) {
            e.printStackTrace();
            uploadResult.setError(1);
            return uploadResult;
        }
        return uploadResult;
    }
}
