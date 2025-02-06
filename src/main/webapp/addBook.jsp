
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Book</title>
    </head>
    <body>
        <div style="text-align: center";>
            <h1>Add New Book</h1>
        
            <form action="LibrarianServlet?action=insert" method="post">
                <label>Title:</label>
                <input type="text" name="title" required /></br></br>

                <label>Author:</label>
                <input type="text" name="author" required /></br></br>

                <label>Quantity:</label>
                <input type="number" name="quantity" min="1" required /></br></br>

                <input type="submit" value="Add Book"></br></br>
            </form>
            <a href="LibrarianServlet">Back to Book List</a> |
            <a href="librarianDashboard.jsp">Back to Dashboard</a>
            
        </div>
        
    </body>
</html>
