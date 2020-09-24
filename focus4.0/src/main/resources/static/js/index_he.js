
	var array = ["../images/focus_001_2.jpg","../images/focus_003.jpg"];
	var i = 0;
	function imgFlush(){
	document.getElementById("img").src = array[i];
		i++;
		if(i == array.length){
            i = 0;
        	}
    	}
		//设置定时器
		//setTimeout("function",timeout),之执行一次
		//setInterval("function",timeout),重复执行
		setInterval("imgFlush()",7000);