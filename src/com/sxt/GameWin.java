package com.sxt;

import com.sxt.obj.*;
import com.sxt.utils.GameUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWin extends JFrame {
    //记录游戏状态的变量
    //0未开始，1游戏中，2暂停，3失败，4通关
    static int state = 0;

    //背景图对象
    BgObj bgObj = new BgObj(GameUtils.bdImg,0,-1800,2);

    //定义一个图片变量
    Image offScreenImage = null;

    //引入我方飞机的对象
    PlaneObj planeObj = new PlaneObj(GameUtils.planeImg,37,41,290,550,0,this);

    //获取我方子弹对象
    //ShellObj shellObj = new ShellObj(GameUtils.shellImg,14,29, planeObj.getX(), planeObj.getY(),5, this);
    //记录游戏绘制的次数
    int count = 1;

    public void launch(){
        //窗口是否可见
        this.setVisible(true);
        //窗口的大小
        this.setSize( 600,800);
        //窗口的位置
        this.setLocationRelativeTo(null);
        //窗口的标题
        this.setTitle("期末大作业——飞机大战");
        //关闭窗口会自动结束进程
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //将所有要绘制的游戏物体全部放入所有元素集合中进行绘制
        GameUtils.gameObjList.add(bgObj);
        GameUtils.gameObjList.add(planeObj);
        //添加鼠标的点击事件
        this.addMouseListener(new MouseAdapter(){
           @Override
            public void mouseClicked(MouseEvent e) {
               if(e.getButton() == 1 && state == 0){//当我们游戏处于一个未开始的状态下点击才能有反应
                    state = 1;//游戏开始状态
                   repaint();
               }
           }
        });
        while(true){
            createObj();
            repaint();
            try {
                Thread.sleep(25);//25毫秒
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void paint(Graphics g) {
        //初始化双缓存图片对象
        if(offScreenImage == null){
            offScreenImage = createImage(600,800);//大小和游戏窗口大小相同
        }
        //获取双缓存对象的画笔
        Graphics gImage = offScreenImage.getGraphics();
        gImage.fillRect(0,0,600,800);

        if(state == 0){
            gImage.drawImage(GameUtils.bdImg,0,0,null);
            gImage.drawImage(GameUtils.explodeImg,270,350,null);
            gImage.drawImage(GameUtils.planeImg,280,470,null);
            gImage.drawImage(GameUtils.bossImg,190,70,null);
            //绘制游戏开始界面的文字
            gImage.setColor(Color.blue);
            gImage.setFont(new Font("仿宋",Font.BOLD,30));
            gImage.drawString("鼠标左键开始游戏",180,300);
            gImage.drawString("项目成员：张超，李庄严，田星杰",60,600);
        }
        if(state == 1){
 //           bgObj.paintself(gImage);
//            planeObj.paintself(gImage);
//            shellObj.paintself(gImage);
            //不再单独绘制某个游戏元素。因为所有游戏元素都放入了所有游戏集合中，这里只需要将集合中所有元素遍历出来然后绘制自身即可
            for(int i = 0;i < GameUtils.gameObjList.size() - 1;i++){
                GameUtils.gameObjList.get(i).paintself(gImage);
            }
        }
        //将双缓存图片绘制在游戏窗口
        g.drawImage(offScreenImage,0,0,null);
        count++;
    }

    //这个方法是用来批量创建物体
    void createObj(){
        if(count % 15 == 0) {//这里控制子弹产生的速度
            GameUtils.shellObjList.add(new ShellObj(GameUtils.shellImg, 14, 29, planeObj.getX() + 12, planeObj.getY() - 20, 5, this));
            GameUtils.gameObjList.add(GameUtils.shellObjList.get(GameUtils.shellObjList.size() - 1));//添加到所有元素集合中的对象，是新new出来的子弹对象，并不是整个子弹集合
        }
        //绘制两种敌方飞机
        if(count % 15 == 0){//控制敌方小飞机的产生的产生速度
            GameUtils.enemy1ObjList.add(new Enemy1Obj(GameUtils.enemy1Img,32,24,(int)(Math.random()*10)*60,0,5,this));
            GameUtils.gameObjList.add(GameUtils.enemy1ObjList.get(GameUtils.enemy1ObjList.size() - 1));
        }
        if(count %20 == 0) {//控制敌方大飞机子弹的速率
            if (count % 100 == 0) {//控制敌方大飞机的产生的产生速度
                GameUtils.enemy2ObjList.add(new Enemy2Obj(GameUtils.enemy2Img, 44, 67, (int) (Math.random() * 10) * 60, 0, 3, this));
                GameUtils.gameObjList.add(GameUtils.enemy2ObjList.get(GameUtils.enemy2ObjList.size() - 1));
            }
            if(GameUtils.enemy2ObjList.size() > 0) {
                //这里的x和y就是最新产生的地方大飞机对象的位置，我们要用这个位置来产生地方大飞机的子弹
                int x = (GameUtils.enemy2ObjList.get(GameUtils.enemy2ObjList.size()-1)).getX();
                int y = (GameUtils.enemy2ObjList.get(GameUtils.enemy2ObjList.size()-1)).getY();
                GameUtils.enemy2bulletObjList.add(new Enemy2BulletObj(GameUtils.enemy2BulletImg,14,25,x+17,y+55,5,this));
                GameUtils.gameObjList.add(GameUtils.enemy2bulletObjList.get(GameUtils.enemy2bulletObjList.size() - 1));
            }
        }
    }

    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }
}
