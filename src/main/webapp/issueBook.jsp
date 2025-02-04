
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Issue Book</title>
    </head>
    <body>
        <div style="text-align:center;">
            <h1>Issue Book</h1>        
            <form action="LibrarianServlet?action=issue" method="post">
            <input type="hidden" name="bookId" value="<%= request.getParameter("id") %>">
            
            <label>Borrower Name:</label>
            <input type="text" name="borrower" required /></br></br>
            
            <label>Librarian ID:</label>
            <input type="text" name="librarianId" required /></br></br>
            
            <input type="submit" value="Issue Book">
        </form>
            <a href="viewBooks.jsp">Back to Book List</a>
        </div>        
    </body>
</html>
