angular.module('bookShelfApp').
    controller('bookCtrl', function($scope, books){
        var book = {name:scope.bookName,author:scope.bookAuthor};
        books.addBook(book);
});