<!DOCTYPE html>

<html>
	<head>
		<title>Index view</title>
	</head>

	<body>
        <form action="${pageContext.servletContext.contextPath}/index" method="get">
            <input type="submit" name="loadPage" value="Add Numbers">
            <input type="submit" name="loadPage" value="Multiply Numbers">
            <input type="submit" name="loadPage" value="Guessing Game">
        </form>
	</body>
</html>
