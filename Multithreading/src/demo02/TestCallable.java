package demo02;

import demo01.TestThread2;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCallable implements Callable {
    private String url;
    private String name;

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了文件名为： " + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://fanyi-cdn.cdn.bcebos.com/static/translation/img/header/logo_e835568.png", "baidu.jpg");
        TestCallable t2 = new TestCallable("https://pic.leetcode-cn.com/d2e85988beccb271af4b1a8f4767e4bdf4c085aaf5aaef093347d778e4e138d7-20.png", "huawei.jpg");
        TestCallable t3 = new TestCallable("https://assets.leetcode-cn.com/aliyun-lc-upload/uploaded_files/2020/09/8b8fc664-3f07-45b8-87fb-7050f3df723b/%E7%B4%A0%E6%9D%90-03.png", "weilai.jpg");
        TestCallable t4 = new TestCallable("https://assets.leetcode-cn.com/aliyun-lc-upload/uploaded_files/2021/08/8cf60796-da3d-4873-a81f-b479b1faf8fa/logo%E5%A4%B4%E5%83%8F.jpg", "tp-link.jpg");

        //创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(4);
        //提交执行
        Future<Boolean> r1 = service.submit(t1);
        Future<Boolean> r2 = service.submit(t2);
        Future<Boolean> r3 = service.submit(t3);
        Future<Boolean> r4 = service.submit(t4);
        //获取结果
        boolean result1 = r1.get();
        boolean result2 = r2.get();
        boolean result3 = r3.get();
        boolean result4 = r4.get();
        //关闭服务
        service.shutdownNow();
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