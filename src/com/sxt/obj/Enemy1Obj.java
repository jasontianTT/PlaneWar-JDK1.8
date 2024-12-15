package com.sxt.obj;

import com.sxt.GameWin;
import com.sxt.utils.GameUtils;

import java.awt.*;

public class Enemy1Obj extends GameObj{
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public Enemy1Obj(Image img, int width, int height, int x, int y, double speed, GameWin frame) {
        super(img, width, height, x, y, speed, frame);
    }

    public Enemy1Obj() {
        super();
    }

    public Enemy1Obj(Image img, int x, int y, double speed) {
        super(img, x, y, speed);
    }

    @Override
    public void paintself(Graphics g) {
        super.paintself(g);
        y+=speed;

        //碰撞检测
        for (ShellObj shellObj: GameUtils.shellObjList){
            if(this.getRec().intersects(shellObj.getRec())){
                //碰撞后出现爆炸效果
                ExplodeObj explodeObj =new ExplodeObj(x,y);
                GameUtils.explodeObjsList.add(explodeObj);
                GameUtils.removeList.add(explodeObj);

                //碰撞后将元素移除
                shellObj.setX(-100);
                shellObj.setY(-100);

                this.setX(-100);
                this.setY(-100);

                GameUtils.removeList.add(shellObj);
                GameUtils.removeList.add(this);

            }
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
