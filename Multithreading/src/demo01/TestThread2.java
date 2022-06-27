package demo01;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestThread2 implements Runnable {
    private String url;
    private String name;

    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了文件名为： " + name);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://fanyi-cdn.cdn.bcebos.com/static/translation/img/header/logo_e835568.png", "baidu.jpg");
        TestThread2 t2 = new TestThread2("https://pic.leetcode-cn.com/d2e85988beccb271af4b1a8f4767e4bdf4c085aaf5aaef093347d778e4e138d7-20.png", "huawei.jpg");
        TestThread2 t3 = new TestThread2("https://assets.leetcode-cn.com/aliyun-lc-upload/uploaded_files/2020/09/8b8fc664-3f07-45b8-87fb-7050f3df723b/%E7%B4%A0%E6%9D%90-03.png", "weilai.jpg");
        TestThread2 t4 = new TestThread2("https://assets.leetcode-cn.com/aliyun-lc-upload/uploaded_files/2021/08/8cf60796-da3d-4873-a81f-b479b1faf8fa/logo%E5%A4%B4%E5%83%8F.jpg", "tp-link.jpg");
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
        new Thread(t4).start();
    }
}

class WebDownloader {
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            System.out.println("IO异常，downloader method go wrong.");
            throw new RuntimeException(e);

        }
    }
}