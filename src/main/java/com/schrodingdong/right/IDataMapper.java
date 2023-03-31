package com.schrodingdong.right;

public interface IDataMapper<T> {
    T map(String jsonString);
}
