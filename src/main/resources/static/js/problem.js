		function zoomin() { 
		
		
			document.getElementById("zoomin").className = "active";
		} 
		function zoomout() { 
			
		} 
		function submitfn() {
			
		}
		var lang = "C++";
		function language(v) {
			
			document.getElementById(lang).className = "";
			lang =  v;
			document.getElementById(lang).className = "active";
		}
		function testfn() {
			up();
			document.getElementById("test").className = "active";
			
		}
		function opposite() {
			if(document.getElementById("arrow").className == "arrow down")down();
			else up();
		}
		function up() {
			document.getElementById("bottomnav").style.bottom = "29%";
			document.getElementById("arrow").className = "arrow down";
			document.getElementById("inputoutput").className = "row bot";
		}
		function down() {
			document.getElementById("bottomnav").style.bottom = "0px";
			document.getElementById("arrow").className = "arrow up";
			document.getElementById("test").className = "";
			document.getElementById("error").className = "row bot collapse";
			document.getElementById("inputoutput").className = "row bot collapse";
		}
		var question = "Problems/1/";
		var curr_right_page = "question.html";
		function rightcontroller(v){
			document.getElementById(curr_right_page).className = "";
			curr_right_page = v;
			document.getElementById("myFrame").src = question+curr_right_page;
			document.getElementById(curr_right_page).className = "active";
			document.getElementById("myFrame").style.fontSize = "50pt";
		}