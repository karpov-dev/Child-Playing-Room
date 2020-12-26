package base.interfaces;

import base.exceptions.DataBaseException;

public interface IDataBase {
    boolean fillBaseFromFile(String path) throws DataBaseException;
}
