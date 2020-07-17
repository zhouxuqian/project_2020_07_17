<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>注册用户</title>
    <script src="/js/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css"/>
    <script src="/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h1 align="center">注册用户</h1>
    <div align="center">
        <form action="/register" method="post" >
            <div class="form-group" >
                <label for="username">用户名:</label>
                <input type="text" class="form-control-sm" name="username" placeholder="用户名">
            </div>
            <div class="form-group">
                <label for="password">密 码：</label>
                <input type="password" class="form-control-sm" name="password" placeholder="密码">
            </div>
            <button type="submit" class="btn btn-primary">注册</button>
        </form>
    </div>
</div>
</body>
</html>