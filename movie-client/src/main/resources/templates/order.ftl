<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <title>Title</title>
</head>
<body>

<div align="center" style="margin-top: 80px">
    <table id="demo" lay-filter="test"></table>
</div>

<div class="layui-row">
    <div id="demo3" align="center"></div>
</div>

<script src="/layui/layui.js"></script>
<script>
    layui.use(['table','laypage'], function () {
        var table = layui.table
        , laypage = layui.laypage;

        //第一个实例
        table.render({
            elem: '#demo'
            , height: 312
            , width: 600
            , url: '/demo/table/user/' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {field: 'id', title: '片名', width: 80, sort: true, fixed: 'left'}
                , {field: 'username', title: '影院', width: 80}
                , {field: 'sex', title: '放映厅', width: 100, sort: true}
                , {field: 'city', title: '座位号', width: 100}
                , {field: 'sign', title: '上映时间', width: 160}
                , {field: 'experience', title: '操作', width: 80, sort: true}
            ]]
        });

        //自定义首页、尾页、上一页、下一页文本
        laypage.render({
            elem: 'demo3'
            ,count: 100
            ,first: '首页'
            ,last: '尾页'
            ,prev: '<em>←</em>'
            ,next: '<em>→</em>'
        });

        //测试数据
        var data = [
            '北京',
            '上海',
            '广州',
            '深圳',
            '杭州',
            '长沙',
            '合肥',
            '宁夏',
            '成都',
            '西安',
            '南昌',
            '上饶',
            '沈阳',
            '济南',
            '厦门',
            '福州',
            '九江',
            '宜春',
            '赣州',
            '宁波',
            '绍兴',
            '无锡',
            '苏州',
            '徐州',
            '东莞',
            '佛山',
            '中山',
            '成都',
            '武汉',
            '青岛',
            '天津',
            '重庆',
            '南京',
            '九江',
            '香港',
            '澳门',
            '台北'
        ];

        //调用分页
        laypage.render({
            elem: 'demo20'
            ,count: data.length
            ,jump: function(obj){
                //模拟渲染
                document.getElementById('biuuu_city_list').innerHTML = function(){
                    var arr = []
                        ,thisData = data.concat().splice(obj.curr*obj.limit - obj.limit, obj.limit);
                    layui.each(thisData, function(index, item){
                        arr.push('<li>'+ item +'</li>');
                    });
                    return arr.join('');
                }();
            }
        });



    });
</script>
</body>
</html>