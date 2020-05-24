var current="problems_list.html";
function myfun(v)
{
	document.getElementById("myFrame").src = v;
	document.getElementById(v).className = "active";
    document.getElementById(current).className = "";
	current = v;
}