package com.sxt.obj;

import com.sxt.GameWin;
import com.sxt.utils.GameUtils;

import java.awt.*;

public class LittleBoss2 extends GameObj{
    //初始血量10
    int health = 10;
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

        //boss2和我方子弹碰撞，子弹消失
        for (ShellObj shellObj: GameUtils.shellObjList){
            if(this.getRec().intersects(shellObj.getRec())&&health>0){
                //子弹消失
                shellObj.setX(-100);
                shellObj.setY(-100);
                GameUtils.removeList.add(shellObj);
                health--;
            }
            //血量为0，boss消失
            else if (this.getRec().intersects(shellObj.getRec())&&health<=0){
                //绘制爆炸
                ExplodeObj explodeObj =new ExplodeObj(x,y);
                GameUtils.explodeObjsList.add(explodeObj);
                GameUtils.removeList.add(explodeObj);

                //boss被击毁时，创建补给
                GiftObj giftObj =new GiftObj(this.x,this.y);
                GameUtils.giftObjList.add(giftObj);
                GameUtils.gameObjList.addAll(GameUtils.giftObjList);

                //子弹消失
                shellObj.setX(-100);
                shellObj.setY(-100);
                GameUtils.removeList.add(shellObj);

                //该boss消失
                this.x=-200;
                this.y=-200;
                GameUtils.removeList.add(this);

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
