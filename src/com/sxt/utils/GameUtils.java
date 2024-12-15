package com.sxt.utils;

import com.sxt.obj.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameUtils {
    //获取背景图片
    public static Image bdImg = Toolkit.getDefaultToolkit().getImage("imgs/bg.jpg");
    //获取boss图片
    public static Image bossImg = Toolkit.getDefaultToolkit().getImage("imgs/boss.png");
    //获取爆炸图片
    public static Image explodeImg = Toolkit.getDefaultToolkit().getImage("imgs/explode/e6.gif");
    //获取我方飞机图片
    public static Image planeImg = Toolkit.getDefaultToolkit().getImage("imgs/plane.png");
    //获取我方子弹图片
    public static Image shellImg = Toolkit.getDefaultToolkit().getImage("imgs/shell.png");
    //获取敌方小飞机的图片
    public static Image enemy1Img = Toolkit.getDefaultToolkit().getImage("imgs/enemy1.png");
    //获取敌方大飞机的图片
    public static Image enemy2Img = Toolkit.getDefaultToolkit().getImage("imgs/enemy2.png");
    //获取敌方大飞机子弹的图片
    public static Image enemy2BulletImg = Toolkit.getDefaultToolkit().getImage("imgs/enemy2Bullet.png");

    //创建我方飞机子弹的集合
    public static List<ShellObj> shellObjList = new ArrayList<>();
    //创建敌方小飞机的集合
    public static List<Enemy1Obj> enemy1ObjList = new ArrayList<>();
    //创建敌方大飞机的集合
    public static List<Enemy2Obj> enemy2ObjList = new ArrayList<>();
    //所有元素的集合
    public static List<GameObj> gameObjList = new ArrayList<>();
    //敌方大飞机子弹的集合
    public static List<Enemy2BulletObj> enemy2bulletObjList = new ArrayList<>();

    //移除游戏窗口的元素的集合
    public static List<GameObj> removeList = new ArrayList<>();
}
