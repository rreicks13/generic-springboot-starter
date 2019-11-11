package com.rossreicks.starter.mappers;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

public class MapperBase<APIModel, DBModel> {
    private final Mapper mapper;
    private final Class<APIModel> apiType;
    private final Class<DBModel> dbType;


    public MapperBase(Class<APIModel> apiType, Class<DBModel> dbType) {
        mapper = new DozerBeanMapper();
        this.apiType = apiType;
        this.dbType = dbType;
    }

    public APIModel ToAPIModel(DBModel dbModel)
    {
        return mapper.map(dbModel, apiType);
    }

    public DBModel ToDBModel(APIModel apiModel)
    {
        return mapper.map(apiModel, dbType);
    }

    public Iterable<APIModel> ToAPIList(Iterable<DBModel> dbModels)
    {
        List<APIModel> returnList = new ArrayList<APIModel>();
        dbModels.forEach((dbModel) -> returnList.add(ToAPIModel(dbModel)));
        return returnList;
    }

    public Iterable<DBModel> ToDBList(Iterable<APIModel> apiModels)
    {
        List<DBModel> returnList = new ArrayList<DBModel>();
        apiModels.forEach((apiModel) -> returnList.add(ToDBModel(apiModel)));
        return returnList;
    }
}