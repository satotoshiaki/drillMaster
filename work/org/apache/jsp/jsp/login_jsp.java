/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.0.M15
 * Generated at: 2017-07-14 02:04:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"ja\">\n");
      out.write("\t<head>\n");
      out.write("\t\t<meta charset=\"utf-8\">\n");
      out.write(" \t \t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write(" \t \t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write(" \t \t<title>DrillMaster</title>\n");
      out.write(" \t\t<link href=\"/drillMaster/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write(" \t\t<link href=\"/drillMaster/css/signin.css\" rel=\"stylesheet\">\n");
      out.write("\t</head>\n");
      out.write("\t<body>\n");
      out.write("\t\t<div class=\"jumbotron text-center\" style=\"background-color:#FFF;color:#000\">\n");
      out.write(" \t \t\t<h1 class=\"text-center\">Drill Master</h1>\n");
      out.write(" \t \t</div>\n");
      out.write(" \t \t<div class=\"container\">\n");
      out.write("\n");
      out.write("        \t<form action=\"./LoginServlet\" method=\"POST\" class=\"form-signin\">\n");
      out.write("\t        \t<h2 class=\"form-signin-heading text-center\">ログイン情報を<br>入力して下さい</h2>\n");
      out.write("\t       \t\t<input type=\"text\" name=\"userId\" class=\"form-control\" placeholder=\"ユーザーid\" maxlength=\"12\" required autofocus>\n");
      out.write("\t      \t    <input type=\"password\" name=\"userPass\" class=\"form-control\" placeholder=\"パスワード\" maxlength=\"12\" required>\n");
      out.write("\t     \t    <button class=\"btn btn-lg btn-warning btn-block\" type=\"submit\" name=\"login\" value=\"Login\">サインイン</button>\n");
      out.write("      \t\t</form>\n");
      out.write("\t\t</div> <!-- container -->\n");
      out.write("\n");
      out.write("<!--\n");
      out.write("\t\t<c:if test=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${result != 0}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("\t\t\t<div class=\"text-center\" style=\"color:#ff0000; font-size:125%;\">入力されたUser Id、またはPasswordが違います。</div>\n");
      out.write("\t\t</c:if>\n");
      out.write("-->\n");
      out.write("\n");
      out.write("\t\t<br><br>\n");
      out.write("\n");
      out.write("\t\t<hr>\n");
      out.write(" \t\t<div class=\"footer\"><p>&nbsp;&nbsp;&nbsp;&copy; Toshiaki SATO</p></div>\n");
      out.write("\n");
      out.write("  \t\t<script src=\"/drillMaster/js/all.min.js\"></script>\n");
      out.write(" \t\t<script src=\"/drillMaster/js/bootstrap.min.js\"></script>\n");
      out.write("\t</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
