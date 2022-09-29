/**
 * 菜单
 * */
$(function () {
    layui.use('element', function () {
        var element = layui.element;
        // 左侧导航区域（可配合layui已有的垂直导航）
        $.get("/menu", function (data) {
            if (data != null) {
                getMenus(data);
                element.render('nav');
            } else {
                layer.alert("权限不足，请联系管理员", function () {
                    //退出
                    window.location.href = "/logout";
                });
            }
        });
    });
})
const getMenus = function (data) {


    //回显选中
    const ul = $("<ul class='layui-nav layui-nav-tree' lay-filter='test'></ul>");
    for (let i = 0; i < data.length; i++) {
        const node = data[i];
        const li = $("<li class='layui-nav-item' flag='" + node.id + "'></li>");
        const a = $("<a class='' href='javascript:;'>" + node.menuName + "</a>");
        li.append(a);
        //获取子节点
        const childArry = node.titleNode;
        if (childArry.length > 0) {
            a.append("<span class='layui-nav-more'></span>");
            const dl = $("<dl class='layui-nav-child'></dl>");
            for (const y in childArry) {
                const dd = $("<dd><a href='" + childArry[y].menuUrl + "'>" + childArry[y].menuName + "</a></dd>");
                //判断选中状态
                if (pathUri.indexOf(childArry[y].menuUrl) > 0) {
                    li.addClass("layui-nav-itemed");
                    dd.addClass("layui-this")
                }
                dl.append(dd);
            }
            li.append(dl);
        }
        ul.append(li);
    }
    $(".layui-side-scroll").append(ul);
}
//根据菜单主键id获取下级菜单
//id：菜单主键id
//arry：菜单数组信息
function getParentArry(id, arry) {
    var newArry = new Array();
    for (var x in arry) {
        if (arry[x].pId == id)
            newArry.push(arry[x]);
    }
    return newArry;
}


function updateUsePwd() {
    layer.open({
        type: 1,
        title: "修改密码",
        fixed: false,
        resize: false,
        shadeClose: true,
        area: ['450px'],
        content: $('#pwdDiv')
    });
}


//注意：导航 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function () {
    var $ = layui.jquery
        , element = layui.element;
    //获取所有的菜单
    $.ajax({
        url: "${ctx}/user/getMenu",
        type: "POST",
        dataType: "json",
        success: function (res) {
            var html = '';
            html += '<ul class="layui-nav layui-nav-tree"  lay-filter="test">';
            $.each(res, function (i, item) {
                html = html + '<li class="layui-nav-item">';
                html += '<a href="javascript:;" data-url="' + item.link + '" nav-id="' + item.id + '">' +
                    '<cite>' + item.title + '</cite></a>';
                if (item.titleNode != "" && item.titleNode.length > 0) {
                    html += '<dl class="layui-nav-child">';
                    $.each(item.titleNode, function (j, item2) {
                        html += '<dd>'
                        html += '<a href="javascript:;" data-url="' + item2.link + '" ' +
                            'nav-id="' + item2.id + '">' +
                            '<cite>' + item2.title + '</cite></a>';
                        if (item2.titleNode != "" && item2.titleNode.length > 0) {
                            html += '<ol class="layui-nav-child">';
                            $.each(item2.titleNode, function (k, item3) {
                                html += '<li>' +
                                    '<a href="javascript:;" data-url="' + item3.link + '" nav-id="' + item3.id + '">' +
                                    '<cite>' + item3.title + '</cite>' +
                                    '</a>' +
                                    '</li>';
                            });
                            html += '</ol>';
                        }
                    });
                    html += '</dl>';
                }
                html += '</li>';
            });
            html += '</ul>';
            $(".layui-side-scroll").append(html);
            element.init();
        }
    });
});
