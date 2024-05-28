
function AJAX()
{
	this.Http = false;
	this.Http = this.createXMLHttpRequest();
	this.value = null;
	this.xmlValue = null;
	this.state = false;
}
AJAX.prototype.author = function()
{
	alert("ajax for liyuanchao\n2007-12-01");
}
AJAX.prototype.help = function()
{
	var str = "var ajax = new AJAX();\n";
	    str += "ajax.post(url);\n";
	    str += "if(ajax.isOK()) \n{\n    var value = ajax.getValue();\n}";
	alert(str);
}
AJAX.prototype.createXMLHttpRequest = function()
{
 if(window.ActiveXObject)
 return new ActiveXObject("Microsoft.XMLHTTP");
 else if(window.XMLHttpRequest)
 return new XMLHttpRequest();
}
AJAX.prototype.post = function(url)
{
	this.Http.open("POST", url, false);
	this.Http.send(null);
	if(this.Http.readyState==4)
	{
		if(this.Http.status==200)
		{
			this.state = true;
			this.value = this.Http.responseText;
			this.xmlValue = this.Http.responseXML;
		}
	}
}
AJAX.prototype.getValue = function()
{
	return this.value;
}
AJAX.prototype.getXmlValue = function()
{
	return this.xmlValue;
}
AJAX.prototype.isOK = function()
{
	return this.state;
}
