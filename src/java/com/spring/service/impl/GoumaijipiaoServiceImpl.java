package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.GoumaijipiaoMapper;
import com.spring.entity.Goumaijipiao;
import com.spring.service.GoumaijipiaoService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("GoumaijipiaoService")
public class GoumaijipiaoServiceImpl extends ServiceBase<Goumaijipiao> implements GoumaijipiaoService {
    @Resource
    private GoumaijipiaoMapper dao;

    @Override
    protected GoumaijipiaoMapper getDao() {
        return dao;
    }
}
