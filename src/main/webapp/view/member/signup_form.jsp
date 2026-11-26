<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../include/title.jsp"/>
</head>
<body>

	<jsp:include page="../include/header.jsp"/>
	
	<jsp:include page="../include/nav.jsp"/>
	
	<section>
		<div class="section_wrap">
			<h1>SIGNUP FORM</h1>
			
			<form action="<%= request.getContextPath() %>/signup_confirm.mem" method="post" name="signup_form">
				
				<input type="text" name="admin_id" placeholder="Input new admin ID">
				<br>
				<input type="password" name="admin_pw" placeholder="Input new admin PW">
				<br>
				<input type="eamil" name="admin_mail" placeholder="Input new admin MAIL">
				<br>
				<input type="text" name="admin_phone" placeholder="Input new admin PHONE">
				<br>
				<input type="button" value="SIGN UP" onclick="signupForm();">
				<input type="reset" value="RESET">
			</form>
		</div>
	</section>
	
	<jsp:include page="../include/footer.jsp"/>

</body>
</html>