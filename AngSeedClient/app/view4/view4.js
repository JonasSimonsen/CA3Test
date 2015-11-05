'use strict';

angular.module('myApp.view4', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view4', {
                    templateUrl: 'view4/view4.html',
                    controller: 'View4Ctrl',
                    controllerAs: 'ctrl'
                })
            }])
        .controller('View4Ctrl', function ($http) {
            var self = this;

            $http({
                method: 'GET',
                url: 'api/currency/dailyrates'

            }).then(function (data) {
                self.data = data.data;
            }, function (data) {

            })

        });