<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        h2 {
            text-align: center;
        }

        table {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
        }

        td {
            border-bottom: 1px solid #3e3c3c;
            text-align: center;
            padding: 10px;
        }

        th {
            font-size: medium;
            padding: 10px;
        }

        [type="submit"] {
            text-align: center;
            margin-top: 10px;
            color: white;
            background: #007bff;
            padding: 10px;
        }

        .btn-filter {
            color: white;
            background: #73c14b;
            padding: 10px;
        }

        a {
            color: white;
            background: #007bff;
            border: none;
            border-radius: 5px;
            padding: 10px;
            text-decoration: none;
            text-align: center;
        }

        .search {
            text-align: center;
            margin-bottom: 10px;
            background: white;
        }

        .search-input, select {
            padding: 10px;
        }

    </style>
</head>
<body>
<h2>Danh sách sinh viên</h2>
<form class="search" action="/students/search" method="get">
    <input type="text" name="keyword" class="search-input" placeholder="Tìm kiếm"/>
    <select name="order">
        <option value="asc">Tăng dần</option>
        <option value="desc">Giảm dần</option>
    </select>
    <button type="submit" class="btn-filter">Lọc</button>
</form>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Email</th>
        <th>Ngày Sinh</th>
        <th>Điểm trung bình</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="stu" items="${students}">
        <tr>
            <td>${stu.id}</td>
            <td>${stu.studentName}</td>
            <td>${stu.email}</td>
            <td>${stu.birthday}</td>
            <td>${stu.avgMark}</td>
            <td>
                <a href="students/edit/${stu.id}">Sửa</a>
                <a href="students/delete/${stu.id}" onclick="return confirm('Bạn có chắc muốn xóa không?')">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/students/add">Thêm sinh viên</a>

</body>
</html>
