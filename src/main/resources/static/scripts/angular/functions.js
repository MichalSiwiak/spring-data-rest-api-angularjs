var app = angular.module('Chart', ['zingchart-angularjs'])

    .filter('percentage', ['$filter', function ($filter) {
        return function (input, decimals) {
            return $filter('number')(input * 100, decimals) + '%';
        };
    }]);


app.controller('MainController', function ($scope, $http) {


    //Initialize page with default data which is blank in this example
    $scope.form = {
        futureValue: 100000,
        yearsOfSavings: 10,
        returnOnCapital: 4.45,
        inflationRate: 0.51
    };
    _draw_chart();
    _refreshPageData();


    //HTTP GET methods
    function _refreshPageData() {
        $http.get('getdata')
            .then(function (response) {
                $scope.jsondata = response.data;
                $scope.myJson.series[0].values = response.data.depositsList;
                $scope.myJson.series[1].values = response.data.accumulatedCapitalsList;
                $scope.myJson.scaleX.values = response.data.yearList;
                console.log("status:" + response.status);
            }).catch(function (response) {
            console.error('Error occurred:', response.status, response.data);
        }).finally(function () {
            console.log("Task Finished.");
        });
    }

    //HTTP POST methods
    $scope.submitData = function () {
        $http({
            method: "POST",
            url: 'submit',
            data: angular.toJson($scope.form),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    function _success(response) {
        _refreshPageData();
        //_clearForm()
    }

    function _error(response) {
        console.log(response.statusText);
    }

    //Clear the form
    function _clearForm() {
        $scope.form.futureValue = "";
        $scope.form.yearsOfSavings = "";
        $scope.form.returnOnCapital = "";
        $scope.form.inflationRate = "";
    };

    //Drawing chart
    function _draw_chart() {
        $scope.myJson = {
            backgroundColor: "",
            legend: {
                align: "right",
                layout: "x2",
                backgroundColor: "transparent",
                borderColor: "transparent",
                marker: {
                    borderRadius: "50px",
                    borderColor: "transparent"
                },
                item: {
                    fontColor: "grey"
                }

            },
            crosshairX: {
                scaleLabel: {
                    backgroundColor: "#fff",
                    fontColor: "black"
                },
                plotLabel: {
                    backgroundColor: "#434343",
                    fontColor: "#FFF",
                    _text: "Number of hits : %v"
                }
            },
            scaleX: { values:  [] },
            plot: {
                lineWidth: "2px",
                aspect: "line",
                marker: {
                    visible: false
                }
            },
            type: 'line',
            series: [{text: "Suma wpłat", values: [], lineColor: "#4AD8CC"}, {
                text: "Zgromadzony kapitał",
                lineColor: "#D8CD98",
                values: []
            }]
        }
    }

});