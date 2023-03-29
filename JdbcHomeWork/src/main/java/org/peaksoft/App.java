package org.peaksoft;

import static org.peaksoft.dao.Lists.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        Impl.getCountry(2);
        Impl.add_db_countries_into_arraylist();
        Impl.add_db_cities_into_arraylist();
        System.out.println(countries.get(2));

        Impl.getCountry(3);
    }
}
