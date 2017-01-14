<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<%
    String basePath = request.getContextPath();
    pageContext.setAttribute("basePath", basePath);
%>
<head>
    <title>列表页</title>
    <link href="<%=basePath%>/static/css/layer.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div style="text-align: center">
    <table class="mydatagrid">
    <%--    <thead>
        <tr>
            <th>标识</th>
            <th>级别</th>
            <th>内容</th>
            <th>描述</th>
            <th>所属系统</th>
            <th>有效性</th>
            <th>操作</th>
        </tr>
        </thead>--%>


    </table>
</div>

<script type="text/javascript" src="<%=basePath%>/static/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/js/layer.js"></script>
<script type="text/javascript">
    $(function () {
        $('#mydatagrid').datagrid({
            title: 'BOH开关配置',
            iconCls: 'icon-ok',
            width: 600,
            pageSize: 5,//默认选择的分页是每页5行数据
            pageList: [5, 10, 15, 20],//可以选择的分页集合
            nowrap: true,//设置为true，当数据长度超出列宽时将会自动截取
            striped: true,//设置为true将交替显示行背景。
            collapsible: true,//显示可折叠按钮
            toolbar: "#tb",//在添加 增添、删除、修改操作的按钮要用到这个
            url: '/boh-config/zk/toList',//url调用Action方法
            loadMsg: '数据装载中......',
            singleSelect: true,//为true时只能选择单行
            fitColumns: true,//允许表格自动缩放，以适应父容器
            //sortName : 'xh',//当数据表格初始化时以哪一列来排序
            //sortOrder : 'desc',//定义排序顺序，可以是'asc'或者'desc'（正序或者倒序）。
            remoteSort: false,
            frozenColumns: [[
                {
                    field: 'identity',
                    width: 80,
                    title: '开关标识'
                },
                {
                    field: 'level',
                    width: 80,
                    title: '级别'
                },
                {
                    field: 'content',
                    width: 150,
                    title: '内容'
                },
                {
                    field: 'mark',
                    width: 150,
                    title: '描述'
                },
                {
                    field: 'systemId',
                    width: 80,
                    title: '所属系统'
                },
                {
                    field: 'delFlag',
                    width: 80,
                    title: '有效性'
                }
            ]],
            pagination: true//分页
        });

        //设置分页控件
        var p = $('#mydatagrid').datagrid('getPager');
        $(p).pagination({
            total: 23,
            rows: 10,
            pageNumber: 10,
            pageList: [10, 20, 30],// 可以设置每页记录条数的列表
            onBeforeRefresh: function () {
            },
            onSelectPage: function (pageNumber, pageSize) {//分页触发
                find(pageNumber, pageSize);
            }
        });

        function find(pageNumber, pageSize) {
            if (validate()) {
                $("#mydatagrid").datagrid('getPager').pagination({pageSize: pageSize, pageNumber: pageNumber});//重置
                $("#mydatagrid").datagrid("loading"); //加屏蔽
                $.ajax({
                    type: "POST",
                    dataType: "json",
                    url: "/boh-config/zk/toList",
                    data: {
                        'page': pageNumber,
                        'rows': pageSize
                    },
                    success: function (data) {
                        $("#mydatagrid").datagrid('loadData', pageData(data.rows, data.total));//这里的pageData是我自己创建的一个对象，用来封装获取的总条数，和数据，data.rows是我在控制器里面添加的一个map集合的键的名称
                        var total = data.total;
                        $("#mydatagrid").datagrid("loaded"); //移除屏蔽
                    },
                    error: function (err) {
                        $.messager.alert('操作提示', '获取信息失败...请联系管理员!', 'error');
                        $("#mydatagrid").datagrid("loaded"); //移除屏蔽
                    }
                });
            }
        }

        function validate() {
            return true;
        }

        function pageData(list, total) {
            var obj = new Object();
            obj.total = total;
            obj.rows = list;
            return obj;
        }

    });
</script>
</body>
</html>
