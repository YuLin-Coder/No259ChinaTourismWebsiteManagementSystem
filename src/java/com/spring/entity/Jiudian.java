package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "jiudian")
public class Jiudian implements Serializable {
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
    @Column(name = "jiudiantupian")
    private String jiudiantupian;
    @Column(name = "jiudiandizhi")
    private String jiudiandizhi;
    @Column(name = "lianxidianhua")
    private String lianxidianhua;
    @Column(name = "jiudianjieshao")
    private String jiudianjieshao;

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

    public String getJiudiantupian() {
        return jiudiantupian;
    }
    public void setJiudiantupian(String jiudiantupian) {
        this.jiudiantupian = jiudiantupian == null ? "" : jiudiantupian.trim();
    }

    public String getJiudiandizhi() {
        return jiudiandizhi;
    }
    public void setJiudiandizhi(String jiudiandizhi) {
        this.jiudiandizhi = jiudiandizhi == null ? "" : jiudiandizhi.trim();
    }

    public String getLianxidianhua() {
        return lianxidianhua;
    }
    public void setLianxidianhua(String lianxidianhua) {
        this.lianxidianhua = lianxidianhua == null ? "" : lianxidianhua.trim();
    }

    public String getJiudianjieshao() {
        return jiudianjieshao;
    }
    public void setJiudianjieshao(String jiudianjieshao) {
        this.jiudianjieshao = jiudianjieshao == null ? "" : jiudianjieshao.trim();
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }
}
