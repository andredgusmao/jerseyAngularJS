var url = "http://localhost:8084/AgendaBelem/rest/";

function FestaListCtrl($scope, $http) {    
    $http.get(url + "festa").success(function(data) {        
        $scope.festas = data;
        console.log(data);
    });
}

function FestaDetalhesCtrl($scope, $http, $routeParams) {
    var id = $routeParams.festaId;
    $http.get(url + "festa/" + id).success(function(data) {        
        $scope.festa = data;
        console.log(data);
    });
}

function FestaUploadCtrl($scope, $http) {    
    $scope.upload = function() {
        var form = j("#upload-form");
        j.ajax({
            url: url + "file/upload",
            type: 'POST',
            data: form.serialize(),
            dataType: 'application/octet-stream',
            async: false,
            success: function (data) {
                $scope.data = data;
            },
            error: function(data, status) {
                $scope.data = data;
                $scope.status = status;                
            }
        });
        
        
//        $http.post(url + "file/upload").
//        success(function(data, status, headers, config) {
//            $scope.data = data;
//        }).error(function(data, status, headers, config) {
//            $scope.data = data;
//            $scope.status = status;
//        });
    };
}

