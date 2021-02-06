package study.chainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * 顺序处理数据，回调也会处理数据
 */
public class ChainOfResponsibilityRequestRespon {
    public static void main(String[] args) {
        String msg = "<html>敏感字眼</html>";

        Request request = new Request();
        request.setRequestStr(msg);
        Response response = new Response();
        response.setResponseStr("response------------");

        RRFilterChain fc = new RRFilterChain();
        fc.addFilter(new RRHTMLFilter()).addFilter(new RRSensitiveFilter());

        fc.doFilter(request, response, fc);
        System.out.println(request.getRequestStr());
        System.out.println(response.getResponseStr());
    }
}
class Request{
    private String requestStr;

    public String getRequestStr() {
        return requestStr;
    }

    public void setRequestStr(String requestStr) {
        this.requestStr = requestStr;
    }
}
class Response{
    private String responseStr;

    public String getResponseStr() {
        return responseStr;
    }

    public void setResponseStr(String responseStr) {
        this.responseStr = responseStr;
    }
}
// 过滤器接口
interface RRFilter{
    public void doFilter(Request request, Response response, RRFilterChain filterChain);
}
// html标签过滤实现
class RRHTMLFilter implements RRFilter{
    @Override
    public void doFilter(Request request, Response response, RRFilterChain filterChain) {
        request.setRequestStr(request.getRequestStr().replace('<', '[').replace(">", "]")+"---HTMLFilter()");
        filterChain.doFilter(request, response, filterChain);
        response.setResponseStr(response.getResponseStr()+"---HTMLFilter()");
    }
}
// 铭感字过滤实现
class RRSensitiveFilter implements  RRFilter{
    @Override
    public void doFilter(Request request, Response response, RRFilterChain filterChain) {
        request.setRequestStr(request.getRequestStr().replace("敏感", "幸福")+"---SensitiveFilter()");
        filterChain.doFilter(request, response, filterChain);
        response.setResponseStr(response.getResponseStr()+"---SensitiveFilter()");
    }
}
// 过滤链实现
class RRFilterChain implements  RRFilter{
    private List<RRFilter> filters = new ArrayList<RRFilter>();
    //标记执行到第几个filter
    int index = 0;
    public RRFilterChain addFilter(RRFilter filter) {
        filters.add(filter);
        return this;
    }
    @Override
    public void doFilter(Request request, Response response, RRFilterChain filterChain) {
        if(index == filters.size()) {
            return ;
        }
        RRFilter rrFilter = filters.get(index);
        index++;
        rrFilter.doFilter(request, response, filterChain);
    }
}
