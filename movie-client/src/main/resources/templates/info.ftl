<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
<script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
<script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

<div class="layui-container">
    <div class="layui-row">
        <div class="layui-col-xs10">
            <a href="#" style="color: red;font-size: 30px;">万达影城</a>
        </div>
        <div class="layui-col-xs1">
            <a href="#" style="font-size: 20px;" class="layui-btn layui-btn-normal">登录</a>
        </div>
        <div class="layui-col-xs1">
            <a href="#" style="font-size: 20px;" class="layui-btn layui-btn-normal">注册</a>
        </div>
    </div>

    <hr class="layui-bg-black">

    <div class="layui-row">
        <div class="layui-col-xs2">
            <div class="grid-demo grid-demo-bg1">
                <img src="/image/yw.jpg" alt="图片加载失败" height="200px" width="180px">
            </div>
        </div>

        <div class="layui-col-xs8">
            <br/>
            <div class="layui-row">
                <div class="layui-col-xs12 ">
                    <div class="grid-demo">
                        <span style="font-size: 15px;color: #1b1e21">
                                因故来到美国唐人街的叶问（甄子丹 饰），意外卷入一场当地军方势力与华人武馆的纠纷，面对日益猖狂的民族歧视与压迫，叶问挺身而出，在美国海军陆战队军营拼死一战，以正宗咏春，向世界证明了中国功夫。
                        </span>
                        <hr class="layui-bg-black">
                        <div class="layui-row">
                            <div class="layui-col-xs3">
                                111111111111111
                            </div>
                            <div  class="layui-col-xs9">
                                因故来到美国唐人街的叶问（甄子丹 饰），意外卷入一场当地军方势力与华人武馆的纠纷，面对日益猖狂的民族歧视与压迫，叶问挺身而出，在美国海军陆战队军营拼死一战，以正宗咏春，向世界证明了中国功夫。
                            </div>
                        </div>

                        <br/>

                        <div class="layui-row">
                            <div class="layui-col-xs3">
                                111111111111111
                            </div>
                            <div  class="layui-col-xs9">
                                因故来到美国唐人街的叶问（甄子丹 饰），意外卷入一场当地军方势力与华人武馆的纠纷，面对日益猖狂的民族歧视与压迫，叶问挺身而出，在美国海军陆战队军营拼死一战，以正宗咏春，向世界证明了中国功夫。
                            </div>
                        </div>

                        <div class="layui-row">
                            <div id="demo3" align="center"></div>
                        </div>

                        <div class="layui-form-item layui-form-text">
                            <label class="layui-form-label">普通文本域</label>
                            <div class="layui-input-block">
                                <textarea placeholder="请输入内容" class="layui-textarea"></textarea>
                            </div>
                        </div>

                        <div align="center"><button class="layui-btn-normal">发表评论</button> </div>

                    </div>
                </div>
            </div>
        </div>

        <div class="layui-col-xs2">
            <div align="center">
                <p>主要演员：</p>

                   <p>甄子丹</p>
                   <p>甄子丹</p>
                   <p>甄子丹</p>
                   <p>甄子丹</p>
                <br/>

                发行公司：<br/>
                   <p>上海博纳文化传媒</p>
                <br/>

                上映时间：<br/>
                   <p>2019-12-01</p>
            </div>
        </div>

    </div>

</div>

<script src="/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['laypage', 'layer'], function(){
        var laypage = layui.laypage
            ,layer = layui.layer;

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