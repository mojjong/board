<ul class="pagination">
<c:set var="blockStartPage" value="${pageVo.getStartPage() }" />
<c:set var="blockEndPage" value="${pageVo.getEndPage() }" />
<c:if test="${blockStartPage != 1 }">
	<li><a href="javascript:_goPage(${blockStartPage-1 }, '${param.category }', '${param.keyword }')">&laquo;</a></li>
</c:if>
<c:forEach var="i" begin="${blockStartPage}" end="${blockEndPage}"
	step="1">
	
	
	<%-- <li><a href="/list?page=${i }">${i }</a></li> --%>
	<c:choose>
	<c:when test="${pageVo.getCurrentPage() == i }">
	<li class="active">
	</c:when>
	<c:otherwise>
	<li>
	</c:otherwise>
	</c:choose>
	<a href="javascript:_goPage(${i }, '${param.category }', '${param.keyword }');">${i }</a></li>
 </c:forEach>
<c:if test="${blockEndPage != pageVo.getTotalPage() }">
	<li><a href="javascript:_goPage(${blockEndPage+1 }, '${param.category }', '${param.keyword }')">&raquo;</a></li>
</c:if>
</ul>
<script>
function _goPage(page, category, keyword){
	
	document.searchForm.page.value = page;
	document.searchForm.category.value = category;
	document.searchForm.keyword.value = keyword;
	
	document.searchForm.submit();
	
	
}

</script>