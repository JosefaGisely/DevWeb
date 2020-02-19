package filtro;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdministradorFiltro {

    public AdministradorFiltro() {
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);
        if (session != null) {
            if (session.getAttribute("tipoSession") != null) {
                if (session.getAttribute("tipoSession").equals("adm")) {
                    chain.doFilter(request, response);
                    return;
                }
            }
        }
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.sendRedirect("../../index.html");
    }

    public void destroy() {
    }


    public void init(FilterConfig filterConfig) {

    }

}
