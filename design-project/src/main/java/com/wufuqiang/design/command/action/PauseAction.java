package com.wufuqiang.design.command.action;

import com.wufuqiang.design.command.GPlayer;
import com.wufuqiang.design.command.IAction;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-24 20:30
 */

public class PauseAction implements IAction {
    private GPlayer gPlayer;

    public PauseAction(GPlayer gPlayer) {
        this.gPlayer = gPlayer;
    }

    @Override
    public void execute() {
        this.gPlayer.pause();
    }
}
