package com.sxt.obj;

import java.awt.*;

public class ExplodeObj extends GameObj{
    //定义一个image类型的静态数组，存放一串爆炸图片
    static Image[] explodePic=new Image[16];
    //定义变量来记录爆炸图的次数
    int explodeCount=0;
    //定义一个静态代码块将爆炸图片放到数组当中
    static {
        for(int i=0;i<explodePic.length;i++){
            explodePic[i]=Toolkit.getDefaultToolkit().getImage("imgs/explode/e"+(i+1)+".gif");

        }
    }
    @Override
    public void paintself(Graphics g) {
        if(explodeCount<16){
            super.img=explodePic[explodeCount];
            super.paintself(g);
            explodeCount++;
        }


    }

    public ExplodeObj(int x, int y) {
        super(x, y);
    }


}
