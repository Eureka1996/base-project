package com.wufuqiang.design.composite.safe;

/**
 * @author: Wu Fuqiang
 * @create: 2022-11-20 00:06
 */
public class SafeTest {
    public static void main(String[] args) {
        System.out.println("=========安全模式的写法==========");

        File qq = new File("QQ.exe");
        File wx = new File("微信.exe");

        Folder office = new Folder("办公软件", 2);
        File word = new File("Word.exe");
        File ppt = new File("ppt.exe");
        File excel = new File("excel.exe");
        office.add(word);
        office.add(ppt);
        office.add(excel);

        Folder root = new Folder("D盘", 1);
        root.add(qq);
        root.add(wx);
        root.add(office);
        root.show();
        System.out.println("==========================");
        root.list();
    }
}
