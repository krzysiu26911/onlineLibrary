var app = angular.module('app', []);

app.controller('appController', function($scope, $http) {
    $scope.listBook = [];
    function getAllCustomer(){

        $http.get("http://localhost:8080/books").then(function (response) {
            $scope.listBook = response.data;
            console.log(response.data)
        })
    }
    getAllCustomer()
   
});