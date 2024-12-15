package com.sxt.obj;

import com.sxt.GameWin;
import com.sxt.utils.GameUtils;

import java.awt.*;

public class LittleBoss2Bullet extends GameObj{
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public LittleBoss2Bullet() {
        super();
    }

    public LittleBoss2Bullet(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
        super(img, width, height, x, y, speed, frame);
    }

    public LittleBoss2Bullet(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    public LittleBoss2Bullet(int x, int y) {
        super(x, y);
    }

    @Override
    public void paintself(Graphics g) {
        super.paintself(g);
        //实现boss2子弹追踪
        //x随飞机移动,y维持原轨迹
        this.y+=speed;
        //判断子弹、飞机的x轴相对位置
        //（子弹位置-飞机位置）/30
        //除以30让子弹运动更流畅
        this.x-=(this.x-GameUtils.gameObjList.get(GameWin.planeindex).getX())/30;
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
