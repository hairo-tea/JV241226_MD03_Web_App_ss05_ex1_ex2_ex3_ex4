<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        h2 {
            text-align: center;
            color: #333;
        }

        .form-container {
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            max-width: 600px;
            margin: 0 auto;
        }

        label {
            display: block;
            margin: 10px 0 5px;
        }

        input {
            width: 100%;
            padding: 10px;
            margin: 5px 0 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        [type="submit"] {
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
        }
    </style>
</head>
<body>
<h2>Thêm mới sinh viên</h2>
<form class="form-container" action="/students/add" method="post">
    <label>Tên:</label>
    <input type="text" name="studentName"/>
    <label>Email:</label>
    <input type="email" name="email"/>
    <label>Ngày sinh:</label>
    <input type="date" name="birthday"/>
    <label>Điểm trung bình:</label>
    <input type="number" name="avgMark" step="0.1" min="0" max="10"/>
    <button type="submit">Thêm</button>
</form>
</body>
</html>
