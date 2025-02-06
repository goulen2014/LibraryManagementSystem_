
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Book</title>
    </head>
    <body>
        <h1>Add New Book</h1>
        
        <form action="LibrarianServlet?action=insert" method="post">
            <label>Title</label>
            <input type="text" name="title" required />
            
            <label>Author:</label>
            <input type="text" name="author" required />
            
            <label>Quantity</label>
            <input type="number" name="quantity" min="1" required />
            
            <input type="submit" value="Add Book">
        </form>
        <a href="LibrarianServlet">Back to Book List</a>
    </body>
</html>
