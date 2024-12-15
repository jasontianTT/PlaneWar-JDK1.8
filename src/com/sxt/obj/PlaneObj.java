package com.sxt.obj;

import com.sxt.GameWin;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlaneObj extends GameObj{
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public PlaneObj() {
        super();
    }

    public PlaneObj(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
        super(img, width, height, x, y, speed, frame);
        //添加鼠标的移动事件
        this.frame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                PlaneObj.super.x = e.getX() - 19;
                PlaneObj.super.y = e.getY() - 20;
            }
        });
    }

    public PlaneObj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintself(Graphics g) {
        super.paintself(g);
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
