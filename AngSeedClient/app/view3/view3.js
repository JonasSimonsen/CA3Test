'use strict';

angular.module('myApp.view3', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view3', {
    templateUrl: 'view3/view3.html',
    controller: 'View3Ctrl'
  });
}])

.controller('View3Ctrl', function ($http) {
    var self = this;
    self.searchInput = "";
    self.searchBy = "";
    self.country = "";
    
    self.search = function(){
          $http({
            method: 'GET',
//            url: 'api/search/' + self.searchBy + '=' + self.searchInput + '&country=' + self.country
            url: 'api/search/'+self.searchBy+'/'+self.searchInput+'/'+self.country
          }).then(function(data) {
            self.data = data.data;
          }, function (data) {
           
          });

        };
        });
        
        
        