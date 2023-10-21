<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nhận diện chữ viết tay</title>
</head>
<body>
    <h1>Chọn tệp tin để nhận diện</h1>
    
    <!-- Biểu mẫu để tải file lên -->
    <form method="POST" action="UploadServlet" enctype="multipart/form-data">
        <input type="file" name="file">
        <button type="submit">Tải lên</button>
    </form>
    
    
</body>
</html>