package com.sxt.obj;

import com.sxt.GameWin;
import com.sxt.utils.GameUtils;

import java.awt.*;

public class Enemy2Obj extends GameObj{
    //设定血量属性
    //初始为3，当血量为0后才移除
    int health =3;
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

        //我方飞机子弹和敌方大飞机碰撞
        for(ShellObj shellObj: GameUtils.shellObjList){
            //判断血量
            if(this.getRec().intersects(shellObj.getRec())&&health>0){
                //大飞机血量不为0
                shellObj.setX(-100);
                shellObj.setY(-100);
                //子弹消失
                GameUtils.removeList.add(shellObj);
                //血量减少
                health--;

            }
            else if(this.getRec().intersects(shellObj.getRec())&&health<=0){
                //血量为0，子弹消失、大飞机消失
                //碰撞后出现爆炸效果
                ExplodeObj explodeObj =new ExplodeObj(x,y);
                GameUtils.explodeObjsList.add(explodeObj);
                GameUtils.removeList.add(explodeObj);
                shellObj.setX(-100);
                shellObj.setY(-100);
                GameUtils.removeList.add(shellObj);

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
