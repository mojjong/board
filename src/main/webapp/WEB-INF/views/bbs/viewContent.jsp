<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class='content'>
	<div class='row'>
		<div class='col-xs-12'>
			<div class='box'>

				<div class='bs-example'>
					<form name="form2" class='form-horizontal'>
						<input type='hidden' name='bbsno' value='${param.bbsno }'>
						<div class='form-group'>
							<label class='control-label col-xs-1'>Name</label>
							<div class='col-xs-10'>
								<p class='form-control-static'>${vo.getWriter() }</p>
							</div>
						</div>
						<div class='form-group'>
							<label class='control-label col-xs-1'>Title</label>
							<div class='col-xs-10'>
								<p class='form-control-static'>${vo.getTitle() }</p>
							</div>
						</div>
						<div class='form-group'>
							<label class='control-label col-xs-1'>Content</label>
							<div class='col-xs-10'>
								<textarea class='form-control' rows='10' name='content' readonly>${vo.getContent() }</textarea>
							</div>
						</div>
						<div class='form-group'>
							<div class='col-xs-offset-1 col-xs-10' style='font-size: 8pt'>
								<b>regdate</b> ${vo.getRegdate() } &nbsp;&nbsp;| &nbsp;&nbsp;<b>bbsno</b>
								&nbsp;${vo.getBbsNo() } &nbsp;&nbsp;| &nbsp;&nbsp;<b>viewcnt</b>
								&nbsp;${vo.getViewcnt() }
							</div>
						</div>
						<c:if test="${vo.getIsfile() == 'T' }">
							<div class="form-group">
								<label class="control-label col-xs-1" for="exampleInputFile">File</label>
								<div class="col-xs-10">
									<p class="form-control-static">
										<a href="/download?filename=${vo.getFilename() }">${vo.getFilename()}</a>
									</p>
								</div>
							</div>
						</c:if>



						<div class='form-group'>
							<div class='col-xs-offset-1 col-xs-10'>
								<button type='button' id="reply_btn"
									class="btn btn-primary btn-lg">Reply</button>
								<button type='button' id="modifybtn"
									class="btn btn-default btn-lg">Modify</button>
								<button type='button' id="deletebtn"
									class='btn btn-default btn-lg'>Delete</button>
							</div>
						</div>
					</form>

					<form name="form3" class='form-horizontal'>
						<input type="hidden" name="replyNo"> <input type="hidden"
							name="reply">
						<div class="form-group">

							<div class='col-xs-offset-1 col-xs-10'>
								<hr>

								<c:if test="${reList.size() != 0}">

									<!-- the comments -->
									<c:forEach items="${reList}" var="revo">

										<h6>
											<i class="fa fa-comment"></i> <strong>${revo.getReplyer() }</strong>
											<small> ${revo.getReplydate() }</small> <a
												href="javascript:reModify(${revo.getReplyNo() })"
												class="btn btn-xs btn-default"><span
												class="glyphicon glyphicon-plus"></span> modify</a> <a
												href="javascript:reDelete(${revo.getReplyNo() })"
												class="btn btn-xs btn-default"><span
												class="glyphicon glyphicon-minus"></span> delete</a>
										</h6>
										<div id="reContent_${revo.getReplyNo() }">${revo.getReply() }</div>
										<hr>
									</c:forEach>

								</c:if>
							</div>


						</div>
					</form>


					<div class='form-group'>
						<div class='col-xs-offset-1 col-xs-20'>
							<form name="rwForm">
								<input type="hidden" name="bbsNo" value="${vo.getBbsNo() }">
								<div class="input-group"
									style="padding-bottom: 50px; margin-bottom: 50px;">
									<div class="row" style="padding: 0px; margin: 0px;">
										<div class="col-lg-2 col-md-6 col-sm-6"
											style="padding: 0px; margin: 0px;">
											<input name="replyer" type="text"
												class="form-control input-sm chat_input" placeholder="Name" />
										</div>
										<div class="col-lg-8 col-md-6 col-sm-6">
											<input name="reply" type="text"
												class="form-control input-sm chat_input"
												placeholder="Enter your comments here..." />
										</div>
										<div class="col-lg-2 col-md-6 col-sm-6">
											<span class="input-group-btn">
												<button class="btn btn-primary btn-sm" id="replybtn">Comment</button>
											</span>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>

			</div>
			<!-- /.box -->


		</div>
	</div>

</section>
