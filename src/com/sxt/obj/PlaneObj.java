package com.sxt.obj;

import com.sxt.GameWin;
import com.sxt.utils.GameUtils;

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

        //碰撞检测
        //我方飞机和敌方小飞机碰撞后：
        //双方都消失
        //即enemy1Obj & 我方飞机
        for(Enemy1Obj enemy1Obj: GameUtils.enemy1ObjList){
            if(this.getRec().intersects(enemy1Obj.getRec())){
                //移除敌方飞机（移出窗口，并不是删除）
                enemy1Obj.setX(-100);
                enemy1Obj.setY(-100);

                //移除我方飞机（移出窗口）
                this.x=-200;
                this.y=-200;

                //将已移除的飞机加入removeList
                GameUtils.removeList.add(enemy1Obj);
                GameUtils.removeList.add(this);

            }
        }

        //我方飞机和敌方大飞机碰撞后，双方都消失
        //即enemy2Obj & 我方飞机
        for(Enemy2Obj enemy2Obj: GameUtils.enemy2ObjList){
            if(this.getRec().intersects(enemy2Obj.getRec())){
                //移除敌方飞机（移出窗口，并不是删除）
                enemy2Obj.setX(-100);
                enemy2Obj.setY(-100);

                //移除我方飞机（移出窗口）
                this.x=-200;
                this.y=-200;

                //将已移除的飞机加入removeList
                GameUtils.removeList.add(enemy2Obj);
                GameUtils.removeList.add(this);

            }
        }

        //我方小飞机和敌方子弹碰撞后，两者都消失
        //即enemy2BulletObj & 我方飞机
        for(Enemy2BulletObj enemy2BulletObj: GameUtils.enemy2bulletObjList){
            if(this.getRec().intersects(enemy2BulletObj.getRec())){
                //移除敌方飞机
                //移出窗口，并不是删除
                enemy2BulletObj.setX(-100);
                enemy2BulletObj.setY(-100);

                //移除我方飞机
                //移出窗口
                this.x=-200;
                this.y=-200;

                //将已移除的飞机、子弹加入removeList
                GameUtils.removeList.add(enemy2BulletObj);
                GameUtils.removeList.add(this);

            }
        }


    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
