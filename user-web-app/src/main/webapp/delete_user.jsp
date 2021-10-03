<%-- 
    Document   : delete_user
    Author     : Senith Umesha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>SU Library</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

        <style>
            body 
            {
                background-image: url(b.png);
                background-size: cover;
                background-attachment: fixed;
            }

            .form {
                margin-left: auto;
                margin-right: auto;      
            }
        </style>

    </head>
    <body>
        <div class="p-3 mb-2 text-white">           
            <h2 style="text-align: center; padding: 30px;">Delete Account</h2>
            <form:form method="POST" action="/delete-user" modelAttribute="user">
                <table class="form">                    
                    <tr>
                        <td><form:label path="name">Name </form:label></td>
                        <td><form:input path="name" required="true"/></td>
                    </tr>                 
                    <tr>
                        <td style="padding-top: 10px"><input type="submit" value="Delete Account"/></td>
                    </tr>
                </table>
            </form:form>
        </div>        
    </body>
</html>

