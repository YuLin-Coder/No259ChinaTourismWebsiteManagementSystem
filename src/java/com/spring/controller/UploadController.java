package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import util.Uploader;
@Controller
public class UploadController extends BaseController{

    /**
     * 上传附件
     * @return
     * @throws Exception
     */
    @RequestMapping("/upload")
    public String Upload() throws Exception
    {
        String path = request.getContextPath();

        /**
         * 使用Uploader 工具类处理上传信息
         */
        Uploader uploader = new Uploader(request);
        uploader.setMaxSize(100 * 1024);
        String saveurl = "upload";
        uploader.setSavePath(saveurl);
        try{
            uploader.upload();
            String url = uploader.getUrl();
            // 将保存的路径放入前台
            request.setAttribute("url",url);
            return "upload";
        }catch (Exception e){
            return showError(e.getMessage());
        }
    }
}
