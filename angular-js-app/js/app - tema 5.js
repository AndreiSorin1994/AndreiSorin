
var app = angular.module('blog', [ ]);

app.controller('HomeController', ['$scope', '$http', function($scope, $http) {
  $scope.helloWorld = 'Aplicatii Web cu suport Java!';
    
$scope.conturi = [];
$scope.cont = {};
    
 $http.get('http://localhost:8080/cont').then(
       function successCallback(response) {

       $scope.conturi = response.data;
     });
    

   $scope.deleteCont = function(id) {
    $http.delete('http://localhost:8080/cont/' + id)
    .then(
      function successCallback(response) {
       angular.element('[data-id=' + id + ']').remove();
      },
      function errorCallback(response) {
    });
  };
    
    
$scope.addCont = function(cont) {

    $http.post('http://localhost:8080/cont/'+cont.id+'?suma=' + cont.suma);
    $scope.conturi.push(cont);
    $scope.conturi = {};
  };

 $scope.setUpdateCont = function(cont) {
  $scope.editCont = cont;
   };


   $scope.updateCont = function(editCont) {
     $http.put('http://localhost:8080/cont/'+editCont.id+'?suma=' + editCont.suma);
       $scope.editCont = {};
  };


}]);
