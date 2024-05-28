package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "pinglun")
public class Pinglun implements Serializable {
    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id",insertable=false)
    private Integer id;

    @Column(name = "biao")
    private String biao;
    @Column(name = "biaoid")
    private Integer biaoid;
    @Column(name = "biaoti")
    private String biaoti;
    @Column(name = "pingfen")
    private String pingfen;
    @Column(name = "pinglunneirong")
    private String pinglunneirong;
    @Column(name = "pinglunren")
    private String pinglunren;

    @Column(name = "addtime")
    private String addtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getBiao() {
        return biao;
    }
    public void setBiao(String biao) {
        this.biao = biao == null ? "" : biao.trim();
    }

    public Integer getBiaoid() {
        return biaoid;
    }
    public void setBiaoid(Integer biaoid) {
        this.biaoid = biaoid == null ? 0 : biaoid;
    }

    public String getBiaoti() {
        return biaoti;
    }
    public void setBiaoti(String biaoti) {
        this.biaoti = biaoti == null ? "" : biaoti.trim();
    }

    public String getPingfen() {
        return pingfen;
    }
    public void setPingfen(String pingfen) {
        this.pingfen = pingfen == null ? "" : pingfen.trim();
    }

    public String getPinglunneirong() {
        return pinglunneirong;
    }
    public void setPinglunneirong(String pinglunneirong) {
        this.pinglunneirong = pinglunneirong == null ? "" : pinglunneirong.trim();
    }

    public String getPinglunren() {
        return pinglunren;
    }
    public void setPinglunren(String pinglunren) {
        this.pinglunren = pinglunren == null ? "" : pinglunren.trim();
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }
}
