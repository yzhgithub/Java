package com.yzh.ssm.service.impl;

import com.yzh.ssm.dao.MotorHomeMapper;
import com.yzh.ssm.model.MotorHome;
import com.yzh.ssm.service.IMotorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MotorServiceImpl  implements IMotorService{

    @Resource
    private MotorHomeMapper motorHomeMapper;

    public MotorHome getModelById(int id){
        return  motorHomeMapper.selectByPrimaryKey(id);
    }
}
