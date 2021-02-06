package study.chainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态链式数据处理
 */
public class ChainOfResponsibilityFilterChain {
    public static void main(String[] args) {
        // 创建消息处理器
        ChainMsgProcessor chainMsgProcessor = new ChainMsgProcessor();
        String msg = "<html>敏感字眼</html>";
        chainMsgProcessor.setMsg(msg);

        // 创建过滤链
        FilterChain filterChain1 = new FilterChain();
        filterChain1.add(new ChainHTMLFilter());

        // 创建另外一个过滤链
        FilterChain filterChain2 = new FilterChain();
        filterChain2.add(new ChainSensitiveFilter());

        // 因过滤链也实现了过滤器接口，故过滤链里面也可以存放过滤链
        filterChain1.add(filterChain2);

        chainMsgProcessor.setFilterChain(filterChain1);
        System.out.println(chainMsgProcessor.process());
    }
}
// 过滤器接口
interface CFilter {
     public String doFilter(String str);
}
// html过滤实现
class ChainHTMLFilter implements  CFilter{
    @Override
    public String doFilter(String str) {
        return str.replace('<', '[').replace(">", "]");
    }
}
// 敏感字过滤
class ChainSensitiveFilter implements  CFilter{
    @Override
    public String doFilter(String str) {
        return str.replace("敏感", "幸福");
    }
}
// 链消息处理器
class ChainMsgProcessor{
    FilterChain filterChain;
    private String msg;
    public FilterChain getFilterChain() {
        return filterChain;
    }
    public void setFilterChain(FilterChain filterChain) {
        this.filterChain = filterChain;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String process() {
        return filterChain.doFilter(msg);
    }
}
// 过滤链，循环调用其他过滤
class FilterChain implements CFilter{
    List<CFilter> filters = new ArrayList<CFilter>();
    public FilterChain add(CFilter f){
        filters.add(f);
        //返回this的好处是：可以链式编程
        return this;
    }
    @Override
    public String doFilter(String msg){
        for(CFilter f : filters){
            msg = f.doFilter(msg);
        }
        return msg;
    }
}