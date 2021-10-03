<%-- 
    Document   : dashboard
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
            <h2 style="text-align: center; padding: 30px;">Welcome ${name} - Dashboard</h2>
            <h4 style="text-align: center; padding: 5px;">Profile</h4>
            <div>            
                <table class="form">
                    <thead>
                        <tr><td style="text-align:center"><a href="<c:url value='/edit-user'/>" >Edit Account</a></td></tr>
                        <tr><td style="text-align:center"><a href="<c:url value='/delete-user'/>" >Delete Account</a></td></tr>
                        <tr><td style="text-align:center"><a href="<c:url value='/log-in'/>" >Log Out</a></td></tr>
                    </thead>
                </table>
            </div>
            <h4 style="text-align: center; padding: 15px;">Library</h4>
            <div>            
                <table class="form">
                    <thead>
                        <tr><td style="text-align:center"><a href="<c:url value='/all-books'/>" >List of Books</a></td></tr>
                        <tr><td style="text-align:center"><a href="<c:url value='/search-books-name'/>" >Search Books by Name</a></td></tr>
                        <tr><td style="text-align:center"><a href="<c:url value='/search-books-author'/>" >Search Books by Author</a></td></tr>
                    </thead>
                </table>
            </div>
        </div>
    </body>
</html>

