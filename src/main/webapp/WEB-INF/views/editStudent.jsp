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

        button {
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
        }
    </style>

</head>
<body>
<h2>Cập nhật sinh viên</h2>
<form class="form-container" action="/students/edit/${student.id }" method="post">
    <input type="hidden" name="id" value="${student.id}"/>
    <label>Tên:</label>
    <input type="text" name="studentName" value="${student.studentName}"/>
    <label>Email:</label>
    <input type="email" name="email" value="${student.email}"/>
    <label>Ngày sinh:</label>
    <input type="date" name="birthday" value="${student.birthday}"/>
    <label>Điểm trung bình:></label>
    <input type="number" name="avgMark" value="${student.avgMark}"/>
    <button type="submit">Lưu</button>
</form>
</body>
</html>
