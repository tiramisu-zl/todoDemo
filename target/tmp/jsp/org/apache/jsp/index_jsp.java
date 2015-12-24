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

      out.write("<html>\n");
      out.write("<head lang=\"en\">\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>TODO - jsp servlet</title>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"./bower_components/todomvc-common/base.css\">\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"./bower_components/todomvc-app-css/index.css\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<section class=\"todoapp\">\n");
      out.write("    <header class=\"header\">\n");
      out.write("        <h1>todos</h1>\n");
      out.write("        <input class=\"new-todo\" placeholder=\"What needs to be done?\" autofocus=\"\">\n");
      out.write("    </header>\n");
      out.write("    <section class=\"main\">\n");
      out.write("        <input class=\"toggle-all\" id=\"toggle-all\" type=\"checkbox\">\n");
      out.write("        <label for=\"toggle-all\">Mark all as complete</label>\n");
      out.write("        <ul class=\"todo-list\">\n");
      out.write("            <!--<c:forEach items=\"");
      out.print( todoItems );
      out.write("\" var=\"todo\">-->\n");
      out.write("                <!--<li data-id=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${todo.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write('"');
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${todo.status==1? \"class='completed'\":\"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(">-->\n");
      out.write("                    <!--<div class=\"view\">-->\n");
      out.write("                        <!--<input class=\"toggle\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${todo.status}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">-->\n");
      out.write("                        <!--<label>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${todo.content}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</label>-->\n");
      out.write("                        <!--<button class=\"destroy\"></button>-->\n");
      out.write("                    <!--</div>-->\n");
      out.write("                    <!--<input class=\"edit\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${todo.content}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">-->\n");
      out.write("                <!--</li>-->\n");
      out.write("            <!--</c:forEach>-->\n");
      out.write("        </ul>\n");
      out.write("    </section>\n");
      out.write("    <footer class=\"footer\" style=\"display: none;\">\n");
      out.write("        <span class=\"todo-count\"><strong>0</strong> items left</span>\n");
      out.write("        <ul class=\"filters\">\n");
      out.write("            <li>\n");
      out.write("                <a class=\"selected\" href=\"#/all\">All</a>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"#/active\">Active</a>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"#/completed\">Completed</a>\n");
      out.write("            </li>\n");
      out.write("        </ul>\n");
      out.write("\n");
      out.write("    </footer>\n");
      out.write("</section>\n");
      out.write("<script  src=\"./bower_components/jquery/dist/jquery.min.js\"></script>\n");
      out.write("<script  src=\"./js/page.js\"></script>");
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
