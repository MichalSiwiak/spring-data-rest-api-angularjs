var app = angular.module("SalesManagement", []);

app.controller("SalesManagementController", function ($scope, $http) {

    $scope.salesList = [];
    $scope.rowsNumberMessage = '';
    $scope.message = '';
    $scope.price = '700';
    $scope.itemTypes = [];
    $scope.itemType = 'ALL';
    $scope.countryName = '';

    $scope.form = {
        id: -1,
        country: "",
        itemType: "",
        orderPriority: "",
        unitsSold: "",
        unitsPrice: "",
        totalCost: ""
    };

    findAll();
    findDistinctByItemType();


    $scope.findByCountryNameLike = function () {
        if ($scope.countryName != "") {
            $http({
                method: "POST",
                url: '/crm/demo/countryName',
                data: $scope.countryName,
                headers: {
                    'Content-Type': 'text/plain'
                }
            }).then(success, error);
        } else {
            $http({
                method: "POST",
                url: '/crm/demo/countryName',
                data: 'all',
                headers: {
                    'Content-Type': 'text/plain'
                }
            }).then(success, error);
        }
    };


    $scope.findByItemTypeEquals = function () {
        $http({
            method: 'POST',
            url: '/crm/demo/itemType',
            data: $scope.itemType,
            headers: {
                'Content-Type': 'text/plain'
            }
        }).then(success, error);
    };


    $scope.findByUnitsPriceLessThan = function () {
        $http({
            method: 'POST',
            url: '/crm/demo/price',
            data: $scope.price,
            headers: {
                'Content-Type': 'text/plain'
            }
        }).then(success, error);
    };


    function findDistinctByItemType() {
        $http({
            method: 'GET',
            url: '/crm/demo/itemTypes'
        }).then(function successCallback(response) {
            $scope.itemTypes = response.data;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }


    $scope.submitSales = function () {

        var method = "";
        var url = "";
        if ($scope.form.id == -1) {
            method = "POST";
            url = '/crm/demo/sales';
        } else {
            method = "PUT";
            url = '/crm/demo/sales/' + $scope.form.id;
        }

        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.form),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function successCallback(response) {
            $scope.message = response.headers('message');
            success();
            error(response);
        })
    };


    $scope.deleteSales = function (sales) {
        $http({
            method: 'DELETE',
            url: '/crm/demo/sales/' + sales.id
        }).then(function successCallback(response) {
            $scope.message = response.headers('message');
            success();
            error(response);
        })
    };


    $scope.editSales = function (sales) {
        $scope.form.country = sales.country;
        $scope.form.itemType = sales.itemType;
        $scope.form.orderPriority = sales.orderPriority;
        $scope.form.unitsSold = sales.unitsSold;
        $scope.form.unitsPrice = sales.unitsPrice;
        $scope.form.totalCost = sales.totalCost;
        $scope.form.id = sales.id;
    };


    function findAll() {
        $http({
            method: 'GET',
            url: '/crm/demo/sales'
        }).then(function successCallback(response) {
            $scope.salesList = response.data.salesList;
            $scope.rowsNumberMessage = response.headers('rowsNumberMessage');
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }


   /* $scope.refresh = function () {
        $http({
            method: 'GET',
            url: '/crm/demo/refresh/'
        }).then(function successCallback(response) {
            success();
            error(response);
        })
    };*/


    function success() {
        findAll();
        clearForm()
    }


    function error(response) {
        console.log(response.statusText);
    }


    function clearForm() {
        $scope.form.country = "";
        $scope.form.itemType = "";
        $scope.form.orderPriority = "";
        $scope.form.unitsSold = "";
        $scope.form.unitsPrice = "";
        $scope.form.totalCost = "";
        $scope.form.id = -1;
    };

});