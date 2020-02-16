import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;

public class filtro implements Filter {

    public void init(FilterConfig arg0) throws ServletException { }

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {

        PrintWriter out = resp.getWriter();


        chain.doFilter(req, resp);//sends request to


    }

    public void destroy() {}

}