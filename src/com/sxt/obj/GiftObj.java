package com.sxt.obj;

import com.sxt.GameWin;
import com.sxt.utils.GameUtils;

import java.awt.*;

public class GiftObj extends GameObj{
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public GiftObj() {
        super();
    }

    public GiftObj(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
        super(img, width, height, x, y, speed, frame);
    }

    public GiftObj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    public GiftObj(int x, int y) {
        super(x, y);
    }

    @Override
    public void paintself(Graphics g) {
        super.img= GameUtils.giftImg;
        super.paintself(g);

    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
