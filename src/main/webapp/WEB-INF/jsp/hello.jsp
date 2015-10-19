<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>Слабоумие и Отвага</title>
</head>
<body>
    <h1>Предстоящие игры</h1>
    <c:forEach items="${games}" var="game">
        <h2><c:out value="${game.name}"/></h2>
        <table>
            <thead>
                <th>Поле</th>
                <th></th>
            </thead>
            <tbody>
                <c:forEach items="${game.field}" var="player">
                    <tr>
                        <td><c:out value="${player.name}"/></td>
                        <td><c:out value="${player.comment}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
            <thead>
                <th>Штаб</th>
                <th></th>
            </thead>
            <tbody>
                <c:forEach items="${game.hq}" var="player">
                    <tr>
                        <td><c:out value="${player.name}"/></td>
                        <td><c:out value="${player.comment}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <table>
            <thead>
                <th>Имя</th>
                <th>Коментарий</th>
                <th></th>
            </thead>
            <form name="form1" method="post">
                <tbody>
                    <input type="hidden" name="gameName" value="${game.name}">
                    <input type="hidden" name="actionType" value="${game.name}">
                    <td><input type="text" name="name" size="20"></td>
                    <td><input type="text" name="comment" size="60"></td>
                    <td><select name="where" size="2" multiple="multiple" tabindex="1">
                                <option value="1">Поле</option>
                                <option value="2">Штаб</option>
                              </select></td>
                    <td><input type="submit" name="submit" value="Готово"></td>
                </tbody>
            </form>
        </table>
    </c:forEach>
    <h1>Добавить игру</h1>
    <table>
            <thead>
                <th>Название</th>
                <th>Дата</th>
            </thead>
            <form name="form2" method="post" action="addGame">
                <tbody>
                    <td><input type="text" name="name" size="20"></td>
                    <td><input type="date" name="date" size="60"></td>
                    <td><input type="submit" name="submit" value="Готово"></td>
                </tbody>
            </form>
        </table>
</body>
</html>
