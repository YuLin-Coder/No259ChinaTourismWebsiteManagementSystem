package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "jiudianyuding")
public class Jiudianyuding implements Serializable {
    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id",insertable=false)
    private Integer id;

    @Column(name = "yudingdanhao")
    private String yudingdanhao;
    @Column(name = "jiudianbianhao")
    private String jiudianbianhao;
    @Column(name = "jiudianmingcheng")
    private String jiudianmingcheng;
    @Column(name = "jiudianleixing")
    private String jiudianleixing;
    @Column(name = "kefangleixing")
    private String kefangleixing;
    @Column(name = "kefangtupian")
    private String kefangtupian;
    @Column(name = "kefangjiage")
    private Double kefangjiage;
    @Column(name = "yujiruzhushijian")
    private String yujiruzhushijian;
    @Column(name = "yudingjianshu")
    private Integer yudingjianshu;
    @Column(name = "lianxidianhua")
    private String lianxidianhua;
    @Column(name = "shenfenzhenghao")
    private String shenfenzhenghao;
    @Column(name = "xingming")
    private String xingming;
    @Column(name = "yudingyonghu")
    private String yudingyonghu;
    private String iszf;
    private Integer jiudiankefangid;

    @Column(name = "addtime")
    private String addtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getYudingdanhao() {
        return yudingdanhao;
    }
    public void setYudingdanhao(String yudingdanhao) {
        this.yudingdanhao = yudingdanhao == null ? "" : yudingdanhao.trim();
    }

    public String getJiudianbianhao() {
        return jiudianbianhao;
    }
    public void setJiudianbianhao(String jiudianbianhao) {
        this.jiudianbianhao = jiudianbianhao == null ? "" : jiudianbianhao.trim();
    }

    public String getJiudianmingcheng() {
        return jiudianmingcheng;
    }
    public void setJiudianmingcheng(String jiudianmingcheng) {
        this.jiudianmingcheng = jiudianmingcheng == null ? "" : jiudianmingcheng.trim();
    }

    public String getJiudianleixing() {
        return jiudianleixing;
    }
    public void setJiudianleixing(String jiudianleixing) {
        this.jiudianleixing = jiudianleixing == null ? "" : jiudianleixing.trim();
    }

    public String getKefangleixing() {
        return kefangleixing;
    }
    public void setKefangleixing(String kefangleixing) {
        this.kefangleixing = kefangleixing == null ? "" : kefangleixing.trim();
    }

    public String getKefangtupian() {
        return kefangtupian;
    }
    public void setKefangtupian(String kefangtupian) {
        this.kefangtupian = kefangtupian == null ? "" : kefangtupian.trim();
    }

    public Double getKefangjiage() {
        return kefangjiage;
    }
    public void setKefangjiage(Double kefangjiage) {
        this.kefangjiage = kefangjiage == null ? 0.0f : kefangjiage;
    }

    public String getYujiruzhushijian() {
        return yujiruzhushijian;
    }
    public void setYujiruzhushijian(String yujiruzhushijian) {
        this.yujiruzhushijian = yujiruzhushijian == null ? "" : yujiruzhushijian.trim();
    }

    public Integer getYudingjianshu() {
        return yudingjianshu;
    }
    public void setYudingjianshu(Integer yudingjianshu) {
        this.yudingjianshu = yudingjianshu == null ? 0 : yudingjianshu;
    }

    public String getLianxidianhua() {
        return lianxidianhua;
    }
    public void setLianxidianhua(String lianxidianhua) {
        this.lianxidianhua = lianxidianhua == null ? "" : lianxidianhua.trim();
    }

    public String getShenfenzhenghao() {
        return shenfenzhenghao;
    }
    public void setShenfenzhenghao(String shenfenzhenghao) {
        this.shenfenzhenghao = shenfenzhenghao == null ? "" : shenfenzhenghao.trim();
    }

    public String getXingming() {
        return xingming;
    }
    public void setXingming(String xingming) {
        this.xingming = xingming == null ? "" : xingming.trim();
    }

    public String getYudingyonghu() {
        return yudingyonghu;
    }
    public void setYudingyonghu(String yudingyonghu) {
        this.yudingyonghu = yudingyonghu == null ? "" : yudingyonghu.trim();
    }
    public String getIszf() {
        return iszf;
    }
    public void setIszf(String iszf) {
        this.iszf = iszf == null ? "" : iszf.trim();
    }
    public Integer getJiudiankefangid() {
        return jiudiankefangid;
    }
    public void setJiudiankefangid(Integer jiudiankefangid) {
        this.jiudiankefangid = jiudiankefangid == null ? 0 : jiudiankefangid;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }
}
