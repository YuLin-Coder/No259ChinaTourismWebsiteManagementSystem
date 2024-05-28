package com.spring.service.impl;

import com.base.ServiceBase;
import com.spring.dao.JiudianyudingMapper;
import com.spring.entity.Jiudianyuding;
import com.spring.service.JiudianyudingService;
import org.springframework.stereotype.Service;
import util.Info;

import javax.annotation.Resource;

@Service("JiudianyudingService")
public class JiudianyudingServiceImpl extends ServiceBase<Jiudianyuding> implements JiudianyudingService {
    @Resource
    private JiudianyudingMapper dao;

    @Override
    protected JiudianyudingMapper getDao() {
        return dao;
    }
}
