package com.dengwn.leetcode;

/**
 * @author: dengwn
 * @date: 2023-07-03
 **/
public class EbayTest1 {

}

class Bean {
    private static class NBean{
        private static final Bean bean = new Bean();
    }

    public Bean getBean(){
        return NBean.bean;
    }
//
//    private static volatile Bean bean;
//
//    private Bean() {
//        bean = new Bean();
//    }
//
//    public Bean getBean() {
//        if (bean == null) {
//            synchronized (Bean.class) {
//                if (bean == null) {
//                    bean = new Bean();
//                }
//            }
//        }
//        return bean;
//    }
}


