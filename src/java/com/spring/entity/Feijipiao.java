package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "feijipiao")
public class Feijipiao implements Serializable {
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
    @Column(name = "shengyushuliang")
    private Integer shengyushuliang;
    @Column(name = "goupiaoxuzhi")
    private String goupiaoxuzhi;

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

    public Integer getShengyushuliang() {
        return shengyushuliang;
    }
    public void setShengyushuliang(Integer shengyushuliang) {
        this.shengyushuliang = shengyushuliang == null ? 0 : shengyushuliang;
    }

    public String getGoupiaoxuzhi() {
        return goupiaoxuzhi;
    }
    public void setGoupiaoxuzhi(String goupiaoxuzhi) {
        this.goupiaoxuzhi = goupiaoxuzhi == null ? "" : goupiaoxuzhi.trim();
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }
}
