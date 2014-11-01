<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
                <!-- Main content -->
                <section class="content">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="box">
                                <div class="bs-example">
    <form class="form-horizontal" method = "post" action= "modify">
    <input type="hidden" name="bbsNo" value="${vo.getBbsNo() }">
        <div class="form-group">
        	
            <label class="control-label col-xs-1">Name</label>
            <div class="col-xs-10">
                      <input type="text" class="form-control" name="writer" value="${vo.getWriter() }">
            </div>
        </div>
                <div class="form-group">
            <label class="control-label col-xs-1">Title</label>
            <div class="col-xs-10">
                      <input type="text" class="form-control" name="title" value="${vo.getTitle() }">
            </div>
        </div>
          <div class="form-group">
		    <label class="control-label col-xs-1">Content</label>
		    <div class="col-xs-10">
		    <textarea class="form-control" rows="10" name="content">${vo.getContent() }</textarea>
		    </div>
  		</div>
  	<div class="form-group">
    <label class="control-label col-xs-1" for="exampleInputFile">File input</label>
    <div class="col-xs-10">
    <input type="file" id="file">
    </div>
  </div>
<div class="form-group">
<div class="col-xs-offset-1 col-xs-10">
   <button type="submit" class="btn btn-primary btn-lg">
      Modify
   </button>
   <button type="reset" class="btn btn-default btn-lg">Reset
   </button>
</div>
</div>
    </form>
</div>
<p>&nbsp;</p>
                            </div><!-- /.box -->

                            
                        </div>
                    </div>

                </section><!-- /.content -->