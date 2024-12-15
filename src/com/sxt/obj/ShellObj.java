package com.sxt.obj;

import com.sxt.GameWin;

import java.awt.*;

public class ShellObj extends GameObj{
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public ShellObj() {
        super();
    }

    public ShellObj(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
        super(img, width, height, x, y, speed, frame);
    }

    public ShellObj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintself(Graphics g) {
        super.paintself(g);
        //实现子弹的移动，改变子弹的纵坐标
        y-=speed;
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
