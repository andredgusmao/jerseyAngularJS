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
    $scope.image = {
      data: "",
      show: false
    };
    $scope.upload = function(callback) {
        var input = document.querySelector('input[type=file]'),
            src = "";
            file = input.files[0];
        if (!file || !file.type.match(/image.*/)) return;
        
        var fd = new FormData();
        fd.append("file", file);

        var xhr = new XMLHttpRequest();
        xhr.open("POST", url + "file/upload");
        xhr.onloadend = function(e) {
            src = xhr.responseText;
            callback(src);
        };
        
        xhr.send(fd);
    };
    $scope.upCallback = function(src) {
        $scope.image = {
          data: src,
          show: true
        };
    };
}

