layui.use('form', function(){
    alert("aaaaaaaaaaaaaaaa")
    var form = layui.form;

    //各种基于事件的操作，下面会有进一步介绍
    form.on('submit(login)', function(data){
        console.log(data.elem) //被执行事件的元素DOM对象，一般为button对象
        console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
        console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });
});