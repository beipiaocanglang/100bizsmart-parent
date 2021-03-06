package biz.consume.frame.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 用于为某个URL加上相应的文件头，以便输出至浏览器可以识别，如缓存图片,CSS等
 *
 * @author : lijianjun
 * @version V1.0
 * @Description: TODO
 * @Company:Justin
 * @date: 2015年11月16日 上午10:20:42
 */
@SuppressWarnings("rawtypes")
public class ResponseHeaderFilter implements Filter {
    private FilterConfig fc;

    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        // set the provided HTTP response parameters   
        for (Enumeration e = fc.getInitParameterNames(); e.hasMoreElements(); ) {
            String headerName = (String) e.nextElement();
            response.addHeader(headerName, fc.getInitParameter(headerName));
        }

        chain.doFilter(req, response);
    }

    public void init(FilterConfig filterConfig) {
        this.fc = filterConfig;
    }

    public void destroy() {
        this.fc = null;
    }

}