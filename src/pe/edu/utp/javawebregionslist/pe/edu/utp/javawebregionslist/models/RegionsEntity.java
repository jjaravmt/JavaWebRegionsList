package pe.edu.utp.javawebregionslist.pe.edu.utp.javawebregionslist.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegionsEntity extends BaseEntity {
    private static String DEFAULT_SQL="SELECT * FROM hr.regions";
    private String sql;

    private List<Region> findByCriteria(String sql) {
        List<Region> regions;
        if (getConnection()!=null){
            regions=new ArrayList<>();
            try {
                ResultSet resulSet=getConnection().createStatement().executeQuery(sql);
                while (resulSet.next()){
                    Region region=new Region()
                            .setId(resulSet.getInt("region_id"))
                            .setName(resulSet.getString("region_name"));
                    regions.add(region);
                }
                return regions;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<Region> findAll(){
        return findByCriteria(DEFAULT_SQL);
    }

    public Region findById(int id){
        List<Region> regions=findByCriteria(DEFAULT_SQL + "WHERE region_id="+
        String.valueOf(id));
        return (regions!=null?regions.get(0):null);
    }

    public Region findByName(String name){
        List<Region> regions=findByCriteria(DEFAULT_SQL+
        " WHERE region_name='"+
        name +"'");
        return (regions!=null?regions.get(0):null);
    }

    private int getMaxId(){
        String sql="SELECT MAX(id) AS max_id FROM regions";
        if (getConnection()!=null){
            try {
                ResultSet resulSet=getConnection()
                        .createStatement()
                        .executeQuery(sql);
                return resulSet.next()?
                        resulSet.getInt("max_id"):0;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return 0;
    }

    private int updatebyCriteria(String sql){
        if(getConnection()!=null){
            try {
                return getConnection()
                        .createStatement()
                        .executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public Region create(String name){
        if (findByName(name)==null){
            if (getConnection()!=null){
                String sql="INSERT INTO regions(region_id,region_name) " +
                        "VALUES("+ String.valueOf(getMaxId()+1)+", '"+
                        name+"')";
                int results=updatebyCriteria(sql);
                if (results>0){
                    Region region=new Region(getMaxId(),name);
                    return region;
                }
            }
        }
        return  null;
    }

    public boolean delete(int id){
        return updatebyCriteria("DELETE FROM regions WHERE region_id="+
        String.valueOf(id))>0;
    }

    public boolean delete(String name){
        return updatebyCriteria("DELETE FROM regions WHERE region_name='"+
                name+"'")>0;
    }

    public boolean update(Region region){
        return updatebyCriteria("UPDATE regions SET region_name='"+
                region.getName()+"' WHERE region_id="+String.valueOf(region.getId()))>0;
    }

    public List<Region> findAllWithCountries(CountriesEntity countriesEntity){
        List<Region> regions = findAll();
        for (Region region:regions) region.setCountries(
                countriesEntity.findForRegion(region,this));

        return null;
    }

}
