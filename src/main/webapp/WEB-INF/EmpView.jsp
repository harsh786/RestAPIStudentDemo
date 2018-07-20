
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LMS</title>
     <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>Login</title>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
	<script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
	<script src="/js/datatable.js"></script>
</head>
<body>

<div class="container">
    	<div class="row">
			<div class="col-md-6 col-md-offset-4">
				<div class="">
			
					<div class="" style="margin-top:150px">
						<div class="row">
							<div class="col-lg-8">
							 <form:form action="/emp" modelAttribute="emp" id="empform"  method="post" role="form" style="display: block;">
						<%-- 	 <div class="form-group">
										<form:input type="text" name="name" id="name" path="name"  class="form-control" placeholder="name" value=""/>
										<form:errors path="name" cssClass="error"/>
							</div>
							<div class="form-group">
										<form:input type="rollNo" name="rollNo" id="rollNo" path="rollNo"  class="form-control" placeholder="rollNo" value=""/>
										<form:errors path="rollNo" cssClass="error"/>
							</div>
							<div class="form-group">
										<form:radiobuttons path="objGender" items="${gender}"  /> 
										<form:errors path="objGender" cssClass="error"/>
							</div>
							<div class="form-group">
										<form:checkboxes path="objHobbies" items="${hobbies}"  /> 
										<form:errors path="objHobbies" cssClass="error"/>
										<c:forEach items="${hobbies}" var="hobbie" varStatus="loopStatus"    >    
  										  <form:checkbox path="objHobbies" value="${hobbie.getKey().toString()}"  />${hobbie.getValue()}
										</c:forEach>
										
										
							</div>
							<div class="form-group">
											<form:select path="objDepartment"   >
											  
											   <form:options items="${dept}"  itemValue="${dept.getKey()}"  />
											</form:select>
											
											<form:select path="objDepartment"  items="${dept}"  	   /> --%>
											  
											 
											<form:select path="objHobbies" multiple="true"  >
							        <form:option value="0">Select hobbies: </form:option>
							        <c:forEach items="${hobbies}" var="depts" >
							          <form:option value="${depts.getKey()}" itemValue="${depts.getKey()}" itemLabel="${depts.getValue()}"   >${depts.getValue()}</form:option>
							        </c:forEach>

      									</form:select>
										
										<form:errors path="objHobbies" cssClass="error"/>
											
											 <form:select path="objDepartment"   >
							        <form:option value="0">Select Newsletter Frequency: </form:option>
							        <c:forEach items="${dept}" var="depts" >
							          <form:option value="${depts.getKey()}" itemValue="${depts.getKey()}" itemLabel="${depts.getValue()}"   >${depts.getValue()}</form:option>
							        </c:forEach>

      									</form:select>
											
										<form:errors path="objDepartment" cssClass="error"/>
							</div>
							<input type="hidden" id="selecteddept" value="${selecteddept}"/>
							<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-primary" value="Log In">
											</div>
										</div>
									</div>
							 </form:form>
			
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

<script>
  $(document).ready(function()
		  {
	       // alert($("#objDepartment").val());
		  });
</script>
