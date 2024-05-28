package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.JiudianMapper;
import com.spring.entity.Jiudian;
import com.spring.service.JiudianService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("JiudianService")
public class JiudianServiceImpl extends ServiceBase<Jiudian> implements JiudianService {
    @Resource
    private JiudianMapper dao;

    @Override
    protected JiudianMapper getDao() {
        return dao;
    }
}
