<h2>Update Employee</h2>
<form action="../update" method="post">
  <input type="hidden" name="eid" value="${employee.eid}">
  Name: <input type="text" name="ename" value="${employee.ename}"><br>
  Department: <input type="text" name="edept" value="${employee.edept}"><br>
  <input type="submit" value="Update">
</form>
