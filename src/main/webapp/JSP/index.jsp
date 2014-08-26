<html>
    <head>
        <title>BOOK SHELF</title>
        <link rel="stylesheet" type="text/css" href="index.css">
    </head>
    <body>
        <div class="column"></div>
        <div class="column">
            <div class="middle"></div>
            <div class="middle">
                <h1>BOOK SHELF</h1>
                <form action = "BookShelf" method="post">
                    <font>isbn</font><input type = "text" id = "isbn" name = "isbn" /> </br>
                    <font>name</font><input type = "text" id = "name" name="name"/></br>
                    <font>author</font><input type = "text" id = "author" name="author"/></br>
                    <font>location</font><input type = "text" id = "location" name="location"/></br>
                    <font>type</font><input type = "text" id = "type" name="type"/></br></br>
                    <input type="submit" id="submit" />
                    <input type="button" id="cancel" value="cancel"/>
                </form>
            </div>
            <div class="middle"></div>
        </div>
        <div class="column"></div>
    </body>
</html>