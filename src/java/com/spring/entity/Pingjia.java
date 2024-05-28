package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "pingjia")
public class Pingjia implements Serializable {
    @GeneratedValue(generator = "JDBC") // 自增的主键映射
    @Id
    @Column(name = "id",insertable=false)
    private Integer id;

    @Column(name = "jiudianbianhao")
    private String jiudianbianhao;
    @Column(name = "jiudianmingcheng")
    private String jiudianmingcheng;
    @Column(name = "pingfen")
    private String pingfen;
    @Column(name = "pingjia")
    private String pingjia;
    @Column(name = "pingjiayonghu")
    private String pingjiayonghu;
    private Integer jiudianyudingid;

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

    public String getPingfen() {
        return pingfen;
    }
    public void setPingfen(String pingfen) {
        this.pingfen = pingfen == null ? "" : pingfen.trim();
    }

    public String getPingjia() {
        return pingjia;
    }
    public void setPingjia(String pingjia) {
        this.pingjia = pingjia == null ? "" : pingjia.trim();
    }

    public String getPingjiayonghu() {
        return pingjiayonghu;
    }
    public void setPingjiayonghu(String pingjiayonghu) {
        this.pingjiayonghu = pingjiayonghu == null ? "" : pingjiayonghu.trim();
    }
    public Integer getJiudianyudingid() {
        return jiudianyudingid;
    }
    public void setJiudianyudingid(Integer jiudianyudingid) {
        this.jiudianyudingid = jiudianyudingid == null ? 0 : jiudianyudingid;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }
}
