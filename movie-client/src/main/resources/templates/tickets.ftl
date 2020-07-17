<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>选座</title>
    <script src="/js/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css"/>
    <script src="/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<form action="/buy" method="post">
    <div align="center" style="border:1px black solid ;height: 100px;width: 30%;margin: 5% auto">
        <h1 style="margin: auto"><span class="badge badge-secondary">银幕</span></h1>
        <input type="text" name="userId" value="${userId!""}" hidden>
        <input type="text" name="siteId" value="${siteId!""}" hidden>
    </div>
    <div align="center">
        <#assign l=1..20/>
        <#assign z=1..5/>
        <#assign flag=["A","B","C","D","E"]/>
        <#list z as j>
            <#list l as i>
                <#assign isExists=false/>
                <#list list as tickets>
                    <#if tickets == hallId+flag[j-1]+i>
                        <#assign isExists=true/>
                    </#if>
                </#list>
                <#if isExists>
                    <div class="form-check form-check-inline">
                        <label class="form-check-label">
                            <input type="checkbox" class="form-check-input" name="seatNumber"
                                   value="${hallId+flag[j-1]+i}" disabled>
                        </label>
                    </div>
                <#else >
                    <div class="form-check form-check-inline">
                        <label class="form-check-label">
                            <input type="checkbox" class="form-check-input" name="seatNumber"
                                   value="${hallId+flag[j-1]+i}" >
                        </label>
                    </div>
                </#if>
            </#list>
            <br/>
        </#list>
        <br/>
        <br/>
        <br/>
        <button type="submit" class="btn btn-primary">确认购买</button>
    </div>

</form>

</body>
</html>