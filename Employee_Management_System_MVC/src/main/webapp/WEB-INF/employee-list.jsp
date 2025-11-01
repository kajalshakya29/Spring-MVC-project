<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Employee List</h2>
<a href="add">Add Employee</a>
<table border="1">
<tr><th>ID</th><th>Name</th><th>Department</th><th>Actions</th></tr>
<c:forEach var="e" items="${employees}">
<tr>
<td>${e.eid}</td>
<td>${e.ename}</td>
<td>${e.edept}</td>
<td>
  <a href="view/${e.eid}">View</a> |
  <a href="update/${e.eid}">Update</a> |
  <a href="delete/${e.eid}" onclick="return confirm('Are you sure you want to delete this employee?');">Delete</a>

</td>
</tr>
</c:forEach>
</table>
