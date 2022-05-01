<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students Details</title>
<style>
  @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;400;600&display=swap');

* {
  box-sizing: border-box;
}

body {
  font-family: 'Poppins', 'Verdana', sans-serif;
  display: flex;
  align-items: center;
  padding: 1.25em;
  min-height: 100vh;
  color: #444;
}

table {
  width: 100%;
  border-spacing: 0;
  border-radius: 1em;
  overflow: hidden;
}

thead {
 visibility: hidden;
 position: absolute;
 width: 0;
 height: 0;
}

th {
  background: #215A8E;
  color: #fff;
}

td:nth-child(1) {
  background: #215A8E;
  color: #fff;
  border-radius: 1em 1em 0 0;
}

th, td {
  padding: 1em;
}

tr, td {
  display: block;
}

td {
  position: relative;
}

td::before {
  content: attr(data-label);
  position: absolute;
  left: 0;
  padding-left: 1em;
  font-weight: 600;
  font-size: .9em;
  text-transform: uppercase;
}

tr {
  margin-bottom: 1.5em;
  border: 1px solid #ddd;
  border-radius: 1em;
  text-align: right;
}

tr:last-of-type {
  margin-bottom: 0;
}

td:nth-child(n+2):nth-child(odd) {
  background-color: #ddd;
}


@media only screen and (min-width: 768px) {
  
  table {
    max-width: 1200px;
    margin: 0 auto;
    border: 1px solid #ddd;
  }
  
  thead {
    visibility: visible;
    position: relative;
  }
  
  th {
    text-align: left;
    text-transform: uppercase;
    font-size: .9em;
  }
  
  tr {
    display: table-row;
    border: none;
    border-radius: 0;
    text-align: left;
  }
  
  tr:nth-child(even) {
  background-color: #ddd;
}
  
  td {
    display: table-cell;
  }
  
  td::before {
    content: none;
  }
  
  td:nth-child(1) {
    background: transparent;
    color: #444;
    border-radius: 0;
  }
  
  td:nth-child(n+2):nth-child(odd) {
    background-color: transparent;
  }
  
  
}
</style>
</head>
<body>
<table>
  <thead>
    <th>Roll No</th>
    <th>Name</th>
    <th>Phone</th>
  </thead>
<%@page import ="java.sql.*"%>
<% String url = "jdbc:mysql://localhost/StudDetails";
 String user = "root";
String password = "Your DataBase Password";
try{
Connection connection = DriverManager.getConnection(url,user,password);
Statement statement = connection.createStatement();
String query = "SELECT * FROM Student";
ResultSet resultSet = statement.executeQuery(query);
while(resultSet.next()){
%>  
  <tbody>
    <tr>
      <td data-label="name"><a href="Update.html"><%= resultSet.getInt("RollNo") %></a></td>
      <td data-label="war"><%= resultSet.getString("name") %></td>
      <td data-label="ba"><%= resultSet.getString("phone") %></td>
    </tr>
  </tbody>
 <%
}
}
 catch(Exception e){
		e.printStackTrace();
	}
 %>
</table>
</body>
</html>