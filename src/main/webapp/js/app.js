var j = jQuery.noConflict();
angular.module('agendabelem', []).
    config(['$routeProvider', function($routeProvider) {
        $routeProvider.
            when('/', {templateUrl: 'partials/inicial.html', controller: FestaListCtrl}).
            when('/festa/:festaId', {templateUrl: 'partials/festa-detalhes.html', controller: FestaDetalhesCtrl}).
            when('/upload', {templateUrl: 'partials/upload.html', controller: FestaUploadCtrl}).
            otherwise({redirectTo: '/'});
    }]);