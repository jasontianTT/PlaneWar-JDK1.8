package com.sxt.obj;

import com.sxt.GameWin;

import java.awt.*;

public class BgObj extends GameObj {
    public BgObj() {
        super();
    }

    @Override
    public Image getImg() {
        return super.getImg();
    }

    public BgObj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintself(Graphics g) {
        super.paintself(g);
        y+=speed;
        if(y>=0){
            y = -1800;
        }
    }

    public BgObj(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
        super(img, width, height, x, y, speed, frame);
    }


    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
