/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module('myApp.view6', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view6', {
                    templateUrl: 'view6/view6.html',
                    controller: 'View6Ctrl'
                });
            }])
        .controller('View6Ctrl', function ($scope, $http) {
            $scope.message = "Create a user to the system!!!";
            $scope.saveUser = function () {
//                alert('User');
                $http.post('api/saveUser', $scope.user).
                        success(function () {
                            alert('User Created');
                          });
            };
        });