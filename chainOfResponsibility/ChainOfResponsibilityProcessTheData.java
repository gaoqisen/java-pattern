package study.chainOfResponsibility;

/**
 * 单一的数据处理
 */
public class ChainOfResponsibilityProcessTheData {
    public static void main(String[] args) {
        String msg = "adfasdf,cao，HGDSFS < TEST >";
        MsgProcessor mp = new MsgProcessor();
        mp.setMsg(msg);
        System.out.println(mp.process());
    }
}
// 过滤接口
interface Filter {
    String doFilter(String msg);
}
// HTML过滤
class HTMLFilter implements Filter {
    @Override
    public String doFilter(String msg) {
        return msg.replace("<", "[")
                .replace(">", "]");
    }
}
// 敏感过滤
class SensetiveFilter implements  Filter{
    @Override
    public String doFilter(String msg) {
        return msg.replace("TEST", "test");
    }
}
// 消息处理
class MsgProcessor{
    private String msg;
    // 定义 插座，插座里面当然是放接口的实现，所以改动的地方只有插座
    Filter[] filters = new Filter[]{new HTMLFilter(),new SensetiveFilter()};
    //这个里面就是如何来用这个插座，你可以顺序的用
    public String process(){
        for(Filter f : filters){
            msg = f.doFilter(msg);
        }
        return msg;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}