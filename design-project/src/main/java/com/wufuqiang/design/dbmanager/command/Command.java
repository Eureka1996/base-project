package com.wufuqiang.design.dbmanager.command;

import com.wufuqiang.design.dbmanager.entities.DimEntity;

import java.io.Serializable;

/**
 * @author wufuqiang
 * @date 2022/1/24 6:38 PM
 **/

public interface Command extends Serializable {

    Object execute() throws Exception;

    void update(DimEntity dimEntity);

}
