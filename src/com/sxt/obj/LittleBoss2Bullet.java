package com.sxt.obj;

import com.sxt.GameWin;
import com.sxt.utils.GameUtils;

import java.awt.*;

public class LittleBoss2Bullet extends GameObj{
    //子弹血量2
    int health = 2;
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

        //boss2子弹和我方子弹碰撞，子弹消失
        for (ShellObj shellObj: GameUtils.shellObjList){
            if(this.getRec().intersects(shellObj.getRec())&&health>0){
                //子弹消失
                shellObj.setX(-100);
                shellObj.setY(-100);
                GameUtils.removeList.add(shellObj);
                health--;
            }
            //血量为0，子弹消失
            else if (this.getRec().intersects(shellObj.getRec())&&health<=0){
                //绘制爆炸
                ExplodeObj explodeObj =new ExplodeObj(x,y);
                GameUtils.explodeObjsList.add(explodeObj);
                GameUtils.removeList.add(explodeObj);
                //我方子弹消失
                shellObj.setX(-100);
                shellObj.setY(-100);
                GameUtils.removeList.add(shellObj);

                //该子弹消失
                this.x=-200;
                this.y=-200;
                GameUtils.removeList.add(this);

            }
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
