package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.PingjiaMapper;
import com.spring.entity.Pingjia;
import com.spring.service.PingjiaService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("PingjiaService")
public class PingjiaServiceImpl extends ServiceBase<Pingjia> implements PingjiaService {
    @Resource
    private PingjiaMapper dao;

    @Override
    protected PingjiaMapper getDao() {
        return dao;
    }
}
