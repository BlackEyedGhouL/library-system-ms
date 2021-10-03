<%-- 
    Document   : all_books
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
        </style>

    </head>
    <body>
        <div class="p-3 mb-2 text-white">
            <div>            
                <h2 style="text-align: center; padding: 30px;">List of Books</h2>
                <form:form method="POST" action="/all-books" modelAttribute="book">
                    <table>                                    
                        <tr>
                            <td style="padding: 10px"><input type="submit" value="Get all available books"/></td>
                        </tr>
                    </table>
                </form:form>
            </div>
            <div>
                <table class="table table-striped table-dark">
                    <tbody>
                        <tr>
                            <td style="font-weight: bold">Book Id</td>
                            <c:forEach items="${searchedBook}" var="book">
                                <td>${book.book_id}</td>
                            </c:forEach>
                        </tr>
                        <tr>
                            <td style="font-weight: bold">Book Name</td>
                            <c:forEach items="${searchedBook}" var="book">
                                <td>${book.book_name}</td>
                            </c:forEach>
                        </tr>
                        <tr>
                            <td style="font-weight: bold">Book Author</td>
                            <c:forEach items="${searchedBook}" var="book">
                                <td>${book.book_author}</td>
                            </c:forEach>
                        </tr>
                    </tbody>
                </table>
            </div> 
        </div>
    </body>
</html>

