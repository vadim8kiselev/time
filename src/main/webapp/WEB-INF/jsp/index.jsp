<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Time</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="/static/css/lib/bootstrap.css">
        <link rel="stylesheet" href="/static/css/index.css">
    </head>

    <body>
        <div class="container h-100">
            <div class="row h-100 justify-content-center">
                <div class="col-sm-7 col-md-9 col-xl-6 mx-auto align-self-center">
                    <div id="registration-card" class="card">
                        <header class="card-header">
                            <a href="/login" class="float-right btn btn-outline-primary mt-1 btn-log">Log in</a>
                            <h4 class="card-title mt-2">Create your account</h4>
                        </header>
                        <article class="card-body">
                            <form:form id="registration-form" action="/registration" method="POST" modelAttribute="uiProfile" autocomplete="off">
                                <div class="form-group">
                                    <label for="username" class="required reg-label">Username</label>
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">
                                                <i class="fa fa-user"></i>
                                            </span>
                                        </div>
                                        <form:input id="username" path="username" type="text" inputmode="verbatim" class="form-control" required="required"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="password" class="required reg-label">Password</label>
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">
                                                <i class="fa fa-lock"></i>
                                            </span>
                                        </div>
                                        <form:input id="password" path="password" inputmode="verbatim" type="password" class="form-control" required="required"/>
                                    </div>
                                    <small class="text-muted">
                                        Make sure it's at least 3 characters and consists of alphanumeric characters.
                                    </small>
                                </div>
                                <div id="income-container">
                                    <div id="income-row-1" class="income-row form-row">
                                        <div class="form-group col-md-7">
                                            <label for="income1" class="required reg-label">Income</label>
                                            <div class="input-group">
                                                <form:input id="income1" path="incomes[0].money" type="number" inputmode="numeric" class="form-control" min="0" required="required"/>
                                                <div class="input-group-append">
                                                    <form:select id="currency1" path="incomes[0].currency" form="registration-form" class="btn input-group-text" required="required">
                                                        <option value="₽" selected="selected">₽</option>
                                                    </form:select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group col-md-3 offset-md-1">
                                            <label for="tax1" class="required reg-label">Tax</label>
                                            <div class="input-group">
                                                <form:input id="tax1" path="incomes[0].tax" type="number" inputmode="numeric" class="form-control" min="0" max="100" required="required"/>
                                                <div class="input-group-append">
                                                    <span class="input-group-text">
                                                        <i class="fa fa-percent"></i>
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-check" disabled="disabled" style="display: none">
                                            <form:checkbox path="incomes[0].main" class="form-check-input" id="mainFlag1" checked="checked"/>
                                        </div>
                                        <div class="form-group col-md-1">
                                            <form:button id="addIncomeForm" class="btn btn-outline-success"
                                                    type="button" onclick="Entry.addIncomeForm()" style="margin-top: 32px">
                                                <i class="fa fa-plus"></i>
                                            </form:button>
                                        </div>
                                    </div>

                                    <div id="income-row-2" class="income-row form-row" disabled="disabled" style="display: none">
                                        <div class="form-group col-md-7">
                                            <div class="input-group">
                                                <form:input id="income2" path="incomes[1].money" type="number" inputmode="numeric" class="form-control" min="0"/>
                                                <div class="input-group-append">
                                                    <form:select id="currency2" path="incomes[1].currency" form="registration-form" class="btn input-group-text">
                                                        <option value="₽" selected="selected">₽</option>
                                                    </form:select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group col-md-3 offset-md-1">
                                            <div class="input-group">
                                                <form:input id="tax2" path="incomes[1].tax" type="number" inputmode="numeric" class="form-control" min="0" max="100"/>
                                                <div class="input-group-append">
                                                    <span class="input-group-text">
                                                        <i class="fa fa-percent"></i>
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-check" disabled="disabled" style="display: none">
                                            <form:checkbox path="incomes[1].main" class="form-check-input" id="mainFlag2"/>
                                        </div>
                                        <div class="form-group col-md-1">
                                            <form:button id="deleteIncomeForm2" class="btn btn-outline-danger"
                                                    type="button" onclick="Entry.deleteIncomeForm('#income-row-2')">
                                                <i class="fa fa-minus"></i>
                                            </form:button>
                                        </div>
                                    </div>

                                    <div id="income-row-3" class="income-row form-row" disabled="disabled" style="display: none">
                                        <div class="form-group col-md-7">
                                            <div class="input-group">
                                                <form:input id="income3" path="incomes[2].money" type="number" inputmode="numeric" class="form-control" min="0"/>
                                                <div class="input-group-append">
                                                    <form:select id="currency3" path="incomes[2].currency" form="registration-form" class="btn input-group-text">
                                                        <option value="₽" selected="selected">₽</option>
                                                    </form:select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group col-md-3 offset-md-1">
                                            <div class="input-group">
                                                <form:input id="tax3" path="incomes[2].tax" type="number" inputmode="numeric" class="form-control" min="0" max="100"/>
                                                <div class="input-group-append">
                                                    <span class="input-group-text">
                                                        <i class="fa fa-percent"></i>
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-check" disabled="disabled" style="display: none">
                                            <form:checkbox path="incomes[2].main" class="form-check-input" id="mainFlag3"/>
                                        </div>
                                        <div class="form-group col-md-1">
                                            <form:button id="deleteIncomeForm3" class="btn btn-outline-danger"
                                                    type="button" onclick="Entry.deleteIncomeForm('#income-row-3')">
                                                <i class="fa fa-minus"></i>
                                            </form:button>
                                        </div>
                                    </div>

                                    <div id="income-row-4" class="income-row form-row" disabled="disabled" style="display: none">
                                        <div class="form-group col-md-7">
                                            <div class="input-group">
                                                <form:input id="income4" path="incomes[3].money" type="number" inputmode="numeric" class="form-control" min="0"/>
                                                <div class="input-group-append">
                                                    <form:select id="currency4" path="incomes[3].currency" form="registration-form" class="btn input-group-text">
                                                        <option value="₽" selected="selected">₽</option>
                                                    </form:select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group col-md-3 offset-md-1">
                                            <div class="input-group">
                                                <form:input id="tax4" path="incomes[3].tax" type="number" inputmode="numeric" class="form-control" min="0" max="100"/>
                                                <div class="input-group-append">
                                                    <span class="input-group-text">
                                                        <i class="fa fa-percent"></i>
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-check" disabled="disabled" style="display: none">
                                            <form:checkbox path="incomes[3].main" class="form-check-input" id="mainFlag4"/>
                                        </div>
                                        <div class="form-group col-md-1">
                                            <form:button id="deleteIncomeForm4" class="btn btn-outline-danger"
                                                    type="button" onclick="Entry.deleteIncomeForm('#income-row-4')">
                                                <i class="fa fa-minus"></i>
                                            </form:button>
                                        </div>
                                    </div>

                                    <div id="income-row-5" class="income-row form-row" disabled="disabled" style="display: none">
                                        <div class="form-group col-md-7">
                                            <div class="input-group">
                                                <form:input id="income5" path="incomes[4].money" type="number" inputmode="numeric" class="form-control" min="0"/>
                                                <div class="input-group-append">
                                                    <form:select id="currency5" path="incomes[4].currency" form="registration-form" class="btn input-group-text">
                                                        <option value="₽" selected="selected">₽</option>
                                                    </form:select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group col-md-3 offset-md-1">
                                            <div class="input-group">
                                                <form:input id="tax5" path="incomes[4].tax" type="number" inputmode="numeric" class="form-control" min="0" max="100"/>
                                                <div class="input-group-append">
                                                    <span class="input-group-text">
                                                        <i class="fa fa-percent"></i>
                                                    </span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-check" disabled="disabled" style="display: none">
                                            <form:checkbox path="incomes[4].main" class="form-check-input" id="mainFlag5"/>
                                        </div>
                                        <div class="form-group col-md-1">
                                            <form:button id="deleteIncomeForm5" class="btn btn-outline-danger"
                                                    type="button" onclick="Entry.deleteIncomeForm('#income-row-5')">
                                                <i class="fa fa-minus"></i>
                                            </form:button>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="spending" class="reg-label">Average spending</label>
                                        <div class="input-group">
                                            <form:input id="spending" path="spending" type="number" inputmode="numeric" class="form-control" min="0"/>
                                            <div class="input-group-append">
                                                <span class="input-group-text">per month</span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-5 offset-md-1">
                                        <label for="age" class="reg-label">Age</label>
                                        <div class="input-group">
                                            <form:input id="age" path="age" type="number" inputmode="numeric" class="form-control" min="0" max="100"/>
                                            <div class="input-group-append">
                                                <span class="input-group-text">years old</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <form:button type="submit" class="btn btn-primary btn-block btn-reg" value="Submit">Register</form:button>
                                </div>
                                <div class="text-center">
                                    <small class="text-muted">
                                        By clicking the 'Register' button, you accept our Terms of use and Privacy Policy.
                                    </small>
                                </div>
                            </form:form>
                        </article>
                        <div class="border-top card-body text-center footer-label">Have an account? <a class="footer-label" href="/login">Log In</a></div>
                    </div>
                </div>
            </div>
        </div>

        <script type="text/javascript" src="/static/js/lib/jquery.js"></script>
        <script type="text/javascript" src="/static/js/lib/popper.js"></script>
        <script type="text/javascript" src="/static/js/lib/bootstrap.js"></script>
        <script type="text/javascript" src="/static/js/page/index.js"></script>
    </body>
</html>