var _h5Callback___ = 1000;

function openAttachmentLayer(param , callback) {
    var key = 'jquery_h5_callback'+(_h5Callback___++);
    window[key] = function (result) {
        console.log(result);
        callback(result);
        window[key] = null;
    };
    layer.open({
        type: 2,
        title:'上传图片',
        area: ['320px', '150px'],
        fixed: true, //不固定
        maxmin: true,
        shadeClose:true,
        shade:0.5,
        content: 'upload.html?mul=1&'+$.param(param)+'&callback='+key,
    });
}

function showUploadImages(  id  ) {
    $(id).hide();
    var $tpl=$('<fieldset class="images_box">'+
        '<legend style="display:;width: auto;border-bottom:none;"><button class="btn btn-primary btn-block uploadBtn" type="button"> <span class="fa fa-cloud-upload"></span> 上传图片</button></legend>'+
        '<div id="gellay_images" class="imagesList"></div>'+
        '</fieldset>'
    );
    var $gellay = $tpl.find('#gellay_images');
    try{
        var values = $(id).val().split(',');
        if(values.length>0){
            appendImages($gellay, values);
        }
    }catch(e){
    }

    $(id).before($tpl);
    $tpl.on('click' , '.uploadBtn,.thumb,.btnClose',function (e) {
        if($(this).hasClass('uploadBtn')){
            var param = {
                mul:1
            };
            openAttachmentLayer(param , function (values) {
                appendImages($gellay,values);
                updateInputValue();
            });
        }else if($(this).hasClass('thumb')){
            jdk.showImage($(this).find('img').attr('src'));
        }else if($(this).hasClass('btnClose')){
            $(this).parents('.uploadImage').remove();
            updateInputValue();
        }
    });

    function updateInputValue() {
        var result = [];
        $tpl.find('.uploadImage').each(function () {
            result.push($(this).attr('filepath'));
        });
        $(id).val(result.join(","));
    }
    /*$gellay.sortable(
        {
            items:'.uploadImage',
            helper:'clone',
            placeholder: 'sortHelper',
            opacity:'0.6',
            revert:true,
            forcePlaceholderSize:false,
            start:function(){},
            stop:function(){
                updateInputValue();
            }
        }
    ).on('sortupdate',function () {
        updateInputValue();
    });*/
    function appendImages($gellay,obj) {
        if($.isArray(obj)){
            for(var i in obj){
                var ci = obj[i];
                appendImages($gellay,ci);
            }
            return;
        }

        if(typeof obj == 'string'){
            // 字符串
            if(obj == '')return;
            obj = {
                filepath:obj,
                attach_id:0,
                filename:''
            };
        }
        var $tpl=$('<div class="uploadImage" draggable="true">' +
            '<span class="thumb thumbnail"><img src="'+obj.filepath+'"/></span>'+
            '<span class="btnClose">' +
            '<span class="fa fa-times-circle" title="清除图片">X</span>' +
            '</span>' +
            '</div>');
        $tpl.attr('filename' , obj.filename);
        $tpl.attr('attach_id' , obj.attach_id);
        $tpl.attr('filepath' , obj.filepath);
        $($gellay).append($tpl);
    }
}
