<html>
<body>
<h1>Student Database</h1>
<h4>Please select the radio button to choose what to search for:</h4>
<form action = "SimpleJSP.jsp" method = "Get">
    <fieldset>
        <input type = "radio" name = "search_selection" value = "account_number"/>Account Number<br>
        <input type = "radio" name = "search_selection" value = "first_name"/>First Name<br>
        <input type = "radio" name = "search_selection" value = "last_name"/>Last Name<br>
        <input type = "radio" name = "search_selection" value = "email_address"/>Email<br>
        <input type = "radio" name = "search_selection" value = "ip_address"/>IP Address<br>
    </fieldset>
    <br><input type = "text" name = "search_query" placeholder="Enter Search Here"><br><br>
    <input type = "submit" value = "Submit Query" />
</form>
</body>
</html>