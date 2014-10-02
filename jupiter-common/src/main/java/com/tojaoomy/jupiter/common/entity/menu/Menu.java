package com.tojaoomy.jupiter.common.entity.menu;

/**
 * 菜单
 * 
 * @author hejian
 *
 *  @date 2014年9月21日
 */
public class Menu {
    /** 一级菜单数组，个数应为1~3个 */
    private Button[] button;

    /**
     *
     *	Get the button
     *
     * @return the button
     */
    public Button[] getButton() {
        return button;
    }

    /**
     *
     *	Set the button
     *
     * @param button the button to set
     */
    public void setButton(Button[] button) {
        this.button = button;
    }
}
