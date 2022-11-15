package com.wufuqiang.design.dbmanager.command.executor;

import com.wufuqiang.design.dbmanager.command.Command;
import com.wufuqiang.design.dbmanager.command.RedisCommand;

/**
 * @author wufuqiang
 * @date 2022/1/24 7:52 PM
 **/

public class RedisExecutor {
    public void execute(Command command){
        if(command instanceof RedisCommand){

        }
    }
}
