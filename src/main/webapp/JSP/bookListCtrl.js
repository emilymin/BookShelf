angular.module('bookShelf').
  controller('bookListCtrl', function ($scope, books) {
     $scope.bookShelf = books.bookShelf;
});