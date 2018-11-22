package com.yzh.ssm.dao;

import com.yzh.ssm.model.Test;

public interface TestDao {
    Test getModelById(int id);

    void addModel(Test test);

    void delModel(int id);

    void updateModel(Test test);
}
