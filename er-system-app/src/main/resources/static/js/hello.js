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
            controller:'profile'
        }).when('/user/reviews', {
            templateUrl:'reviews.html',
            controller:'reviews'
        }).otherwise('/');

        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    })
    .controller('home', function() {
        console.log("home clicked")
    })
    .controller('profile', function() {
        console.log("profile clicked")
    })
    .controller('projects', function($scope, $http) {
        $http.get('/projects/').success(function(data){
            if(data._embedded){
                console.log("filled projects")
                $scope.projects = data._embedded.projects;
            } else {
                console.log("no data found")
            }
        })
    })
    .controller('reviews', function() {
        console.log("reviews clicked")
    })
    .controller('navigation', function($rootScope, $scope, $http, $location){
        var authenticate = function(credentials, callback){
            var headers = credentials
                ? {authorization : "Basic " + btoa(credentials.username + ":" + credentials.password)}
                : {};

            $http.get('user', {headers : headers})
                .success(function(data){
                    if(data.name){
                        $rootScope.authenticated = true;
                    } else {
                        $rootScope.authenticated = false;
                    }
                }).error(function(){
                    $rootScope.authenticated = false;
                    callback && callback();
                });
        }

        authenticate();
        $scope.credentials = {};
        $scope.login = function(){
            authenticate($scope.credentials, function(){
                if($rootScope.authenticated){
                    $location.path("/");
                    $scope.error = false;
                } else {
                    $location.path("/login");
                    $scope.error = true;
                }
            });
        }

        $scope.logout = function(){
            $http.post('logout', {}).success(function(){
                $rootScope.authenticated = false;
                $location.path("/");
            }).error(function(data){
                $rootScope.authenticated = false;
            })
        }
    });