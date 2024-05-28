package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.JiudiankefangMapper;
import com.spring.entity.Jiudiankefang;
import com.spring.service.JiudiankefangService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("JiudiankefangService")
public class JiudiankefangServiceImpl extends ServiceBase<Jiudiankefang> implements JiudiankefangService {
    @Resource
    private JiudiankefangMapper dao;

    @Override
    protected JiudiankefangMapper getDao() {
        return dao;
    }
}
