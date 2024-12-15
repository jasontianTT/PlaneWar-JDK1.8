package com.sxt.obj;

import com.sxt.GameWin;

import java.awt.*;

public class Enemy2Obj extends GameObj{
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public Enemy2Obj() {
        super();
    }

    public Enemy2Obj(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
        super(img, width, height, x, y, speed, frame);
    }

    public Enemy2Obj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintself(Graphics g) {
        super.paintself(g);
        y+=speed;
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
