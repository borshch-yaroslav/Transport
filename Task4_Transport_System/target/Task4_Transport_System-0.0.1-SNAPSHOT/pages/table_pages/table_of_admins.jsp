
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" type="text/css"
	href="pages/user_pages/buttons_css3/buttons.css" />

<div id="container" style="margin-left:-5em">

	<c:forEach var="user" items="${users}">
		<div class="pricetabmid"
			style="display: inline-block; margin: 1em 1em 1em 1em">
			<h1>
				ADMIN
				<c:out value=" ${user.name}" />
			</h1>
			<div class="infos">
				<h3>
					<c:out value="${user.login}" />
				</h3>
				<h3>
					<c:out value="${user.email}" />
				</h3>
				<h3>
					<c:out value="${user.role}" />
				</h3>
			</div>
			<div class="pricefootermid">
				<div class="buttonmid">
					<a
						href="controller?command=hr.DeAssignAdmin&loginToDelete=${user.login}">
						De-assign </a>
				</div>
			</div>
		</div>
	</c:forEach>

	<div>
		<h2>Enter login to assign admin:</h2>
		<div style="width:20em; margin: auto">
			<form action="controller" method="post">
				<h2>
					<input type="text" name="txtLogin" placeholder="Login" style="background-color:grey"/>
				</h2>
				<button name="command" value="hr.AssignAdmin"
					class="button medium green">Assign admin</button>
			</form>
		</div>
	</div>
</div>