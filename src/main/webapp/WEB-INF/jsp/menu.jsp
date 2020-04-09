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
        <link href="/static/css/menu.css" rel="stylesheet">
        <link href="/static/css/component/menu.css" rel="stylesheet">


        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>


        <script src="/static/js/lib/jquery.cookie.js" type="text/javascript"></script>
        <script src="/static/js/service/service.js" type="text/javascript"></script>
        <script src="/static/js/page/menu.js" type="text/javascript"></script>
    </head>

    <body>
        <nav class="menu">
            <h3>Time</h3>
            <form id="edit-profile" action="/edit" method="GET">
                <button type="submit">Edit profile</button>
            </form>
            <form id="information" action="/information" method="GET">
                <button type="submit">Information</button>
            </form>
            <form id="copyright" action="/copyright" method="GET">
                <button type="submit">Authors</button>
            </form>
        </nav>
        <button class="toggler">
            <svg class="ham" viewBox="0 0 100 100" width="80" onclick="this.classList.toggle('active')">
                <path class="line top"
                        d="m 70,33 h -40 c 0,0 -8.5,-0.149796 -8.5,8.5 0,8.649796 8.5,8.5 8.5,8.5 h 20 v -20"></path>
                <path class="line middle"
                        d="m 70,50 h -40"></path>
                <path class="line bottom"
                        d="m 30,67 h 40 c 0,0 8.5,0.149796 8.5,-8.5 0,-8.649796 -8.5,-8.5 -8.5,-8.5 h -20 v 20"></path>
            </svg>
        </button>

        <div class="container h-100">
            <div class="clock">
                <div class="hours-container">
                    <div class="hours"></div>
                </div>
                <div class="minutes-container">
                    <div class="minutes"></div>
                </div>
                <div class="seconds-container">
                    <div class="seconds"></div>
                </div>

                <form id="calculator" action="/calculator" method="GET">
                    <button type="submit" class="calculator-chart"></button>
                </form>
                <form id="planner" action="/planner" method="GET">
                    <button type="submit" class="planner-chart"></button>
                </form>
                <form id="function1" action="/something" method="GET">
                    <button type="submit" class="something-chart"></button>
                </form>
                <form id="function2" action="/else" method="GET">
                    <button type="submit" class="else-chart"></button>
                </form>
            </div>

            <p id="calculator-title" class="curved-title">Calculator</p>
            <p id="planner-title" class="curved-title">Planner</p>
            <p id="title1" class="curved-title">Something</p>
            <p id="title2" class="curved-title">Else</p>
        </div>
    </body>
</html>