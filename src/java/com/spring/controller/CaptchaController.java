package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 * 验证码输出
 */
@Controller
public class CaptchaController extends BaseController {
    /**
     * 生成验证码，访问地址：captcha.do
     */
    @RequestMapping("/captcha")
    public String Index()
    {
        //byte[] img = xxx;
        response.setContentType("image/jpeg"); // 定义输出类型为 图片
        response.setHeader("Pragma","No-cache");   // 设置为无缓存
        response.setHeader("Cache-Control","no-cache");  // 设置为无缓存
        response.setDateHeader("Expires", 0);  // 设置缓存时间为0秒后过期
        int width=60, height=20;   // 定义图片宽为 60  高度为 20

        // 创建图片缓冲区
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // 获取渲染画板
        Graphics g = image.getGraphics();

        // 生成随机数类
        Random random = new Random();

        // 设置颜色
        g.setColor(getRandColor(200,250));

        // 绘制矩形
        g.fillRect(0, 0, width, height);

        // 设置字体信息
        g.setFont(new Font("Times New Roman",Font.PLAIN,18));

        // 设置颜色信息
        g.setColor(getRandColor(160,200));

        // 写入干扰线
        for (int i=0;i<155;i++)
        {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x,y,x+xl,y+yl);
        }

        // 写入验证码字符串
        String sRand="";
        for (int i=0;i<4;i++){
            String rand=String.valueOf(random.nextInt(10));
            sRand+=rand;
            g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
            g.drawString(rand,13*i+6,16);
        }
        // 把验证码字符串写入session 中，保存待下次验证时使用
        request.getSession().setAttribute("random",sRand);
        g.dispose();  // 释放画板
        try {
            // 输出渲染好的内容到前端浏览器
            ServletOutputStream stream= response.getOutputStream();
            ImageIO.write(image, "JPEG", stream);
            stream.flush();
            stream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "success";
    }

    // 获取随机颜色
    protected Color getRandColor(int fc, int bc)
    {
        Random random = new Random();
        if(fc>255) fc=255;
        if(bc>255) bc=255;
        int r=fc+random.nextInt(bc-fc);
        int g=fc+random.nextInt(bc-fc);
        int b=fc+random.nextInt(bc-fc);
        return new Color(r,g,b);
    }
}
