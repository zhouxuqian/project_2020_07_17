//同步请求 门店一级
function getHall(cinemaId,pageNum,flag) {
   /* console.log(flag)*/
    if (!flag){
        $(".nav-link").removeClass("active");
        $("#cinemaId"+cinemaId).addClass("active");
    }


    $("#halls").html("");
    $.ajax({
        async:false,
        type: 'get',
        url: 'http://localhost:8081/hall?cinemaId=' + cinemaId,
        data: {},
        dataType: 'json',
        success: function (data) {
            var content ='';
            if (data.length != 0){
                $.each(data, function (index,cinema) {
                    if(index == 1){
                        content += '<option value="' + cinema.id + '" >' + cinema.name + '</option>';
                    }else {
                        content += '<option value="' + cinema.id + '" >' + cinema.name + '</option>';
                    }

                })
            }else {
                content += '<option value="0">整顿中</option>';
            }

            /*window.console.log(content)*/
            $("#halls").html(content);
            getMovie(pageNum);
        },
        error: function () {
            alert("connect error!");
        }
    })
}

// 影厅二级
function getMovie(pageNum) {
    $("#movies").html("");
    $("#page").html("");
    //获取厅id
    var hallId = $("#halls").val();
    //获取日期
    var showTime = $("#showTime").val();
    $.ajax({
        async: true,
        type: 'get',
        url: 'http://localhost:8081/movies?hallId=' + hallId,
        data: {
                showTime:showTime,
                pageNum:pageNum
                },
        dataType: 'json',
        success: function (data) {
            var content = "";
            $.each(data.movieList, function (index,movie) {
                content = '<div class="col-3" align="center" style="padding-bottom: 15px">'+
                    '<a href="https://www.baidu.com"><img src="/image/yw.jpg" alt="图片加载失败" height="170px" width="180px"><br/></a>' +
                    '<a href="https://www.baidu.com"><span style="font-size: 12px;color: #1b1e21">片名:'+movie.name+'</span><br/></a>' +
                    '<span style="font-size: 12px;color: #1b1e21">类型:'+movie.categoryName+'</span><br/>' +
                    '<span style="font-size: 12px;color: #1b1e21">主演:'+movie.protagonist+'</span><br/>' +
                    '<span style="font-size: 12px;color: #1b1e21">开始时间:'+dateFtt("yyyy-MM-dd",new Date(movie.showTime))+'</span><br/>' +
                    '<button type="button" class="btn btn-primary btn-sm" onclick="buy('+movie.siteId+')">购买</button>' +
                    '</div>';
                $("#movies").append(content);
            })
            /*console.log(data)*/
            myPage(data.pageNum,data.total);
        },
        error: function () {
            alert("connect error!");
        }
    })
}
function myPage(page,total) {
    var pageContent = '<ul class="pagination">\n';

    if(page==1){
        pageContent += '  <li class="page-item disabled"><a class="page-link" href="javascript:void(0)">首页</a></li>\n';
    }else {
        pageContent += '  <li class="page-item "><a class="page-link" href="javascript:void(0)" onclick="getMovie(1)">首页</a></li>\n';
    }
    for (var i=1;i<=total;i++){
        if (page==i){
            pageContent += '  <li class="page-item active"><a class="page-link" href="javascript:void(0)">'+i+'</a></li>\n';
        }else {
            pageContent += '  <li class="page-item"><a class="page-link" href="javascript:void(0)" onclick="getMovie('+i+')">'+i+'</a></li>\n';
        }
    }
    if(page==total){
        pageContent += '  <li class="page-item disabled"><a class="page-link" href="javascript:void(0)">尾页</a></li>\n';
    }else {
        pageContent += '  <li class="page-item "><a class="page-link" href="javascript:void(0)" onclick="getMovie('+total+')">尾页</a></li>\n';
    }
    pageContent += '</ul>';

    $("#page").html(pageContent);
}

function dateFtt(fmt,date)
{ //author: meizz
    var o = {
        "M+" : date.getMonth()+1,     //月份
        "d+" : date.getDate(),     //日
        "h+" : date.getHours(),     //小时
        "m+" : date.getMinutes(),     //分
        "s+" : date.getSeconds(),     //秒
        "q+" : Math.floor((date.getMonth()+3)/3), //季度
        "S" : date.getMilliseconds()    //毫秒
    };
    if(/(y+)/.test(fmt))
        fmt=fmt.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length));
    for(var k in o)
        if(new RegExp("("+ k +")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
    return fmt;
}

function fun_date(num) {

    var dateList=new Array();

    for (var i = 1; i <= num; i++) {
        var date1 = new Date();
        //今天时间
        var time1 = date1.getFullYear() + "-" + (date1.getMonth() + 1) + "-" + date1.getDate()
       /* console.log(time1);*/
        var date2 = new Date(date1);
        date2.setDate(date1.getDate() + i);
        //num是正数表示之后的时间，num负数表示之前的时间，0表示今天
        var time2 = date2.getFullYear() + "-" + (date2.getMonth() + 1) + "-" + date2.getDate();
        dateList[i-1]=time2;
    }
    /*console.log(dateList);*/
    return dateList;
}

function buy(siteId) {
    if ($("#user").text() == ''){
        /*未登录*/
        location.href="http://localhost:8081/goLogin";
    }else {
        /*已登录*/
        var userId = $("#userId").val();
        var hallId = $("#halls").val();
        location.href="http://localhost:8081/goBuy?userId="+userId+"&siteId="+siteId+"&hallId="+hallId;
    }

}
