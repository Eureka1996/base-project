package com.wufuqiang.design.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-24 20:40
 */
public class Controller {

    private List<IAction> actions = new ArrayList<>();

    public void addAction(IAction action){
        actions.add(action);
    }

    public void execute(IAction action){
        action.execute();
    }

    public void executes(){
        actions.forEach(action -> action.execute());
        actions.clear();
    }
}
