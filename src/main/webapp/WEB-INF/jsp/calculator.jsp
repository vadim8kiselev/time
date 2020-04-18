<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <title>Time</title>

        <link rel="stylesheet"
              href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="/static/css/lib/bootstrap.css">
        <link rel="stylesheet" href="/static/css/calculator.css">
        <link rel="stylesheet" href="/static/css/component/menu.css">
    </head>

    <body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

                <!-- Sidebar - Brand -->
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/">
                    <div class="sidebar-brand-icon rotate-n-15">
                        <i class="fa fa-clock-o"></i>
                    </div>
                    <div class="sidebar-brand-text mx-3">Time</div>
                </a>

                <!-- Divider -->
                <hr class="sidebar-divider my-0">

                <!-- Nav Item - Dashboard -->
                <li class="nav-item active">
                    <a class="nav-link" href="/calculator">
                        <i class="fa fa-calculator"></i>
                        <span>Calculator</span></a>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
                        <i class="fa fa-table"></i>
                        <span>Menu</span>
                    </a>
                    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <h6 class="collapse-header">Functions:</h6>
                            <a class="collapse-item" href="/calculator">Calculator</a>
                            <a class="collapse-item" href="/menu">Function 2</a>
                            <a class="collapse-item" href="/menu">Function 3</a>
                            <a class="collapse-item" href="/menu">Function 4</a>
                        </div>
                    </div>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Heading -->
                <div class="sidebar-heading">
                    Other
                </div>

                <!-- Nav Item - Charts -->
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <i class="fa fa-info"></i>
                        <span>Information</span>
                    </a>
                </li>

                <!-- Nav Item - Tables -->
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <i class="fa fa-user"></i>
                        <span>Authors</span>
                    </a>
                </li>

            </ul>
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                        <!-- Sidebar Toggle (Topbar) -->
                        <button id="sidebarToggleTop" class="btn btn-link rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>

                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">

                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">User Name</span>
                                    <img class="img-profile rounded-circle" width="60" height="60"
                                         src="https://cdn2.iconfinder.com/data/icons/ios-7-icons/50/user_male2-512.png">
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                                    <a class="dropdown-item" href="#">
                                        <i class="fa fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Profile
                                    </a>
                                    <a class="dropdown-item" href="#">
                                        <i class="fa fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Settings
                                    </a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                        <i class="fa fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Logout
                                    </a>
                                </div>
                            </li>
                        </ul>
                    </nav>
                    <!-- End of Topbar -->

                    <!-- Begin Page Content -->
                    <div class="container-fluid">
                        <div class="row h-100">
                            <div class="col-6 mx-auto align-self-center">
                                <div id="calculator-card" class="card">
                                    <header class="card-header">
                                        <h4 class="card-title mt-2">Calculator</h4>
                                    </header>
                                    <article class="card-body">
                                        <form id="calculator" autocomplete="off">
                                            <div class="form-group">
                                                <label for="calculator-money">Price</label>
                                                <div class="input-group">
                                                    <div class="input-group-prepend">
                                            <span class="input-group-text">
                                                <i class="fa fa-money"></i>
                                            </span>
                                                    </div>
                                                    <input id="calculator-money" class="form-control" type="number" min="0" name="money" placeholder="Enter price here...">
                                                </div>
                                            </div>
                                            <br>
                                            <div class="form-group">
                                                <label for="calculator-date">Date:</label>
                                                <input id="calculator-date" class="form-control" name="date" type="text" readonly>
                                            </div>
                                            <div class="form-group">
                                                <label for="calculator-time">Calendar time:</label>
                                                <input id="calculator-time" class="form-control" name="time" type="text" readonly>
                                            </div>
                                            <div class="form-group">
                                                <label for="calculator-clean-time">Exact time:</label>
                                                <input id="calculator-clean-time" class="form-control" name="clean-time" type="text" readonly>
                                            </div>
                                            <div class="form-group">
                                                <label for="calculator-percents">Life percent:</label>
                                                <input id="calculator-percents" class="form-control" name="percents" type="text" readonly>
                                            </div>
                                        </form>
                                    </article>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End of Main Content -->

                <!-- Footer -->
                <!--<footer class="sticky-footer bg-white">
                  <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                      <span>Copyright &copy; Your Website 2019</span>
                    </div>
                  </div>
                </footer>-->
                <!-- End of Footer -->

            </div>
            <!-- End of Content Wrapper -->

        </div>
        <!-- End of Page Wrapper -->

        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <a class="btn btn-primary" href="/">Logout</a>
                    </div>
                </div>
            </div>
        </div>

        <script type="text/javascript" src="/static/js/lib/jquery.js"></script>
        <script type="text/javascript" src="/static/js/lib/popper.js"></script>
        <script type="text/javascript" src="/static/js/lib/bootstrap.js"></script>
        <script type="text/javascript" src="/static/js/lib/jquery.cookie.js"></script>
        <script type="text/javascript" src="/static/js/lib/admin.js"></script>
        <script type="text/javascript" src="/static/js/service/service.js"></script>
        <script type="text/javascript" src="/static/js/page/calculator.js"></script>
    </body>
</html>