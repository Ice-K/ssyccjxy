<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8"/>
<base href="<%=basePath%>" />
<body>
    <h2>登录</h2>
    <form action="<%=basePath%>login" method="post">
        <table>
            <tr>
                <td>用户：</td>
                <td>
                    <label>
                        <input type="text" name="username"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td>密码：</td>
                <td>
                    <label>
                        <input type="password" name="password"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td>验证码：</td>
                <td>
                    <label>
                        <input type="text" name="imgCode"/><a href="javascript:changeImg()"><img id="imgCode" src="<%=basePath%>imgCode" alt=""></a>
                    </label>
                </td>
            </tr>
            <tr>
                <td colspan="2"><button type="submit">提交</button></td>
            </tr>
        </table>


    </form>
</body>
<script type="text/javascript">
    $(function () {
        
    });
    
    function changeImg() {
        var img = document.getElementById("imgCode");
        var d = new Date();
        var time = d.getTime();//如果没有这个
        //下面这一句不会起作用，因为浏览器的缓存技术，图片并不会刷新
        //img.src="/myHelloWeb/servlet/ImageServlet";
        img.src='<%=basePath%>imgCode?t='+time;
        //?号后面的东西是通过get方式传递的
    }
</script>
</html>
