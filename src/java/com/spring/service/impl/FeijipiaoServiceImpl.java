package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.FeijipiaoMapper;
import com.spring.entity.Feijipiao;
import com.spring.service.FeijipiaoService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("FeijipiaoService")
public class FeijipiaoServiceImpl extends ServiceBase<Feijipiao> implements FeijipiaoService {
    @Resource
    private FeijipiaoMapper dao;

    @Override
    protected FeijipiaoMapper getDao() {
        return dao;
    }
}
