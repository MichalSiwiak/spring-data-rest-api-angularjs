var app = angular.module("SalesManagement", []);

//Controller Part
app.controller("SalesManagementController", function ($scope, $http) {

    $scope.salesList = [];
    $scope.rowsNumberMessage = '';
    $scope.message = '';
    $scope.price = '';

    $scope.form = {
        id: -1,
        country: "",
        itemType: "",
        orderPriority: "",
        unitsSold: "",
        unitsPrice: "",
        totalCost: ""
    };

    _findAll();


    $scope.submitPrice = function () {
        $http({
            method: 'POST',
            url: '/demo/price',
            data: $scope.price,
            headers: {
                'Content-Type': 'text/plain'
            }
        }).then(function successCallback(response) {
            _success();
            _error(response);
        })
    };

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
            _success();
            _error(response);
        })
    };


    $scope.deleteSales = function (sales) {
        $http({
            method: 'DELETE',
            url: '/crm/demo/sales/' + sales.id
        }).then(function successCallback(response) {
            $scope.message = response.headers('message');
            _success();
            _error(response);
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


    function _findAll() {
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

    function _success() {
        _findAll();
        _clearForm()
    }

    function _error(response) {
        console.log(response.statusText);
    }

    function _clearForm() {
        $scope.form.country = "";
        $scope.form.itemType = "";
        $scope.form.orderPriority = "";
        $scope.form.unitsSold = "";
        $scope.form.unitsPrice = "";
        $scope.form.totalCost = "";
        $scope.form.id = -1;
    };
});