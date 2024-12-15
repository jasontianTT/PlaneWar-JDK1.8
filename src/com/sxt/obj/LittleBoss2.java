package com.sxt.obj;

import com.sxt.GameWin;

import java.awt.*;

public class LittleBoss2 extends GameObj{
    @Override
    public Rectangle getRec() {
        return super.getRec();
    }

    @Override
    public void paintself(Graphics g) {
        super.paintself(g);
        //boss2移动方式
        if(y<150){
            y+=2;
        }else{
            x+=speed;

            //boss碰到边框时反方向移动
            if(x>400||x<10){
                speed=-speed;
            }
        }
    }

    public LittleBoss2() {
        super();
    }

    public LittleBoss2(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
        super(img, width, height, x, y, speed, frame);
    }

    public LittleBoss2(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    public LittleBoss2(int x, int y) {
        super(x, y);
    }
}
