var app = angular.module("SalesManagement", []);

//Controller Part
app.controller("SalesManagementController", function ($scope, $http) {

    $scope.salesList = [];

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
        }).then(_success, _error);
    };


    $scope.deleteSales = function (sales) {
        $http({
            method: 'DELETE',
            url: '/crm/demo/sales/' + sales.id
        }).then(_success, _error);
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