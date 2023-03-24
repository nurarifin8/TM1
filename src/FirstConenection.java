import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class FirstConenection {
    public static void main(String[] argh) throws IOException {
//        REQUEST
        ConnectURI koneksiSaya = new ConnectURI();
        URL myAddress = koneksiSaya.buildURL("https://harber.mimoapps.xyz/api/getaccess.php");
        String responsse = koneksiSaya.getResponseFromHttpurl(myAddress);
        System.out.println(responsse);
//        decoding
        assert responsse != null;
        JSONArray responJSON = new JSONArray(responsse);
        ArrayList<ResponModel> responseModel =
                new ArrayList<>();
        for (int i = 0; i < responJSON.length(); i++) {
            ResponModel resModel = new ResponModel();
            JSONObject myJSONobject = responJSON.getJSONObject(i);
            resModel.setMsg(myJSONobject.getString("message"));
            resModel.setStatus(myJSONobject.getString("status"));
            resModel.setComment(myJSONobject.getString("comment"));
            responseModel.add(resModel);
        }
        System.out.println("Response are");
        for (int index = 0; index < responseModel.size(); index++) {
            System.out.println("MESSAGE : " + responseModel.get(index).getMsg());
            System.out.println("STATUS : " + responseModel.get(index).getStatus());
            System.out.println("COMMENT : " + responseModel.get(index).getComment());
        }
    }
}
