package com.altman.demo.thread;

public class ThreadUnsafe {

    // 假定限量商品有十个
    private static int limited_offer = 10;

    // 模拟用户抢购
    public void rushPurchase() {
        Thread thread = new Thread(() -> {
            while (limited_offer > 0) {
                try {
                    // 这个地方模拟暂停一下，避免因为程序运行太快导致不容易出现负数
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                limited_offer--;
            }
        });
        thread.start();
    }

    public static void main(String[] args) throws Exception {
        // 模拟100个用户抢购
        for (int i = 0; i < 100; i++) {
            ThreadUnsafe customer = new ThreadUnsafe();
            customer.rushPurchase();
        }
        // 等待商品秒光
        while (limited_offer > 0) {
            Thread.sleep(1);
        }
        // 结果会发现limited_offer会出现随机负数，即线程不安全
        System.out.println(limited_offer);
    }

}
