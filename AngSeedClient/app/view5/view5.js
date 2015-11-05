/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
'use strict';

angular.module('myApp.view5', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view5', {
                    templateUrl: 'view5/view5.html',
                        controller: 'View5Ctrl'
                });
            }])
        .controller('View5Ctrl', function ($http, $scope) {
//            $scope.username = "";
            
            $http.get('api/demoadmin/users/')
                    .then(function (response) {
                        $scope.usersFound = true;
                        $scope.users = response.data;
                    });
            $scope.deleteUser = function (x) {
                $http.delete('api/demoadmin/delete/'+x)
            }
//            $scope.updateList = function (response) {
//                $http.get('api/demoadmin/users/')
//                $scope.users = response.data;
//            }
        });

