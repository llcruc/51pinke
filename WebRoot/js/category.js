;(function ($, window) {
    //分类选择器实例构造函数
    //container:一个HTML对象，分类信息会显示在该对象内
    //index:实例索引
    //config:初始化实例时可以传入配置信息
    var category = function (container, index, config) {
        this._container = container;
        this._index = index;
        //用于标识分类选择器是否已经加载完成
        this._loaded = false;
        //可以通过selectItems属性获取或设置当前选中的分类信息
        //selectItems属性示例：[{ cid: 1, level:1, text:'教育专区' }, { cid: 11, level:2, text:'外语学习'}];
        //通过selectItems属性设置当前选中的分类后，需要调用“reload()”方法
        this.selectItems = [];
        this.config = config || {};
	
	    if (typeof config === 'string' || config.nodeType === 1) {
		    config = {sourceData: eval(config)};
	    };
	
	    var defaults = category.defaults;
		
	    // 合并默认配置
	    for (var i in defaults) {
		    if (config[i] === undefined) config[i] = defaults[i];		
	    };

        //ID添加索引，避免多少实例之间ID产生重复
        this.config.button += this._index;
        this.config.buttonIcon += this._index;
        this.config.nameView += this._index;
        this.config.popLayout += this._index;
        this.config.cateView += this._index;
        if (this.config.hidField == defaults.hidField) {
            this.config.hidField += this._index;
        }
        
        //更新模板中的ID
        this.config.template = this.config.template.replace(defaults.button, this.config.button);
        this.config.template = this.config.template.replace(defaults.buttonIcon, this.config.buttonIcon);
        this.config.template = this.config.template.replace(defaults.nameView, this.config.nameView);
        this.config.template = this.config.template.replace(defaults.popLayout, this.config.popLayout);
        this.config.template = this.config.template.replace(defaults.cateView, this.config.cateView);
        //应用背景
        this.config.template = this.config.template.replace("{bg_img_arrow_down}", this.config.bg_img_arrow_down);
        this.config.template = this.config.template.replace("{bg_img_button}", this.config.bg_img_button);
    };

    category.fn = category.prototype = {
        "load":function () {
        //加载分类信息，一个实例只能调用一次
            if (!this._container) {
                return;
            }
            if (this._loaded){
                return;
            }
            this._container.html(this.config.template);

            $(document).click({cfg:this.config}, function (event) {
                var c = event.data.cfg;
                if ($("#" + c.popLayout).is(":visible")) {
                    $("#" + c.popLayout).hide();
                    $("#" + c.buttonIcon).css({background: c.bg_img_arrow_down});
                }
            });

            $("#" + this.config.button).click({self:this}, function (event) {
                var c = event.data.self.config;
                if ($("#" + c.popLayout).is(":hidden")) {
                    $("#" + c.popLayout).show();
                    $("#" + c.buttonIcon).css({background: c.bg_img_arrow_up});
                }else{
                    $("#" + c.popLayout).hide();
                    $("#" + c.buttonIcon).css({background: c.bg_img_arrow_down});
                }
                event.stopPropagation();
            });

            this.reload();
        },
        "reload":function () {
        //用于设置了默认选定分类后重新加载分类信息
            $("#" + this.config.nameView).text(this.config.nameDefault);
            $("#" + this.config.cateView).html("");
            this._loaded = false;
            this._render();
            this.setCategoryName();
            this._setHidFieldValue();
            this._loaded = true;
        },
        "getCategory":function (cid, level) {
        //根据cid获取子分类,通过重写该方法实现从服务器动态获取子分类
            return null;
        },
        "getCategoryCid": function () {
        //获取选择分类的编号，以逗号分隔，例如：4,73,191
            var e = "";
            if (this.selectItems.length != 0) for (var t = 0; t < this.selectItems.length; t++) t == 0 ? e = this.selectItems[t].cid : e += "," + this.selectItems[t].cid;
            return e;
        },
		getCategoryName: function() {
        //获取选择分类的名称，以空格大于号空格分隔，例如：专业资料 > 经管营销 > 经济/市场
			var t = "";
            if (this.selectItems.length != 0) {
                for(var i = 0; i < this.selectItems.length; i++){
                    if (i == 0) {
                        t = this.selectItems[i].name;
                    }else{
                        t += " > " + this.selectItems[i].name;
                    }
                }
            }
            return t;
		},
        setCategoryName:function (name) {
        //设置选择分类按钮显示的分类名称为当前选定的分类名称
            if (typeof name == "undefined") {
                name = this.getCategoryName();
            }
            if (name == "") {
                name = this.config.nameDefault;
            }
            $("#" + this.config.nameView).text(name);
        }
    };

    category.fn._setHidFieldValue = function () {
        var hf = $("#" + this.config.hidField);
        if (hf.length == 0) {
            hf = $("<input type=\"hidden\" id=\"" + this.config.hidField + "\" />");
            $(document.body).append(hf);
        }
        hf.val(this.getCategoryCid());
    };

    category.fn._getCategory = function (sourceData, cid){
    //根据cid获取子分类
        if (typeof cid == undefined || cid == null) {
            return sourceData;
        }
        var cate = null;
        var c = this.config.columnName;
        if (sourceData[c.list]) {
            for(var i = 0; i < sourceData[c.list].length; i++){
                if (sourceData[c.list][i][c.cid] == cid) {
                    cate = sourceData[c.list][i];
                    break;
                }
            }
            if (cate == null) {
                for(var i = 0; i < sourceData[c.list].length; i++){
                    cate = this._getCategory(sourceData[c.list][i], cid);
                    if (cate != null) {
                        break;
                    }
                }
            }
        }
        return cate;
    };

    category.fn._itemIsLast = function (item){
    //判断该分类下是否还有子分类
        var itemIsLast = true;
        var c = this.config.columnName;
        if (item[c.list]) {
            if (item[c.list].length != 0) {
                itemIsLast = false;
            }
        }else{
            if (typeof item[c.isLast] != "undefined" && !item[c.isLast]) {
                itemIsLast = false;
            }
        }
        return itemIsLast;
    };

    category.fn._render = function (cid, level) {
        if (typeof cid == "undefined") {
            cid = null;
        }
        if (typeof level == "undefined") {
            level = 1;
        }

        var li = $("#li_categoryItem" + this._index + "_" + level);
        if (li.length == 0) {
            li = $("<li id=\"li_categoryItem" + this._index + "_" + level + "\" style=\"display: block; float: left; clear: none; margin: 0; padding: 0; width: 138px; height: 170px; border: 0; overflow-y: scroll; overflow-x: hidden; background: #FFF; color: #333; font: 12px / 1.333 arial, helvetica, clean;\"></li>");
            $("#" + this.config.cateView).append(li);
        }else{
            li.html("");
        }

        var liNext = li.next();
        while(liNext.length != 0){
            liNext.hide();
            liNext = liNext.next();
        }
		
		//更新弹出层的大小
        var popLayoutWidth = 138 * level;
        if (popLayoutWidth < 138) {
            popLayoutWidth = 138;
        }
        $("#" + this.config.popLayout).width(popLayoutWidth);

		//获取列表数据
        var c = this.config.columnName;
        var sourceData = null;
        if (this.config.sourceData[c.list] && this.config.sourceData[c.list].length != 0) {
            sourceData = this._getCategory(this.config.sourceData, cid);
        }else{
            sourceData = this.getCategory(cid, level);
        }
        if (sourceData == null || !(sourceData.list)) {
            li.hide();
            return;
        }

		//填充列表
        var pSelected = null;
        var itemSelected = null;
        for(var i = 0; i < sourceData[c.list].length; i++){
            var item =  sourceData[c.list][i];
            var span = $("<span id=\"span_categoryItem" + this._index + "_" + item[c.cid] + "\" style=\"overflow:hidden; display:block; float:left; margin: 0; padding: 0; width:90px; height: 14px; line-height:14px; font: 12px arial, helvetica, clean; color: #333; vertical-align: middle;word-break:keep-all;word-wrap:normal;\"></span>");
            span.text(item[c.name]);
            span.attr("title", item[c.name].replace("\"", "&quot").replace("'","&acute;"));
            var p = $("<p id=\"p_categoryItem" + this._index + "_" + item[c.cid] + "\" style=\"overflow:hidden; display:block; float:left; margin: 0; clear: both; padding: 5px; width:123px; height: 13px; cursor: default;\"></p>");
            p.data("data-cid", item[c.cid]);
            p.data("data-level", level);
            p.append(span);
            
            var itemIsLast = this._itemIsLast(item);
			//绑定鼠标事件
            p.mouseenter({isLast: itemIsLast, bg_img:this.config.bg_img_arrow_hover}, function (event) {
                if ($(this).data("data-selected") != "1"){
                    $(this).css({color: "#333", background: "#dcefea"});
                    if (!event.data.isLast) {
                        $(this).css({background: "#dcefea " + event.data.bg_img});
                    }
                }
            });
            p.mouseleave(function () {
                if ($(this).data("data-selected") != "1"){
                    $(this).css({color: "#333", background: ""});
                }
            });
            p.click({self:this, cid:item[c.cid], level:level, isLast: itemIsLast},function (event) {
                $("p", $(this).parent()).each(function () {
                    $(this).data("data-selected", "");
                    $(this).css({background: ""});
                    $("span", $(this)).css({color: "#333"});
                });

                var c = event.data.self.config;
                var s = event.data.self.selectItems;
                if (!s) {
                    s = [];
                }
                if (s.length >= level){
                    s = s.slice(0, level - 1);
                }
                s.push({cid:event.data.cid, level:level, name:$(this).text()});
                event.data.self.selectItems = s;
                event.data.self._setHidFieldValue();

                if (c.onSelect) {
                    c.onSelect.apply(event.data.self, [event.data.cid, event.data.level, $(this).text()]);
                }

                if (event.data.isLast) {
                    $("#" + c.popLayout).hide();
                    $("#" + c.buttonIcon).css({background: event.data.self.config.bg_img_arrow_down});
                    $(this).data("data-selected", "1");
                    $(this).css({background: "#316AC5"});
                    $("span", $(this)).css({color: "#fff"});
                    if (c.onChange) {
                        c.onChange.apply(event.data.self, [event.data.cid, event.data.level, $(this).text()]);
                    }
                }else{
                    $(this).data("data-selected", "1");
                    $(this).css({background: "#316AC5 " + event.data.self.config.bg_img_arrow_select});
                    $("span", $(this)).css({color: "#fff"});
                    event.data.self._render(event.data.cid, event.data.level+1);
                }
                event.stopPropagation();
            });
            li.append(p);
            li.show();

            if (!this._loaded){
                if (this.selectItems.length >= level && this.selectItems[level - 1].cid == item[c.cid]){
                    pSelected = p;
                    itemSelected = item;
                    if (!this.selectItems[level - 1].name || this.selectItems[level - 1].name !=item[c.name]) {
                        this.selectItems[level - 1].name = item[c.name];
                    }
                }
            }
        }
        
		//设置选中状态，并加载子分类
        if (!this._loaded && pSelected != null && itemSelected != null){
            if (this._itemIsLast(itemSelected)) {
				//是最后一级分类
                pSelected.data("data-selected", "1");
                pSelected.css({background: "#316AC5"});
                $("span", pSelected).css({color: "#fff"});
            }else{
				//不是则加载子分类
                pSelected.data("data-selected", "1");
                pSelected.css({background: "#316AC5 " + this.config.bg_img_arrow_select});
                $("span", pSelected).css({color: "#fff"});
                this._render(itemSelected.cid, level+1);
            }
        }
    };
    //默认配置值
    category.defaults = {
        bg_img_button:"url(data:image/gif;base64,R0lGODlhBQAeAKIAAP////7+/v39/fz8/Pv7+/r6+gAAAAAAACH5BAAHAP8ALAAAAAAFAB4AAAMdCLrcHTDKSSsUOOvN9fhgKI4hYZ5oqq5m4b5wHCcAOw==) repeat-x",
        bg_img_arrow_down:"url(data:image/gif;base64,R0lGODlhCwAQAJEAAHR0dP///////wAAACH5BAEHAAIALAAAAAALABAAAAIVlI+py+3/gARnUiuwsTPx1TEUREIFADs=) no-repeat",
        bg_img_arrow_up:"url(data:image/gif;base64,R0lGODlhCwAQAJEAAHR0dP///////wAAACH5BAEHAAIALAAAAAALABAAAAIVlI+py+2fQAN00RsvNlr0zm3QSB4FADs=) no-repeat",
        bg_img_arrow_select:"url(data:image/gif;base64,R0lGODlhFwAXAJEAAP///////////wAAACH5BAEHAAIALAAAAAAXABcAAAIjlI+py+0Po5y0MpAw1YdLL4AQKD7kdH4ZuqpIacXyTNd2XQAAOw==) no-repeat 100px 0px",
        bg_img_arrow_hover:"url(data:image/gif;base64,R0lGODlhFwAXAIAAAJmZmf///yH5BAEHAAEALAAAAAAXABcAAAIjjI+py+0Po5y0MpAw1YdLH4AQKD7kdH4ZuqpIacXyTNd2XQAAOw==) no-repeat 100px 0px",
        template:"<div style=\"position:relative;z-index:3;margin:0;padding:0;display:block;color:#333;font:12px/1.333 arial,helvetica,clean;\"><span id=\"span_button\" tabindex=\"-1\" hidefocus=\"true\" cidstr=\"\"cids=\"\" obj=\"\" beforetext=\"\" style=\"background:{bg_img_button};display:inline-block;height:18px;line-height:18px;padding:5px 10px;border:1px solid #E1E1E1;cursor:pointer;outline:0;\"><span id=\"span_nameView\" style=\"_position:relative;_top:2px;line-height:18px;cursor:pointer;color:#333;font:12px/1.333 arial,helvetica,clean;\">请选择分类</span> <b id=\"b_buttonIcon\" style=\"background:{bg_img_arrow_down};display:-moz-inline-stack;display:inline-block;padding:0;vertical-align:-2px;font-size:0;line-height:9999em;overflow:hidden;position:relative;width:16px;height:16px;margin-left:5px!important;font-style:normal;font-weight:normal;cursor:pointer;color:#333;\"></b></span><div id=\"div_popLayout\" tabindex=\"17\" hidefocus=\"true\" style=\"display:none;position:absolute;top:29px;left:0;z-index:2;box-shadow:3px 3px 5px rgba(0, 0, 0, 0.1);outline:0;border:1px solid #AAA;background:#FFF;clip:rect(0 602px 202px 0);height:171px;margin:-1px;overflow:hidden;padding:0;width:553px;color:#333;font:12px / 1.333 arial, helvetica, clean;\"><div style=\"* zoom:1;_display:inline;display:block;margin:0;padding:0;\"><ul id=\"ul_cateView\" style=\"list-style:none;margin:0;padding:0;display:block;\"></ul></div></div></div>",
        sourceData:{ list:[] },
        button:"span_button",
        buttonIcon:"b_buttonIcon",
        nameView:"span_nameView",
        nameDefault:"\u8BF7\u9009\u62E9\u5206\u7C7B",
        popLayout:"div_popLayout",
        cateView:"ul_cateView",
        hidField:"hid_category",
        columnName:{ "list":"list","pcid":"pcid","cid":"cid","name":"name","isLast":"isLast"},
        onChange:null,
        onSelect:null
    };
    //全局对象，记录所有实例
    category.list = [];
    //扩展JQuery，添加category方法
    $.fn.category = function (config) {
        var idx = category.list.length;
	    category.list[idx] = new category(this, idx, config);
        return category.list[idx];
    };
    window.category = $.category = category;
} (this.jQuery, this));