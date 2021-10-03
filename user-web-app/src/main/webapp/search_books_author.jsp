<%-- 
    Document   : search_books_author
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
                <h2 style="text-align: center; padding: 30px;">Search Books by Author</h2>
                <form:form method="POST" action="/search-books-author" modelAttribute="book">
                    <table>                    
                        <tr>
                            <td><form:label path="book_author">Book Author</form:label></td>
                            <td><form:input path="book_author" required="true"/></td>
                        </tr>                 
                        <tr>
                            <td style="padding-top: 10px; padding-bottom: 20px;"><input type="submit" value="Search"/></td>
                        </tr>
                    </table>
                </form:form>
            </div>
            <div>
                <c:if test="${empty searchedBook}">
                    <h6 style="text-align: center; padding: 30px;">No Results!</h6>
                </c:if>
                <c:if test="${!empty searchedBook}">
                    <div>
                        <table class="table table-striped table-dark">
                            <tbody>
                                <tr>
                                    <td style="font-weight: bold">Book Id</td>
                                    <td><c:out value="${searchedBook.book_id}"/></td>
                                </tr>
                                <tr>
                                    <td style="font-weight: bold">Book Name</td>
                                    <td><c:out value="${searchedBook.book_name}"/></td>
                                </tr>
                                <tr>
                                    <td style="font-weight: bold">Book Author</td>
                                    <td><c:out value="${searchedBook.book_author}"/></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </c:if>
            </div>
        </div>
    </body>
</html>

