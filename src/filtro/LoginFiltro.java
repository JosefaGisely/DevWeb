package filtro;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class LoginFiltro implements Filter {
    public LoginFiltro() {
    }


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            if (request.getParameterMap().containsKey("password")) {
                if (request.getParameter("password") != null) {
                    String senha = request.getParameter("password");
                    String senhaMD5 = getMd5(senha);
                    request.setAttribute("password", senhaMD5);
                }
            }
            chain.doFilter(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Erro no filtro de login ao encriptar senha: " + ex);
        }
        return;
    }

    public String getMd5(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(senha.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException ex) {
            System.err.println("Erro no metodo getMd5(): " + ex);
            throw new RuntimeException(ex);
        }
    }

    public void init(FilterConfig filterConfig) {
    }


    public void destroy() {
    }

    @Override
    public boolean isLoggable(LogRecord logRecord) {
        return false;
    }
}
