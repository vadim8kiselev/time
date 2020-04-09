<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Time</title>

        <link href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="/static/css/calculator.css" rel="stylesheet">
        <link href="/static/css/component/menu.css" rel="stylesheet">


        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>


        <script src="/static/js/lib/jquery.cookie.js" type="text/javascript"></script>
        <script src="/static/js/service/service.js" type="text/javascript"></script>
        <script src="/static/js/page/calculator.js" type="text/javascript"></script>
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
            <div class="row h-100">
                <div class="col-6 mx-auto align-self-center">
                    <form id="calculator" class="text-center" autocomplete="off">
                        <input id="calculator-money" type="number" name="money" placeholder="Money">
                        <input id="calculator-date" name="date" type="text" placeholder="Date" readonly>
                        <input id="calculator-time" name="time" type="text" placeholder="Time" readonly>
                        <input id="calculator-clean-time" name="clean-time" type="text" placeholder="Clean time" readonly>
                        <input id="calculator-percents" name="percents" type="text" placeholder="Percents" readonly>
                    </form>
                </div>
            </div>
        </div>

        <!--<div id="circularMenu" class="circular-menu">
            <a class="floating-btn" onclick="document.getElementById('circularMenu').classList.toggle('active');">
                <i class="fa fa-plus"></i>
            </a>
            <menu class="items-wrapper">
                <a href="#" class="menu-item fa fa-facebook"></a>
                <a href="#" class="menu-item fa fa-twitter"></a>
                <a href="#" class="menu-item fa fa-google-plus"></a>
                <a href="#" class="menu-item fa fa-linkedin"></a>
            </menu>
        </div>-->
    </body>
</html>