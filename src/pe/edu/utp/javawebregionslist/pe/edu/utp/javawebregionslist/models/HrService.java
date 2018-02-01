package pe.edu.utp.javawebregionslist.pe.edu.utp.javawebregionslist.models;

import java.sql.Connection;
import java.util.List;

public class HrService {
    private Connection connection;
    private RegionsEntity regionsEntity;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    //Patron de diseño singleton
    public RegionsEntity getRegionsEntity() {
        if (getConnection()!=null){
            if(regionsEntity==null){
                regionsEntity=new RegionsEntity();
                regionsEntity.setConnection(getConnection());
            }
        }
        return regionsEntity;
    }

    //Patron fachada - llama al singleton
    public List<Region> findAllRegions(){
        return getRegionsEntity()!=null?
                getRegionsEntity().findAll():null;
    }

    public Region findRegionById(int id){
        return getRegionsEntity()!=null?getRegionsEntity().findById(id):null;
    }
    public Region createRegion(String name){
        return  getRegionsEntity()!=null?
                getRegionsEntity().create(name):null;

    }

}
