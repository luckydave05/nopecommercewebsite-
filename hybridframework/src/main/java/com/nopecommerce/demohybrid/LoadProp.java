package com.nopecommerce.demohybrid;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProp
{

    static Properties prop;
    static FileInputStream input;
    static String filename = "TestDataConfig.Properties";
    static String fileLocation = "src\\test\\Resources\\TestData\\";

    public String getPropety (String key)
    {
        prop = new Properties ();
        try {
            input = new FileInputStream( fileLocation + filename);
            prop.load (input);
            input.close ( );
        }
        catch (IOException e)
        {
            e.printStackTrace ();
        }
        return prop.getProperty (key);
    }
}
