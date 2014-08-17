angular.module('bookShelfApp').service('books',function() {
    var bookShelf = [];

    this.bookShelf = bookShelf;
    this.addBook = function (book){
        bookShelf.push(book);
    }
})