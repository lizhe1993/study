<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script  type="text/javascript" src="./js/jquery-3.2.1.min.js" ></script>
    <script type="text/javascript" src="./js/json2.js"  ></script>
    <script type="text/javascript">
        $(function () {
            testRequestBody();
        });
        function testRequestBody() {
            $.ajax({
                url:"${pageContext.request.contextPath}/example9/json/testRequestBody"  ,
                dataType: "json",
                type: "post",
                contentType: "application/json",
                data: JSON.stringify({id: 1, name: "spring mvc 企业测试"}),
                async: true,
                success: function (data) {
                    console.log(data);
                    $("#id").html(data.id);
                    $("#name").html(data.name);
                    $("#author").html(data.author);
                },
                error: function () {
                    alert("数据发送失败");
                }
            });
        }
    </script>
    <title>Document</title>
</head>
<body>
编号：<span id="id"></span><br/>
书名：<span id="name"></span><br/>
作者：<span id="author"></span><br/>
</body>
</html>

