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
    <script src="resources/js/functions.js"></script>
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
        <div class="collapse" id="navbarHeader" style="">
            <div class="container">
                <div class="row">
                    <div class="col-md-7 py-4">
                        <h4>About</h4>
                        <p class="text-info">Free open source projects present different java solutions using spring,
                            hibernate and other popular frameworks.</p>
                    </div>
                    <div class="col-md-3 offset-md-1 py-4">
                        <h4>Contact</h4>
                        <ul class="list-unstyled">
                            <li>
                                <a href="https://pl.linkedin.com/in/michalsiwiak" class="text-secondary"
                                   target="_blank">Follow on LinkedIn</a>
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
                        class=""> HOME
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
                            the client side, the web application supports received JSON data using AngularJS.</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="my-3">
            <div style="height: 65px!important">
                <div role="alert" class="alert text-dark text-center alert-warning">
                    <i class="now-ui-icons ui-2_like lg pull-left mr-3"></i>
                    <strong>{{message}}</strong>
                    <span> {{rowsNumberMessage}}</span>
                </div>
            </div>
            <div class="container">
                <div class="row shadow border-top">
                    <div class="col-md-4 order-md-2 rounded-0 border-0 border-left-0 border-right">
                        <h4 class="my-2" contenteditable="true"><b>Filters:</b></h4>
                        <div class="col-md-12 mb-3 text-center"><label>Type Country Like:</label>
                            <input type="text" ng-model="countryName"
                                   ng-change="findByCountryNameLike()" class="form-control rounded-0 text-center">
                        </div>
                        <div class="col-md-12 mb-3 text-center"><label>Select Item Type:</label>
                            <select ng-model="itemType" value="itemType" name="cars"
                                    class="form-control rounded-0 text-center" ng-change="findByItemTypeEquals()">
                                <option selected="selected">ALL</option>
                                <option ng-repeat="itemType in itemTypes" value="{{itemType}}">{{itemType}}</option>
                            </select>
                        </div>
                        <div class="col-md-12 text-center custom-control custom-slider mb-3 px-3">
                            <label>Select Price Less Than <
                                <output name="ageOutputName" id="ageOutputId">700</output>
                            </label>
                            <input type="range" class="slider w-100 border-0" name="ageInputName" id="ageInputId"
                                   min="0" max="700" step="10" value="700"
                                   oninput="ageOutputId.value = ageInputId.value"
                                   ng-change="findByUnitsPriceLessThan()" ng-model="price"
                                   ng-model-options="{updateOn: 'blur mouseup'}" style="">
                        </div>
                    </div>
                    <div class="col-md-8 order-md-1 shadow-none">
                        <h4 class="my-2 mb-0"><b>New/Edit Record:</b></h4>
                        <form ng-submit="submitSales()">
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="col-md-12 mb-3 text-center"><label>Country</label>
                                        <input type="text" ng-model="form.country"
                                               required="true" class="form-control rounded-0 text-center">
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="col-md-12 mb-3 text-center"><label>Item Type</label>
                                        <input type="text" ng-model="form.itemType"
                                               required="true" class="form-control rounded-0 text-center">
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="col-md-12 mb-3 text-center"><label>Order Priority</label>
                                        <input type="text" ng-model="form.orderPriority"
                                               required="true" class="form-control rounded-0 text-center">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="col-md-12 mb-3 text-center"><label>Units Price</label>
                                        <input min="0" max="100000000" step="0.01"
                                               type="number" ng-model="form.unitsPrice" ng-model="form.country"
                                               required="true" class="form-control rounded-0 text-center">
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="col-md-12 mb-3 text-center"><label>Units Sold</label>
                                        <input min="0" max="100000000" step="0.01"
                                               type="number" ng-model="form.unitsSold" ng-model="form.unitsPrice"
                                               required="true" class="form-control rounded-0 text-center">
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="col-md-12 mb-3 text-center"><label>Total Cost</label>
                                        <input min="0" max="100000000" step="0.01"
                                               type="number" ng-model="form.totalCost" ng-model="form.country"
                                               required="true" class="form-control rounded-0 text-center">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="col-md-12 mb-3 text-center">
                                        <button class="btn btn-block text-dark btn-sm mr-3 mt-4 mb-0 btn-warning"
                                                type="submit">
                                            Save changes
                                        </button>
                                        <%--<button ng-click="refresh()" class=" btn btn-block text-white btn-sm mr-3 mt-4
                                                mb-0 btn-danger" type="button">
                                            Refresh database
                                        </button>--%>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="py-2">
            <div class="py-5">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12" style="">
                            <div class="table-wrapper-scroll-y">
                                <table class="table table-striped">
                                    <thead class="thead-light">
                                    <tr class="text-center">
                                        <th>Country</th>
                                        <th>Item Type</th>
                                        <th>Order Priority</th>
                                        <th>Units Sold</th>
                                        <th>Units Price</th>
                                        <th>Total Cost</th>
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
                                            <a title="Edit" class="btn btn-sm text-dark btn-primary"
                                               ng-click="editSales( sale )"><i
                                                    class="fa fa-pencil-square-o fa-lg text-dark"
                                                    aria-hidden="true"></i></a>
                                            <a title="Delete" class="btn btn-sm text-dark btn-warning"
                                               ng-click="deleteSales( sale )"><i class="fa fa-trash fa-lg text-dark"
                                                                                 aria-hidden="true"></i></a>
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