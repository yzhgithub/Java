package com.yzh.ssm.service;

import com.yzh.ssm.model.Test;

public interface ITestService {
    public Test getModelById(int id);

    public void addModel(Test test);

    public void delModel(int id);

    public void updateModel(Test test);
}
