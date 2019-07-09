<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
   <head>
      <meta charset="UTF-8" />
      <title>Note</title>
   </head>
   <body>
      <h1>Скачать прайс с почтового ящика и загрузить в базу:</h1>

      <form action="<c:url value="/load"/>" method="post">
      				<input type="text" name="mail" placeholder="Адрес почты">
      				<input type="text" name="password" placeholder="Пароль">
      				<input type="text" name="supplier" placeholder="Поставщик">
      				<input type="text" name="smail" placeholder="Адрес почты поставщика">

      				<input type="submit" value="Выполнить">
      			</form>


   </body>

</html>
