var selectTypeVa=document.getElementsByName("selectType").value;
var chaxunVa= document.getElementById("ipt01").value;
document.getElementById("btn01").onclick=function () {
    alert(chaxunVa);
    alert(selectTypeVa);
    location.href = "/selectReal?chaxun="+ chaxunVa + "&selectTYpe=" + selectTypeVa;
}
