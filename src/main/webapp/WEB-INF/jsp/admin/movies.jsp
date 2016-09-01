

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <tr><td>id</td><td>title</td><td>price</td><td>photo</td></tr>
        <c:forEach items="${movies}"var="movie">
            <tr><td>${movie.id}</td><td>${movie.title}</td><td>${movie.price}</td><td><img src="../resources/images${movie.photo}"/>photo</td><td><a href="updatemovie=${movie.id}">edit</a></td></tr>
        </c:forEach>
            <tr><td colspan="5">
                    <c:forEach begin="1" end="${totalpages}" varStatus="counter">
                         <a href="movies?page=${counter.count}">${counter.count}</a>
                    </c:forEach>               
           </td>
       </tr>
        </table>
    </body>
</html>
