<%@page import="bank.model.Register"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Display All Data</title>
    <style>
        body {
            background-color: rgb(212, 212, 212);
            font-family: Arial, sans-serif;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        table, th, td {
            border: 1px solid #ccc;
        }

        th, td {
            padding: 8px;
            text-align: left;
        }

        .message {
            text-align: center; /* Center-align the message */
            font-weight: bold; /* Make the font bold */
            font-size: 18px; /* Optionally, adjust the font size */
        }
    </style>
</head>
<body>
  <% List<Register> lst = null;
      Register reg = null; %>
      <%
      lst = (List<Register>) session.getAttribute("data");

      if (lst != null)
      {
          for (Register lstn : lst)
          {
              out.println(lstn.getRegNo() + "&nbsp" + lstn.getCustName() + "&nbsp" + lstn.getAccbal() + "&nbsp" + lstn.getUserName());
          }
      }
      else {
          out.println("<p class='message'>Privacy issue: Cannot display the data.</p>"); // Center-align the message
      }
      session.invalidate();
      %>
</body>
</html>
