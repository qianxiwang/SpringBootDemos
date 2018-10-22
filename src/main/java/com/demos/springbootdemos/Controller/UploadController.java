package com.demos.springbootdemos.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@Controller
@RequestMapping("/upload")
public class UploadController {

    /**
     * 初始化文件上传页面，跳转到uoload.jsp
     *
     * @return
     */
    @RequestMapping("/aaa")
    public String aaa() {
        return "upload";
    }

    /**
     * 提取上传方法为公共方法
     */
    public void executeUpload(String uploaddir, MultipartFile file) throws Exception {
        //文件后缀名(以.结尾的)
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //上传文件名
        String filename = UUID.randomUUID() + suffix;
        //服务器端保存的对象
        File serverFile = new File(uploaddir + filename);
        //将上传的文件写入到服务器端文件内
        file.transferTo(serverFile);
    }

    /**
     * 上传文件方法
     *
     * @return
     */
    @RequestMapping("/upload")
    public @ResponseBody
    String upload(HttpServletRequest request, MultipartFile file) {
        try {
            //上传目录地址
            String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
            //如果目录不存在，则自动创建文件夹
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            //调用上传方法
            executeUpload(uploadDir, file);

        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }

        return "上传成功";
    }

    /**
     * 上传多个文件
     * @param request
     * @param file
     * @return
     */
    @RequestMapping("/uploads")
    public @ResponseBody
    String uploads(HttpServletRequest request, MultipartFile[] file) {
        try {
            //上传目录地址
            String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdir();
            }

            //遍历文件数组执行上传
            for (int i = 0; i < file.length; i++) {
                if (file[i] != null) {
                    //调用上传方法
                    executeUpload(uploadDir, file[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }

        return "上传成功";
    }
}
