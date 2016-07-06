angular.module('hello', [ 'ngRoute' ])
    .config(function($routeProvider, $httpProvider) {
        $routeProvider.when('/', {
            templateUrl:'home.html',
            controller:'home'
        }).when('/login', {
            templateUrl:'login.html',
            controller:'navigation'
        }).when('/projects', {
            templateUrl:'projects.html',
            controller:'projects'
        }).when('/profile', {
            templateUrl:'profile.html',
            controller:'profile'
        }).when('/reviews', {
            templateUrl:'reviews.html',
            controller:'reviews'
        }).otherwise('/');

        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    })
    .controller('home', function() {})
    .controller('navigation', function(){});