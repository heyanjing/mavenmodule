<%@ page language="java" pageEncoding="utf-8" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@include file="/WEB-INF/include/jspTaglib.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="../../static/libs/bootstrap-3.3.7-dist/css/bootstrap.css">
    <link rel="stylesheet" href="${BOOTSTRAP}/css/bootstrap.css">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="${BOOTSTRAP}/css/bootstrap-theme.css">


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        .self {
            width: 200px;
            height: 200px;
            border: 1px solid darkgray;

        }

    </style>

</head>
<body>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<ul class="nav nav-tabs">
    <li class="active"><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
</ul>
<ul class="nav nav-tabs nav-justified">
    <li class="active"><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
</ul>
<ul class="nav nav-pills">
    <li class="active"><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
</ul>
<ul class="nav nav-pills nav-stacked ">
    <li class="active"><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
</ul>
<br>
<div class="btn-group btn-group-vertical" role="group" >
    <button type="button" class="btn btn-default">Left</button>
    <button type="button" class="btn btn-default">Middle</button>
    <button type="button" class="btn btn-default">Right</button>
</div>
<div class="btn-group btn-group-justified" role="group">
    <div class="btn-group" role="group">
        <button type="button" class="btn btn-default">Left</button>
    </div>
    <div class="btn-group" role="group">
        <button type="button" class="btn btn-default">Middle</button>
    </div>
    <div class="btn-group" role="group">
        <button type="button" class="btn btn-default">Right</button>
    </div>
</div>
<br>
<div class="dropup">
    <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        Dropup
        <span class="caret"></span>
    </button>
    <ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
        <li><a href="#">Action</a></li>
        <li><a href="#">Another action</a></li>
        <li><a href="#">Something else here</a></li>
        <li role="separator" class="divider"></li>
        <li><a href="#">Separated link</a></li>
    </ul>
</div>
<br>
<span class="glyphicon glyphicon-remove"></span>
<i class="glyphicon glyphicon-star"></i>
<br>
<div class="visible-md-block bg-info self">992≤md≤1200显示 超出范围隐藏</div>
<div class="hidden-md bg-danger self">992≤md≤1200隐藏 超出范围显示</div>
<br>
<br>
<div style="background: #000;">
    <img src="${IMG}/qq.jpg" alt="..." class="img-rounded">
    <img src="${IMG}/qq.jpg" alt="..." class="img-circle">
    <img src="${IMG}/qq.jpg" alt="..." class="img-thumbnail">
</div>
<br>
<button type="button" class="btn btn-default" disabled>（默认样式）Default</button>
<button type="button" class="btn btn-primary disabled">（首选项）Primary</button>
<button type="button" class="btn btn-success">（成功）Success</button>
<button type="button" class="btn btn-info">（一般信息）Info</button>
<button type="button" class="btn btn-warning">（警告）Warning</button>
<button type="button" class="btn btn-danger">（危险）Danger</button>
<button type="button" class="btn btn-link">（链接）Link</button>
<br>
<div><%--style="width: 600px;height: 400px"--%>
    <form class="form-horizontal">
        <div class="form-group form-group-lg has-success has-feedback">
            <label class="col-sm-2 control-label">Email</label>
            <div class="col-sm-2">
                <select class="form-control " disabled>
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                </select>
            </div>
        </div>
        <div class="form-group has-warning has-feedback">
            <label class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10">
                <textarea class="form-control" rows="3"></textarea>
                <span class="glyphicon glyphicon-remove form-control-feedback"></span>
            </div>
        </div>
        <div class="form-group has-error has-feedback">
            <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" id="inputEmail3" placeholder="Email">
                <span class="glyphicon glyphicon-ok form-control-feedback"></span>
            </div>

        </div>
        <div class="form-group has-feedback">
            <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
                <span class="glyphicon glyphicon-warning-sign form-control-feedback"></span>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">多选</label>
            <div class="col-sm-10">
                <div class="checkbox">
                    <label>
                        <input type="checkbox"> Remember me
                    </label>
                </div>
                <div class="checkbox disabled">
                    <label>
                        <input type="checkbox" disabled> Remember me2
                    </label>
                </div>
                <label class="checkbox-inline">
                    <input type="checkbox"> Remember me
                </label>
                <label class="checkbox-inline disabled">
                    <input type="checkbox" disabled> Remember me2
                </label>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Sign in</button>
            </div>
        </div>
    </form>

</div>

<br>
<h1>表格</h1>
<div class="table-responsive">
    <table class="table table-striped table-bordered table-hover "><%-- table-condensed--%>
        <thead class=""><%--thead-inverse|thead-default--%>
        <tr>
            <th>列1</th>
            <th>列2</th>
            <th>列3</th>
        </tr>
        </thead>
        <tbody>
        <tr class="success"><%--active success  info warning danger --%>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
        <tr>
            <td class="info">4</td>
            <td class="warning">5</td>
            <td class="danger">6</td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
        <tr>
            <td>4</td>
            <td>5</td>
            <td>6</td>
        </tr>
        </tbody>
    </table>
</div>
<br>
<ul class="list-inline">
    <li>1</li>
    <li>2</li>
    <li>3</li>
    <li>4</li>
    <li>5</li>
</ul>
<br>
<div class="container ">
    <div class="row">
        <div class="col-md-12 self">
            <h1 class="text-center">栅格系统</h1>
        </div>
    </div>
    <div class="row ">
        <div class="col-md-1 self">1</div>
        <div class="col-md-1 self">2</div>
        <div class="col-md-1 self">3</div>
        <div class="col-md-1 self">4</div>
        <div class="col-md-1 self">5</div>
        <div class="col-md-1 self">6</div>
        <div class="col-md-1 self">7</div>
        <div class="col-md-1 self">8</div>
        <div class="col-md-1 self">9</div>
        <div class="col-md-1 self">10</div>
        <div class="col-md-1 self">11</div>
        <div class="col-md-1 self">12</div>
    </div>
    <div class="row ">
        <div class="col-md-6 self">6</div>
        <div class="col-md-6 self">6</div>
    </div>
    <div class="row">
        <div class="col-md-4 self">4</div>
        <div class="col-md-4 self col-md-offset-4">4</div>
    </div>
    <div class="row">
        <div class="col-md-9 self col-md-push-3">9</div>
        <div class="col-md-3 self col-md-pull-9">3</div>
    </div>

</div>
<p class="lead">Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Duis mollis, est non commodo luctus.</p>
You can use the mark tag to
<mark>highlight</mark>
text.<br>
<del>This line of text is meant to be treated as deleted text.</del>
<br>
<s>This line of text is meant to be treated as no longer accurate.</s><br>
<ins>This line of text is meant to be treated as an addition to the document.</ins>
<br>
<u>This line of text will render as underlined</u><br>
<small>This line of text is meant to be treated as fine print.</small>
<br>
The following snippet of text is <strong>rendered as bold text</strong><br>
The following snippet of text is <em>rendered as italicized text</em><br>
<p class="text-left">Left aligned text.</p>
<p class="text-center">Center aligned text.</p>
<p class="text-right">Right aligned text.</p>

<%--
<p class="text-justify">Justified textJustified textJustified textJustified textJustified textJustified textJustified textJustified textJustified textJustified textJustified textJustified textJustified textJustified textJustified textJustified textJustified textJustified textJustified textJustified textJustified textJustified textJustified textJustified textJustified textJustified textJustified textJustified textJustified textJustified textJustified textJustified textJustified textJustified textJustified textJustified textJustified text.</p>
<p class="text-nowrap">No wrap text No wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap text No wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap text No wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap text No wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap text No wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap text No wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap text No wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap text No wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap textNo wrap text No wrap textNo wrap textNo wrap</p><br>
--%>

<p class="text-lowercase">Lowercased text.</p>
<p class="text-uppercase">Uppercased text.</p>
<p class="text-capitalize">Capitalized text.</p><br>


<br>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${JQUERY}/jquery-1.12.4.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${BOOTSTRAP}/js/bootstrap.js"></script>
</body>
</html>