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
<input type="text" id="userId" placeholder="不输入则查询用户列表">
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
</ul>


<script src="../static/jquery.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("#qMsg").click(function () {
            $.get("/sendMsg", function (data) {
                if(data.code == 0){
                    var result = "";
                    result +="<li>";
                    result +=data.msg;
                    result +="</li>";
                    $("ul").html(result);
                }else{
                    $("ul").html("");
                }
            });
        });

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
                    }else{
                        $("ul").html("无数据");
                    }
                }else{
                    $("ul").html("无数据");
                }
            });
        });
    });
</script>
</body>
</html>
