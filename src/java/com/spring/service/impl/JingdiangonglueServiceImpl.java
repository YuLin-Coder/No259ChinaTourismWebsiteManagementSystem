package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.JingdiangonglueMapper;
import com.spring.entity.Jingdiangonglue;
import com.spring.service.JingdiangonglueService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("JingdiangonglueService")
public class JingdiangonglueServiceImpl extends ServiceBase<Jingdiangonglue> implements JingdiangonglueService {
    @Resource
    private JingdiangonglueMapper dao;

    @Override
    protected JingdiangonglueMapper getDao() {
        return dao;
    }
}
