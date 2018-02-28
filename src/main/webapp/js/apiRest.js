var API = angular.module('API', ['ngResource']);

// With this you can inject POKEAPI url wherever you want
API.constant('apiRest', 'http://localhost:9955/rest/API/');

API.config(['$resourceProvider', function($resourceProvider) {
    $resourceProvider.defaults.stripTrailingSlashes = false;
}]);


API.controller("API",function($scope,$log,$http){
$http({
  method: 'GET',
  url: 'http://localhost:9955/rest/API/personnes'
}).then(function successCallback(response) {
    $scope.listPersonnes = response.data;
  }, function errorCallback(response) {
    console.log("fail "+ response)
  });
  $scope.$log = $log;

    $scope.postPers = function (){
        $resource("http://localhost:9955/rest/API/personnes?nom="+$scope.newPerso.nom +"&prenom="+$scope.newPerso.prenom+"&age="+$scope.newPerso.age).save();
    }  
});



