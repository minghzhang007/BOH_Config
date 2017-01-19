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
    <link href="<%=basePath%>/static/css/jquery-easyui/common.css" rel="stylesheet" type="text/css"/>
    <link href="<%=basePath%>/static/css/jquery-easyui/icon.css" rel="stylesheet" type="text/css"/>
    <link href="<%=basePath%>/static/css/jquery-easyui/easyui.css" rel="stylesheet" type="text/css"/>
    <link href="<%=basePath%>/static/css/layer.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div style="text-align: center">
    <table id="mydatagrid">
    </table>
</div>

<script type="text/javascript" src="<%=basePath%>/static/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/js/layer.js"></script>
<script type="text/javascript">
    $(function () {
        $('#mydatagrid').datagrid({
            title: 'BOH开关配置',
            iconCls: 'icon-ok',
            width: 1300,
            rownumbers:true,
            nowrap: true,//设置为true，当数据长度超出列宽时将会自动截取
            striped: true,//设置为true将交替显示行背景。
            collapsible: true,//显示可折叠按钮
            toolbar: "#tb",//在添加 增添、删除、修改操作的按钮要用到这个
            url: '/boh-cnf/zk/getListJson',//url调用Action方法
            loadMsg: '数据装载中......',
            singleSelect: true,//为true时只能选择单行
            fitColumns: true,//允许表格自动缩放，以适应父容器
            //sortName : 'xh',//当数据表格初始化时以哪一列来排序
            //sortOrder : 'desc',//定义排序顺序，可以是'asc'或者'desc'（正序或者倒序）。
            remoteSort: false,
            rowStyler:function(index,record){
               /* console.info(index);
                console.info(record);*/
            },
            columns: [[
                {
                    field: 'identity',
                    width: 180,
                    title: '开关标识',
                    formatter:function(value,record,index){
                        return '<span title='+value+'>'+value+'</span>';
                    }
                },
                {
                    field: 'level',
                    width: 100,
                    title: '级别',
                    formatter:function(value,record,index){
                        if(value == 1){
                            return "接口级别";
                        }else
                        if (value ==2){
                            return "业务类型级别";
                        }else
                        if (value ==3){
                            return "功能级别";
                        }else
                        if (value ==4){
                            return "参数级别";
                        }else
                        if (value ==5){
                            return "日志级别";
                        }else
                        if (value ==6){
                            return "变量级别";
                        }
                    }
                },
                {
                    field: 'content',
                    width: 250,
                    title: '内容',
                    formatter:function(value,record,index){
                        return '<span title='+value+'>'+value+'</span>';
                    }
                },
                {
                    field: 'mark',
                    width: 250,
                    title: '描述',
                    formatter:function(value,record,index){
                        return '<span title='+value+'>'+value+'</span>';
                    }
                },
                {
                    field: 'systemId',
                    width: 80,
                    title: '所属系统',
                    formatter:function(value,record,index){
                        if (value ==1){
                            return "BOH-NM";
                        }
                        if (value ==2){
                            return "BOH-PRC";
                        }
                        if (value ==3){
                            return "BOH-OTH";
                        }
                        if (value == 4){
                            return "BOH-CACHE";
                        }
                        if (value ==5){
                            return "BOH-CNF";
                        }
                    }
                },
                {
                    field: 'delFlag',
                    width: 80,
                    title: '有效性',
                    formatter:function(value,record,index){
                        if (value ==0){
                            return "有效";
                        }
                        if (value ==1){
                            return "无效";
                        }
                    }
                },
                {
                    field:'opt',
                    width:200,
                    title:'操作',
                    align:'center',
                    formatter:function(value,record,index){
                        var btn = '<a onclick="update(\''+record.identity+'\')" href="javascript:void(0)">编辑</a> '+
                                ' <a onclick="remove(\''+record.identity+'\')" href="javascript:void(0)">删除</a>';
                        return  btn;
                    }
                }
            ]],
            pagination: true,//分页
            pageSize: 20,//默认选择的分页是每页5行数据
            pageList: [5, 10, 15, 20,40,100],//可以选择的分页集合
            toolbar:[
                {
                    text:'新增开关' ,
                    iconCls:'icon-add' ,
                    handler:function(){
                        var url ="/boh-cnf/zk/toAdd"
                        layer.open({
                            type:2,
                            shade: [0.5, '#000', false],
                            fix: false, //不固定
                            maxmin: true,
                            title: ['新增开关开关', false],
                            area: ['700px', '500px'],
                            content:url
                        })
                    }
                }
            ]
        });
    });


    function update(identity){
        var url ="/boh-cnf/zk/toUpdate?identity="+identity
        layer.open({
            type:2,
            shade: [0.5, '#000', false],
            fix: false, //不固定
            maxmin: true,
            title: ['修改开关', false],
            area: ['700px', '500px'],
            content:url
        })
    }

    function remove(identity){
        var url = "/boh-cnf/zk/delete?identity="+identity;
        window.location.href =url;
    }

</script>
</body>
</html>
