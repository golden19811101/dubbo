<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>首页</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
</head>
<body>
测试一：<a href="#" id="qMsg">获取消息</a>
<br>
测试二(用户操作)：
<br>
请输入用户id：<input type="text" id="userId" placeholder="不输入则查询用户列表">
<input type="button" id="qUserBtn" value="查询">
<input type="button" id="deleteUserBtn" value="删除">
<br>
<input type="number" id="id" placeholder="id">
<input type="text" id="name" placeholder="姓名">
<input type="number" id="age" placeholder="年龄">
<input type="button" id="saveUserBtn" value="保存">
<input type="button" id="updateUserBtn" value="更新">
<hr>
结果：
<ul>
    <li>444</li>
</ul>


<script src="../static/jquery.min.js"></script>
<script type="text/javascript">
    // ul绑定更新的点击事件
    function bindClick() {
        $("ul li").css("cursor","pointer");
        $("ul li").click(function(){
            var arr = $(this).text().split("--");
            // 赋值
            $("#id").val(arr[0]);
            $("#name").val(arr[1]);
            $("#age").val(arr[2]);
        });
    }
    $(function () {
        // 获取消息
        $("#qMsg").click(function () {
            $.get("/sendMsg", function (data) {
                if(data.code == 0){
                    $("ul").html("<li>" + data.msg + "</li>");
                }else{
                    $("ul").html("");
                }
            });
        });
        //查询用户
        $("#qUserBtn").click(function () {
            var url = "/user/";
            var userId = $("#userId").val();
            if(null != userId && "" != userId){
                url += userId;
            }else{
                url += "list";
            }
            $.get(url, function (data) {
                if(data.code == 0){
                    var result = "";
                    if(null != data.user && "" != data.user){
                        result +="<li>";
                        result += data.user.id + "--" + data.user.name + "--" + data.user.age;
                        result +="</li>";
                        $("ul").html(result);
                    }else if(null != data.userList && "" != data.userList){
                        for(var i = 0 ; i < data.userList.length ; i ++){
                            result +="<li>";
                            result += data.userList[i].id + "--" + data.userList[i].name + "--" + data.userList[i].age;
                            result +="</li>";
                        }
                        $("ul").html(result);
                        bindClick();
                    }else{
                        $("ul").html("<li>无数据</li>");
                    }
                }else{
                    $("ul").html("<li>无数据</li>");
                }
            });
        });
        // 删除用户
        $("#deleteUserBtn").click(function () {
            var userId = $("#userId").val();
            if(null != userId && "" != userId){
                $.get("/user/delete/" + userId, function (data) {
                    if(data.code == 0){
                        $("ul").html("<li>" + data.msg + "</li>");
                    }else{
                        $("ul").html("<li>删除失败！</li>");
                    }
                });
            }else{
                $("ul").html("<li>请输入用户id！</li>");
            }
        });
        //保存
        $("#saveUserBtn").click(function () {
            var id = $("#id").val();
            var name = $("#name").val();
            var age = $("#age").val();
            if(null == userId && "" == userId){
                $("ul").html("<li>请输入用户id！</li>");
            }
            if(null == name && "" == name){
                $("ul").html("<li>请输入姓名！</li>");
            }
            if(null == age && "" == age){
                $("ul").html("<li>请输入年龄！</li>");
            }
            $.ajax({
                type: "POST",
                async: false,
                url: "/user/save",
                dataType:"json",
                contentType: "application/json",
                data:JSON.stringify({
                    id: id,
                    name: name,
                    age: age
                }),
                success:function(data){
                    if(data.code == 0){
                        $("ul").html("<li>" + data.msg + "</li>");
                    }else{
                        $("ul").html("<li>" + data.msg + "</li>");
                    }
                }
            });
        });
        //更新
        $("#updateUserBtn").click(function () {
            var id = $("#id").val();
            var name = $("#name").val();
            var age = $("#age").val();
            if(null == userId && "" == userId){
                $("ul").html("<li>请输入用户id！</li>");
            }
            if(null == name && "" == name){
                $("ul").html("<li>请输入姓名！</li>");
            }
            if(null == age && "" == age){
                $("ul").html("<li>请输入年龄！</li>");
            }
            $.ajax({
                type: "POST",
                async: false,
                url: "/user/update",
                dataType:"json",
                contentType: "application/json",
                data:JSON.stringify({
                    id: id,
                    name: name,
                    age: age
                }),
                success:function(data){
                    if(data.code == 0){
                        $("ul").html("<li>" + data.msg + "</li>");
                    }else{
                        $("ul").html("<li>" + data.msg + "</li>");
                    }
                }
            });
        });
    });
</script>
</body>
</html>
