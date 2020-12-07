package spring02;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Owl {

    public List<String> names;

    public Set<String> cities;

    public Map<String,String> home;



    Properties dbConfig;

    public void setNames(List<String> names) {
        this.names = names;
    }

    public void setCities(Set<String> cities) {
        this.cities = cities;
    }

    public void setHome(Map<String, String> home) {
        this.home = home;
    }
    public void setDbConfig(Properties dbConfig) {
        this.dbConfig = dbConfig;
    }
}
