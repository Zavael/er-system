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
        }).when('/user', {
            templateUrl:'user.html',
            controller:'user'
        }).when('/user/reviews', {
            templateUrl:'reviews.html',
            controller:'reviews'
        }).otherwise('/');

        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    })
    .controller('home', function() {})
    .controller('profile', function() {})
    .controller('reviews', function() {})
    .controller('navigation', function(){});