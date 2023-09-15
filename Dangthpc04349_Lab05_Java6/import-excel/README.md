## REST API với AngularJS

### Cấu hình đơn giản

#### HTML:
```html
<body ng-app="myapp">
	<div ng-controller="myctrl">
		...
	</div>
</body>
```

#### JAVASCRIPT:
```js
var app = angular.module("myapp", []).controller("myctrl", function ($scope, $http) {
	$scope.list = [];
});
```

### GET API 

```js
// Simple GET request example:
$http({
  method: 'GET',
  url: '/someUrl'
}).then(function successCallback(response) {
    // this callback will be called asynchronously
    // when the response is available
  }, function errorCallback(response) {
    // called asynchronously if an error occurs
    // or server returns response with an error status.
  });
```

### Kết quả
![text](pokemon.gif)

Development by TranHuuDang.
