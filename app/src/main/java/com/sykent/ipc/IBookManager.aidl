// IBookManager.aidl
package com.sykent.ipc;

import com.sykent.ipc.Book;
// Declare any non-default types here with import statements

interface IBookManager {
    List<Book> getBookList();
    void addBook(in Book book);
}
