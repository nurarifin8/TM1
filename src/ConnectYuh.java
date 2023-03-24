import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class ConnectYuh {
    public static void main (String[] argh) throws IOException{
        ConnectURI koneksiSaya = new ConnectURI();
        URL myAddress = koneksiSaya.buildURL("https://farmasi.mimoapps.xyz/mimoqss2auyqD1EAlkgZCOhiffSsFl6QqAEIGtM");
        String response = koneksiSaya.getResponseFromHttpurl(myAddress);
        System.out.println(response);

        assert response != null;
        JSONArray responsJSON = new JSONArray(response);
        ArrayList<Model> model = new ArrayList<>();
        for (int i =0; i< responsJSON.length();i++){
            Model responModel = new Model();
            JSONObject myJSONobject = responsJSON.getJSONObject(i);
            responModel.setI_name(myJSONobject.getString("i_name"));
            responModel.setI_qty(myJSONobject.getString("i_qty"));
            responModel.setI_sell(myJSONobject.getString("i_sell"));
            model.add(responModel);
        }
        System.out.println("Response are");
        for (int index = 0; index < model.size();index++) {
            System.out.println("NAMA : " + model.get(index).getI_name());
            System.out.println("QTY : " + model.get(index).getI_qty());
            System.out.println("SELL : " + model.get(index).getI_sell());

        }
    }
}
