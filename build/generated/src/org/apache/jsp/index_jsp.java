package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        \n");
      out.write("        <script src=\"https://www.google.com/recaptcha/api.js\" async defer></script>\n");
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
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("  function random() {\n");
      out.write("    return Math.random().toString(36).substr(2); // Eliminar `0.`\n");
      out.write("};\n");
      out.write(" \n");
      out.write("function token() {\n");
      out.write("    return random() + random(); // Para hacer el token más largo\n");
      out.write("};\n");
      out.write(" document.getElementById(\"csrf\").value = token();\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("    \n");
      out.write("    \n");
      out.write(" <meta name=\"csrf\" content=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${_csrf.token}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("    <!-- default header name is X-CSRF-TOKEN -->\n");
      out.write("    <meta name=\"_csrf_header\" content=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${_csrf.headerName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("    <!-- ... -->\n");
      out.write("    \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    function validarcampos(e)\n");
      out.write("{\n");
      out.write("key = e.keyCode || e.which;\n");
      out.write("tecla = String.fromCharCode(key).toString();\n");
      out.write("datos = \"ABCDEFGHIJKLMÑOPQRSTUVWXYZabcdefghijklmnñopqrstvwxyz1234567890\";\n");
      out.write("\n");
      out.write("especiales = [8,13];\n");
      out.write("tecla_e = false\n");
      out.write("for(var i in especiales) {\n");
      out.write("if(key == especiales[i]){\n");
      out.write(" tecla_e = true;\n");
      out.write(" break;\n");
      out.write("}\n");
      out.write("}\n");
      out.write("\n");
      out.write("if(datos.indexOf(tecla) == -1 && !tecla_e)\n");
      out.write("{\n");
      out.write(" alert(\"ingreso de caracteres invalido\");\n");
      out.write(" return false;\n");
      out.write("}\n");
      out.write("}\n");
      out.write("    \n");
      out.write("    \n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("   \n");
      out.write("    <div class=\"modal-dialog text-center\">\n");
      out.write("        \n");
      out.write("        <div class=\"col-sm-10 main-section\">\n");
      out.write("            \n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                \n");
      out.write("                 <div class=\"form-group  \">\n");
      out.write("                 <h2> Iniciar sesión </h2>\n");
      out.write("                 <br>\n");
      out.write("                 <br>\n");
      out.write("                    </div>\n");
      out.write("                <div class=\"col-12 user-img\">\n");
      out.write("                   \n");
      out.write("                    <img src=\"statico/img/user.png\" th:src=\"@{/img/user.png}\"/>\n");
      out.write("                    \n");
      out.write("                  <form class=\"col-12\" method=\"post\" action=\"cont_logeo\">\n");
      out.write("  \n");
      out.write("                                <div class=\"form-group  \">\n");
      out.write("                                    <br>\n");
      out.write("                              \n");
      out.write("                \n");
      out.write("                                 <input type=\"text\" class=\"form-control \" id=\"usu\" name=\"usuario\" placeholder=\"Usuario\" required autocomplete=\"off\" \n");
      out.write("                                        onkeypress=\"validarcampos(event);\" required>\n");
      out.write(" \t\t\t\t </div>\n");
      out.write("  \n");
      out.write("                                <div class=\"form-group  \">\n");
      out.write("                                 <input type=\"password\" class=\"form-control\" id=\"PASWORD\" name=\"clave\"\n");
      out.write("                                        placeholder=\"Contraseña\" required autocomplete=\"off\" onkeypress=\"validarcampos(event);\" required>\n");
      out.write("                                 \n");
      out.write("                                </div>\n");
      out.write("                       <div class=\"form-group  \">\n");
      out.write("                           <input type=\"hidden\" name=\"csrf\" value=\"\";>\n");
      out.write("                                </div>\n");
      out.write("                      \n");
      out.write("  \n");
      out.write("           <div id=\"g-recaptcha\" >\n");
      out.write("               \n");
      out.write("           </div>\n");
      out.write("      <br/>\n");
      out.write("      \n");
      out.write("     \n");
      out.write("      \n");
      out.write("      <button type=\"submit\" name=\"btn_loging\" class=\"btn btn-primary\" >Ingresar</button>\n");
      out.write("   \n");
      out.write("  <br>\n");
      out.write("  <p> <a  href=\"registrarse.jsp\"> Registrarse </a> </p>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("      var onloadCallback = function() {\n");
      out.write("        grecaptcha.render('g-recaptcha', {\n");
      out.write("          'sitekey' : '6LerAoYaAAAAAG2i5u7jdDuQWPUw5D5qCXOO1L6_'\n");
      out.write("        });\n");
      out.write("      };\n");
      out.write("    </script>\n");
      out.write("    <script src=\"https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit\"\n");
      out.write("        async defer>\n");
      out.write("    </script>\n");
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
