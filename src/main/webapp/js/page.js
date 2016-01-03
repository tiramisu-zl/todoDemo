$(function () {
    getAllTodoList();
    var todoListDom = $(".todo-list");
    var addNewTodoInput = $('.new-todo');

    function getAllTodoList() {
        var dataList, listHtml = '';
        $.ajax({
            url: "/index/",
            type: "GET",
            success: function (json_todo) {
                dataList = JSON.parse(json_todo);
                dataList.forEach(function (item) {
                    listHtml += concatString(item.id, item.content, item.status);
                });
                todoListDom.html(listHtml);
            }
        })
    }

    addNewTodoInput.keydown(function (e) {
        if (e.keyCode == 13) {
            var content = addNewTodoInput.val();
            $.ajax({
                url: "/add",
                data: {content: content},
                type: "POST",
                success: function (result) {
                    if (result === "success") {
                        getAllTodoList();
                        addNewTodoInput.val("");
                    }
                }
            })
        }
    });

    todoListDom.delegate(".destroy", "click", function (e) {
        var closest = $(e.target).closest("li");
        var id = closest.data("id");
        $.ajax({
            url: "/del",
            data: {id: id},
            type: "POST",
            success: function (result) {
                if (result === "success") {
                    getAllTodoList();
                }
            }
        })
    }).delegate(".toggle", "change", function (e) {
        var target = $(e.target);
        var closest = target.closest("li");
        var id = closest.data("id");
        var status = target.val();
        var content = target.next().text();
        $.ajax({
            url: "/edit",
            data: {id: id, content:content, status: status},
            type: "POST",
            success: function (result) {
                var result = JSON.parse(result);
                if (result.status) {
                    closest.addClass("completed");
                }else{
                    closest.removeClass("completed");
                }
                target.val(result.status);
            }
        })
    }).delegate("label", "dblclick", function(e){
        var target = $(e.target);
        var text = target.text();
        var closest = target.closest("li");
        closest.addClass("editing").find(".edit").val(text);
    }).delegate(".edit", "keydown blur", function(e){
        var target = $(e.target);
        var closest = target.closest("li");
        var id = closest.data("id");
        var content = target.val();
        var status = closest.find(".toggle").val();
        if (e.keyCode === 13 || e.type === "focusout") {
            editContent(closest, id, content, status);
        }
    });

    function editContent(closest, id, content, status){
        $.ajax({
            url: "/edit",
            data: {id:id, content:content, status:status},
            type: "POST",
            success: function (result) {
                var result = JSON.parse(result);
                if(result.content){
                    closest.removeClass("editing").find("label").text(result.content);
                }
            }
        })
    }

    function concatString(id, content, status) {
        var className = status ? "completed" : "";
        var checked = status ? "checked" : "";
        var expectString =
            "<li data-id=" + id + " class='" + className + "'>" +
                "<div class='view'>" +
            "<input class='toggle' type='checkbox' " + checked + " value='" + status + "'>" +
                    "<label>" + content + "</label>" +
                    "<button class='destroy'></button>" +
                "</div>" +
                "<input class='edit' value=''>" +
            "</li>";
        return expectString;
    }
});