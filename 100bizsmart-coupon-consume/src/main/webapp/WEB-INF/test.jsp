<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>测试页面</title>
    <link href="/bootstrap.min.css" rel="stylesheet">
    <link href="/sweetalert2.min.css" rel="stylesheet">
    <link href="/theme/default/laydate.css" rel="stylesheet">
    <script src="/sweetalert2.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="/laydate.js" type="text/javascript"></script>
    <script src="/bootstrap.min.js"></script>
</head>
<body>
    <input type="text" name="checkUidMid" placeholder="uid">
    <button class="btn btn-primary" id="show_all_main_coupon_data">查询用户可领所有券活动</button>
    <br/>
    <!-- 模态框（Modal） -->
    <div class="modal fade" id="all_main_coupon_data" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">全部活动</h4>
                </div>
                <div class="modal-body">
                    <input type="text" name="uid" class="input-xlarge">
                    <table class="table table-striped">
                        <thead>
                        <th>name</th>
                        <th>couponId</th>
                        <th>desc</th>
                        <th>begin</th>
                        <th>end</th>
                        <th>操作</th>
                        </thead>
                        <tbody id="main_coupon_data"></tbody>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

    <button class="btn btn-primary" id="create_main_coupon_data">创建券活动</button>
    <!-- 模态框（Modal） -->
    <div class="modal fade" id="main_coupon_data_create_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">创建活动</h4>
                </div>
                <div class="modal-body" style="max-height: 500px;overflow-y: auto;">
                    <form class="form-horizontal">
                        <fieldset>
                            <div class="control-group">
                                <label class="control-label">name:</label>
                                <div class="controls">
                                    <input type="text" name="couponMainDataName" class="input-xlarge">
                                    <p class="help-block">活动名称</p>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">storeId:</label>
                                <div class="controls">
                                    <input type="text" name="couponMainDataStoreId" class="input-xlarge">
                                    <p class="help-block">门店ID</p>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">promotionCode:</label>
                                <div class="controls">
                                    <input type="text" name="promotionCode" class="input-xlarge">
                                    <p class="help-block">活动编码</p>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">type:</label>
                                <div class="controls">
                                    <select name="couponMainDataType">
                                        <option value="DJ">品牌代金券</option>
                                        <option value="ZK">品牌折扣券</option>
                                        <option value="CX">品牌促销券</option>
                                        <option value="LP">礼品券</option>
                                        <option value="YQ">邀请券</option>
                                        <option value="YY">异业券</option>
                                    </select>
                                    <p class="help-block">活动类型</p>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">capital:</label>
                                <div class="controls">
                                    <input type="number" name="couponMainDataCapital" class="input-xlarge">
                                    <p class="help-block">本金（当券类型为代金券时有效）</p>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">faceValue:</label>
                                <div class="controls">
                                    <input type="number" name="couponMainDataFaceValue" class="input-xlarge">
                                    <p class="help-block">面值（当券类型为代金券时有效）</p>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">threshold:</label>
                                <div class="controls">
                                    <input type="number" name="couponMainDataThreshold" class="input-xlarge">
                                    <p class="help-block">门槛（当券类型为满减券时有效）</p>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">exemption:</label>
                                <div class="controls">
                                    <input type="number" name="couponMainDataExemption" class="input-xlarge">
                                    <p class="help-block">免减金额（当券类型为满减券时有效）</p>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">beginDate:</label>
                                <div class="controls">
                                    <input type="text" name="couponMainDataBeginDate" class="input-xlarge datetimepicker">
                                    <p class="help-block">有效开始日期</p>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">endDate:</label>
                                <div class="controls">
                                    <input type="text" name="couponMainDataEndDate" class="input-xlarge datetimepicker">
                                    <p class="help-block">有效结束日期</p>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">guide:</label>
                                <div class="controls">
                                    <input type="text" name="couponMainDataGuide" class="input-xlarge">
                                    <p class="help-block">使用说明</p>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">countMax:</label>
                                <div class="controls">
                                    <input type="number" name="couponMainDataCountMax" class="input-xlarge">
                                    <p class="help-block">活动总发放券总数</p>
                                </div>
                            </div>
                            <div class="control-group">
                                <label class="control-label">userCountMax:</label>
                                <div class="controls">
                                    <input type="number" name="couponMainDataUserCountMax" class="input-xlarge">
                                    <p class="help-block">单个用户可领券总数</p>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary submitCouponMainData">提交</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

    <p>
        <input type="text" name="checkUid" placeholder="uid">
        <button class="btn btn-info checkuid">查询用户</button>
    </p>
    <p>
        <input type="text" name="checkCouponCode" placeholder="couponNo">
        <button class="btn btn-info checkCouponCode">查询券</button>
    </p>
    <p>
        <input type="text" name="couponNo" placeholder="couponNo">
        <input type="text" name="shopCode" placeholder="shopCode">
        <input type="text" name="salesNo" placeholder="salesNo">
        <input type="text" name="couponNum" placeholder="couponNum">
        <button class="btn btn-info coupuseParam">核销券</button>
    </p>
    <p>
        <input type="text" name="checkCouponCodeII" placeholder="checkCouponCode">
        <input type="text" name="checkShopCode" placeholder="checkShopCode">
        <button class="btn btn-info checkCouponCodeII">查询券II</button>
    </p>
    <p>
        <button class="btn btn-info couponlist">查询可用券列表</button>
    </p>

    <!-- 模态框（Modal） -->
    <div class="modal fade" id="all_user_detail_coupon_data" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="lLabel">已领取优惠券</h4>
                </div>
                <div class="modal-body">
                    <table class="table table-striped">
                        <thead>
                        <th>name</th>
                        <th>券码</th>
                        <th>券ID</th>
                        <th>desc</th>
                        <th>begin</th>
                        <th>end</th>
                        <th>操作</th>
                        </thead>
                        <tbody id="detail_coupon_data"></tbody>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

    <br/>

    <button class="btn btn-success excuteTime">执行定时任务</button>

    <script type="text/javascript">
        var prev = "/api/ccoup/";
        var test = "/test/ccoup/";
        $(function () {
            showAllMainCouponData();
            createCouponMainData();
            getCoupon();
            checkuid();
            checkCouponCode();
            coupuseParam();
            checkCouponCodeII();
            getCouponList();
            excuteTime();
            laydate.render({
                elem: '.datetimepicker' //指定元素
            });
        })

        function showAllMainCouponData() {
            $(document).on("click", "#show_all_main_coupon_data", function () {
                var uid = $("input[name=checkUidMid]").val();
                if(uid == "" || uid == undefined || uid == null){
                    alert("请填写用户")
                    return false;
                }

                var getCouponVO = {
                    uid: uid,
                }

                $.ajax({
                    url: prev + "couponlist",
                    type: "POST",
                    dataType: "json",
                    data:JSON.stringify(getCouponVO),
                    contentType: "application/json",
                    success: function (res) {
                        if (res.statusCode == 200) {
                            var list = res.result;
                            var _html = "";
                            for (var i = 0; i < list.length; i++) {
                                var obj = list[i];
                                _html += "<tr>" +
                                    "<td style='margin-left: 20px;'>" + obj.name + "</td>" +
                                    "<td style='margin-left: 20px;'>" + obj.couponId + "</td>" +
                                    "<td style='margin-left: 20px;'>" + obj.desc + "</td>" +
                                    "<td style='margin-left: 20px;'>" + obj.begin + "</td>" +
                                    "<td style='margin-left: 20px;'>" + obj.end + "</td>" +
                                    "<td style='margin-left: 20px;'>" +
                                    "<button class='btn btn-info getCoupon' coupon-id='" + obj.couponId + "'>领券</button>" +
                                    "</td>" +
                                    "</tr>";
                            }
                            $("#main_coupon_data").html(_html);
                            $("#all_main_coupon_data").modal("show");
                        }
                    }
                })
            })
        }

        function createCouponMainData() {
            $(document).on("click", "#create_main_coupon_data", function () {
                $("#main_coupon_data_create_modal").modal("show");
            })
            $(document).on("click", ".submitCouponMainData", function () {
                var couponMainData = {
                    rid: "" + Math.random() * 100000,
                    promotionCode: $("input[name=promotionCode]").val(),
                    storeId: $("input[name=couponMainDataStoreId]").val(),
                    name: $("input[name=couponMainDataName]").val(),
                    type: $("select[name=couponMainDataType]").val(),
                    capital: $("input[name=couponMainDataCapital]").val(),
                    faceValue: $("input[name=couponMainDataFaceValue]").val(),
                    threshold: $("input[name=couponMainDataThreshold]").val(),
                    exemption: $("input[name=couponMainDataExemption]").val(),
                    beginDate: $("input[name=couponMainDataBeginDate]").val(),
                    endDate: $("input[name=couponMainDataEndDate]").val(),
                    createdon: "" + Math.random() * 100000,
                    processer: "" + Math.random() * 100000,
                    guide: $("input[name=couponMainDataGuide]").val(),
                    countMax: $("input[name=couponMainDataCountMax]").val(),
                    userCountMax: $("input[name=couponMainDataUserCountMax]").val(),
                    state: "200",
                }
                $.ajax({
                    url: test + "saveMainDataTest",
                    type: "POST",
                    dataType: "json",
                    data: JSON.stringify(couponMainData),
                    contentType: "application/json",
                    success: function (res) {
                        if (res.statusCode == 200) {
                            swal({
                                    title: " 成功",
                                    text: res.msg,
                                    type: "success",
                                    showCancelButton: false,
                                    confirmButtonColor: "#DD6B55",
                                    confirmButtonText: "确定",
                                    cancelButtonText: "取消删除！",
                                    closeOnConfirm: true,
                                    closeOnCancel: false
                                },
                                function (isConfirm) {
                                    $("#main_coupon_data_create_modal").modal("hide");
                                });
                        } else {
                            swal("警告", res.msg, "warning");
                        }
                    }
                })
            })
        }

        function getCoupon() {
            $(document).on("click", ".getCoupon", function () {
                var couponId = $(this).attr("coupon-id");
                var uid = $("input[name=uid]").val();
                var getCouponVO = {
                    uid: uid,
                    couponId: couponId,
                }
                $.ajax({
                    url: prev + "getcoupon",
                    type: "POST",
                    dataType: "json",
                    data: JSON.stringify(getCouponVO),
                    contentType: "application/json",
                    success: function (res) {
                        if (res.statusCode == 200) {
                            alert("成功");
                        } else {
                            alert("失败");
                        }
                    }
                })
            })
        }

        function checkuid() {
            $(document).on("click", ".checkuid", function () {
                var uid = $("input[name=checkUid]").val();
                var getCouponVO = {
                    uid: uid,
                }
                $.ajax({
                    url: prev + "getmycouponlist",
                    type: "POST",
                    dataType: "json",
                    data: JSON.stringify(getCouponVO),
                    contentType: "application/json",
                    success: function (res) {
                        if (res.statusCode == 200) {
                            var list = res.result;
                            var _html = "";
                            for (var i = 0; i < list.length; i++) {
                                var obj = list[i];
                                _html += "<tr>" +
                                    "<td style='margin-left: 20px;'>" + obj.name + "</td>" +
                                    "<td style='margin-left: 20px;'>" + obj.couponCode + "</td>" +
                                    "<td style='margin-left: 20px;'>" + obj.couponId + "</td>" +
                                    "<td style='margin-left: 20px;'>" + obj.desc + "</td>" +
                                    "<td style='margin-left: 20px;'>" + obj.begin + "</td>" +
                                    "<td style='margin-left: 20px;'>" + obj.end + "</td>" +
                                    "<td style='margin-left: 20px;'>" +
                                    "</td>" +
                                    "</tr>";
                            }
                            $("#detail_coupon_data").html(_html);
                            $("#all_user_detail_coupon_data").modal("show");

                        } else {
                            alert("失败");
                        }
                    }
                })
            })
        }

        function checkCouponCode() {
            $(document).on("click", ".checkCouponCode", function () {
                var code = $("input[name=checkCouponCode]").val();
                var coupScanParam = {
                    couponNo: code,
                }
                $.ajax({
                    url: prev + "coupscan",
                    type: "POST",
                    dataType: "json",
                    data: JSON.stringify(coupScanParam),
                    contentType: "application/json",
                    success: function (res) {
                        if (res.statusCode == 200) {
                            console.log(res.result);
                        } else {
                            alert("失败");
                        }
                    }
                })
            })
        }

        function coupuseParam() {
            $(document).on("click", ".coupuseParam", function () {
                var shopCode = $("input[name=shopCode]").val();
                var salesNo = $("input[name=salesNo]").val();
                var couponNo = $("input[name=couponNo]").val();
                var couponNum = $("input[name=couponNum]").val()
                var coupuseParam = {
                    shopCode: shopCode,
                    salesNo: salesNo,
                    couponNo: couponNo,
                    couponNum: couponNum,
                }
                $.ajax({
                    url: prev + "coupuse",
                    type: "POST",
                    dataType: "json",
                    data: JSON.stringify(coupuseParam),
                    contentType: "application/json",
                    success: function (res) {
                        if (res.statusCode == 200) {
                            console.log(res.result);
                        } else {
                            alert("失败");
                        }
                    }
                })
            })
        }

        function checkCouponCodeII() {
            $(document).on("click", ".checkCouponCodeII", function () {
                var code = $("input[name=checkCouponCodeII]").val();
                var shopCode = $("input[name=checkShopCode]").val();
                var coupScanStoreParam = {
                    couponNo: code,
                    shopCode: shopCode,
                }
                $.ajax({
                    url: prev + "coupscan",
                    type: "POST",
                    dataType: "json",
                    data: JSON.stringify(coupScanStoreParam),
                    contentType: "application/json",
                    success: function (res) {
                        if (res.statusCode == 200) {
                            console.log(res.result);
                        } else {
                            alert("失败");
                        }
                    }
                })
            })
        }

        function getCouponList() {
            $(document).on("click", ".couponlist", function () {

                $.ajax({
                    url: prev + "couponlist",
                    type: "POST",
                    dataType: "json",
                    contentType: "application/json",
                    success: function (res) {
                        if (res.statusCode == 200) {
                            alert("成功,请查看console");
                            console.log(res);
                        } else {
                            alert("失败,请查看console");
                            console.log(res);
                        }
                    }
                })
            })
        }

        function excuteTime(){
            $(document).on("click",".excuteTime",function(){
                $.ajax({
                    url: test + "excuteTime",
                    type: "GET",
                    dataType: "json",
                    contentType: "application/json",
                    success: function (res) {
                        if (res.statusCode == 200) {
                            alert("成功,请查看console");
                        } else {
                            alert("失败,请查看console");
                        }
                    }
                })
            })
        }
    </script>
</body>
</html>