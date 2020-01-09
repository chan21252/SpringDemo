package com.chan.spring.aop.proxy;

/**
 * 开庭用
 */
public class 法院 {
    public static void main(String[] args) {
        //原告是谁
        诉讼 张大妈 = new 原告("张大妈");

        //律师事务所给张大妈派一个代理律师
        诉讼 律师 = new 律师事务所(张大妈).委派代理律师();

        //律师代替张大妈起诉和出庭
        律师.起诉();
        律师.出庭();
    }
}
