document.write('<script type="text/javascript" charset="utf-8" src="../../js/jquery-easyui/jquery.min.js"></script>');
document.write('<script type="text/javascript" charset="utf-8" src="../../js/jquery-easyui/jquery.easyui.min.js"></script>');
document.write('<script type="text/javascript" charset="utf-8" src="../../js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>');
document.write('<link rel="stylesheet" type="text/css" href="../../js/jquery-easyui/themes/default/easyui.css">');
document.write('<link rel="stylesheet" type="text/css" href="../../js/jquery-easyui/themes/icon.css">');

//转换日期格式
function changeDateFormat(cellval) {
    if (cellval != null) {
        var date = new Date(parseInt(cellval.replace("/Date(", "").replace(")/", ""), 10));
        var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
        var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
        return date.getFullYear() + "-" + month + "-" + currentDate;
    }
};
function tolocaldate(value){
    var date = new Date(value.time);
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    var d = date.getDate();
    var h = date.getHours();
    var M = date.getMinutes();
    var s = date.getSeconds();
    return y + '-' +m + '-' + d + ' ' + h + ':' + M + ':' + s;
}

