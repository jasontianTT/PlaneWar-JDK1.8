package com.sxt.obj;

import com.sxt.GameWin;
import com.sxt.utils.GameUtils;

import java.awt.*;

public class LittleBoss1 extends GameObj {
    //boss1初始血量10
    int health = 10;
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
        //boss1和我方子弹碰撞，子弹消失
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

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
