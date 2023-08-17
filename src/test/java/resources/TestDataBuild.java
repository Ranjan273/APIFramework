package resources;

import pojo.PoJoOne;
import pojo.PoJoTwoLocation;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public PoJoOne addPlacePayload(String name,String language,String address){

        PoJoOne pj=new PoJoOne();
        pj.setAccuracy(50);
        pj.setAddress(address);
        pj.setLanguage(language);
        pj.setName(name);
        pj.setPhone_number("(+91) 8099163065");
        pj.setWebsite("http://google.com");

        List<String> ml=new ArrayList<>();
        ml.add("shoe park");
        ml.add("shop");

        pj.setTypes(ml);

        PoJoTwoLocation pl=new PoJoTwoLocation();
        pl.setLat(-38.383494);
        pl.setLng(33.427362);

        pj.setLocation(pl);

        return pj;
    }
}
