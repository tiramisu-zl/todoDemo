$(function () {
    init();
    var target = $(".todo-list");
    var THIS = $('.new-todo');

    function init(){
        //get data from db
        var dataList, listHtml = null;
        $.ajax({
            url:"/index/",
            type:"GET",
            success:function(json_todo){
                dataList = JSON.parse(json_todo);
                dataList.forEach(function(item){
                    listHtml += concatString(item.id, item.content, item.status);
                });
                target.append(listHtml);
            }
        })
    }
    THIS.keydown(function(e){
        if(e.keyCode==13){
            var content = THIS.val();
            $.ajax({
                url:"/index/add",
                data:{content:content},
                type:"POST",
                success:function(json_todo){
                    var todo = JSON.parse(json_todo);
                    target.append(concatString(todo.id,todo.name));
                    THIS.val("");
                }
            })
        }
    });

    function concatString(id,name,status){
        var expectString =
            "<li data-id=" + id + ">" +
            "<div class='view'>" +
            "<input class='toggle' type='checkbox' value='" + status + "'>" +
            "<label>" + name + "</label>" +
            "<button class='destroy'></button>" +
            "</div>" +
            "<input class='edit' value='123'>" +
            "</li>";
        return expectString;
    }
});