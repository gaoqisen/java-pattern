package study.factory;

import java.util.HashMap;
import java.util.Map;

public class NoticeFactory {

    private static Map<String, Notice> stringNoticeMap = new HashMap<>();

    public static Notice getNotice(String type) {
        return stringNoticeMap.get(type);
    }

    // 可以使用构造方法初始化（https://blog.csdn.net/weixin_39778003/article/details/112264129）
    public static void register(Notice notice, String type) {
        stringNoticeMap.put(type, notice);
    }

    public static void main(String[] args) {
        Notice notice = NoticeFactory.getNotice("A");
        notice.invoke("url");
    }

}

class Trust implements Notice{

    @Override
    public void invoke(String url) {
        System.out.println("调用第三方接口");
    }

    // 初始化数据，spring的InitializingBean直接初始化数据
    public void afterPropertiesSet() {
        NoticeFactory.register(this, "A");
    }

}

class Generic implements Notice{

    @Override
    public void invoke(String url) {
        System.out.println("内部泛化调用");
    }

    // 初始化数据，
    // 1. 可以用spring的InitializingBean直接初始化数据
    public void afterPropertiesSet() {
        NoticeFactory.register(this, "B");
    }
}

interface Notice{

    public void invoke(String url);

}