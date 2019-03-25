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

            $.post("${pageContext.request.contextPath}/example9/json/testRequestBody1" ,null,
                function (data) {
                    console.log(data);
                    $.each(data,function () {
                       var tr = $("<tr align='center'>");
                       $("<td/>").html(data.id).appendTo(tr);
                       $("<td/>").html(data.name).appendTo(tr);
                       $("<td/>").html(data.author).appendTo(tr);
                       $("#booktable").appendTo(tr);
                    });
                },"json");
        }
    </script>
    <title>Document</title>
</head>
<body>
<table id="booktable" border="1" style="border-collapse: collapse;">
    <tr align="center">
        <td>编号</td>
        <td>书名</td>
        <td>作者</td>
    </tr>
</table>
</body>
</html>

