package pe.edu.utp.javawebregionslist.pe.edu.utp.javawebregionslist.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountriesEntity extends BaseEntity {
    private static String DEFAULT_SQL="SELECT * FROM countries";

    private List<Country> findByCriteria(String sql,RegionsEntity regionsEntity){
        List<Country> countries;
        if (getConnection()!=null){
            countries=new ArrayList<>();

            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                while (resultSet.next()){
                    Country country=new Country(
                            resultSet.getString("country_id"),
                            resultSet.getString("country_name"),
                            regionsEntity
                                    .findById(resultSet.
                                            getInt("region_id"))
                    );
                    countries.add(country);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public List<Country> findAll(RegionsEntity regionsEntity){
        return getConnection()!=null?
                findByCriteria(DEFAULT_SQL,regionsEntity):null;
    }

    public List<Country> findForRegion(Region region,RegionsEntity regionsEntity){
        return getConnection()!=null?
                findByCriteria(DEFAULT_SQL +" WHERE region_id="+String.valueOf(region.getId()),regionsEntity):null;

    }
}
