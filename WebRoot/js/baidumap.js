function baiduMap( option ) {
    $.extend(this , option);
    this.start();
}
baiduMap.prototype = {
    province:null,
    city:null,
    district:null,
    lng:null,
    lat:null,
    zoom:15,
    btnID:null,
    id:'',     // input ID
    lngID:'', // lngID
    latID:'', // latID
    zoomID:"",
    mapID:'',//视图ID
    callback:function(){},
    Point:null,
    bgeo:null,
    bmap:null,
    marker:null,
    lock:true,
    ac:null,
    start:function () {
        var $this = this;
        this.input = document.getElementById(this.id);
        var objCity = new BMap.LocalCity();
        objCity.get(function (result){
            var city= result.name;
            var point = result.center;
            $this.lng = $this.lng || point.lng;
            $this.lat = $this.lat || point.lat;

            $this.Point = new BMap.Point($this.lng, $this.lat);
            $this.bgeo = new BMap.Geocoder();
            $this.bmap = new BMap.Map($this.mapID);
            $this.bmap.centerAndZoom($this.Point, 15);
            $this.bmap.enableScrollWheelZoom(true);

            var ac = new BMap.Autocomplete({    //建立一个自动完成的对象
                "input" : $this.id,
                "location" : $this.bmap
            });

            ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
                var _value = e.item.value;
                var myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
                //document.getElementById("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;
                //console.log(e);

                $this.searchKeywords(myValue)
            });

            $this.bmap.centerAndZoom($this.Point, 18);
            $this.bmap.addOverlay(new BMap.Marker($this.Point));    //添加标注

            var val = $($this.input).val();
            $($this.btnID).click(function(){
                $this.searchKeywords($($this.id).val());
            });
            ac.setInputValue(val);
            $this.ac = ac;
        });
    },
    searchKeywords: function(myValue){
        if(myValue==''){
            return;
        }
        var $this = this;
        $this.bmap.clearOverlays();    //清除地图上所有覆盖物
        var local = new BMap.LocalSearch($this.bmap, { //智能搜索
            onSearchComplete: myFun
        });
        function myFun(){
            var pp = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
            $this.bmap.centerAndZoom(pp, 18);
            $this.bmap.addOverlay(new BMap.Marker(pp));    //添加标注
            $this.showPointValue(pp);
        }
        local.search(myValue);
    },
    showPointValue: function(p) {
        var $this = this;
        var point = p || $this.marker.getPosition();
        var obj = {
            lng:point.lng,
            lat:point.lat,
            zoom:$this.bmap.getZoom(),
            address:$this.input.value
        };
        this.callback.call(this,obj);
        //$($this.lngID).val(point.lng);
        //$($this.latID).val(point.lat);
        //$($this.zoomID).val($this.bmap.getZoom());
    }
}

function showSelectAddress( id ) {
    var obj = {
        id:id+'_input',
        mapID:id+'_view',
        callback:function (val) {
            //console.log(JSON.stringify(val));

            $('#'+id).val(JSON.stringify(val));
        }
    }
    // 数据解码
    try{
        var json = JSON.parse($("#"+id).val());
        if(json && json.address){
            $('#'+obj.id).val(json.address);
            obj.lng =json.lng;
            obj.lat = json.lat;
            obj.zoom = json.zoom;
        }
    }catch (e) {

    }
    new baiduMap(obj);
}

function showAddressView( id , obj ) {
    if(!obj){
        return;
    }
    var $this = {};
    $this.Point = new BMap.Point(obj.lng, obj.lat);
    $this.bgeo = new BMap.Geocoder();
    var map = $this.bmap = new BMap.Map(id+'_view');
    $this.bmap.centerAndZoom($this.Point, obj.zoom);
    $this.bmap.enableScrollWheelZoom(true);

    var marker = new BMap.Marker($this.Point);
    $this.bmap.addOverlay(marker);    //添加标注

    var opts = {
        width : 200,     // 信息窗口宽度
        height: 100,     // 信息窗口高度
        title : "" , // 信息窗口标题
        enableMessage:true,//设置允许信息窗发送短息
        message:"亲耐滴，晚上一起吃个饭吧？戳下面的链接看下地址喔~"
    }

    var url = "http://api.map.baidu.com/marker?location="+obj.lat+","+obj.lng+"&title=目的地&content="+obj.address+"&output=html&src=webapp.baidu.openAPIdemo&output=html";


    var infoWindow = new BMap.InfoWindow("地址："+obj.address+'<br><a href="'+url+'">导航</a>');
    map.openInfoWindow(infoWindow,$this.Point); //开启信息窗口

    marker.addEventListener("click", function(){
        map.openInfoWindow(infoWindow,$this.Point); //开启信息窗口
    });
}




