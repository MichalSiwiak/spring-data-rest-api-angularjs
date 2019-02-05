<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>coffeecoding.net</title>
    <meta name="description"
          content="Free open source projects present different java solutions using spring, hibernate and other popular frameworks.">
    <meta name="keywords"
          content="java, spring, hibernate, apache, tomcat, coding, programmer, linux, google cloud platform, open source, bootstrap, mysql, java ideas">
    <!-- CSS dependencies -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
          type="text/css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.standalone.min.css">
    <link rel="stylesheet" href="https://coffeecoding.net/resources/css/now-ui-kit.css" type="text/css">
    <link rel="stylesheet" href="https://coffeecoding.net/resources/css/style.css" type="text/css">
    <link rel="icon" href="resources/img/favicon.png">
    <!-- PAGE scripts -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.9/angular.min.js"></script>
    <script src="resources/js/functions2.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.js"></script>
</head>


<body ng-app="SalesManagement" ng-controller="SalesManagementController" class="bg-light text-dark" style="">
<div id="wrap">
    <div id="main" class="clear-top">


        <div class="collapse" id="navbarHeader">
            <div class="container">
                <div class="row">
                    <div class="col-md-7 py-4">
                        <h4>About</h4>
                        <p class="text-info">Free open source projects present different java solutions using spring,
                            hibernate
                            and other popular frameworks.</p>
                    </div>
                    <div class="col-md-3 offset-md-1 py-4">
                        <h4>Contact</h4>
                        <ul class="list-unstyled">
                            <li>
                                <a href="https://pl.linkedin.com/in/michalsiwiak" class="text-secondary"
                                   target="_blank">Follow
                                    on LinkedIn</a>
                            </li>
                            <li>
                                <a href="mailto:info@coffeecoding.net" target="_top" class="text-secondary">Email me</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>


        <div class="navbar sticky-top navbar-dark bg-info">
            <div class="container d-flex justify-content-between">
                <a href="https://www.coffeecoding.net/" class="navbar-brand d-flex align-items-center"><i
                        class="fa fa-home fa-2x lead fa-fw d-inline-block" aria-hidden="true"></i>&nbsp;&nbsp;<text
                        class="">
                    HOME
                </text>
                </a>
                <a href="https://github.com/MichalSiwiak/spring-data-rest-api-angularjs" target="_blank"
                   class="navbar-brand d-flex align-items-center"><i
                        class="fa fa-git-square fa-fw d-inline-block lead fa-2x"></i>&nbsp;&nbsp;<text class="">SOURCE
                    CODE
                </text>
                </a>
                <a href="${pageContext.request.contextPath}" class="navbar-brand d-flex align-items-center"><i
                        class="fa fa-file-text fa-2x fa-fw lead d-inline-block" aria-hidden="true"></i>&nbsp;&nbsp;<text
                        class="">DESCRIPTION
                </text>
                </a>
                <a href="https://coffeecoding.net/resources/img/cv_msiwiak.pdf" target="_blank"
                   class="navbar-brand d-flex align-items-center"><i
                        class="fa fa-address-card fa-2x lead fa-fw d-inline-block" aria-hidden="true"></i>&nbsp;&nbsp;<text
                        class="">RESUME
                </text>
                </a>
                <a href="/contact" class="navbar-brand d-flex align-items-center"><i
                        class="fa fa-envelope fa-2x lead fa-fw d-inline-block" aria-hidden="true"></i>&nbsp;&nbsp;<text
                        class="">CONTACT
                </text>
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarHeader"><span
                        class="navbar-toggler-icon"></span></button>
            </div>
        </div>


        <div class="text-center py-4 bg-secondary"
             style="	background-image: linear-gradient(to left, rgba(0, 0, 0, 0.1), rgba(0, 0, 0, 0.9));	background-position: top left;	background-size: 100%;	background-repeat: repeat;">
            <div class="container">
                <div class="row">
                    <div class="col-md-0">
                        <h1 class="text-left text-primary">CRM System - Spring Data Rest Api</h1>
                        <p class="lead text-left">Implementation of database functionality using spring data. The
                            application sends sql queries (including CRUD methods) and receives data in JSON format. On
                            the client side, the
                            web application supports received JSON data using AngularJS.</p>
                    </div>
                </div>
            </div>
        </div>


        <div class="py-2">
            <div class="container">
                <form ng-submit="submitSales()">
                    <div class="row">
                        <div class="col-md-4" style="">
                            <div class="form-group"><label>country</label> <input type="text" class="form-control"
                                                                               ng-model="form.country"></div>
                            <div class="form-group"><label>itemType</label> <input type="text" class="form-control"
                                                                                    ng-model="form.itemType"></div>
                            <div class="form-group"><label>orderPriority</label> <input type="text"
                                                                                       class="form-control"
                                                                                       ng-model="form.orderPriority">
                            </div>
                        </div>
                        <div class="col-md-4" style="">
                            <div class="form-group"><label>unitsSold</label> <input type="number"
                                                                                            class="form-control"
                                                                                            ng-model="form.unitsSold">
                            </div>
                            <div class="form-group"><label>unitsPrice</label> <input type="number" class="form-control"
                                                                                     ng-model="form.unitsPrice"></div>
                            <div class="form-group"><label>totalCost</label> <input type="number"
                                                                                          class="form-control"
                                                                                          ng-model="form.totalCost">
                            </div>
                        </div>
                        <div class="col-md-4" style="">
                            <div class="form-group"><label>Name Starts:</label> <input type="text" ng-model="name"
                                                                                       ng-change="submitName()"
                                                                                       class="form-control"></div>
                            <div class="form-group"><label>Category</label> <select ng-model="sales" value="cokolwiek"
                                                                                    name="cars" class="form-control"
                                                                                    ng-change="submitsales()">
                                <option ng-repeat="x in saless">{{x}}</option>
                            </select></div>
                            <label>Name Starts:
                                <output name="ageOutputName" id="ageOutputId" class="mb-2">835031000</output>
                            </label>
                            <br>
                            <input type="range" class="custom-range w-100" name="ageInputName" id="ageInputId" min="0"
                                   max="2000000000" step="1000" oninput="ageOutputId.value = ageInputId.value"
                                   ng-change="submitPopulationL()" ng-model="populationL"
                                   ng-model-options="{updateOn: 'blur mouseup'}" style="">
                        </div>
                    </div>
                    <div class="col-md-4" style="">
                        <div class="row">
                            <button type="submit" class="btn btn-success w-25">Save</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="py-5">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12" style="">
                            <div class="table-wrapper-scroll-y">
                                <table class="table table-striped">
                                    <thead class="thead-light">
                                    <tr class="text-center">
                                        <th>country</th>
                                        <th>itemType</th>
                                        <th>orderPriority</th>
                                        <th>unitsSold</th>
                                        <th>unitsPrice</th>
                                        <th>totalCost</th>
                                        <th>Actions</th>
                                    </tr>
                                    </thead>
                                    <tbody class="text-center">
                                    <tr ng-repeat="sale in salesList">
                                        <td>{{ sale.country }}</td>
                                        <td>{{ sale.itemType }}</td>
                                        <td>{{ sale.orderPriority }}</td>
                                        <td>{{ sale.unitsSold }}</td>
                                        <td>{{ sale.unitsPrice }}</td>
                                        <td>{{ sale.totalCost }}</td>
                                        <td class="text-center">
                                            <a class="btn btn-sm text-dark btn-primary"
                                               ng-click="editSales( sale )"><i
                                                    class="fa fa-pencil-square-o fa-lg text-dark"
                                                    aria-hidden="true"></i></a>
                                            <a class="btn btn-sm text-dark btn-warning"
                                               ng-click="deleteSales( sale )"><i
                                                    class="fa fa-trash fa-lg text-dark" aria-hidden="true"></i></a>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>


<footer class="footer bg-dark text-muted">
    <div class="container">
        <p class="float-right">
            <a href="#">Back to top</a>
        </p>
        <p>© Copyright 2018 coffeecoding.net - All rights reserved.<br>Contact: info@coffeecoding.net<br>Warsaw PL<br><a
                href="https://www.coffeecoding.net/">Visit the homepage</a>
        </p>
    </div>
</footer>


</body>
</html>