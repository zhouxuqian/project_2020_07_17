<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>万达影城</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css"/>
    <script src="/js/jquery-3.4.1.min.js"></script>
    <script src="/js/index.js"></script>
    <script src="/bootstrap/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        $(function () {
            getHall(1, 1, true);
            $("#halls").change(function () {
                getMovie();
            })

            $("#showTime").change(function () {
                getMovie();
            })

            $(".nav-link").change(function () {
                alert("ok")
            })

        });

    </script>

</head>
<body>

<div class="container">
    <#--登录-->
    <div class="row">
        <div class="col-10">
            <a href="#" style="color: red;font-size: 30px;">万达影城</a>
        </div>
        <div class="col-2">
            <#if Session.user??>
                <h6>当前用户 <span class="badge badge-secondary" id="user">${"${Session.user.username}"}</span></h6>
                <input type="text" id="userId" value="${"${Session.user.id}"}" hidden>
            <#else >
                <a href="/goLogin" class="btn btn-info" role="button">登录</a>
                <a href="/goRegister" class="btn btn-info" role="button">注册</a>
            </#if>
        </div>
    </div>
    <#--横线-->
    <hr/>

    <div class="row">
        <#--门店列表-->
        <div class="col-2">
            <ul class="nav flex-column nav-pills">
                <#list cinemaList as cinema>
                    <#if cinema.id = 1>
                        <li class="nav-item">
                            <a class="nav-link active " id="cinemaId${cinema.id}" href="javascript:void(0)"
                               onclick="getHall(${cinema.id},1,false)">${cinema.name}</a>
                        </li>
                    <#else >
                        <li class="nav-item">
                            <a class="nav-link " id="cinemaId${cinema.id}" href="javascript:void(0)"
                               onclick="getHall(${cinema.id},1,false)">${cinema.name}</a>
                        </li>
                    </#if>
                </#list>
            </ul>
        </div>
        <div class="col-10">
            <div class="row">
                <div class="col-3">
                    <span style="font-size: 20px;color: #1b1e21">放映厅</span>
                    <select id="halls" name="halls"></select>
                </div>
                &emsp;
                <#--上映日期-->
                <div class="col-4">
                    <span style="font-size: 20px;color: #1b1e21">上映时间</span>
                    <select id="showTime" name="showTime">
                        <#list nextWeek as d>
                            <option value="${d}">${d}</option>
                        </#list>
                    </select>
                </div>
            </div>
            <hr/>
            <#--电影列表容器-->
            <div class="row">
                <div class="row" id="movies"></div>

                <div class="row" id="page" style="margin: 0 auto;padding-top: 20px"></div>
            </div>
        </div>
    </div>

</div>

</body>
</html>