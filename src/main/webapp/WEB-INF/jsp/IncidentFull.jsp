<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>Список активных нарядов</title></head>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
  <body>
  <h3>Данные наряда ${n_incident}</h3>

  <span>Логин -   </span><c:out value="${incidеnt.service}" /><br>
  <span>Адрес -   </span><c:out value="${incidеnt.address}"/> -<c:out value="${incidеnt.room}"/><br>
  <span>Наименование  -</span><c:out value="${incidеnt.nameclient}"/><br>
  <span>Заявлено - </span><c:out value="${incidеnt.declared}"/><br>
  <span>Контрольный срок -  </span><c:out value="${incidеnt.controlterm}"/><br>
  <span>Sla              -  </span><c:out value="${incidеnt.controltermsla}"/><br>
  <span>Контрольный срок задачи - </span><c:out value="${incidеnt.controltermtask}"/><br>
  <span>Время визита -  </span><c:out value="${incidеnt.decisiontime}"/><br>
  <span>Повторность -   </span><c:out value="${incidеnt.repet}"/><br>
  <span>Телефон -       </span><c:out value="${incidеnt.phone}"/><br>
  <span>Тех.данные - </span><c:out value="${incidеnt.techdata}"/><br>

  <span>Примечание - </span><c:out value="${incidеnt.comment}"/><br>
  <script>
    $("span").css( "color", "blue").css("font-weight", "bold");
  </script>
  </body>
</html>