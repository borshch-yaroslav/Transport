<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:setLocale value="${locale}" />
<fmt:setBundle basename="menu" />
<fmt:requestEncoding value="utf-8" />

<h1 style="color: white"><fmt:message key="message_form.send_to" /></h1>
<div class="row">

	<div class="col-md-12">
		<div class="contact-form">
			<div class="row">
				<form action="controller" method="post">
					<fieldset class="col-md-4">
						<input id="name" type="text" name="receiverLogin"
							placeholder="Login">
					</fieldset>
					<fieldset class="col-md-4">
						<input type="text" name="subject" id="subject"
							placeholder="Subject">
					</fieldset>
					<fieldset class="col-md-12">
						<textarea name="messageText" id="message" placeholder="Message"></textarea>
					</fieldset>
					<fieldset class="col-md-12">
						<button type="submit" name="command" value="hr.SendMessage"
							id="submit" class="button"><fmt:message key="message_form.send" /></button>
					</fieldset>
				</form>
			</div>
			<!-- /.row -->
						<div style="margin-top:2em">
	<jsp:include page="../table_pages/table_of_messages.jsp" />
</div>
		</div>
		<!-- /.contact-form -->

	</div>
	<!-- /.col-md-12 -->
</div>
<!-- /.row -->
