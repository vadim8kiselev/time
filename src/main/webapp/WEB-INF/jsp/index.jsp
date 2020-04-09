<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Time</title>

        <link href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="/static/css/index.css" rel="stylesheet">

        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>

    <body>
        <div class="container h-100">
            <div class="row h-100">
                <div class="col-6 mx-auto align-self-center">
                    <form:form id="salary-form" method="POST" class="form-inline text-center"
                               action="/" modelAttribute="profile" autocomplete="off">
                        <form:input id="salary-input" type="number" path="salary" min="1" placeholder="Salary" required="required"/>

                        <form:select id="currency-input" path="currency" form="salary-form">
                            <option value="₽" selected="selected">₽</option>
                            <option value="$">$</option>
                        </form:select>

                        <form:input id="hours-input" type="number" path="hours" placeholder="Working hours"/>
                        <form:input id="tax-input" type="number" path="tax" placeholder="Tax"/>
                        <form:input id="age-input" type="number" path="age" placeholder="Age"/>

                        <form:button type="submit" style="visibility: hidden;"/>
                    </form:form>
                </div>
            </div>
        </div>
    </body>
</html>