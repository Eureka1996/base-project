package com.wufuqiang.design.command;

import com.wufuqiang.design.command.action.PauseAction;
import com.wufuqiang.design.command.action.PlayAction;
import com.wufuqiang.design.command.action.SpeedAction;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-24 19:52
 */
public class CommandTest {
    public static void main(String[] args) {
        GPlayer player = new GPlayer();
        Controller controller = new Controller();

        controller.execute(new PlayAction(player));

        PauseAction pauseAction = new PauseAction(player);
        controller.addAction(pauseAction);
        controller.addAction(new SpeedAction(player));
        controller.executes();

    }
}
