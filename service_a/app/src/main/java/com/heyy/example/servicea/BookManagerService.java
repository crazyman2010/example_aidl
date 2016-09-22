package com.heyy.example.servicea;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class BookManagerService extends Service {
    private CopyOnWriteArrayList<Book> mBookList;

    public BookManagerService() {
        mBookList = new CopyOnWriteArrayList<>();
        mBookList.add(new Book(1, "book1"));
        mBookList.add(new Book(2, "book2"));
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("aidl","service a bind!");
        return mBinder;
    }

    private Binder mBinder = new IBookManager.Stub() {

        @Override
        public List<Book> getBookList() throws RemoteException {
            return mBookList;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            mBookList.add(book);
        }
    };
}
