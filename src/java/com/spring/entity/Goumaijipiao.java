package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "goumaijipiao")
public class Goumaijipiao implements Serializable {
    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id",insertable=false)
    private Integer id;

    @Column(name = "feijipiaobianhao")
    private String feijipiaobianhao;
    @Column(name = "hangbanhao")
    private String hangbanhao;
    @Column(name = "suoshuhangkonggongsi")
    private String suoshuhangkonggongsi;
    @Column(name = "qifeishijian")
    private String qifeishijian;
    @Column(name = "qifeichengshi")
    private String qifeichengshi;
    @Column(name = "daodachengshi")
    private String daodachengshi;
    @Column(name = "daodashijian")
    private String daodashijian;
    @Column(name = "jianpiaokou")
    private String jianpiaokou;
    @Column(name = "jipiaojiage")
    private Double jipiaojiage;
    @Column(name = "shenfenzhenghao")
    private String shenfenzhenghao;
    @Column(name = "lianxidianhua")
    private String lianxidianhua;
    @Column(name = "xingming")
    private String xingming;
    @Column(name = "goumaiyonghu")
    private String goumaiyonghu;
    private String iszf;
    private Integer feijipiaoid;

    @Column(name = "addtime")
    private String addtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getFeijipiaobianhao() {
        return feijipiaobianhao;
    }
    public void setFeijipiaobianhao(String feijipiaobianhao) {
        this.feijipiaobianhao = feijipiaobianhao == null ? "" : feijipiaobianhao.trim();
    }

    public String getHangbanhao() {
        return hangbanhao;
    }
    public void setHangbanhao(String hangbanhao) {
        this.hangbanhao = hangbanhao == null ? "" : hangbanhao.trim();
    }

    public String getSuoshuhangkonggongsi() {
        return suoshuhangkonggongsi;
    }
    public void setSuoshuhangkonggongsi(String suoshuhangkonggongsi) {
        this.suoshuhangkonggongsi = suoshuhangkonggongsi == null ? "" : suoshuhangkonggongsi.trim();
    }

    public String getQifeishijian() {
        return qifeishijian;
    }
    public void setQifeishijian(String qifeishijian) {
        this.qifeishijian = qifeishijian == null ? "" : qifeishijian.trim();
    }

    public String getQifeichengshi() {
        return qifeichengshi;
    }
    public void setQifeichengshi(String qifeichengshi) {
        this.qifeichengshi = qifeichengshi == null ? "" : qifeichengshi.trim();
    }

    public String getDaodachengshi() {
        return daodachengshi;
    }
    public void setDaodachengshi(String daodachengshi) {
        this.daodachengshi = daodachengshi == null ? "" : daodachengshi.trim();
    }

    public String getDaodashijian() {
        return daodashijian;
    }
    public void setDaodashijian(String daodashijian) {
        this.daodashijian = daodashijian == null ? "" : daodashijian.trim();
    }

    public String getJianpiaokou() {
        return jianpiaokou;
    }
    public void setJianpiaokou(String jianpiaokou) {
        this.jianpiaokou = jianpiaokou == null ? "" : jianpiaokou.trim();
    }

    public Double getJipiaojiage() {
        return jipiaojiage;
    }
    public void setJipiaojiage(Double jipiaojiage) {
        this.jipiaojiage = jipiaojiage == null ? 0.0f : jipiaojiage;
    }

    public String getShenfenzhenghao() {
        return shenfenzhenghao;
    }
    public void setShenfenzhenghao(String shenfenzhenghao) {
        this.shenfenzhenghao = shenfenzhenghao == null ? "" : shenfenzhenghao.trim();
    }

    public String getLianxidianhua() {
        return lianxidianhua;
    }
    public void setLianxidianhua(String lianxidianhua) {
        this.lianxidianhua = lianxidianhua == null ? "" : lianxidianhua.trim();
    }

    public String getXingming() {
        return xingming;
    }
    public void setXingming(String xingming) {
        this.xingming = xingming == null ? "" : xingming.trim();
    }

    public String getGoumaiyonghu() {
        return goumaiyonghu;
    }
    public void setGoumaiyonghu(String goumaiyonghu) {
        this.goumaiyonghu = goumaiyonghu == null ? "" : goumaiyonghu.trim();
    }
    public String getIszf() {
        return iszf;
    }
    public void setIszf(String iszf) {
        this.iszf = iszf == null ? "" : iszf.trim();
    }
    public Integer getFeijipiaoid() {
        return feijipiaoid;
    }
    public void setFeijipiaoid(Integer feijipiaoid) {
        this.feijipiaoid = feijipiaoid == null ? 0 : feijipiaoid;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }
}
