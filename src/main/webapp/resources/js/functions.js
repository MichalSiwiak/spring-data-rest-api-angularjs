var app = angular.module("UserManagement", []);

//Controller Part
app.controller("UserManagementController", function ($scope, $http) {

    //Initialize page with default data which is blank in this example
    $scope.countries = [];
    $scope.record = "";
    $scope.name = "";
    $scope.populationL = "2000000000";

    $scope.form = {
        id: -1,
        name: "",
        continent: "",
        surfaceArea: "",
        indepYear: "",
        population: "",
        lifeExpectancy: ""
    };

    //Now load the data from server
    _refreshPageData();
    _getAllContinents();

    $scope.submitPopulationL = function () {
        $http({
            method: "POST",
            url: '/crm/demo/population',
            data: $scope.populationL,
            headers: {
                'Content-Type': 'text/plain'
            }
        }).then(_success, _error);
    };

    $scope.submitName = function () {
        if ($scope.name != "") {
            $http({
                method: "POST",
                url: '/crm/demo/name',
                data: $scope.name,
                headers: {
                    'Content-Type': 'text/plain'
                }
            }).then(_success, _error);
        } else {
            $http({
                method: "POST",
                url: '/crm/demo/name',
                data: 'all',
                headers: {
                    'Content-Type': 'text/plain'
                }
            }).then(_success, _error);
        }
    };

    $scope.submitRecord = function () {
        $http({
            method: "POST",
            url: '/crm/demo/continent',
            data: $scope.record,
            headers: {
                'Content-Type': 'text/plain'
            }
        }).then(_success, _error);
    };

    function _getAllContinents() {
        $http({
            method: 'GET',
            url: '/crm/demo/continents'
        }).then(function successCallback(response) {
            $scope.records = response.data;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }

    //HTTP POST/PUT methods for add/edit country
    $scope.submitCountry = function () {

        var method = "";
        var url = "";
        if ($scope.form.id == -1) {
            //Id is absent so add country - POST operation
            method = "POST";
            url = '/crm/demo/countries';
        } else {
            //If Id is present, it's edit operation - PUT operation
            method = "PUT";
            url = '/crm/demo/countries/' + $scope.form.id;
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

    //HTTP DELETE- delete country by Id
    $scope.removeCountry = function (country) {
        $http({
            method: 'DELETE',
            url: '/crm/demo/countries/' + country.id
        }).then(_success, _error);
    };

    //In case of edit country, populate form with country data
    $scope.editCountry = function (country) {
        $scope.form.name = country.name;
        $scope.form.continent = country.continent;
        $scope.form.population = country.population;
        $scope.form.lifeExpectancy = country.lifeExpectancy;
        $scope.form.surfaceArea = country.surfaceArea;
        $scope.form.indepYear = country.indepYear;
        $scope.form.id = country.id;
    };

    /* Private Methods */

    //HTTP GET- get all countries collection
    function _refreshPageData() {
        $http({
            method: 'GET',
            url: '/crm/demo/countries'
        }).then(function successCallback(response) {
            $scope.countries = response.data.countries;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }

    function _success() {
        _refreshPageData();
        _clearForm()
    }

    function _error(response) {
        console.log(response.statusText);
    }

    //Clear the form
    function _clearForm() {
        $scope.form.name = "";
        $scope.form.continent = "";
        $scope.form.population = "";
        $scope.form.lifeExpectancy = "";
        $scope.form.surfaceArea = "";
        $scope.form.indepYear = "";
        $scope.form.id = -1;
    };
});