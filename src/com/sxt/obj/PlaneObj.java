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

    LittleBoss1 littleBoss1 = new LittleBoss1();
    LittleBoss2 littleBoss2 = new LittleBoss2();

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
                //碰撞后出现爆炸效果
                ExplodeObj explodeObj =new ExplodeObj(x,y);
                GameUtils.explodeObjsList.add(explodeObj);
                GameUtils.removeList.add(explodeObj);

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
                //碰撞后出现爆炸效果
                ExplodeObj explodeObj =new ExplodeObj(x,y);
                GameUtils.explodeObjsList.add(explodeObj);
                GameUtils.removeList.add(explodeObj);

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
                //碰撞后出现爆炸效果
                ExplodeObj explodeObj =new ExplodeObj(x,y);
                GameUtils.explodeObjsList.add(explodeObj);
                GameUtils.removeList.add(explodeObj);

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
        //boss1与我方碰撞，boss1不消失，我方消失
        if(this.getRec().intersects(littleBoss1.getRec())){
            //绘制爆炸
            ExplodeObj explodeObj =new ExplodeObj(x,y);
            GameUtils.explodeObjsList.add(explodeObj);
            GameUtils.removeList.add(explodeObj);

            //移除我方飞机
            //移出窗口
            this.x=-200;
            this.y=-200;
            GameUtils.removeList.add(this);

        }
        if(this.getRec().intersects(littleBoss2.getRec())){
            //绘制爆炸
            ExplodeObj explodeObj =new ExplodeObj(x,y);
            GameUtils.explodeObjsList.add(explodeObj);
            GameUtils.removeList.add(explodeObj);

            //移除我方飞机
            //移出窗口
            this.x=-200;
            this.y=-200;
            GameUtils.removeList.add(this);

        }
        //我方飞机和boss1子弹碰撞后，两者都消失
        for (LittleBoss1Bullet littleBoss1Bullet:GameUtils.littleBoss1BulletList){
            if(this.getRec().intersects(littleBoss1Bullet.getRec())){
                //绘制爆炸
                ExplodeObj explodeObj =new ExplodeObj(x,y);
                GameUtils.explodeObjsList.add(explodeObj);
                GameUtils.removeList.add(explodeObj);

                //移除子弹
                littleBoss1Bullet.setX(-100);
                littleBoss1Bullet.setY(-100);

                //移除我方飞机
                this.x=-200;
                this.y=-200;

                //加入移除列表
                GameUtils.removeList.add(littleBoss1Bullet);
                GameUtils.removeList.add(this);
            }
        }
        //我方飞机和boss2子弹碰撞后，两者都消失
        for (LittleBoss2Bullet littleBoss2Bullet:GameUtils.littleBoss2BulletList){
            if(this.getRec().intersects(littleBoss2Bullet.getRec())){
                //绘制爆炸
                ExplodeObj explodeObj =new ExplodeObj(x,y);
                GameUtils.explodeObjsList.add(explodeObj);
                GameUtils.removeList.add(explodeObj);

                //移除子弹
                littleBoss2Bullet.setX(-100);
                littleBoss2Bullet.setY(-100);

                //移除我方飞机
                this.x=-200;
                this.y=-200;

                //加入移除列表
                GameUtils.removeList.add(littleBoss2Bullet);
                GameUtils.removeList.add(this);
            }
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
