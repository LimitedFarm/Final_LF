/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.45
 * Generated at: 2019-10-31 04:52:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.Board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class PaymentA_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css?family=Noto+Serif+KR:200,300&display=swap&subset=korean\" rel=\"stylesheet\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/buttons.css\" />\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>결제 페이지</title>\r\n");
      out.write("<script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-1.12.4.min.js\" ></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"https://cdn.iamport.kr/js/iamport.payment-1.1.5.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<form action=\"");
      out.print(request.getContextPath());
      out.write("/PaySuccess.bo\" method=\"post\" id=\"submit\">\r\n");
      out.write("\r\n");
      out.write("<input type=\"hidden\" id=\"pid\" name=\"pid\">\r\n");
      out.write("<input type=\"hidden\" id=\"sid\" name=\"sid\">\r\n");
      out.write("<input type=\"hidden\" id=\"cid\" name=\"cid\">\r\n");
      out.write("<input type=\"hidden\" id=\"mCount\" name=\"mCount\">\r\n");
      out.write("\r\n");
      out.write("<input type=\"hidden\" id=\"cInput4\" name=\"Cname\">\t<!-- 이름 -->\r\n");
      out.write("<input type=\"hidden\" id=\"cInput5\" name =\"Cphone\">\t<!-- 연락처1 -->\r\n");
      out.write("<input type=\"hidden\" id=\"cInput6\" name =\"Cphone\">\t<!-- 연락처2 -->\r\n");
      out.write("<input type=\"hidden\" id=\"cInput7\" name =\"Cphone\">\t<!-- 연락처3 -->\r\n");
      out.write("<input type=\"hidden\" id =\"phone\" name=\"phone\"> <!-- 연락처 합친거 -->\r\n");
      out.write("<input type=\"hidden\" id=\"cInput8\" name=\"Cadd\">\t<!-- 주소1 -->\r\n");
      out.write("<input type=\"hidden\" id=\"cInput8\" name=\"Cadd\" value=\" \"> <!-- 주소구분 공백 -->\r\n");
      out.write("<input type=\"hidden\" id=\"cInput9\" name=\"Cadd\">\t<!-- 주소2 -->\r\n");
      out.write("<input type=\"hidden\" id=\"cInput8\" name=\"Cadd\" value=\" \"> <!-- 주소구분 공백 -->\r\n");
      out.write("<input type=\"hidden\" id=\"cInput10\" name=\"Cadd\">\t<!-- 주소3 -->\r\n");
      out.write("<input type=\"hidden\" id =\"address\" name=\"address\"> <!-- 주소 합친거 -->\r\n");
      out.write("<input type=\"hidden\" id=\"cInput11\" name=\"pPlz\">\t<!-- 배송 요청사항  -->\r\n");
      out.write("<input type=\"hidden\" id=\"cInput12\" name =\"pCount\">\t<!-- 수량 -->\r\n");
      out.write("\r\n");
      out.write("<input type=\"hidden\" id=\"cInput\">\t<!-- 결제수단 -->\r\n");
      out.write("<input type=\"hidden\" id=\"cInput2\" name =\"Pname\">\t<!-- 상품명 -->\r\n");
      out.write("<input type=\"hidden\" id=\"cInput3\" name =\"pPrice\">\t<!-- 가격 -->\r\n");
      out.write("</form>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\t\twindow.onload = function () {\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tdocument.getElementById(\"pid\").value = opener.document.getElementById(\"pid\").value;\r\n");
      out.write("\t\tdocument.getElementById(\"sid\").value = opener.document.getElementById(\"sid\").value;\r\n");
      out.write("\t\tdocument.getElementById(\"cid\").value = opener.document.getElementById(\"cid\").value;\r\n");
      out.write("\t\tdocument.getElementById(\"mCount\").value = opener.document.getElementById(\"mCount\").value;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\tdocument.getElementById(\"cInput\").value = opener.document.getElementById(\"throw\").value;\r\n");
      out.write("\t\tdocument.getElementById(\"cInput2\").value = opener.document.getElementById(\"throw2\").value;\r\n");
      out.write("\t\tdocument.getElementById(\"cInput3\").value = opener.document.getElementById(\"throw3\").value;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tdocument.getElementById(\"cInput4\").value = opener.document.getElementById(\"name\").value;\r\n");
      out.write("\t\tdocument.getElementById(\"cInput5\").value = opener.document.getElementById(\"phone1\").value;\r\n");
      out.write("\t\tdocument.getElementById(\"cInput6\").value = opener.document.getElementById(\"phone2\").value;\t\t\r\n");
      out.write("\t\tdocument.getElementById(\"cInput7\").value = opener.document.getElementById(\"phone3\").value;\r\n");
      out.write("\t\tdocument.getElementById(\"cInput8\").value = opener.document.getElementById(\"sample6_address\").value;\r\n");
      out.write("\t\tdocument.getElementById(\"cInput9\").value = opener.document.getElementById(\"sample6_detailAddress\").value;\r\n");
      out.write("\t\tdocument.getElementById(\"cInput10\").value = opener.document.getElementById(\"sample6_extraAddress\").value;\r\n");
      out.write("\t\tdocument.getElementById(\"cInput11\").value = opener.document.getElementById(\"selbox\").value;\r\n");
      out.write("\t\tdocument.getElementById(\"cInput12\").value = opener.document.getElementById(\"throw4\").value;\r\n");
      out.write("\t\tvar result='';\r\n");
      out.write("\t\t$('input[name=Cphone]').map(function(){\r\n");
      out.write("\t\t\tresult +=$(this).val();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tvar result1='';\r\n");
      out.write("\t\t$('input[name=Cadd]').map(function(){\r\n");
      out.write("\t\t\tresult1 +=$(this).val();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\tdocument.getElementById(\"phone\").value = result; // 전화번호 합친거\r\n");
      out.write("\tdocument.getElementById(\"address\").value = result1; // 주소 합친거\r\n");
      out.write("\t\t\r\n");
      out.write("\tvar payee = document.getElementById(\"cInput\").value;\r\n");
      out.write("\tvar pname = document.getElementById(\"cInput2\").value;\r\n");
      out.write("\tvar pprice = document.getElementById(\"cInput3\").value;\r\n");
      out.write("\tvar name2 = document.getElementById(\"cInput4\").value;\r\n");
      out.write("\t\r\n");
      out.write("\tvar IMP = window.IMP; // 생략가능\r\n");
      out.write("\tIMP.init('imp62749039'); // 'iamport' 대신 부여받은 \"가맹점 식별코드\"를 사용\r\n");
      out.write("\tIMP.request_pay({\r\n");
      out.write("\t    pg : 'html5_inicis', // version 1.1.0부터 지원.\r\n");
      out.write("\t    pay_method : payee,\r\n");
      out.write("\t    merchant_uid : 'merchant_' + new Date().getTime(),\r\n");
      out.write("\t    name : pname,\r\n");
      out.write("\t    amount : pprice,\r\n");
      out.write("\t    buyer_email : 'iamport@siot.do',\r\n");
      out.write("\t    buyer_name : name2,\r\n");
      out.write("\t    buyer_tel : '010-1234-5678',\r\n");
      out.write("\t    buyer_addr : '서울특별시 강남구 삼성동',\r\n");
      out.write("\t    buyer_postcode : '123-456',\r\n");
      out.write("\t    m_redirect_url : 'https://www.naver.com'\r\n");
      out.write("\t}, function(rsp) {\r\n");
      out.write("\t    if ( rsp.success ) {\r\n");
      out.write("\t    \tvar msg = name2 + '님의 결제가 완료되었습니다.\\n';\r\n");
      out.write("\t        msg += '결제 금액 ' + rsp.paid_amount + \"원\";\r\n");
      out.write("\t        document.getElementById('submit').submit();\r\n");
      out.write("\t        opener.location.replace('test.jsp');\r\n");
      out.write("\t        window.close();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t    } else {\r\n");
      out.write("\t        var msg = '결제에 실패하였습니다.';\r\n");
      out.write("\t        msg += '에러내용 : ' + rsp.error_msg;\r\n");
      out.write("\t        window.close();\r\n");
      out.write("\t    }\r\n");
      out.write("\t    alert(msg);\r\n");
      out.write("\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
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
