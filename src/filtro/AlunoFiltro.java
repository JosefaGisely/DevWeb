package filtro;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AlunoFiltro implements Filter {

    public AlunoFiltro() {
    }

    public void init(FilterConfig filterConfig) {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);
        if (session != null) {
            if (session.getAttribute("tipoSession") != null) {
                if (session.getAttribute("tipoSession").equals("aluno") || session.getAttribute("tipoSession").equals("adm")) {
                    chain.doFilter(request, response);
                    return;
                }
            }
        }
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.sendRedirect("../../index.html");
    }


    public void destroy() {}

}