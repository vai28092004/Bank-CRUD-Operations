<%@page import="bank.model.Register" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        body {
        	margin-top:200px;
            background-color: #f1f1f1;
            font-family: Arial, sans-serif;
        }
        
         .message {
        text-align: center;
        margin-top: 520px; /* Adjust the margin as needed for vertical spacing */
    }

        form {
            background-color: #ffffff;
            padding: 20px;
            margin: 20px auto;
            width: 400px;
            border: 1px solid #ccc;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 5px;
        }

        table {
            width: 100%;
        }

        td {
            padding: 10px;
        }

        h1 {
            font-size: 24px;
            margin-left: 12px; /* Adjust the margin as needed to shift the title to the right */
        }

        input[type="text"] {
            width: 100%;
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        input[type="submit"] {
            background-color:  #3498db;
            color: #fff;
            border: none;
            padding: 10px 15px;
            margin-top: 10px;
            border-radius: 3px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
         p {
        text-align:center;
    }

    p.success {
        color: green;
    }

    p.error {
        color: red;
    }
    </style>
</head>
<body>
    <form action="RetriveController" method="get">
        <h1>Enter Register Number</h1>
        <table>
            <tr>
                <td><input type="text" name="regno"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Retrive"></td>
            </tr>
        </table>
    </form>
    <%
        String message = (String) session.getAttribute("message");
        String error = (String) session.getAttribute("error");
        
        if (message != null) {
    %>
            <p class="success"><%= message %></p>
    <%
        }
        if (error != null) {
    %>
            <p class="error"><%= error %></p>
    <%
        }
        
        // Clear the session attributes after displaying the message
        session.removeAttribute("message");
        session.removeAttribute("error");
    %>
    
   
   
</body>
</html>
