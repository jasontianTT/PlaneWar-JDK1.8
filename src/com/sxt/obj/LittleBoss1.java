package com.sxt.obj;

import com.sxt.GameWin;

import java.awt.*;

public class LittleBoss1 extends GameObj {
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public LittleBoss1() {
        super();
    }

    public LittleBoss1(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
        super(img, width, height, x, y, speed, frame);
    }

    public LittleBoss1(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    public LittleBoss1(int x, int y) {
        super(x, y);
    }

    @Override
    public void paintself(Graphics g) {
        super.paintself(g);
        //移动boss位置（向右移动）
        x+=speed;

        //当boss碰到右边框，则向左折返
        if(x>400){
            speed=-1;
        }

    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
