package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "jingdiangonglue")
public class Jingdiangonglue implements Serializable {
    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id",insertable=false)
    private Integer id;

    @Column(name = "jingdianbianhao")
    private String jingdianbianhao;
    @Column(name = "jingdianmingcheng")
    private String jingdianmingcheng;
    @Column(name = "jingdiantupian")
    private String jingdiantupian;
    @Column(name = "suozaichengshi")
    private String suozaichengshi;
    @Column(name = "menpiaojiage")
    private Double menpiaojiage;
    @Column(name = "kaifangshijian")
    private String kaifangshijian;
    @Column(name = "jingdianweizhi")
    private String jingdianweizhi;
    @Column(name = "gongluexiangqing")
    private String gongluexiangqing;

    @Column(name = "addtime")
    private String addtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getJingdianbianhao() {
        return jingdianbianhao;
    }
    public void setJingdianbianhao(String jingdianbianhao) {
        this.jingdianbianhao = jingdianbianhao == null ? "" : jingdianbianhao.trim();
    }

    public String getJingdianmingcheng() {
        return jingdianmingcheng;
    }
    public void setJingdianmingcheng(String jingdianmingcheng) {
        this.jingdianmingcheng = jingdianmingcheng == null ? "" : jingdianmingcheng.trim();
    }

    public String getJingdiantupian() {
        return jingdiantupian;
    }
    public void setJingdiantupian(String jingdiantupian) {
        this.jingdiantupian = jingdiantupian == null ? "" : jingdiantupian.trim();
    }

    public String getSuozaichengshi() {
        return suozaichengshi;
    }
    public void setSuozaichengshi(String suozaichengshi) {
        this.suozaichengshi = suozaichengshi == null ? "" : suozaichengshi.trim();
    }

    public Double getMenpiaojiage() {
        return menpiaojiage;
    }
    public void setMenpiaojiage(Double menpiaojiage) {
        this.menpiaojiage = menpiaojiage == null ? 0.0f : menpiaojiage;
    }

    public String getKaifangshijian() {
        return kaifangshijian;
    }
    public void setKaifangshijian(String kaifangshijian) {
        this.kaifangshijian = kaifangshijian == null ? "" : kaifangshijian.trim();
    }

    public String getJingdianweizhi() {
        return jingdianweizhi;
    }
    public void setJingdianweizhi(String jingdianweizhi) {
        this.jingdianweizhi = jingdianweizhi == null ? "" : jingdianweizhi.trim();
    }

    public String getGongluexiangqing() {
        return gongluexiangqing;
    }
    public void setGongluexiangqing(String gongluexiangqing) {
        this.gongluexiangqing = gongluexiangqing == null ? "" : gongluexiangqing.trim();
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }
}
