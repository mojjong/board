<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>
.uploadUL {
	list-style: none;
}

.uploadUL li {
	float: left;
}

.uploadUL li .thumb {
	width: 100px;
	height: 100px;
}
</style>

<!-- BbsController에 의해 호출될 data.jsp페이지 -->
<!-- data.html내용을 그대로 긁어와서 resources파일내부로 링크를건 모든 곳(/resources/되있던곳)에 /resources/라고 직접 넣어줌... -->

<meta charset="UTF-8">
<!--  <base href="http://localhost:8080/${pageContext.request.contextPath}"/>-->
<!-- 여기선 얘가 않먹힘 -->
<title>AdminLTE | Data Tables</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<!-- Ionicons -->
<link
	href="//code.ionicframework.com/ionicons/1.5.2/css/ionicons.min.css"
	rel="stylesheet" type="text/css" />
<!-- DATA TABLES -->
<link href="/resources/css/datatables/dataTables.bootstrap.css"
	rel="stylesheet" type="text/css" />
<!-- Theme style -->
<link href="/resources/css/AdminLTE.css" rel="stylesheet"
	type="text/css" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
<style type="text/css">
.bs-example {
	margin: 20px;
}
/* Fix alignment issue of label on extra small devices in Bootstrap 3.2 */
.form-horizontal .control-label {
	padding-top: 7px;
}
</style>
</head>
<body class="skin-blue">
	<!-- header logo: style can be found in header.less -->
	<header class="header"> <a href="/resources/index.html"
		class="logo"> <!-- Add the class icon to your logo image or logo icon to add the margining -->
		AdminLTE
	</a> <!-- Header Navbar: style can be found in header.less --> <nav
		class="navbar navbar-static-top" role="navigation"> <!-- Sidebar toggle button-->
	<a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas"
		role="button"> <span class="sr-only">Toggle navigation</span> <span
		class="icon-bar"></span> <span class="icon-bar"></span> <span
		class="icon-bar"></span>
	</a>
	<div class="navbar-right">
		<ul class="nav navbar-nav">
			<!-- Messages: style can be found in dropdown.less-->
			<li class="dropdown messages-menu"><a href="#"
				class="dropdown-toggle" data-toggle="dropdown"> <i
					class="fa fa-envelope"></i> <span class="label label-success">4</span>
			</a>
				<ul class="dropdown-menu">
					<li class="header">You have 4 messages</li>
					<li>
						<!-- inner menu: contains the actual data -->
						<ul class="menu">
							<li>
								<!-- start message --> <a href="#">
									<div class="pull-left">
										<img src="/resources/img/avatar3.png" class="img-circle"
											alt="User Image" />
									</div>
									<h4>
										Support Team <small><i class="fa fa-clock-o"></i> 5
											mins</small>
									</h4>
									<p>Why not buy a new awesome theme?</p>
							</a>
							</li>
							<!-- end message -->
							<li><a href="#">
									<div class="pull-left">
										<img src="/resources/img/avatar2.png" class="img-circle"
											alt="user image" />
									</div>
									<h4>
										AdminLTE Design Team <small><i class="fa fa-clock-o"></i>
											2 hours</small>
									</h4>
									<p>Why not buy a new awesome theme?</p>
							</a></li>
							<li><a href="#">
									<div class="pull-left">
										<img src="/resources/img/avatar.png" class="img-circle"
											alt="user image" />
									</div>
									<h4>
										Developers <small><i class="fa fa-clock-o"></i> Today</small>
									</h4>
									<p>Why not buy a new awesome theme?</p>
							</a></li>
							<li><a href="#">
									<div class="pull-left">
										<img src="/resources/img/avatar2.png" class="img-circle"
											alt="user image" />
									</div>
									<h4>
										Sales Department <small><i class="fa fa-clock-o"></i>
											Yesterday</small>
									</h4>
									<p>Why not buy a new awesome theme?</p>
							</a></li>
							<li><a href="#">
									<div class="pull-left">
										<img src="/resources/img/avatar.png" class="img-circle"
											alt="user image" />
									</div>
									<h4>
										Reviewers <small><i class="fa fa-clock-o"></i> 2 days</small>
									</h4>
									<p>Why not buy a new awesome theme?</p>
							</a></li>
						</ul>
					</li>
					<li class="footer"><a href="#">See All Messages</a></li>
				</ul></li>
			<!-- Notifications: style can be found in dropdown.less -->
			<li class="dropdown notifications-menu"><a href="#"
				class="dropdown-toggle" data-toggle="dropdown"> <i
					class="fa fa-warning"></i> <span class="label label-warning">10</span>
			</a>
				<ul class="dropdown-menu">
					<li class="header">You have 10 notifications</li>
					<li>
						<!-- inner menu: contains the actual data -->
						<ul class="menu">
							<li><a href="#"> <i class="ion ion-ios7-people info"></i>
									5 new members joined today
							</a></li>
							<li><a href="#"> <i class="fa fa-warning danger"></i>
									Very long description here that may not fit into the page and
									may cause design problems
							</a></li>
							<li><a href="#"> <i class="fa fa-users warning"></i> 5
									new members joined
							</a></li>

							<li><a href="#"> <i class="ion ion-ios7-cart success"></i>
									25 sales made
							</a></li>
							<li><a href="#"> <i class="ion ion-ios7-person danger"></i>
									You changed your username
							</a></li>
						</ul>
					</li>
					<li class="footer"><a href="#">View all</a></li>
				</ul></li>
			<!-- Tasks: style can be found in dropdown.less -->
			<li class="dropdown tasks-menu"><a href="#"
				class="dropdown-toggle" data-toggle="dropdown"> <i
					class="fa fa-tasks"></i> <span class="label label-danger">9</span>
			</a>
				<ul class="dropdown-menu">
					<li class="header">You have 9 tasks</li>
					<li>
						<!-- inner menu: contains the actual data -->
						<ul class="menu">
							<li>
								<!-- Task item --> <a href="#">
									<h3>
										Design some buttons <small class="pull-right">20%</small>
									</h3>
									<div class="progress xs">
										<div class="progress-bar progress-bar-aqua" style="width: 20%"
											role="progressbar" aria-valuenow="20" aria-valuemin="0"
											aria-valuemax="100">
											<span class="sr-only">20% Complete</span>
										</div>
									</div>
							</a>
							</li>
							<!-- end task item -->
							<li>
								<!-- Task item --> <a href="#">
									<h3>
										Create a nice theme <small class="pull-right">40%</small>
									</h3>
									<div class="progress xs">
										<div class="progress-bar progress-bar-green"
											style="width: 40%" role="progressbar" aria-valuenow="20"
											aria-valuemin="0" aria-valuemax="100">
											<span class="sr-only">40% Complete</span>
										</div>
									</div>
							</a>
							</li>
							<!-- end task item -->
							<li>
								<!-- Task item --> <a href="#">
									<h3>
										Some task I need to do <small class="pull-right">60%</small>
									</h3>
									<div class="progress xs">
										<div class="progress-bar progress-bar-red" style="width: 60%"
											role="progressbar" aria-valuenow="20" aria-valuemin="0"
											aria-valuemax="100">
											<span class="sr-only">60% Complete</span>
										</div>
									</div>
							</a>
							</li>
							<!-- end task item -->
							<li>
								<!-- Task item --> <a href="#">
									<h3>
										Make beautiful transitions <small class="pull-right">80%</small>
									</h3>
									<div class="progress xs">
										<div class="progress-bar progress-bar-yellow"
											style="width: 80%" role="progressbar" aria-valuenow="20"
											aria-valuemin="0" aria-valuemax="100">
											<span class="sr-only">80% Complete</span>
										</div>
									</div>
							</a>
							</li>
							<!-- end task item -->
						</ul>
					</li>
					<li class="footer"><a href="#">View all tasks</a></li>
				</ul></li>
			<!-- User Account: style can be found in dropdown.less -->
			<li class="dropdown user user-menu"><a href="#"
				class="dropdown-toggle" data-toggle="dropdown"> <i
					class="glyphicon glyphicon-user"></i> <span>Jane Doe <i
						class="caret"></i></span>
			</a>
				<ul class="dropdown-menu">
					<!-- User image -->
					<li class="user-header bg-light-blue"><img
						src="/resources/img/avatar3.png" class="img-circle"
						alt="User Image" />
						<p>
							Jane Doe - Web Developer <small>Member since Nov. 2012</small>
						</p></li>
					<!-- Menu Body -->
					<li class="user-body">
						<div class="col-xs-4 text-center">
							<a href="#">Followers</a>
						</div>
						<div class="col-xs-4 text-center">
							<a href="#">Sales</a>
						</div>
						<div class="col-xs-4 text-center">
							<a href="#">Friends</a>
						</div>
					</li>
					<!-- Menu Footer-->
					<li class="user-footer">
						<div class="pull-left">
							<a href="#" class="btn btn-default btn-flat">Profile</a>
						</div>
						<div class="pull-right">
							<a href="#" class="btn btn-default btn-flat">Sign out</a>
						</div>
					</li>
				</ul></li>
		</ul>
	</div>
	</nav> </header>
	<div class="wrapper row-offcanvas row-offcanvas-left">
		<!-- Left side column. contains the logo and sidebar -->
		<aside class="left-side sidebar-offcanvas"> <!-- sidebar: style can be found in sidebar.less -->
		<section class="sidebar"> <!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="/resources/img/avatar3.png" class="img-circle"
					alt="User Image" />
			</div>
			<div class="pull-left info">
				<p>Hello, Jane</p>

				<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
			</div>
		</div>
		<!-- search form -->
		<form action="#" method="get" class="sidebar-form">
			<div class="input-group">
				<input type="text" name="q" class="form-control"
					placeholder="Search..." /> <span class="input-group-btn">
					<button type='submit' name='seach' id='search-btn'
						class="btn btn-flat">
						<i class="fa fa-search"></i>
					</button>
				</span>
			</div>
		</form>
		<!-- /.search form --> <!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li><a href="/resources/index.html"> <i
					class="fa fa-dashboard"></i> <span>Dashboard</span>
			</a></li>
			<li><a href="/resources/widgets.html"> <i class="fa fa-th"></i>
					<span>Widgets</span> <small class="badge pull-right bg-green">new</small>
			</a></li>
			<li class="treeview"><a href="#"> <i
					class="fa fa-bar-chart-o"></i> <span>Charts</span> <i
					class="fa fa-angle-left pull-right"></i>
			</a>
				<ul class="treeview-menu">
					<li><a href="/resources/charts/morris.html"><i
							class="fa fa-angle-double-right"></i> Morris</a></li>
					<li><a href="/resources/charts/flot.html"><i
							class="fa fa-angle-double-right"></i> Flot</a></li>
					<li><a href="/resources/charts/inline.html"><i
							class="fa fa-angle-double-right"></i> Inline charts</a></li>
				</ul></li>
			<li class="treeview"><a href="#"> <i class="fa fa-laptop"></i>
					<span>UI Elements</span> <i class="fa fa-angle-left pull-right"></i>
			</a>
				<ul class="treeview-menu">
					<li><a href="/resources/UI/general.html"><i
							class="fa fa-angle-double-right"></i> General</a></li>
					<li><a href="/resources/UI/icons.html"><i
							class="fa fa-angle-double-right"></i> Icons</a></li>
					<li><a href="/resources/UI/buttons.html"><i
							class="fa fa-angle-double-right"></i> Buttons</a></li>
					<li><a href="/resources/UI/sliders.html"><i
							class="fa fa-angle-double-right"></i> Sliders</a></li>
					<li><a href="/resources/UI/timeline.html"><i
							class="fa fa-angle-double-right"></i> Timeline</a></li>
				</ul></li>
			<li class="treeview"><a href="#"> <i class="fa fa-edit"></i>
					<span>Forms</span> <i class="fa fa-angle-left pull-right"></i>
			</a>
				<ul class="treeview-menu">
					<li><a href="/resources/forms/general.html"><i
							class="fa fa-angle-double-right"></i> General Elements</a></li>
					<li><a href="/resources/forms/advanced.html"><i
							class="fa fa-angle-double-right"></i> Advanced Elements</a></li>
					<li><a href="/resources/forms/editors.html"><i
							class="fa fa-angle-double-right"></i> Editors</a></li>
				</ul></li>
			<li class="treeview active"><a href="#"> <i
					class="fa fa-table"></i> <span>Tables</span> <i
					class="fa fa-angle-left pull-right"></i>
			</a>
				<ul class="treeview-menu">
					<li><a href="simple.html"><i
							class="fa fa-angle-double-right"></i> Simple tables</a></li>
					<li class="active"><a href="board"><i
							class="fa fa-angle-double-right"></i> Yo Free Board</a></li>
				</ul></li>
			<li><a href="/resources/calendar.html"> <i
					class="fa fa-calendar"></i> <span>Calendar</span> <small
					class="badge pull-right bg-red">3</small>
			</a></li>
			<li><a href="/resources/mailbox.html"> <i
					class="fa fa-envelope"></i> <span>Mailbox</span> <small
					class="badge pull-right bg-yellow">12</small>
			</a></li>
			<li class="treeview"><a href="#"> <i class="fa fa-folder"></i>
					<span>Examples</span> <i class="fa fa-angle-left pull-right"></i>
			</a>
				<ul class="treeview-menu">
					<li><a href="/resources/examples/invoice.html"><i
							class="fa fa-angle-double-right"></i> Invoice</a></li>
					<li><a href="/resources/examples/login.html"><i
							class="fa fa-angle-double-right"></i> Login</a></li>
					<li><a href="/resources/examples/register.html"><i
							class="fa fa-angle-double-right"></i> Register</a></li>
					<li><a href="/resources/examples/lockscreen.html"><i
							class="fa fa-angle-double-right"></i> Lockscreen</a></li>
					<li><a href="/resources/examples/404.html"><i
							class="fa fa-angle-double-right"></i> 404 Error</a></li>
					<li><a href="/resources/examples/500.html"><i
							class="fa fa-angle-double-right"></i> 500 Error</a></li>
					<li><a href="/resources/examples/blank.html"><i
							class="fa fa-angle-double-right"></i> Blank Page</a></li>
				</ul></li>
		</ul>
		</section> <!-- /.sidebar --> </aside>

		<script type="text/javascript" src="/resources/js/paging.js"></script>
		<script type="text/javascript" src="/resources/js/event.js"></script>

		<!-- Right side column. Contains the navbar and content of the page -->
		<aside class="right-side"> <!-- Content Header (Page header) -->
		<section class="content-header">
		<h1>
			Yo FreeBoard <small>글쓰기</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
			<li><a href="#">Tables</a></li>
			<li class="active">Data tables</li>
		</ol>
		</section> <!-- Main content --> <section class="content">
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="bs-example">
						<form name="writeForm" class="form-horizontal">
							<input type="hidden" name="fileNames">
							<div class="form-group">
								<label class="control-label col-xs-1">Name</label>
								<div class="col-xs-10">
									<input type="text" class="form-control" name="writer"
										placeholder="Enter Name">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="control-label col-xs-1">Password</label>
								<div class="col-xs-10">
									<input type="password" class="form-control" name="password"
										placeholder="Enter Password">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-xs-1">Title</label>
								<div class="col-xs-10">
									<input type="text" class="form-control" name="title"
										placeholder="Enter Title">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-xs-1">Content</label>
								<div class="col-xs-10">
									<textarea class="form-control" rows="10" name="content"
										placeholder="Enter Content"></textarea>
								</div>
							</div>
							<div class="form-group">
								<div class="col-xs-offset-1 col-xs-10">
									<button id="writeBtn" class="btn btn-primary btn-lg">
										Submit</button>
									<button type="reset" class="btn btn-default btn-lg">
										Reset</button>
								</div>
							</div>
							<label class="control-label col-xs-1" for="exampleInputFile">File</label>
							<ul class="uploadUL">

							</ul>
						</form>
						<div class="form-group">

							<form target="zero" action="/bbs/file/upload" method="post"
								enctype="multipart/form-data" class="form-horizontal">

								<div class="col-xs-offset-1 col-xs-10">
									<input type="file" name="file">
									<button type="submit" class="btn btn-primary btn-sm">등록</button>
								</div>

							</form>
						</div>
					</div>
					<p>&nbsp;</p>
				</div>
				<!-- /.box -->

				<iframe name="zero" frameborder="0" width="0" height="0"></iframe>


			</div>
		</div>

		</section><!-- /.content --> </aside>
		<!-- /.right-side -->
	</div>
	<!-- ./wrapper -->

	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"
		type="text/javascript"></script>
	<!-- DATA TABES SCRIPT -->
	<script src="/resources/js/plugins/datatables/jquery.dataTables.js"
		type="text/javascript"></script>
	<script src="/resources/js/plugins/datatables/dataTables.bootstrap.js"
		type="text/javascript"></script>
	<!-- AdminLTE App -->
	<script src="/resources/js/AdminLTE/app.js" type="text/javascript"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="/resources/js/AdminLTE/demo.js" type="text/javascript"></script>
	<!-- page script -->
	<script type="text/javascript">
        $(function() {
            $("#example1").dataTable();
            $('#example2').dataTable({
                "bPaginate": false,
                "bLengthChange": false,
                "bFilter": false,
                "bSort": false,
                "bInfo": false,
                "bAutoWidth": false
            });
        });
        
        EventUtil.addHandler(document, "DOMContentLoaded", function(event){
    		EventUtil.addHandler(writeBtn, "click", function(event){
    			writeSubmit();
    		});
    	});
        
        function updateResult(data){

        	console.log(data);
        	//$(".uploadUL").append("<li><image class='thumb' src='/web/file/view/"+ fileName+"'/></li>");
        	if(data.suffix == '.jpg' || data.suffix == '.gif' || data.suffix == '.png' || data.suffix == '.bmp'){
        		$(".uploadUL").append("<li><image class='thumb' data-src='" + data.fileName + "' src='/bbs/file/view?path="+ data.fileName+"'/></li>");
        	}else{
        		$(".uploadUL").append("<li><image class='thumb' data-src='" + data.fileName + "' src='/resources/img/iDVD.png'/></li>");
        	}
        }
        
        function writeSubmit() {
        	
        	
        	
            var srcList = [];
            for(var i=0; i<$(".thumb").length; i++)
               srcList.push($($(".thumb" ).get(i)).attr("data-src"));
            
            console.log(srcList);
            
             document.writeForm.action="write";
             document.writeForm.method="post";
             document.writeForm.fileNames.value = srcList;
             document.writeForm.submit();   
         }
    </script>
</body>

</html>