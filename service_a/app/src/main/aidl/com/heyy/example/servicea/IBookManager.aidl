// IBookManager.aidl
package com.heyy.example.servicea;

import com.heyy.example.servicea.Book;

interface IBookManager {
    List<Book> getBookList();
    void addBook(in Book book);
}
