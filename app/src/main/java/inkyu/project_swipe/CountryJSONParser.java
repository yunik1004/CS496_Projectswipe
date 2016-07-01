package inkyu.project_swipe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountryJSONParser {

    /** Receives a JSONObject and returns a list */
    public List<HashMap<String,String>> parse(JSONObject jObject){

        JSONArray jNames = null;
        try {
            /** Retrieves all the elements in the 'countries' array */
            jNames = jObject.getJSONArray("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        /** Invoking getCountries with the array of json object
         * where each json object represent a country
         */
        return getNames(jNames);
    }

    private List<HashMap<String, String>> getNames(JSONArray jNames){
        int nameCount = jNames.length();
        List<HashMap<String, String>> nameList = new ArrayList<HashMap<String,String>>();
        HashMap<String, String> name = null;

        /** Taking each country, parses and adds to list object */
        for(int i=0; i<nameCount;i++){
            try {
                /** Call getCountry with country JSON object to parse the country */
                name = getName((JSONObject)jNames.get(i));
                nameList.add(name);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return nameList;
    }

    /** Parsing the Country JSON object */
    private HashMap<String, String> getName(JSONObject jName){

        HashMap<String, String> name = new HashMap<String, String>();
        String humanName = "";
        String flag = "";
        String phoneNumber = "";
        String job = "";
        String statusContent = "";

        try {
            humanName = jName.getString("humanname");
            flag = jName.getString("flag");
            phoneNumber = jName.getString("phonenumber");
            job = jName.getString("job");
            statusContent = jName.getJSONObject("status").getString("statuscontent");

            String details =        "휴대전화 : " + phoneNumber + "\n" +
                    "직업 : " + job + "\n" +
                    "대화명 : " + statusContent;

            name.put("country", humanName);
            name.put("flag", flag);
            name.put("details", details);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return name;
    }
}