package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "jiudiankefang")
public class Jiudiankefang implements Serializable {
    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id",insertable=false)
    private Integer id;

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
    @Column(name = "shengyukefangshu")
    private Integer shengyukefangshu;
    private Integer jiudianid;

    @Column(name = "addtime")
    private String addtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getShengyukefangshu() {
        return shengyukefangshu;
    }
    public void setShengyukefangshu(Integer shengyukefangshu) {
        this.shengyukefangshu = shengyukefangshu == null ? 0 : shengyukefangshu;
    }
    public Integer getJiudianid() {
        return jiudianid;
    }
    public void setJiudianid(Integer jiudianid) {
        this.jiudianid = jiudianid == null ? 0 : jiudianid;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }
}
