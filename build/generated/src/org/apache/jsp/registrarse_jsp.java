package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registrarse_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\" xmlns:th=\"http://www.thymeleaf.org\">\n");
      out.write("<head>\n");
      out.write("    <title>registrarse</title>\n");
      out.write("\n");
      out.write("    <!--JQUERY-->\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("    \n");
      out.write("    <!-- FRAMEWORK BOOTSTRAP para el estilo de la pagina-->\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\">\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"></script>\n");
      out.write("    \n");
      out.write("    <!-- Los iconos tipo Solid de Fontawesome-->\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.0.8/css/solid.css\">\n");
      out.write("    <script src=\"https://use.fontawesome.com/releases/v5.0.7/js/all.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Nuestro css-->\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"statico/css/index.css\" th:href=\"@{/css/index.css}\">\n");
      out.write(" \n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("   \n");
      out.write("    <div class=\"modal-dialog text-center\">\n");
      out.write("        \n");
      out.write("        <div class=\"col-sm-8 main-section\">\n");
      out.write("            \n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                   <div class=\"form-group  \">\n");
      out.write("                 <h2> Registro </h2>\n");
      out.write("                 <br>\n");
      out.write("                 <br>\n");
      out.write("                    </div>\n");
      out.write("                <div class=\"col-12 user-img\">\n");
      out.write("                   \n");
      out.write("                    <img src=\"statico/img/user.png\" th:src=\"@{/img/user.png}\"/>\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                   \n");
      out.write("                  <form class=\"col-12\" method=\"post\" action=\"control_reg\">\n");
      out.write("  \n");
      out.write("  \t\t\t\t <div class=\"form-group  \">\n");
      out.write("  \t\t\t  \n");
      out.write("                           <br>\n");
      out.write("                                 <input type=\"text\" name=\"usuario\"class=\"form-control \" id=\"usu\" placeholder=\"Usuario\" required autocomplete=\"off\">\n");
      out.write(" \t\t\t\t </div>\n");
      out.write("                      \n");
      out.write("                                  <div class=\"form-group  \">\n");
      out.write("  \t\t\t\t\n");
      out.write("                                 <input type=\"text\" name=\"nombre\" class=\"form-control \" id=\"nom1\" placeholder=\"Nombre \" required autocomplete=\"off\">\n");
      out.write(" \t\t\t\t</div>\n");
      out.write("                      \n");
      out.write("                                  <div class=\"form-group  \">\n");
      out.write("                                \n");
      out.write("                                <input type=\"text\" name=\"apellido\"class=\"form-control\" id=\"APEL\" placeholder=\"Apellido\" required autocomplete=\"off\">\n");
      out.write("                                </div>\n");
      out.write("                      \n");
      out.write("                                 <div class=\"form-group  \">\n");
      out.write("                                 \n");
      out.write("                                 <input type=\"password\" name=\"clave\" class=\"form-control\" id=\"PASWORD\" placeholder=\"Contraseña\" required autocomplete=\"off\">\n");
      out.write("                                  </div>\n");
      out.write("                                 \n");
      out.write("                                 <div class=\"form-group  \">\n");
      out.write("                                 \n");
      out.write("                                 <input type=\"email\" class=\"form-control\" name=\"email\" id=\"EMAILL\" aria-describedby=\"emailHelp\" placeholder=\"Correo electronico\" required size=\"30\">\n");
      out.write("                                 </div>\n");
      out.write("                                \n");
      out.write("                      <small id=\"emaill\" style=\"color:#FF0000;\"  class=\"form-text text-muted\">Sus datos estan seguros</small>\n");
      out.write("\n");
      out.write("                      <button type=\"submit\" id=\"bn\" name=\"btn_loging\" class=\"btn btn-primary\">Registrarse</button>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("   <script src =\" node_modules/sweetalert2/dist/sweetalert2.all..min.js \"> </script >\n");
      out.write("    <script>\n");
      out.write("          function  sweetalertclick(){\n");
      out.write("               \n");
      out.write("       Swal('Oops...', 'Som', 'error')\n");
      out.write("        }\n");
      out.write("            \n");
      out.write("    </script>\n");
      out.write("        \n");
      out.write("    \n");
      out.write("   \n");
      out.write("    \n");
      out.write("    \n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
