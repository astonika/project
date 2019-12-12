package com.example.demo.jvm;

import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * https://d11.baidupcs.com/file/506c6d7872be8bbba30ef84e9aa1d6b2?bkt=en-038bee77e919b76a56f7c3ee994360e6011424fcdb4d328110efc659a1bc5ba305b0ec5f795e6ac1&xcode=35834f5f65fa06bed9b74312de878d1318d1f702223220c46b79d6e956ade3fe4af7c94e8aa35ad6ae1d923ed175fbe03dc35a89c1f2d779&fid=2248280294-250528-450021037772960&time=1575945188&sign=FDTAXGERLQBHSKf-DCb740ccc5511e5e8fedcff06b081203-J%2BpNW5t1lpbYKdj%2FFBLBYKdBihc%3D&to=d11&size=1311954&sta_dx=1311954&sta_cs=15305&sta_ft=pdf&sta_ct=5&sta_mt=5&fm2=MH%2CQingdao%2CAnywhere%2C%2Cbeijing%2Cct&ctime=1563308984&mtime=1573224149&resv0=cdnback&resv1=0&resv2=rlim&resv3=5&resv4=1311954&vuk=2248280294&iv=0&htype=&randtype=&newver=1&newfm=1&secfm=1&flow_ver=3&pkey=en-595a691c649765c9b4a46e123e4f4c75acae2b9b7365098914269e2685c284d6043a696ac9d48906&sl=68616270&expires=8h&rt=pr&r=554416172&vbdid=68297128&fin=%E4%B8%80%E6%97%A5%E4%B8%80%E8%AE%B0.pdf&fn=%E4%B8%80%E6%97%A5%E4%B8%80%E8%AE%B0.pdf&rtype=1&dp-logid=7965335689803694451&dp-callid=0.1&hps=1&tsl=200&csl=200&csign=9xgG6dVGc%2F5XkLFj27kZVT5q6Us%3D&so=0&ut=6&uter=4&serv=0&uc=2123281652&ti=cdac69781712398013ed1fb74edaf52f2021b6e4f13af3c4305a5e1275657320&reqlabel=250528_f_05541358d3d2f5435637d4e045022383_-1_2a3d9636452efc1bee01b10354a06ee9&by=themis
 * */
public class Test {
    public static void main(String[] args) {
        List<GarbageCollectorMXBean> l =
                ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean b : l) {
            System.out.println(b.getName());
        }
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
