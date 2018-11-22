package com.yzh.ssm.service.impl;

import com.yzh.ssm.dao.TestDao;
import com.yzh.ssm.model.Test;
import com.yzh.ssm.service.ITestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestServiceImpl implements ITestService {

    @Resource
    private TestDao testDao;

    public Test getModelById(int id){
        return testDao.getModelById(id);
    }

    public void addModel(Test test){
        testDao.addModel(test);
    }

    public void delModel(int id){
        testDao.delModel(id);
    }

    public void updateModel(Test test){
        testDao.updateModel(test);
    }
}
